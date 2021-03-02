<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String check = request.getParameter("check");
		if(check == null){
			check = "";
		}
	%>
	<input type = "hidden" name="check" value="<%=check%>">	
	<form action="join_ok.jsp" name="joinForm">
	아이디 : <input type="text" name="id"><p id="result"></p>
	<input type="button" value="완료" onclick="sendIt()">
	</form>
</body>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	var check = $("input[name='check']").val();
	if(check != ""){
		if(check == "true"){
			$("p#result").text("중복된 아이디 입니다.");
		}else{
			
			$("p#result").text("사용 가능한 아이디 입니다.");
		}
	}

	function sendIt(){
		if($("input[name='id']").val() == ""){
			alert("아이디를 입력해주세요.");
			return false;
		}
		document.joinForm.submit();
	}
</script>
</html>