package com.koreait.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MemberDAO {
	//커넥터
	Connection conn;
	//pstm
	PreparedStatement pstm;
	//rs
	ResultSet rs;
	MemberVO member;
	
	//이름으로 전체 정보를 가져오기
	public ArrayList<MemberVO> select(String name) {
		//가져온 '생년월일시분초'를 '월-일'로 변경해서 저장
		String query = "SELECT * FROM TBL_MEMBER WHERE NAME = ?";
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		ArrayList<MemberVO> members = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				member = new MemberVO();
				member.setNum(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setBirthday(sdf.format(rs.getDate(3)));
				
				members.add(member);
			}
		} catch (SQLException e) {
			System.out.println("select(String) 쿼리 오류" + e.getMessage());
		} catch (Exception e) {
			System.out.println("select(String) 오류" + e.getMessage());
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
		return members;
	}
}





















