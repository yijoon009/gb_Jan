<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class = "prac.day02.TABLE_MEMBER_DAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
	<%
	response.sendRedirect("join.jsp?check="+dao.checkId(request.getParameter("id")));
	
	/* int rows = dao.idCheck(request.getParameter("id"));
	if(rows == 1){
		out.print("이미 존재하는 ID입니다.");
	}else{
		out.print("사용 가능한 ID입니다.");
	} */
	%>
</body>
</html>