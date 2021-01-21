package bank;

public class Woori extends Bank{
	static int cnt;
	public Woori() {}
	//잔액 조회시 재산 반토막
	@Override
	public int getBalance() {
		this.money *= 0.5;
		return super.getBalance();
	}
}
