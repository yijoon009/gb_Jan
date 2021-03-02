<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<jsp:useBean id="dao" class = "day03.TABLE_MEMBER_DAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.sendRedirect("join.jsp?check="+dao.checkId(request.getParameter("id")));	
	%>
</body>
</html>