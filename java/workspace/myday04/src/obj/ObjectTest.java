package obj;

import java.util.Random;


public class ObjectTest {

	public static void main(String[] args) {
		
		//상수의 영역에 같은걸 공유하고 있구나
		//constant pool
		//해쉬코드 붙어
		String data1 = "ABC";
		String data2 = "ABC";
		
		//둘이 필드가 다르니까 false
		//해쉬코드 안붙어
		String data3 = new String("ABC");
		String data4 = new String("ABC");
		
		System.out.println(data1 == data2);
		System.out.println("===어떻게 컨스턴트 풀의 주소를 가져오는가?===");
		System.out.println(data3 == data4);	//주소비교
		System.out.println(data3.intern() == data4.intern());
		System.out.println("=============================");
		System.out.println(data3.equals(data4));	//값 비교
		

		System.out.println("=================");
		System.out.println(data1.hashCode());
		System.out.println(data2.hashCode());
		System.out.println("=================");
		System.out.println(data3.hashCode());
		System.out.println(data4.hashCode());
		System.out.println("=================");
		
		Random r1 = new Random();
		Random r2 = new Random();
		
		System.out.println(r1 == r2);
		System.out.println(r1.equals(r2));
		
		
		
		
	}

}
