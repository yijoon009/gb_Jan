package com.koreait.servlet;

public class Calc {
	//덧
	public int add(int num1, int num2) {return num1 + num2;}
	
	//뺄
	public int sub(int num1, int num2) {return num1 - num2;}
	
	//곱
	public int mul(int num1, int num2) {return num1 * num2;}
	
	//나
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 * @throws ArithmeticException
	 */
	public int div(int num1, int num2) {return num1 / num2;}
}
