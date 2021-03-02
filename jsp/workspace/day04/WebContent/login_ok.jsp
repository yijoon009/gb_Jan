<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="com.koreait.beans.TABLE_MEMBER_DAO" id="m_dao"/>
<%
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
%>
<%
	if(m_dao.login(userid, pwd)){
		//로그인 성공
		session.setAttribute("userid", userid);
		response.sendRedirect("login.jsp");
	}else{
		//로그인 실패
	%>
	<script>
		alert("로그인 실패");
		location.href="login.jsp";
	</script>
<%}%>