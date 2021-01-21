package bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {

		// 각 은행별로 최대 100명의 고객을 유치할 수 있다.
		Shinhan[] arS = new Shinhan[100];
		Kookmin[] arK = new Kookmin[100];
		Woori[] arW = new Woori[100];

		Bank[][] arrBank = { arS, arK, arW };
		
		int[] arUserCnt = {Shinhan.cnt, Shinhan.cnt, Woori.cnt};

		int choice;
		int optionChoice = 0;

		String msg = "은행을 고르세요.\n1. 신한 2. 국민 3. 우리 4. 나가기";
		String optionMsg = "1. 계좌개설, 2. 입금하기, 3. 출금하기, 4. 잔액조회, 5. 계좌번호 찾기, 6. 돌아가기";

		String name = null, account = null, pw = null, phone = null;
		
		//중복여부 확인 flag
		boolean check = false;
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		// 메인메뉴 : 은행선택(신한, 국민, 우리)
		// 사용자 메뉴: 계좌개설, 입금하기, 출금하기, 잔액조회, 계좌번호 찾기, 돌아가기

		// 계좌 개설 시 필요한 정보
		// 1. 예금주
		// 2. 비밀번호(비밀번호는 4자리이고, 4자리를 입력할때 까지 무한반복)
		// 3. 계좌번호(계좌번호는 6자리이며, 100000부터 시작한다. 중복검사 후 중복이 없을 때까지 무한반복)
		// new Random().nextInt() 사용
		// 4. 핸드폰 번호(-를 제외하고 입력받으며, 중복검사 후 중복이 없을 때까지 무한 반복)
		// '0' ~ '9' 아스키코드 이용

		// ※중복검사는 해당 은행의 고객 수 만큼만 반복하여 검사한다.

		// 계좌번호 찾기 구현 방법
		// 핸드폰 번호와 비밀번호를 입력한 후 일치하는 고객의 계좌번호를 재발급해준다.

		while (true) {

			System.out.println(msg);
			choice = sc.nextInt();
			
			if (choice == 4) break;
			while (true) {
				
				System.out.println(optionMsg);
				optionChoice = sc.nextInt();
				if(optionChoice==5) break;
				switch (optionChoice) {
				//계좌계설 (예금주, 계좌번호, 비밀번호, 핸드폰번호)
				case 1:
					while (true) {
						switch (choice) {
						case 1:
							// 계좌개설
							System.out.println("예금주를 입력하세요.");
							name = sc.next();
							do {
								//중복 여부 확인 flag
								check = false;
								account = (r.nextInt(900000)+100000)+"";
								//중복검사
								for(int i=0;i<arrBank.length;i++) {
									for(int j=0;j<arU)
								}
							}while(check)
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							break;
						case 6:
							break;
						}
						break;
					}
					break;
				case 2:
					break;
				case 3:
					break;

				}
			}

		}

	}

}
