package com.koreait.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_test {
	//JSON타입을 문자열로 담아줄 변수
	public String json;
	
	public void jsonAdd() {
		//내부 JSON
		JSONObject jObj_in = new JSONObject();
		
		//외부 JSON
		JSONObject jObj_out = new JSONObject();
		
		//데이터 3쌍 추가
		jObj_in.put("name", "한동석");
		jObj_in.put("gender", "남자");
		jObj_in.put("nation", "Republic of Korea");
		
		//{name : '한동석', gender : '남자', nation : 'Republic of Korea'}
		
		jObj_out.put("han", jObj_in);
		//{ "han" : {name : '한동석', gender : '남자', nation : 'Republic of Korea'}}
		
		json = jObj_out.toJSONString();
		System.out.println(json);
	}
	public static void main(String[] args) {
		JSON_test j_test = new JSON_test();
		j_test.jsonAdd();
		
		JSONParser p = new JSONParser();
		JSONArray j_array = new JSONArray();
		JSONObject jObj_in = new JSONObject();
		JSONObject jObj_out = new JSONObject();
		j_array.add(jObj_in);
		
		String name = null;
		String gender = null;
		String nation = null;
		
		try {
			//문자열을 JSON타입으로 변경
			jObj_out = (JSONObject)p.parse(j_test.json);
			
			//외부 JSON의 KEY를 전달해서 내부 JSON 가져오기
			jObj_in = (JSONObject)jObj_out.get("han");
			
			//내부 JSON의 요소들에 KEY로 접근
			name = (String)jObj_in.get("name");
			gender = (String)jObj_in.get("gender");
			nation = (String)jObj_in.get("nation");
			
			System.out.println("이름 : " + name);
			System.out.println("성별 : " + gender);
			System.out.println("국가 : " + nation);
			
			System.out.println(j_array.toJSONString());
			
		} catch (ParseException e) {;}
		
	}
}
















