package com.koreait.dao;

import com.koreait.vo.MemberVO;

public class Test {

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
//		System.out.println(dao.getPw(1));
		dao.getAll().forEach(member -> System.out.println(member));
//		MemberVO member = dao.selectUser(1);
//		member.setName("홍길동");
		
//		System.out.println(dao.delete(1));
	}

}
