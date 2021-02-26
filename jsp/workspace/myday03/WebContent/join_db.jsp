<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class = "com.koreait.beans.TABLE_MEMBER_DAO"/>
<jsp:useBean id="member" class = "com.koreait.beans.TABLE_MEMBER_VO"></jsp:useBean>
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
		response.sendRedirect("join_finish.jsp?id="+member.getId());
	}else{
		response.sendRedirect("join.jsp?check=false");
	}
%>
</body>
</html>