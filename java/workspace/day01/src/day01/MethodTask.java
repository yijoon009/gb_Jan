package day01;

import java.util.Scanner;

public class MethodTask {
	
	//1~n까지의 합을 println()으로 출력하는 메소드
	void printSumFrom1(int end){
		
		if(end < 1) {
			//특정성 부여하지 않기 위해 사용자가 정의하도록 하자
			throw new ArithmeticException();
		}
		
		int total=0;
		for(int i=0;i<end;i++) {
			total += i + 1;
		}
		System.out.println(total);
	}
	
	public static void sum(int num) {
		int total = 0;
		for(int i=1;i<=num;i++) {
			total +=i;
		}
		System.out.println(total);
	}
	
	
	//나눗셈을 구해주는 메소드
	/**
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 * @throws ArithmeticException
	 */
	public int divFor2Integers(int n1, int n2) {
		return n1/n2;
	}
	
	public static double div(int n1, int n2) {
		return n1/n2;
	}
	
	public static void main(String[] args) {
		//teacher ver
		MethodTask task = new MethodTask();
		try {
			task.printSumFrom1(10);
		} catch (ArithmeticException e1) {
			System.out.println("1보다 큰 수를 입력해 주세요");
		}
		
		try {
			task.divFor2Integers(10, 0);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
		
		
		int num=0;
		int n1=0, n2=0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하시오");
		num = sc.nextInt();
		sum(num);
		
		System.out.println("정수 두개를 입력하시오");
		while(true) {
			n1 = sc.nextInt();
			if(n1==0) {
				System.out.println("0을 나눌 수 없습니다.");
				continue;
			}
			n2 = sc.nextInt();
			if(n2==0) {
				System.out.println("0으로 나눌 수 없습니다.");
				continue;
			}
			System.out.println(div(n1, n2));
			break;
		}
		
	}

}
