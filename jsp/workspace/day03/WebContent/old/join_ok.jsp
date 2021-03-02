<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="com.koreait.beans.TABLE_MEMBER_DAO" id="dao"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
<!-- DB에서 조회 -->
<!-- out.print를 사용하여 조회 결과 출력 -->
	<%
		//중복인지 아닌지를 join.jsp로 전달해준다.
		response.sendRedirect("join.jsp?check=" + dao.checkId(request.getParameter("id")));	
/* 		if(dao.checkId(request.getParameter("id"))){
			out.println("중복된 아이디입니다.");
		}else{
			out.println("사용 가능한 아이디입니다.");
		} */
	%>
</body>
</html>