package myday06;

public class Animal implements Runnable{

	private String cry;
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	public Animal(String cry) {
		super();
		this.cry = cry;
	}
	
	public void makeCry() {
		System.out.println(cry);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			makeCry();
			try {Thread.sleep(500);} catch (InterruptedException e) {;}
		}
	}

}
