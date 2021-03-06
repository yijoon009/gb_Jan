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
		String errMsg = "다시 시도해주세요.";
		
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
			while(true) {
				System.out.println(optionMsg);
				optionChoice = sc.nextInt();
				if(optionChoice==6) break;
				switch(optionChoice) {
				//계좌개설
				case 1:
					System.out.print("예금주: ");
					name=sc.next();
					
					do {
						//중복 여부 확인 flag
						check=false;
						account=(r.nextInt(900000)+100000)+"";
						//중복검사
						for(int i=0;i<arrBank.length;i++) {
							//arUserCnt[i]: 해당 은행의 회원 수
							for(int j=0;j<arUserCnt.length;j++) {
								if(arrBank[i][j].account.equals(account)) {
									//중복시 check는 true
									check=true;
								}
							}
						}
						//중복되지 않을 때까지 무한반복
					} while(check);
					
					do {
						System.out.println("설정할 비밀번호 4자리를 입력하세요");
						pw = sc.next();
					}while(pw.length()!=4);
					
					while(true) {
						System.out.println("휴대폰 번호 입력 (-제외)");
						phone = sc.next();
						try {
							Integer.parseInt(phone);
							break;
						} catch (NumberFormatException e) {
							System.out.println("숫자만 입력할 수 있습니다.");
						}
					}
					
					
					Bank temp = arrBank[choice-1][arUserCnt[choice-1]];
					temp.name = name;
					temp.pw = pw;
					temp.account = account;
					temp.phone = phone;
					
					System.out.println("축하드립니다!!");
					System.out.println(name+"님의 계좌번호는"+account+"입니다.");
					System.out.println("이제부터 정상이용 가능합니다!!!");
					
					arUserCnt[choice-1]++;
					break;
				//입금하기
				case 2:
					System.out.println("계좌번호: ");
					account = sc.next();
					
					System.out.println("비밀번호: ");
					pw = sc.next();
					
					for(int i=0;i<arUserCnt[choice-1];i++) {
						if(arrBank[choice-1][i].account.equals(account) && 
								arrBank[choice-1][i].pw.equals(pw)) {
							check = true;
							System.out.println("입금액 : ");
							arrBank[choice-1][i].deposit(sc.nextInt());
							System.out.println("현재 잔액 : "+arrBank[choice-1][i].money+"원");
							break;
						}
					}
					
					if(!check) System.out.println("계좌번호 혹은 비밀번호를 확인해주세요.");

					break;
				//출금하기
				case 3:
					System.out.println("계좌번호: ");
					account = sc.next();
					
					System.out.println("비밀번호: ");
					pw = sc.next();
					
					for(int i=0;i<arUserCnt[choice-1];i++) {
						if(arrBank[choice-1][i].account.equals(account) && 
								arrBank[choice-1][i].pw.equals(pw)) {
							check = true;
							System.out.println("출금액 : ");
							if(arrBank[choice-1][i].withdraw(sc.nextInt())) {
								System.out.println("현재 잔액 : "+arrBank[choice-1][i].money+"원");
							}else {
								System.out.println("출금 실패/잔액 부족");
							}
							break;
						}
					}
					
					if(!check) System.out.println("계좌번호 혹은 비밀번호를 확인해주세요.");
					break;
				//잔액조회
				case 4:
					System.out.println("계좌번호: ");
					account = sc.next();
					
					System.out.println("비밀번호: ");
					pw = sc.next();
					for(int i=0;i<arUserCnt[choice-1];i++) {
						if(arrBank[choice-1][i].account.equals(account)&&
								arrBank[choice-1][i].pw.equals(pw)) {
							check = true;
							System.out.println("예금주: "+arrBank[choice-1][i].name);
							System.out.println("계좌번호: "+arrBank[choice-1][i].account);
							System.out.println("현재 잔액: "+arrBank[choice-1][i].getBalance()+"원");
							break;
						}
					}
					if(!check) {
						System.out.println("계좌번호 혹은 비밀번호를 확인해주세요.");
					}
					break;
				//계좌번호 찾기
				case 5:
					System.out.println("전화번호: ");
					phone = sc.next();
					System.out.println("비밀번호: ");
					pw = sc.next();
					for(int i=0;i<arUserCnt[choice-1];i++) {
						if(arrBank[choice-1][i].phone.equals(phone) && 
								arrBank[choice-1][i].pw.equals(pw)) {
							check = true;
							System.out.println("사용자의 계좌번호는 "+arrBank[choice-1][i].account);
							break;
						}
						
					}
					if(!check) {
						System.out.println("전화번호 혹은 비밀번호를 확인해주세요.");
					}
					break;
				default:
					System.out.println(errMsg);
				}
			}
				
				
		}

	}
}
