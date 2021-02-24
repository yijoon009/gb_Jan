<%@page import="prac.day02.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class = "prac.day02.MemberDAO"/>
<jsp:useBean id="member" class = "prac.day02.MemberDTO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:getProperty property="name" name="member"/>
	<jsp:getProperty property="birthday" name="member"/>

	<% ArrayList<MemberDTO> members = dao.select("김이준"); %>
	<table>
	<%for(int i=0;i<members.size();i++){ %>
		<tr>
			<td><%=members.get(i).getName() %></td>
			<td><%=members.get(i).getBirthday() %></td>
		</tr>
	
	<%} %>
	
	</table>


</body>
</html>