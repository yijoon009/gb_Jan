package user;

public class Form {
	public static void main(String[] args) {
		UserField uf = new UserField();
		
		User user = new User();
		String msg = null;
		
		user.id = "ddd";
		user.pw = "1234";
		
		msg = uf.join(user) ? "회원가입 성공" : "회원가입 실패";
		System.out.println(msg);
		
		
//		if(uf.join(user)) {
//			System.out.println("회원가입 성공");
//		}else {
//			System.out.println("회원가입 실패");
//		}
		
		
		msg = uf.login("ddd", "1234") ? "로그인 성공" : "로그인 실패";
		System.out.println(msg);
		
		
		
		
		
		
		
		
		
		
	}
}
