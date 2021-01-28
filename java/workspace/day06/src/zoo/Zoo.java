package zoo;

public class Zoo {
	public static void main(String[] args) {
		Animal lion = new Animal("어흥");
		Animal duck = new Animal("꽥꽥");
		Animal cat = new Animal("야옹");
		
		Thread lionThread = new Thread(lion);
		Thread duckThread = new Thread(duck);
		Thread catThread = new Thread(cat);
		
		lionThread.start();
		duckThread.start();
		
		try {
			lionThread.join();
			duckThread.join();
		} catch (InterruptedException e) {;}
		
		catThread.start();
	}
}


















