package com.koreait.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultT
 */
@WebServlet("/ResultT")	//요청된 rul 매핑 - 요청된 전송방식에 맞는 doGet()또는 doPost()가 실행된다.
public class ResultT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//문서의 데이터
		request.setCharacterEncoding("UTF-8");	//전달받은 데이터 인고딩 설정
		response.setCharacterEncoding("UTF-8");	//전달할 데이터 인고딩 설정
		
		//문서의 타입
		response.setContentType("text/html; charset-UTF-8");	//응답할 페이지 타입 설정
		
		Calc c = new Calc();
		
		String input = request.getParameter("input").replaceAll(" ", "");	//수식 내의 공백을 없애주기 위해 " "를 ""로 모두 대체
		PrintWriter out = response.getWriter();
		String opers = "+-*/";	//4칸 문자 배열
		char oper = ' ';
		int check = 0;
		String[] arTemp = null;
		int n1=0, n2=0;
		String resultMsg = null;
		
		
		out.println("<html><body><h1>서블릿으로 만든 페이지</h1>");
		
		//수식 내의 연산자를 찾아주는 로직
		for(int i=0;i<opers.length();i++) {
			for(int j=0;j<input.length();j++) {
				if(input.charAt(j) == opers.charAt(i)) {
					//연산자를 찾았다면 oper에 저장
					oper = input.charAt(j);
					//들어온 횟수가 수식에 있는 연산자 갯수
					//수식 내의 연산자 개수
					check++;
				}
			}
		}
		
		out.println("<p>결과 : ");
		if(check == 1) {	//수식 내에 연산자가 1개 있다는 뜻
			try {
				//찾은 연산자를 기준을 ㅗ양 옆을 잘라준다.
				arTemp = input.split("\\"+oper);
				n1 = Integer.parseInt(arTemp[0]);	//첫 번째 정수
				n2 = Integer.parseInt(arTemp[1]);	//두 번째 정수
				switch (oper) {
				case '+':
					resultMsg = c.add(n1, n2) +"";
					break;
				case '-':
					resultMsg = c.sub(n1, n2) +"";
					break;
				case '*':
					resultMsg = c.mul(n1, n2) +"";
					break;
				case '/':
					try {
						resultMsg = c.div(n1, n2) +"";
					} catch (ArithmeticException e) {
							resultMsg = "0으로 나눌 수 없습니다.";
					}
					break;
				}
			} catch (NumberFormatException e) {	//인티저파싱에서 문제 발생 시
				resultMsg = "정수의 연산만 가능합니다.";
			} catch (ArrayIndexOutOfBoundsException e) {	//파싱 된 곳(arTemp[0,1])에서 문제발생
				resultMsg = "양식에 맞게 작성해주세요.";
			}
			
		}else if(check > 1) {	//연산자가 2개 이상이라는 뜻
			resultMsg = "두 정수의 연산만 가능합니다.";
		}else {	//check == 0
			resultMsg = "연산자를 찾지 못했습니다.";
		}
		
		out.println(resultMsg + "</p>");
		out.write("<a href='calc'>계산기로 이동!</a></body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
