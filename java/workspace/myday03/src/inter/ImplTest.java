package inter;

public class ImplTest implements InterA, InterB {
	@Override
	public void printName() {
		// TODO Auto-generated method stub
		InterB.super.printName();
	}
	public static void main(String[] args) {
		new ImplTest().printName();
	}
}
