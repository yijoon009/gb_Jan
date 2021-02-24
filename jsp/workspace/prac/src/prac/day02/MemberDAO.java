package prac.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

public class MemberDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	MemberDTO member;
	
	public ArrayList<MemberDTO> select(String name){
		String sql = "select * from prac_tbl_mem where name=?";
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		ArrayList<MemberDTO> memberList = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				member = new MemberDTO();
				member.setNumber(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setBirthday(sdf.format(rs.getDate(3)));
				memberList.add(member);
			}
		} catch (SQLException e) {
			System.out.println("select(String) 쿼리 오류" + e.getMessage());
		} catch (Exception e) {
			System.out.println("select(String) 오류" + e.getMessage());
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e1) {
				throw new RuntimeException(e1.getMessage());
			}
		}
		
		return memberList;
	}
}
