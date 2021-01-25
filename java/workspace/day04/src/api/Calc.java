package api;

import api2.Math2;

/**
 * 
 * @author unascribed
 * @since JDK8
 * <br>Calculator
 */
public class Calc {
	
	/**
	 * To div the following numbers.<br>
	 * For example<br>
	 * <code>div(10,3) : 3</code>
	 * @param num1 : First integer for div
	 * @param num2 : Last integer for div
	 * @return : int
	 * 
	 * @see Math
	 * @throws ArithmeticException
	 * 
	 */
	public int div(int num1, int num2) {
		return num1 / num2;
	}
	
	
	public static void main(String[] args) {
		Math2 m = new Math2();
	}
}











