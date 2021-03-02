<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET, POST 방식의 요청</title>
</head>
<body>
<!-- 	<h1>GET 방식의 요청</h1>
	<button type="button" onclick="sendRequest()">GET 방식으로 요청 보내기!</button>
	<p id="text"></p> -->
	<h1>POST 방식의 요청</h1>
	<button type="button" onclick="sendRequest()">POST 방식으로 요청 보내기!</button>
	<p id="text"></p>
</body>
<script>
	function sendRequest(){
		var httpRequest = new XMLHttpRequest();
		
		/* GET 방식 */
//		httpRequest.open("GET", "request_ajax.jsp?city=Seoul&zipcode=88855", true);
//		httpRequest.send();
		
		/* POST 방식 */
		httpRequest.open("POST", "request_ajax.jsp", true);
		httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		httpRequest.send("city=Seoul&zipcode=55775");
		
		httpRequest.onreadystatechange = function(){
			//요청과 응답에 성공했을 때
			if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200){
				//응답 값을 받아온다.
				document.getElementById("text").innerHTML = httpRequest.responseText;
			}
		}
		
	}
</script>
</html>














