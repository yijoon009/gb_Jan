package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import dto.USER_TBL_DTO;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class USER_TBL_DAO {

	//현재는 DB가 없으니 static에라도 저장해보자.
	public static String session_id;
	
	//String id = "hds";
	
	//[statement]
	//String query = "select * from user_tbl where id = \'" + id + "\'";
	
	//[preparedStatement]
	//String query = "select * from user_tbl where id = ?";
	//ps.setString(1, id);
	
	
	//모든 객체가 각각 가질 필요 없이 공유하면 되게끔 static 붙였음
	private static final int KEY = 3;
	
	Connection conn;	//접속에 성공한 DB의 연결 객체
	PreparedStatement ps;	//JAVA에서 문자열로 작성한 쿼리문을 저장하고, 
							//?에 필요한 값을 채운 후 쿼리를 실행시켜 준다.
	ResultSet rs;	//조회 결과값을 담을 수 있는 객체
	
	
	//아이디 검사
	public boolean checkId(String id) {
		//COUNT(컬럼명)
		//COUNT(*) : 결과 행의 개수
		String sql = "select count(*) from user_tbl where id = ?";
		boolean check = false;
		try {
			//커넥션 객체 가져오기
			conn = DBConnecter.getConnection();
			//가져온 커넥션 객체를 통해 prepareStatement 실행 후 ps객체에 넣기
			ps = conn.prepareStatement(sql);
			//? 에 들어갈 값 설정
			ps.setString(1, id);
			//완성된 쿼리문을 실행, 결과가 있다면 rs객체에 넣기
			rs = ps.executeQuery();
			
			//결과 행 1개 불러오기
			rs.next();
			//첫번째 결과 열 가져오기
			if(rs.getInt(1) == 1) { 
				//아이디 검사 후 존재한다면 1, 존재하지 않으면 0
				check = true;}

		} catch (SQLException e) {
			System.out.println("checkId() 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("checkId() 알 수 없는 오류");
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
		
	}
	
	
	
	//회원가입(암호화 후 DB추가)
	public boolean join(USER_TBL_DTO dto) {
		
		//insert
		//회원 번호는 SEQ 사용
		//USER_SEQ.NEXTVAL : 시퀀스 값 가져오기
		
		String sql = "insert into user_tbl values(user_seq.nextval,?,?,?,?,?)";
		boolean check = false;
		int rows = 0;
		
		//사용자가 입력한 아이디를 db에서 검사한다.
		//근데 이건 회원가입 메소드 안에서 하는게 아니야.
		/*if(checkId(dto.getId())) {
			//true일 때 중복이 있다는 뜻
			return check;
		}*/
		
		try {
			conn = DBConnecter.getConnection();
			ps = conn.prepareStatement(sql);
			//select 외의 insert, update, delete 쿼리문은 결과 건수를 가져와 확인하면 된다.
			//executeQuery() : select 의 결과를 리턴해주는 메소드 (resultSet)
			//executeUptate() : UPDATE, INSERT, DELETE의 결과 건수를 리턴해주는 메소드(int)
			
			int idx = 0;
			ps.setString(++idx, dto.getId());
			ps.setString(++idx, encrypt(dto.getPw()));
			ps.setString(++idx, dto.getName());
			ps.setInt(++idx, dto.getAge());
			ps.setString(++idx, dto.getPhoneNumber());
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("join() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("join() 알 수 없는 오류");
		}finally {
			try {
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return rows == 1;
	}
	
	
	
	
	//로그인
	public boolean login(String id, String pw) {
		String sql = "select count(*) from user_tbl where id = ? and pw = ?";
		boolean check = false;
		
		try {
			conn = DBConnecter.getConnection();
			ps = conn.prepareCall(sql);
			ps.setString(1, id);
			ps.setString(2, encrypt(pw));
			rs = ps.executeQuery();
			
			//행
			rs.next();
			//열
			if(rs.getInt(1) == 1) {
				check = true;
				//로그인 된 회원의 id 저장
				session_id = id;
			}
			
			
		} catch (SQLException e) {
			System.out.println("login() 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("login() 알 수 없는 오류");
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return check;
		
		
	}
	
	//로그아웃
	public boolean logout() {
		//세션 만료 시간이 있기 때문에 한번 더 확인 해줘야할거같아
		if(session_id != null){
			session_id = null;
			return true;
		}
		return false;
	}
	
	//마이페이지
	public USER_TBL_DTO select(String pw) {
		USER_TBL_DTO user = null;
		String sql = "select * from uer_tbl where id = ? and pw = ?";
		
		try {
			conn = DBConnecter.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, session_id);
			ps.setString(2, encrypt(pw));
			rs = ps.executeQuery();
			
			if(rs.next()){
				//한 객체에 담을 회원 정보
				user = new USER_TBL_DTO();
				user.setId(rs.getString("ID"));
				user.setPw(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				user.setAge(rs.getInt("AGE"));
				user.setPhoneNumber(rs.getString("PHONENUMBER"));
			}
		
			
		} catch (SQLException e) {
			System.out.println("select() 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("select() 알 수 없는 오류");
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return user;
	}
	
	
	
	//목록(회원 전체 목록)
	//selectAll()
	public ArrayList<USER_TBL_DTO> selectAll() {
		String sql = "select * from user_tbl";
		USER_TBL_DTO user = null;
		ArrayList<USER_TBL_DTO> userList = new ArrayList<>();
		
		try {
			conn = DBConnecter.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new USER_TBL_DTO();
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				user.setAge(rs.getInt("AGE"));
				user.setPhoneNumber(rs.getString("PHONENUMBER"));
				
				userList.add(user);
			}
		}catch (SQLException e) {
			System.out.println("selectAll() 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("selectAll() 알 수 없는 오류");
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return userList;
				
	}
	
	
	
	//삭제(회원 탈퇴)
	public boolean delete(String pw) {
		String sql = "delete from user_tbl where id = ? and pw = ?";
		boolean check = false;
		
		try {
			conn = DBConnecter.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, session_id);
			ps.setString(2, encrypt(pw));
			if(ps.executeUpdate() == 1) {
				check = true;
			}
			
			
		} catch (SQLException e) {
			System.out.println("delete() 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("delete() 알 수 없는 오류");
		}finally {
			try {
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}
	
	
	//아이디 찾기
	//핸드폰 번호와 비밀번호로 아이디 조회
	public String findId(String phonenumber, String pw) {
		String sql = "select id from user_tbl where pw = ? and phonenumber = ?";
		String id = "";
		
		try {
			conn = DBConnecter.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, encrypt(pw));
			ps.setString(2, phonenumber);
			rs = ps.executeQuery();
			if(rs.next()) {
				id =  rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("findId() 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("findId() 알 수 없는 오류");
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return id;
	}
	
	
	//수정(비밀번호 변경 : 로그인 된 상태에서)
	// 현재 비밀번호, 새로운 비밀번호
	public boolean changePw(String pw, String new_pw) {
		String sql = "update user_tbl set pw = ? where id = ? and pw = ?";
		boolean check = false;
		
		try {
			conn = DBConnecter.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, encrypt(new_pw));
			ps.setString(2, session_id);
			ps.setString(3, encrypt(pw));
			
			if(ps.executeUpdate() == 1) {
				check = true;
			}
		}  catch (SQLException e) {
			System.out.println("changePw(String, String) 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("changePw(String, String) 알 수 없는 오류");
		}finally {
			try {
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}
	
	
	
	
	//수정(비밀번호 변경 : 임시 비밀번호로 변경)
	//비번 찾기 메소드 안에서만 쓸거니까 private으로 만들어
	//회원번호를 통해 임시비밀번호로 비밀번호 변경
	private void changePw(int user_number, String tmp_pw) {
		String sql = "update user_tbl set pw = ? where user_number = ?";
		try {
			conn = DBConnecter.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, encrypt(tmp_pw));
			ps.setInt(2, user_number);
			
			ps.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("changePw(int, String) 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("changePw(int, String) 알 수 없는 오류");
		}finally {
			try {
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	
	//비번 찾기(아이디와 핸드폰 번호를 전달 받는다)
	//임시 비밀번호 6자리 생성(Random)
	//SMS API를 사용하여 JSON으로 데이터(수신번호, 발신번호, 내용 등 ) 전송
	//전송된 임시 비밀번호로 UPDATE
	//본인 핸드폰에 온 문자 확인 후 임시 비밀번호 확인
	public void findPw(String id, String phoneNumber) {
		String sql = "select user_number from user_tbl where id = ? and phonenumber = ?";
		
		try {
			conn = DBConnecter.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, phoneNumber);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				//임시 비밀번호 생성
				Random r = new Random();
				String tmp = "0123456789abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+{}[];:/?";
				String tmp_pw = "";
				
				final int TMP_PW_LENGTH = 6;
				
				for (int i = 0; i < TMP_PW_LENGTH; i++) {
					tmp_pw += tmp.charAt(r.nextInt(tmp.length()));
				}
				
				//비밀번호 변경
				changePw(rs.getInt(1), tmp_pw);
				
				//ctrl shift o -> 자동 임포트
				//SMS 문자 전송
				String api_key = "NCSZTOKNQ9IPW7DB";
			    String api_secret = "2L73VWKGBYOVB6O0TSH6LEAD7KUINWKD";
			    Message coolsms = new Message(api_key, api_secret);

			    // 4 params(to, from, type, text) are mandatory. must be filled
			    HashMap<String, String> params = new HashMap<String, String>();
			    params.put("to", "01099984653");
			    params.put("from", "01099984653");
			    params.put("type", "SMS");
			    params.put("text", "[테스트]\n임시 비밀번호 : "+tmp_pw+"\n노출될 수 있으니 반드시 비밀번호를 변경해 주세요.");
			    params.put("app_version", "JAVA SDK V2.2"); // application name and version

			    try {
			      JSONObject obj = (JSONObject) coolsms.send(params);
			      System.out.println(obj.toString());
			    } catch (CoolsmsException e) {
			      System.out.println(e.getMessage());
			      System.out.println(e.getCode());
			    }
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//암호화
	public String encrypt(String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char) (pw.charAt(i) * KEY);
		}
		return en_pw;
	}
	
	
	
}















