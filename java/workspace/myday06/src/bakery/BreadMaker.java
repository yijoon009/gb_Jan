package bakery;

public class BreadMaker implements Runnable{
	
	BreadPlate plate = BreadPlate.getInstance();
	
	public BreadMaker() {;}
	
//	public BreadMaker(BreadPlate plate) {
//		super();
//		this.plate = plate;
//	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			plate.makeBread();
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		}
		System.out.println("재료 소진");
	}
}
