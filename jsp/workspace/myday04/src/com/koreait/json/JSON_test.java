package com.koreait.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_test {
	public String json;
	
	public void jsonAdd() {
		JSONObject jObj_in = new JSONObject();
		JSONObject jObj_out = new JSONObject();
		
		jObj_in.put("name", "이준");
		jObj_in.put("gender", "여자");
		jObj_in.put("nation", "Republic of Korea");
		
		//{name: '이준', gender : '여자', nation : 'Republic of Korea'}
		
		jObj_out.put("lee", jObj_in);
		json = jObj_out.toJSONString();
		System.out.println(json);
	
	
	}
	public static void main(String[] args) {
		JSON_test j_test = new JSON_test();
		j_test.jsonAdd();
		
		JSONParser p = new JSONParser();
		
		JSONObject jObj_in = new JSONObject();
		JSONObject jObj_out = new JSONObject();
		
		String name=null;
		String gender=null;
		String nation=null;
		
		try {
			jObj_out = (JSONObject) p.parse(j_test.json);
			jObj_in = (JSONObject) jObj_out.get("lee");
			
			name = (String) jObj_in.get("name");
			gender = (String) jObj_in.get("gender");
			nation = (String) jObj_in.get("nation");
			
			System.out.println("이름 : "+name);
			System.out.println("성별 : "+gender);
			System.out.println("국가 : "+nation);
		} catch (ParseException e) {;}
		
		
		
	}
}
