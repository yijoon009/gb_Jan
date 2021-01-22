package inter;

public interface InterA {
	
//	int data = 10;
	final int data = 10;
	
//	void getData();
	
	default void printName() {
		System.out.println("김이준 interA");
	}
}
