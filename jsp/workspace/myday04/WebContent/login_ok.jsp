<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String userid = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    
    %>

    <%
    if(){
    	//로그인 성공
    	session.setAttribute("userid", userid);
    	response.sendRedirect("login.jsp");
    }else{
    	//로그인 실패
    }
    %>