<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="m_vo" class="com.koreait.beans.TABLE_MEMBER_VO"/>
<jsp:useBean id="m_dao" class="com.koreait.beans.TABLE_MEMBER_DAO"/>
<!-- 반드시 파라미터의 KEY(name)값과 해당 객체의 필드명이 일치해야 정확한 값이 들어간다. -->
<jsp:setProperty property="*" name="m_vo"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		String url = "";
		//전달받은 데이터들을 DB에 INSERT한다.
		if(m_dao.join(m_vo)){
			//회원가입 성공
			//sendRedirect()방식으로 쿼리 스트링에 한글 데이터를 전달할 때 반드시 인코딩을 직접 설정해주어야 한다.
			url = "join_finish.jsp?name=" + URLEncoder.encode(m_vo.getName(), "UTF-8");
		}else{
			//회원가입 실패
			url = "join.jsp?check=false";
		}
		response.sendRedirect(url);
	%>
</body>
</html>












