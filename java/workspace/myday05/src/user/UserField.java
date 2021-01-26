package user;

import java.util.ArrayList;

public class UserField {
	//ArrayList 내부 저장소로 구현
	//회원의 정보는 아이디, 비밀번호 2개이다.
	
	//배열은 크기를 제한해야할 때 사용하고,
	//ArrayList는 몇 개의 데이터가 들어올 지 알 수 없을 때 사용한다.
	
	ArrayList<User> users = new ArrayList<>();
	final int KEY = 5;
	
	//아이디 중복검사
	//회원가입이랑 로그인까지 끌고가려고 boolean이 아니라 User로 한거야.
	public User checkId(String id) {
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).id.equals(id)) {
				return users.get(i);
			}
		}
		return null;
	}
	
	//회원가입
	//사용자 입장에서 회원가입 성공 했는지 안했는지 알려줘야해.
	public boolean join(User user) {
		//중복 없다. 회원가입 성공
		if(checkId(user.id) == null) {
			//암호화
			user.pw = encrypt(user.pw);
			users.add(user);
			return true;
		}
		return false;
	}
	
	//로그인
	//전체 객체는 이미 이 클래스에 있으니까 id,pw만 받아와
	public boolean login(String id, String pw) {
		User user = checkId(id);
		
		//id가 있을때
		if(user != null) {
			//복호화
			if(decrypt(user.pw).equals(pw)) {
				return true;
			}
		}
		return false;
	}

	
	//암호화
	public String encrypt(String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		return en_pw;
	}
	
	//복호화
	public String decrypt(String en_pw) {
		String de_pw = "";
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / KEY);
		}
		return de_pw;
	}
}






























