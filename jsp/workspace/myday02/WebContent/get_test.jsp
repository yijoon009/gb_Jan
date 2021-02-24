<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>get방식의 요청</title>
</head>
<body>
	<h1>GET 방식의 요청</h1>
	<%
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		if(city == null || zipcode == null){
			response.sendRedirect("post_test.jsp");
		}else{
	%>
	<form action="get_test.jsp" method="get">
		<input type="text" name="city" value="Seoul" readonly>
		<input tye="text" name="zipcode" value="097872" readonly>
		<button type="submit">GET 방식으로 요청 보내기!</button>
	
	</form>
	<p><%=city %>, <%=zipcode %></p>
	<%} %>
</body>
</html>