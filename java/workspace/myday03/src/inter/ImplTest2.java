package inter;

public class ImplTest2 extends SuperImplTest2 implements InterA {
	
	@Override
	public void printName() {
		// TODO Auto-generated method stub
		InterA.super.printName();
	}
	public static void main(String[] args) {
		new ImplTest2().printName();
	}
}
