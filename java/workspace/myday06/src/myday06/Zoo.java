package myday06;

public class Zoo {

	public static void main(String[] args) {

		Animal cow = new Animal("moo~");
		Animal cat = new Animal("meow~");
		Animal lion = new Animal("roar~");
		
		Thread t1 = new Thread(cow);
		Thread t2 = new Thread(cat);
		Thread t3 = new Thread(lion);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {;}

		t3.start();
	}

}
