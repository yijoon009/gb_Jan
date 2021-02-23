<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		String site = request.getParameter("site");
		String viewPageURL = null;
		
		if(site.equals("naver")){
			viewPageURL="forward_naver.jsp";	
		}else if(site.equals("daum")){
			viewPageURL="forward_daum.jsp";	
		}else if(site.equals("google")){
			viewPageURL="forward_google.jsp";	
		}
	%>
	<jsp:forward page="<%=viewPageURL %>"></jsp:forward>
</body>
</html>