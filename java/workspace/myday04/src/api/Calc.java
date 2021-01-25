package api;

import api2.Math2;

/**
 * 
 * @author unascribed
 * @since JDK8
 * <br>Calculator
 *
 * 
 */
public class Calc {
	/**
	 * To div the following numbers. <br>
	 * For example<br>
	 * <code>div(10,3) : 3</code>
	 * @param n1: First Integer for div
	 * @param n2: Last Integer for div
	 * @return : int
	 * 
	 * @see Math
	 * @throws ArithmeticException
	 */
	public int div(int n1, int n2) {
		return n1/n2;
	}
	
	public static void main(String[] args) {
		Math2 m = new Math2();
		System.out.println(m.add(6, 3));
	}
}
