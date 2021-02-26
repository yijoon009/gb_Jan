<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("id","apple");
	//다른 어떤 request에서도 쿠키 접근 가능
	response.addCookie(cookie);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키 생성</h3>
	<a href = "getCookie1.jsp">쿠키 전송</a>
</body>
</html>