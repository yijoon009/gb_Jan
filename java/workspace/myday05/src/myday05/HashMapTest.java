package myday05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, Integer> fruitMap = new HashMap<>();
		int total = 0;
		
		
		
		fruitMap.put("apple", 3500);
		fruitMap.put("banana", 4000);
		
		System.out.println(fruitMap);
		
		System.out.println(fruitMap.get("banana"));
		
		//KEY 분리 : KeySet()
		Iterator<String> fruitNames = fruitMap.keySet().iterator();
		while(fruitNames.hasNext()) {
			System.out.println(fruitNames.next());
		}
		
		
		
		//value 분리: values()
		//과일 평균 가격 출력
		fruitMap.values().forEach(price -> {
			//다른 영역의 변수에 연산을 할 수 없다.
			System.out.println(price);
		});
		
		for(Integer value : fruitMap.values()) {
			total += value;
		}
		
		double avg = Double.parseDouble(
		String.format("%.2f",  (double)total/fruitMap.size()));
		
		System.out.println("과일 평균 : "+avg +"원");
		
		
		//메뉴판
		//한 쌍씩 분리 (entrySet())
		Iterator<Entry<String, Integer>> iter = fruitMap.entrySet().iterator();
		
		while(iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			System.out.println(entry.getKey() +":"+entry.getValue()+"원");
		}
		
	}
}






