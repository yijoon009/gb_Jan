package myday02;

public class Car {
	String brand;
	String color;
	int price;

	//기본생성자
	//클래스 선언 시 자동으로 기본 생성자가 생성된다.
	//만약 사용자가 직접 생성자를 선언한다면
	//선언한 생성자가 기본 생성자로 인식된다.
	public Car() {}
	
	
	public Car(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	
	public Car(String color, int price) {
		this.color = color;
		this.price = price;
	}


	void engineStart() {
		System.out.println("열쇠로 시동 킴");
	}
	void engineStop() {
		System.out.println("열쇠로 시동 끔");
	}
	
	
}
