package day04;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_test {
	public String json;
	
	public void jsonAdd() {
		JSONObject jobj_in = new JSONObject();
		JSONObject jobj_out = new JSONObject();
		jobj_in.put("name", "김이준");
		jobj_in.put("gender", "female");
		jobj_in.put("nation", "Korea");
		jobj_out.put("kim", jobj_in);
		
		json = jobj_out.toJSONString();
		System.out.println(json);
		
	}
	public static void main(String[] args) {
		JSON_test jTest = new JSON_test();
		jTest.jsonAdd();
		
		JSONParser p = new JSONParser();
		JSONArray array = new JSONArray();
		JSONObject jobj_in = new JSONObject();
		JSONObject jobj_out = new JSONObject();
		array.add(jobj_in);
		
		String name=null;
		String gender=null;
		String nation=null;
		
		try {
			jobj_out = (JSONObject) p.parse(jTest.json);
			jobj_in = (JSONObject) jobj_out.get("kim");
			name = (String) jobj_in.get("name");
			gender = (String) jobj_in.get("gender");
			nation = (String) jobj_in.get("nation");
			
			System.out.println("이름 : " + name);
			System.out.println("성별 : " + gender);
			System.out.println("국가 : " + nation);
			
			System.out.println(array.toJSONString());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
