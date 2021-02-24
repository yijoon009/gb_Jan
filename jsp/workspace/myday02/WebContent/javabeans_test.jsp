<%@page import="com.koreait.beans.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="com.koreait.beans.MemberVO" id="member"/>
<jsp:useBean class="com.koreait.beans.MemberDAO" id="dao"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈즈 예제</title>
</head>
<body>
	<!-- html주석은 컴파일을 막지 않고 보여지는 부분만 주석처리 해준다. -->
	<%-- jsp 주석은 컴파일도 주석처리 된다.--%>
	<!-- <jsp:setProperty property="name" name="member" value="김이준"/>
	<jsp:setProperty property="birthday" name="member" value="08-08"/> -->
	
	<jsp:getProperty property="name" name="member"/>
	<jsp:getProperty property="birthday" name="member"/>
	
	
	<table>
	<%ArrayList<MemberVO> members = dao.select("이준"); %>
	<%for (int i=0;i<members.size();i++){%>
		<tr>
			<td><%=members.get(i).getName() %></td>
			<td><%=members.get(i).getBirthday() %></td>
		</tr>
	<%} %>
	</table>
	
</body>
</html>