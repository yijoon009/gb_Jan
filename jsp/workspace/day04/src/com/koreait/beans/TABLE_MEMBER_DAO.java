package com.koreait.beans;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TABLE_MEMBER_DAO {
	
	Context context;
	DataSource dataSource;
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	public boolean login(String id, String pw) {
		boolean check = false;
		
		try {
			context = new InitialContext(null);
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			
			conn = dataSource.getConnection();
			String query = "SELECT COUNT(*) FROM TABLE_MEMBER WHERE ID = ? AND PASSWORD = ?";
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			
			rs = pstm.executeQuery();
			
			rs.next();
			
			if(rs.getInt(1) == 1) {
				check = true;
			}
			
		} catch (NamingException e) {
		} catch (SQLException e) {
		} catch (Exception e) {
			System.out.println("login(String, String) 오류 " + e.getMessage());
		} finally {
			try {
				//커넥션 풀에서 close()의 역할은 해제가 아니라 반납이다.
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * 중복이면 true, 중복이 없으면 false
	 */
	//아이디 중복검사
	public boolean checkId(String id) {
		String query = "SELECT COUNT(*) FROM TABLE_MEMBER WHERE ID = ?";
		boolean check = false;
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			rs.next();
			
			if(rs.getInt(1) == 1) {
				check = true;
			}
			
		} catch (SQLException e) {
			System.out.println("checkId(String) 쿼리 오류 " + e.getMessage());
		} catch (Exception e) {
			System.out.println("checkId(String) 오류 " + e.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}
	
	//회원가입
	public boolean join(TABLE_MEMBER_VO member) {
		String query = "INSERT INTO TABLE_MEMBER VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean check = false;
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, member.getId());
			pstm.setString(2, member.getName());
			pstm.setString(3, member.getPassword());
			pstm.setString(4, member.getGender());
			pstm.setString(5, member.getZipcode());
			pstm.setString(6, member.getAddress());
			pstm.setString(7, member.getAddressDetail());
			pstm.setString(8, member.getAddressEtc());
			
			if(pstm.executeUpdate() == 1) {
				check = true;
			}
			
		} catch (SQLException e) {
			System.out.println("join(TABLE_MEMBER_VO) 쿼리 오류 " + e.getMessage());
		} catch (Exception e) {
			System.out.println("join(TABLE_MEMBER_VO) 오류 " + e.getMessage());
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}
}


















