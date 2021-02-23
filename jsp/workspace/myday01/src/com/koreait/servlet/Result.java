package com.koreait.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

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

	Calc c = new Calc();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String input = request.getParameter("input");
		int n1 = 0, n2 = 0, result = 0;
		String[] nums = null;

		String oper = "+-*/";
		
		

		if (input.contains("+")) {
			nums = input.split("\\+");
			result = c.add(n1, n2);
		} else if (input.contains("-")) {
			nums = input.split("\\-");
			result = c.sub(n1, n2);
		} else if (input.contains("*")) {
			nums = input.split("\\*");
			result = c.mul(n1, n2);
		} else if (input.contains("/")) {
			nums = input.split("\\/");
			if (n2 == 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.write("<html><body>0으로 나눌 수 없습니다!!!!<br>");
				out.write("<a href='calc.jsp'>계산기로 이동!</a></body></html>");
				out.close();
			}
			
			result = Double.parseDouble(form.format(n1/n2));
			
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write("<html><body>다시 입력해주세요.<br>");
			out.write("<a href='calc.jsp'>계산기로 이동!</a></body></html>");
			out.close();
		}

		n1 = Integer.parseInt(nums[0]);
		n2 = Integer.parseInt(nums[1]);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<html><body><h1>계산 결과</h1>");
		out.write("<div>" + result + "</div>");

		out.write("<a href='calc.jsp'>계산기로 이동!</a></body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
