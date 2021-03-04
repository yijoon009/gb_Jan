package com.koreait.app.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.member.vo.MemberVO;
import com.koreait.mybatis.config.SqlMapConfig;

public class MemberDAO {
	private static final int KEY = 3;
	
	SqlSessionFactory sesion_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	public MemberDAO() {
		//세션 팩토리로 세션을 열어주고 모든 쿼리문을 auto 커밋으로 설정
		session = sesion_f.openSession(true);
	}
	
	
	
	
	//아이디 검사
	/**
	 * 
	 * @param memberId
	 * @return
	 * true: 중복된 아이디<br>false: 사용 가능한 아이디
	 */
	public boolean checkId(String memberId) {
		return (Integer) session.selectOne("Member.checkId", memberId) == 1;
	}
	
	//회원가입
	public boolean join(MemberVO member) {
		member.setMemberPw(encrypt(member.getMemberPw()));
		return session.insert("Member.join", member) == 1;
	}
	
	//암호화
	public String encrypt(String pw) {
		String en_pw="";
		for(int i=0;i<pw.length();i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		return en_pw;
	}
	
	//복호화
	public String decrypt(String en_pw) {
		String de_pw="";
		for(int i=0;i<en_pw.length();i++) {
			de_pw += (char)(en_pw.charAt(i) / KEY);
		}
		return de_pw;
	}
	
	
}
