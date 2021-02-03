package views;

import java.io.IOException;

import dao.BoxOfficeDAO;
import dto.BoxOfficeDTO;

public class Test {

	public static void main(String[] args) {
		 BoxOfficeDAO dao = new BoxOfficeDAO();
	      
	      BoxOfficeDTO film_vo = new BoxOfficeDTO();

	      
	      try {
	         dao.selectAll().forEach(film -> {
	            System.out.print(film.getRanking() + "\t");
	            System.out.print(film.getFilmName() + "\t");
	            System.out.print(film.getIncome() + "\t");
	            System.out.print(film.getGuestCnt() + "\t");
	            System.out.println(film.getScreenCnt());
	            
	         });
	      } catch (IOException e) {
	      }
	      
//	      try {
//	         dao.select("7").forEach(film -> {
//	            System.out.println(film.getFilmName());
//	         });
//	      } catch (IOException e) {
//	      }
	      
//	      try {
//	         if(dao.delete("노아")) {
//	            System.out.println("삭제 성공");
//	         }
//	      } catch (IOException e) {}
	      
//	      try {
//	         if(dao.update("겨울왕국", "여름왕국")) {
//	            System.out.println("수정 성공");
//	         }
//	      } catch (IOException e) {}
	      
//	      film.setRanking(7);
//	      film.setFilmName("겨울왕국");
//	      
//	      try {   dao.insertOrAppend(film);} catch (IOException e) {;}
	      
	      
	      
	      
	      // 과연 \n도 readline()이 가져올까?
	      
//	      BoxOfficeDAO dao = new BoxOfficeDAO();
//	      BoxOfficeVO vo = new BoxOfficeVO();
//	      vo.setFilmName("한동석은 짱");
//	      vo.setGuestCnt(10);
//	      vo.setIncome(10000);
//	      vo.setReleaseDate("2009-12-17");
//	      vo.setScreenCnt(10);
//	      
//	      try {   dao.append(vo);} catch (IOException e) {;}
//	      try {   dao.append(vo);} catch (IOException e) {;}
	   
		
	}

}
