package com.koreait.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.mybatis.config.SqlMapConfig;
import com.koreait.vo.MemberVO;

public class MemberDAO {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;

	public MemberDAO() {
		sqlsession = sqlsession_f.openSession(true);
	}

	
	//회원 삭제 (회원번호)
	public boolean delete(int num) {
		return (Integer) sqlsession.delete("Member.delete",num) == 1;
	}
	
	
	// 회원 이름 수정(회원 번호로, 새로운 이름)
	// 회원 상세보기(마이페이지-select)를 통해 가져온 모델 객체에 바로 수정하기 때문에
	// 수정된 모델 객체를 전달받는 것이 편하다
	public boolean modify(MemberVO member) {
		return sqlsession.update("Member.modify", member) == 1;
	}

	// 전체 회원 조회
	public List<MemberVO> getAll() {
		return (List) sqlsession.selectList("Member.getAll");
	}

	// 회원번호로 비밀번호 조회
	public String getPw(int num) {
		return sqlsession.selectOne("Member.getPw", num);
	}

	// 아이디 조회(회원번호)
	public String selectId(int num) {
		return sqlsession.selectOne("Member.selectId", num);
	}

	// 비밀번호 조회(아이디)
	public String selectPw(String id) {
		return sqlsession.selectOne("Member.selectPw", id);
	}

	// 회원번호 조회 (아이디로)
	public int selectNum(String id) {
		return sqlsession.selectOne("Member.selectNum", id);
	}

	// 회원 조회(회원번호)
	public MemberVO selectUser(int num) {
		return sqlsession.selectOne("Member.selectUser", num);
	}

	// 회원가입
	public boolean join(MemberVO member) {
		return sqlsession.insert("Member.join", member) == 1;
	}

	// 로그인
	public boolean login(String id, String pw) {
		HashMap<String, String> datas = new HashMap<>();
		datas.put("id", id);
		datas.put("pw", pw);
		return (Integer) sqlsession.selectOne("Member.login", datas) == 1;
	}

	/**
	 * datas{id='id',pw='pw'}
	 * 
	 * @param
	 * @return
	 *//*
		 * public boolean login(HashMap<String, String> datas) { return (Integer)
		 * sqlsession.selectOne("Member.login",datas) == 1; }
		 */

	// 아이디 중복검사
	public boolean checkId(String id) {
		return (Integer) sqlsession.selectOne("Member.checkId", id) == 0;
	}
}
