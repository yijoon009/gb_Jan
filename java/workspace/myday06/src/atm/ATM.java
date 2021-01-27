package atm;

public class ATM implements Runnable{
	
	int money = 10000;
	
	
	
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			withdraw(1000);
		}
		
	}
	
	public void withdraw(int money) {
		this.money -= money;
		System.out.println(Thread.currentThread().getName()+"이(가) "+money+"원 출금");
		System.out.println("현재잔액"+this.money+"원");
		
	}
	
}
