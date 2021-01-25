package myday04;

public interface Cafe {
	//메뉴
	//void로 쓰면 안돼
	//Starbucks에서 c.으로 할거니까 리턴타입 있어야해
	String[] getMenu();
	
	//가격
	int[] getPrice();
	
	//판매방식
	//exception만 안뜨면 되니까 void 괜찮아
	//항상 try catch 잡아라
	void sell(String menu) throws Exception;
	
}
