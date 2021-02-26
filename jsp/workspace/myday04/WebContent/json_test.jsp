<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실시간 검색 순위</title>
</head>
<body>
   <table border="1">
      <tr>
         <td class="td1"><h2>실시간 검색 순위</h2></td>
         <td class="td2"><div id="ranking">키워드</div></td>
      </tr>
   </table>
</body>
<script>
   window.onload = function(){
      var words = new Array();
      var obj = "";
      var ranking = document.getElementById("ranking");
      
      var request = new XMLHttpRequest();
      request.open("GET", "data.json", true);
      request.send();
      
      request.onreadystatechange = function(){
         if(request.readyState == 4){
            if(request.status == 200){
               obj = JSON.parse(request.responseText);
               for(let i=0; i<obj.search_word.length; i++){
                  words[i] = "[" + obj.search_word[i].rank + "]" + obj.search_word[i].name;
               }
            }
         }
      }
      
      var i = 0;
      var interval = setInterval(function(){
         if(i == obj.search_word.length) { i = 0;}
         ranking.innerHTML = "<h3>" + words[i] + "</h3>";
         i++;
      }, 500);
      
      setTimeout(function(){
         clearInterval(interval);
      }, 100000);
   }
</script>
</html>























