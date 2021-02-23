package prac.day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String input = request.getParameter("input").replaceAll(" ", "");
		String opers = "+-*/";
		char oper = ' ';	//char의 초기값은 공백
		int check = 0;
		String[] nums = null;
		int n1=0, n2=0;
		String resultMsg = null;
		Calc c = new Calc();
		PrintWriter out = response.getWriter();
		
		out.print("<html><body><h1>서블릿으로 만든 페이지</h1>");
		
		
		for(int i=0;i<opers.length();i++) {
			for(int j=0;j<input.length();j++) {
				if(opers.charAt(i) == input.charAt(j)) {
					oper = input.charAt(j);
					check++;
				}
			}
		}
		
		out.print("<p> 결과 : ");
		if(check == 1) {
			try {
				nums = input.split("\\"+oper);
				n1 = Integer.parseInt(nums[0]);
				n2 = Integer.parseInt(nums[1]);

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
			} catch (NumberFormatException e) {
				resultMsg = "정수의 연산만 가능합니다.";
			} catch (ArrayIndexOutOfBoundsException e) {
				resultMsg = "양식에 맞게 작성해주세요.";
			}
		}else if (check == 0){
			resultMsg = "연산자를 찾지 못했습니다.";
		}else if(check >1) {
			resultMsg = "두 정수의 연산만 가능합니다.";
		}
		out.println(resultMsg+"</p>");
		out.print("<a href='calc'>계산기로 	이동!</a></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
