<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class = "com.koreait.beans.TABLE_MEMBER_DAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- DB에서 조회 -->
<!-- out.print를 사용하여 조회 결과 출력 -->
<%
	//중복인지 아닌지를 join.jsp로 전달해준다.
	response.sendRedirect("join.jsp?check=" + dao.checkId(request.getParameter("id")));
	/* int rows = dao.idCheck(request.getParameter("id"));
	if(rows == 1){
		out.print("이미 존재하는 ID입니다.");
	}else{
		out.print("사용 가능한 ID입니다.");
	} */
%>
</body>
</html>