<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class = "com.koreait.beans.TABLE_MEMBER_DAO"/>
	<%
		//DAO에 있는 checkId()함수의 리턴값에 다라서
		//true라면 "중복된 아이디" body에 출력
		//false라면 "사용가능한 아이디" body에 출력
		String id = request.getParameter("id");
		if(dao.checkId(id)){
			//중복
			out.println("not-ok");
		}else{
			//사용 가능
			out.println("ok");
		}
	%>
