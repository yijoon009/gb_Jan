package com.prac.day05.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.prac.day05.mybatis.config.SqlMapConfig;

public class MemberDAO {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public MemberDAO() {
		sqlsession = sqlsession_f.openSession(true);
	}
	
	//아이디 중복검사
	public boolean checkId(String id) {
		 return (Integer) sqlsession.selectOne("Member.checkId",id) == 0;
	}
}
