package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBConnector {
	private static final String PATH = "boxOffice.txt";

	public static String getPath() {
		return PATH;
	}
	
	
	
	//전부 static으로 할거야
	//왜? 객체화 안하려고
	
	//데이터 추가
	public static BufferedWriter getAppend() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
		return bw;
	}
	
	
	//데이터 가져오기
	public static BufferedReader getReader() throws IOException{
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(PATH));
		} catch (FileNotFoundException e) {}
		return br;
	}
	
	
	//데이터 덮어쓰기
	public static BufferedWriter getWriter() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH));
		return bw;
	}
	
	
	
}
