package dao;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import dto.BoxOfficeDTO;

public class BoxOfficeDAO {
	
	//private 추가(랭킹이 전달되지 않았을 때)
	private boolean append(BoxOfficeDTO film) throws IOException{
		
		//외부에서 전달된 영화 정보가 없을 때
		if(film == null) {return false;}
		
		//파일의 가장 마지막 문자가 \n인지 검사(readAllBytes() 사용)
		//텍스트파일에서 각 컬럼의 구분은 \t로 구분되어 있다.
		
		BufferedReader br = DBConnector.getReader();
		//해당 경로에 읽어올 파일이 없을 때
		if(br == null) {return false;}
		
		//메모장 각 줄(라인) 문자열을 저장할 변수
		String line = null;
		
		//마지막 랭킹 번호를 저장할 변수
		int last_ranking = 0;
		
		//while문 종료시 lastRanking에는 마지막 영화 순위가 저장된다.
		while((line = br.readLine()) != null) {
			//마지막 랭킹을 알아야 한다.
			last_ranking++;
		}
		
		//확인용
		/*System.out.println(last_ranking);*/
		br.close();
		
		String content = new String(Files.readAllBytes(Paths.get(DBConnector.getPath())));	//메모장 전체 문자열
		//메모장 양식에 맞춰서 추가할 요소를 담아 줄 임시 저장공간
		String tmp = "";
		
		//가장 마지막에 줄바꿈이 있는지 검사
		if(content.charAt(content.length()-1) != '\n') {
			//줄바꿈이 없다면 \n을 추가하고 시작한다.
			tmp += "\n";
		}
		
		//새롭게 추가될 영화 순위는 마지막 순위 +1이 된다.
		tmp += ++last_ranking+"\t"+film.getFilmName()+"\t"+film.getReleaseDate()+
				"\t"+film.getIncome()+"\t"+film.getGuestCnt()+"\t"+film.getScreenCnt()+"\n";
		//마지막 \n은 추가해도 되고 안해도 된다. 
		
		BufferedWriter bw = DBConnector.getAppend();
		bw.write(tmp);
		bw.close();
		return true;
	}
	
	
	//private 삽입(랭킹이 전달되었을 때)
	private boolean insert(BoxOfficeDTO film) throws IOException {
		
		if(film == null) {return false;}
		
		BufferedReader br = DBConnector.getReader();
		if(br == null) {return false;}

		String line = null;
		String tmp = "";
		//삽입 여부 FLAG
		boolean check_insert = false;
		
		String insertFilm = film.getRanking()+"\t"+film.getFilmName()+"\t"+film.getReleaseDate()+
				"\t"+film.getIncome()+"\t"+film.getGuestCnt()+"\t"+film.getScreenCnt()+"\n";
		
		//전달받은 삽입할 랭킹을 newRanking에 담아준다.
		int newRanking = film.getRanking();
		
		while((line = br.readLine()) != null) {
			
			//삽입할 순위를 기존 데이터와 비교
			if(Integer.parseInt(line.split("\t")[0]) == film.getRanking()) {
				//현재 순위와 삽입할 순위가 일치하면
				//기존 정보 이전에 새로운 삽입할 정보를 tmp에 넣어준다
				tmp+=insertFilm;
				check_insert = true;
				//삽입 완료
			}
			if(check_insert) {
				//삽임 후 나머지 랭킹에 모두 +1을 하여 수정해준다.
				//line.substring(line.indexOf("\t")) : 순위를 제외한 나무지 정보
				tmp+= ++newRanking + line.substring(line.indexOf("\t"))+"\n";
			}else {
				//삽입 전에는 순위를 그대로 유지해야 한다. 
				tmp += line+"\n";
			}
		}
		br.close();
		
		BufferedWriter bw = DBConnector.getWriter();
		bw.write(tmp);
		bw.close();
		return true;
	}
	
	
	
	//INSERT
	public boolean insertOrAppend(BoxOfficeDTO film) throws IOException{
		
		//랭킹 유무 확인
		if(film.getRanking() == 0) {
			//추가
			if(append(film)) {return true;}
		}else {
			//삽입
			//전달받은 랭킹이 마지막 순위보다 클 때(오류)
			/*if(film.getRanking() <= new String(Files.readAllBytes(Paths.get(DBConnector.getPath()))).split("\n").length) {
				check = insert(film);
			}*/
			
			String contents = new String(Files.readAllBytes(Paths.get(DBConnector.getPath())));
			String[] arTmp = contents.split("\n");
			//마지막 순위와 사용자가 보낸 순위 비교
			if(Integer.parseInt(arTmp[arTmp.length-1].split("\t")[0]) < film.getRanking()) {return false;}
			if(insert(film)) {return true;}
		}
		return false;
	}
	
	
	//수정(영화제목만 수정 가능)
	public boolean update(String filmName, String newFilmName) throws IOException{
		
		
		BufferedReader br = DBConnector.getReader();
		if(br == null) {return false;}
		String line = null;
		String tmp = "";
		//수정 완료 flag
		boolean check = false;
		
		while((line = br.readLine()) != null){
			//메모장에서 한 줄씩 가져온 후 수정할 영화제목을 비교하여 검사한다.
			if(line.split("\t")[1].equals(filmName)) {
				//제목\t 정보1...
				String stub = line.substring(line.indexOf("\t")+1);
				//일치하는 영화제목이 있다면 새로운 영화제목으로 변경한다.
				tmp += line.split("\t")[0] +"\t"+ newFilmName +"\t"+ stub.substring(stub.indexOf("\t")) + "\n";
				check = true;
				continue;
			}
			tmp += line +"\n";
		}
		br.close();

		//수정이 되었다면 덮어쓴 후 true 리턴
		if(check) {
			BufferedWriter bw = DBConnector.getWriter();
			bw.write(tmp);
			bw.close();
			return true;
		}
		return false;
	}
	
	
	
	//삭제
	public boolean delete(String fileName) throws IOException{
		
		BufferedReader br = DBConnector.getReader();
		if(br == null) {return false;}
		String line = null;
		String tmp = "";

		int ranking = 0;
		
		boolean check = false;
		
		while((line = br.readLine()) != null) {
			ranking++;
			if(line.split("\t")[1].equals(fileName)) {
				ranking--;
				check = true;
				continue;
			}
			tmp += ranking + line.substring(line.indexOf("\t")) + "\n";
		}
		br.close();
		
		if(check) {
			BufferedWriter bw = DBConnector.getWriter();
			bw.write(tmp);
			bw.close();
			return true;
		}
		return false;
		
	}
	
	
	//검색
	public ArrayList<BoxOfficeDTO> select(String keyword) throws IOException{
		BufferedReader br = DBConnector.getReader();
		ArrayList<BoxOfficeDTO> filmList = new ArrayList<>();
		if(br==null) {return null;}
		
		String line = null;
		
		while((line = br.readLine()) != null) {
			String[] arTmp = line.split("\t");
			
			if(line.split("\t")[1].contains(keyword)) {
				BoxOfficeDTO film = new BoxOfficeDTO();
				film.setRanking(Integer.parseInt(arTmp[0]));
				film.setFilmName(arTmp[1]);
				film.setReleaseDate(arTmp[2]);
				film.setIncome(changeToLong(arTmp[3]));
				film.setGuestCnt(changeToInteger(removeS(arTmp[4])));
				film.setScreenCnt(changeToInteger(removeS(arTmp[5])));
				
				filmList.add(film);
			}
		}
		br.close();
		return filmList;
	}
	
	
	
	//목록
	public ArrayList<BoxOfficeDTO> selectAll() throws IOException{
		BufferedReader br = DBConnector.getReader();
		ArrayList<BoxOfficeDTO> filmList = new ArrayList<>();
		if(br==null) {return null;}
		
		String line = null;
		
		while((line = br.readLine()) != null) {
			String[] arTmp = line.split("\t");
			BoxOfficeDTO film = new BoxOfficeDTO();
			
			film.setRanking(Integer.parseInt(arTmp[0]));
			film.setFilmName(arTmp[1]);
			film.setReleaseDate(arTmp[2]);
			film.setIncome(changeToLong(arTmp[3]));
			film.setGuestCnt(changeToInteger(removeS(arTmp[4])));
			film.setScreenCnt(changeToInteger(removeS(arTmp[5])));
			
			filmList.add(film);
		}
		br.close();
		return filmList;
	}
	
	
	public int changeToInteger(String includedComma) {
		String[] arTemp = includedComma.split(",");
		String result = "";
		for (int i = 0; i < arTemp.length; i++) {
			result += arTemp[i];
		}
		if(includedComma.equals("")) {result = "0";}

		return Integer.parseInt(result);
	}
	
	public long changeToLong(String includedComma) {
		String[] arTemp = includedComma.split(",");
		String result = "";
		for (int i = 0; i < arTemp.length; i++) {
			result += arTemp[i];
		}
		if(includedComma.equals("")) {result = "0";}

		return Long.parseLong(result);
	}
	
	
	
	public String removeS(String screenCount) {
		if(screenCount.contains("S")) {
			screenCount = screenCount.substring(screenCount.indexOf("S")+2);
		}
		return screenCount;
	}
	
	
	
}

























