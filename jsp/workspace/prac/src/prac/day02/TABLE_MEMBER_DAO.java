package prac.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TABLE_MEMBER_DAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
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
}


















