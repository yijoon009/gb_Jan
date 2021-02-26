<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dao" class = "com.koreait.beans.TABLE_MEMBER_DAO"/>
<jsp:useBean id="member" class = "com.koreait.beans.TABLE_MEMBER_VO"></jsp:useBean>
<!-- 반드시 파라미터의 KEY(name)값과 해당 객체의 필드명ㅇ ㅣ일치해야 정확한 값이 들어간다. -->
<jsp:setProperty property="*" name="member"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int rows = dao.join(member);
	if(rows > 0){
		response.sendRedirect("join_finish.jsp?id="+URLEncoder.encode(member.getId(), "UTF-8"));
	}else{
		response.sendRedirect("join.jsp?check=false");
	}
%>
</body>
</html>