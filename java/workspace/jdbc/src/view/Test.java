package view;

import dao.USER_TBL_DAO;
import dto.USER_TBL_DTO;

public class Test {

	public static void main(String[] args) {
		
		USER_TBL_DAO dao = new USER_TBL_DAO();
		USER_TBL_DTO dto = new USER_TBL_DTO();
		
		
		
//		dao.findPw("kyj8", "01099984653");
		
		
//		System.out.println(dao.findId("01099984653", "1234"));
		
		
		
		
//		dto.setAge(12);
//		dto.setId("kyj8");
//		dto.setName("김이준");
//		dto.setPhoneNumber("01099984653");
//		dto.setPw("0000");
//		if(dao.join(dto)) {
//			System.out.println("회원가입 성공");
//		}else{
//			System.out.println("회원가입 실패");
//		}
//			
		if(dao.login("kyj8", "_qoq+r")) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		if(dao.changePw("_qoq+r", "1234")) {
			System.out.println("비번 변경 완료");
		}else {
			
			System.out.println("비번 변경 실패");
		}
//		if(dao.delete("1234")) {
//			System.out.println("삭제 성공");
//		}else {
//			System.out.println("삭제 실패");
//		}
	}

}
