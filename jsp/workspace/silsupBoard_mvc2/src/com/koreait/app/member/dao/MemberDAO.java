package com.koreait.app.member.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.member.vo.MemberVO;
import com.koreait.mybatis.config.SqlMapConfig;

public class MemberDAO {
	private static final int KEY = 3;
	
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public MemberDAO() {
		session = sqlsession_f.openSession(true);
	}
	
	
	//아이디 검사
	/**
	 * 
	 * @param memberId
	 * @return
	 * 
	 * true : 중복된 아이디<br>false : 사용 가능한 아이디
	 * 
	 */
	public boolean checkId(String memberId) {
		return (Integer)session.selectOne("Member.checkId", memberId) == 1;
	}
	
	
	//로그인
	public boolean login(String memberId, String memberPw) {
		HashMap<String, String> datas = new HashMap<>();
		datas.put("memberId", memberId);
		datas.put("memberPw", encrypt(memberPw));
		return (Integer) session.selectOne("Member.login", datas) == 1;
	}
	
	
	//회원가입
	public boolean join(MemberVO member) {
		member.setMemberPw(encrypt(member.getMemberPw()));
		return session.insert("Member.join", member) == 1;
	}
	
	//암호화
	public String encrypt(String pw) {
		String en_pw = "";
		for(int i=0;i<pw.length();i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		return en_pw;
	}
	
	//복호화
	public String decrypt(String en_pw) {
		String de_pw = "";
		for(int i=0;i<en_pw.length();i++) {
			de_pw += (char)(en_pw.charAt(i) / KEY);
		}
		return de_pw;
	}
}
