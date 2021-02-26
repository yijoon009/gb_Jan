<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제 확인</title>
<!-- 쿠키가 없다면 p태그로 "쿠키가 삭제되었습니다" 출력 -->
</head>
<body>
<%
	String cookie = request.getHeader("Cookie");
	String id = null;
	String msg="";
	if(cookie != null){
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
			if(c.getName().equals("id")){
				id = c.getValue();
				break;
			}
		}
	}
	if(id == null){
		msg = "쿠키가 삭제되었습니다.";
	}
%>
	<p><%=msg %></p>
</body>
</html>