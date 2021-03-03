<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST(제어문 - 반복문)</title>
</head>
<body>
	forEach 연습 결과
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i}"/>&nbsp;&nbsp;
	</c:forEach>
	<hr>
	varStatus 연습 결과<br>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="stat">
		index : <c:out value="${stat.index}"/><br>
		count : <c:out value="${stat.count}"/><br>
		begin : <c:out value="${stat.begin}"/><br>
		end : <c:out value="${stat.end}"/><br>
		step : <c:out value="${stat.step}"/><br>
		first : <c:out value="${stat.first}"/><br>
		last : <c:out value="${stat.last}"/><hr>
	</c:forEach>
</body>
</html>
















