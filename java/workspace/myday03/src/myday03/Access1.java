package myday03;

public class Access1 {
	int dat1 = 10;	//default
	public int data2 = 11;
	protected int date3 = 12;
	private int data4 = 13;	//반드시 getter(), setter()를 만들라는 경고
	
	public Access1() {}
	
	//생성자로 초기화
	public Access1(int data4) {
		this.data4 = data4;
	}
	
	public int getData4() {
		return data4;
	}
	public void setData4(int data4) {
		this.data4 = data4;
	}
	
	
	
}
