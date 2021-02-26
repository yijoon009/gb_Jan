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
	
	//naming 소속
	Context context;
	DataSource dataSource;
	
	// 커넥터
	Connection conn;
	// pstm
	PreparedStatement ps;
	// rs
	ResultSet rs;

	public boolean login(String id, String pw) {
		try {
			context = new InitialContext(null);
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			
			conn = dataSource.getConnection();
			String sql = "select count(*) from table_member where id=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, x);
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//회원가입
	public int join(TABLE_MEMBER_VO member) {
		
		int cnt=1;	//아까 예시로 하나 넣어놔서 지금은 1부터 시작
		int rows = 0;
		String sql = "INSERT INTO TABLE_MEMBER VALUES(?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ++cnt);
			ps.setString(2, member.getId());
			ps.setString(3, member.getName());
			ps.setString(4, member.getPassword());
			ps.setString(5, member.getGender());
			ps.setString(6, member.getZipcode());
			ps.setString(7, member.getAddress());
			ps.setString(8, member.getAddressdetail());
			ps.setString(9, member.getAddressetc());
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("join() 쿼리문 오류" + e.getMessage());
		} catch (Exception e) {
			System.out.println("join()  오류" + e.getMessage());
		} finally {
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return rows;
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
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
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
				if(ps != null) {
					ps.close();
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
	
	
	
	
	//TABLE_MEMBER_VO member;
	/**
	 * 
	 * @param id
	 * @return
	 * 중복 있으면 1 리턴, 없으면 0 리턴
	 */
	// 아이디 중복검사
	/*public int idCheck(String id) {
		int rows = 0;
		String sql = "select * from table_member where id = ?";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				rows = 1;
			}
		} catch (SQLException e) {
			System.out.println("idCheck() 쿼리 오류");
		} finally {
			try {
	            if(rs != null) {
	               rs.close();
	            }
	            if(ps != null) {
	               ps.close();
	            }
	            if(conn != null) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            throw new RuntimeException(e.getMessage());
	         }
		}
		return rows;
	}*/
}
