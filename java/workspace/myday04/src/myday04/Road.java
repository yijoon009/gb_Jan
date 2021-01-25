package myday04;

public class Road {
	public static void main(String[] args) {
		Starbucks gangnam = new Starbucks();
		Starbucks jamsil = new Starbucks();
		
						//업케스팅
		jamsil.register(new CafeAdapter() {
			
			@Override
			public String[] getMenu() {
				String[] arMenu = {"아메리카노","바닐라라떼","콜드브류"};
				return arMenu;
			}
		});
		
		
		//강남점
		gangnam.register(new Cafe() {
			
			@Override
			public void sell(String menu) throws Exception{
				//같은 {}에 있으니까 getMenu() 메소드 쓸 수 있어
				String[] arMenu = getMenu();
				
				//메뉴 오류없나 확인 flag
				boolean isOk = false;
				
				for (int i = 0; i < arMenu.length; i++) {
					if(arMenu[i].equals(menu)) {
						isOk = true;
					}
				}
				
				if(!isOk) {throw new Exception();}
				
			}
			
			@Override
			public int[] getPrice() {
				int[] arPrice = {3000,4000,3500};
				return arPrice;
			}
			
			@Override
			public String[] getMenu() {
				String[] arMenu = {"아메리카노","카페라떼","콜라"};
				return arMenu;
			}
		});
	}
	
}
