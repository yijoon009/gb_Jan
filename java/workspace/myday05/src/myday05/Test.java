package myday05;

public class Test {
	public static void changeData(int[] data) {
		data[0] = 100;
	}
	
	//주소를 사용하는 이유
	//1.여러 개의 값을 리턴하고 싶을 때
	//2.다른 지역에 있는 저장공간의 값을 변경하고 싶을 때
	public static void main(String[] args) {
		
		int[] data = {10};
		Test.changeData(data);
		System.out.println(data[0]);
	}
}
