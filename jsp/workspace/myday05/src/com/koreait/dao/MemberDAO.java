package com.koreait.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.mybatis.config.SqlMapConfig;
import com.koreait.vo.MemberVO;

public class MemberDAO {
	//이걸로 sqlSession 가져오려고
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public MemberDAO() {
		sqlsession = sqlsession_f.openSession(true);	//default : false, 자동 커밋 여부
	}
	
	
	//아이디 조회(회원번호)
	public String selectId(int num) {
		return sqlsession.selectOne("Member.selectId",num);
	}
	
	
	//비밀번호 조회(아이디)
	public String selectPw(String id) {
		return sqlsession.selectOne("Member.selectPw",id);
	}
	

	//회원번호 조회 (아이디로)
	public int selectNum(String id) {
		return sqlsession.selectOne("Member.selectNum", id);
	}
	
	
	//회원 조회(회원번호)
	public MemberVO selectUser(int num) {
		return sqlsession.selectOne("Member.selectUser", num);
	}
	
	//회원가입
	public boolean join(MemberVO member) {
		return sqlsession.insert("Member.join", member) == 1;
	}
	
	//로그인
	public boolean login(String id, String pw) {
		HashMap<String, String> datas = new HashMap<>();
		datas.put("id", id);
		datas.put("pw", pw);
		return (Integer) sqlsession.selectOne("Member.login",datas) == 1;
	}
	
	/**
	 * datas{id='id',pw='pw'}
	 * @param 
	 * @return
	 *//*
	public boolean login(HashMap<String, String> datas) {
		return (Integer) sqlsession.selectOne("Member.login",datas) == 1;
	}*/
	
	
	
	//아이디 중복검사
	public boolean checkId(String id) {
		return (Integer) sqlsession.selectOne("Member.checkId", id) == 0;
	}
	
	
}
