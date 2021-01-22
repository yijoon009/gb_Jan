package bank_teacher;

import java.util.Random;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {

		// 각 은행별로 최대 100명의 고객을 유치할 수 있다.
		Shinhan[] arS = new Shinhan[100];
		Kookmin[] arK = new Kookmin[100];
		Woori[] arW = new Woori[100];

		Bank[][] arrBank = { arS, arK, arW };

//		int[] arUserCnt = {Shinhan.cnt, Shinhan.cnt, Woori.cnt};
		int[] arMemberCnt = { 0, 0, 0 };

		String main_menu = "은행을 고르세요.\n1. 신한 2. 국민 3. 우리 4. 나가기";
		String user_menu = "1. 계좌개설, 2. 입금하기, 3. 출금하기, 4. 잔액조회, 5. 계좌번호 찾기, 6. 돌아가기";
		String errMsg = "다시 시도해주세요.";

		int choice;
		int optionChoice = 0;

		String name = null, account = null, pw = null, phone = null;
		//사용자가 원하는 금액을 담을 변수
		int money = 0;
		
		//계좌번호 FLAG
		boolean isDupAcc = false;

		//고객을 담아줄 임시 저장소
		Bank temp = null;
		
		
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

			System.out.println(main_menu);
			choice = sc.nextInt();
			if (choice == 4) {
				break;
				//은행이 늘어나면 은행 개수도 늘어나고, 은행 메뉴도 늘어난다.
				//개발자가 직접 코드를 수정하지 않고,
				//arMemberCnt.length를 통해 컴파일러가 연산하도록 개발한다.
			}else if(choice < 1 || choice > arMemberCnt.length) {
				continue;
			}
			
			
			
			while (true) {
				System.out.println(user_menu);
				optionChoice = sc.nextInt();
				if (optionChoice == 6) {
					break;
				}

				switch (optionChoice) {
				// 계좌개설
				case 1:
					// 현재 개설된 통장 개수와 은행에서 발급할 수 있는 통장의 개수가 일치하면
					// 더 이상 계좌개설을 할수가 없다.
					if (arMemberCnt[choice - 1] == arrBank[choice - 1].length) {
						System.out.println("정원 초과입니다.");
						break;
					}
					System.out.print("예금주: ");
					name = sc.next();

					do {
						System.out.println("설정할 비밀번호 4자리를 입력하세요");
						pw = sc.next();
					} while (pw.length() != 4);

					// 계좌번호(계좌번호는 6자리이며, 100000부터 시작한다. 중복검사 후 중복이 없을 때까지 무한반복)
					while (true) {

						// 계좌번호 중복체크 플래그
						isDupAcc = false;

						// 100000 ~ 99999
						// 0 ~ 89999 + 100000
						// nextInt(10):: 0~9 //10으로 나눈 나머지 0~9
						account = r.nextInt(900000) + 100000 + ""; // 6자리 랜덤한 계좌번호

						// 모든 은행 수 만큼 반복(신한, 국민, 우리 총 3개)
						// arMemberCount.lenght, arrBank.length : 둘다 은행 개수
						for (int i = 0; i < arMemberCnt.length; i++) {
							// 각 은행 별 고객 수만큼 반복
							for (int j = 0; j < arMemberCnt[i]; j++) {

								// 모든 회원의 계좌번호를 방금 생성한 계좌번호와 같은 지 비교
								if (arrBank[i][j].account.equals(account)) {
									// 중복 있음
									isDupAcc = true;
									break;
								}
							}
							// 중복이 있다면 더 이상 검사할 의미가 없기 때문에 for문을 탈출한다
							if (isDupAcc) {
								break;
							}
						}

						// 중복이 없을 때 탈출
						if (!isDupAcc) {
							break;
						}

					}

//					do {
//						//중복 여부 확인 flag
//						check=false;
//						account=(r.nextInt(900000)+100000)+"";
//						//중복검사
//						for(int i=0;i<arrBank.length;i++) {
//							//arUserCnt[i]: 해당 은행의 회원 수
//							for(int j=0;j<arMemberCnt.length;j++) {
//								if(arrBank[i][j].account.equals(account)) {
//									//중복시 check는 true
//									check=true;
//								}
//							}
//						}
//						//중복되지 않을 때까지 무한반복
//					} while(check);

					while (true) {

						boolean isRightPhone = false;
						boolean isDupphone = false;
						
						System.out.print("휴대폰 번호 입력 (-제외)");
						phone = sc.next();

						// 입력받은 핸드폰 번호 개수만큼 반복(문자 하나하나 검사하기 위해서)
						for (int i = 0; i < phone.length(); i++) {
							char c = phone.charAt(i);
							// 아스키 코드로 정수라면 48~57이다.
							if (c < 48 || c > 57) {
								// 정수가 아닌 문자가 포함되어 있을 때
								isRightPhone = true;
								break;
							}
						}

						if (isRightPhone) {
							continue;
						}

						// 중복검사
						for (int i = 0; i < arrBank.length; i++) {
							for (int j = 0; j < arMemberCnt[i]; j++) {
								if(arrBank[i][j].phone.equals(phone)) {
									//중복 있음
									isDupphone = true;
									break;
								}
							}
							if(isDupphone) {break;}
						}
						
//						if(!isDupphone) {break;}
						//이렇게 사용해도 되지만 안전하게 아래의 코드로 작성을 한다.
						if(!isDupphone && !isRightPhone) {break;}
					}

//					while(true) {
//						System.out.print("휴대폰 번호 입력 (-제외)");
//						phone = sc.next();
//						try {
//							Integer.parseInt(phone);
//							break;
//						} catch (NumberFormatException e) {
//							System.out.println("숫자만 입력할 수 있습니다.");
//						}
//					}

					
					//현재 회원이 없는 곳에서는 null이 저장되어 있으므로,
					//계좌 개설 후 정보를 저장하기 위해서는 해당 필드를 메모리에 할당해야 한다.
					//사용자가 선택한 은행에 맞는 필드를 메모리에 할당하기 위해서 3개의 필드를 준비한다.
					Bank[] arNewMember = {new Shinhan(), new Kookmin(), new Woori()};
					
					arrBank[choice-1][arMemberCnt[choice-1]] = arNewMember[choice-1];
					temp = arrBank[choice - 1][arMemberCnt[choice - 1]];
					
					temp.name = name;
					temp.account = account;
					temp.pw = Bank.encrypt(pw);
					temp.phone = phone;
					
					System.out.println("축하드립니다!!");
					System.out.println("암호화 : "+temp.pw);
					System.out.println("복호화 : "+Bank.decrypt(temp.pw));
					System.out.println(name + "님의 계좌번호는" + account + "입니다.");
					System.out.println("이제부터 정상이용 가능합니다!!!");

	               //내 이전 고객의 정보도 출력해보기
	               if(arMemberCnt[choice - 1] != 0) {
	                  temp = arrBank[choice - 1][arMemberCnt[choice - 1] - 1];
	                  System.out.println("==========이전 고객=========");
	                  System.out.println("예금주 : " + temp.name);
	                  System.out.println("계좌번호 : " + temp.account);
	                  System.out.println("암호화 : " + temp.pw);
	                  System.out.println("복호화 : " + Bank.decrypt(temp.pw));
	                  System.out.println("폰번호 : " + temp.phone);
	               }
					
					//계좌개설 정상 종료 후 해당 은행 고객 수 1 증가
					arMemberCnt[choice - 1]++;
					break;
					
				// 입금하기
				case 2:
					//사용자에게 계좌번호와 비밀번호를 입력받은 후 검사한다.
					//입금액을 입력받아 일치하는 사용자의 통장으로 넣어준다.
					
					isDupAcc = false;
					System.out.println("계좌번호: ");
					account = sc.next();

					//모든 고객의 계좌번호와 비교
					for(int i=0;i<arMemberCnt.length;i++) {
						for(int j=0;j<arMemberCnt[i];j++) {
							if(arrBank[i][j].account.equals(account)) {
								//유효한 계좌번호
								temp = arrBank[i][j];
								isDupAcc = true;
								break;
							}
						}
						if(isDupAcc) {break;}
					}
					if(!isDupAcc) {
						System.out.println("잘못된 계좌번호입니다.");
						continue;
					}
					
					
					//비밀번호 비교
					System.out.print("비밀번호: ");
					pw = sc.next();
					
					//암호화된 pw
//					pw = Bank.encrypt(pw);
//
//					//암호화 된 pw끼리 비교
//					if(temp.pw.equals(pw)) {
//						temp.deposit(money);
//					}else {
//						
//					}
					
					//복호화 후 pw 비교
					if(Bank.decrypt(temp.pw).equals(pw)) {
						System.out.println("입금액: ");
						money = sc.nextInt();
						
						if(money < 1) {
							System.out.println("해당 금액은 입금하실 수 없습니다.");
							continue;
						}
						temp.deposit(money);
						System.out.println("입금 성공!");
					}else {
						System.out.println("잘못된 비밀번호입니다.");
					}
					
					break;
					
				// 출금하기
				case 3:
					
					isDupAcc = false;
					System.out.println("계좌번호: ");
					account = sc.next();

					//모든 고객의 계좌번호와 비교
					for(int i=0;i<arMemberCnt.length;i++) {
						for(int j=0;j<arMemberCnt[i];j++) {
							if(arrBank[i][j].account.equals(account)) {
								//유효한 계좌번호
								temp = arrBank[i][j];
								isDupAcc = true;
								break;
							}
						}
						if(isDupAcc) {break;}
					}
					if(!isDupAcc) {
						System.out.println("잘못된 계좌번호입니다.");
						continue;
					}
					
					
					//비밀번호 비교
					System.out.print("비밀번호: ");
					pw = sc.next();
					
					//복호화 후 pw 비교
					if(Bank.decrypt(temp.pw).equals(pw)) {
						System.out.println("출금액: ");
						money = sc.nextInt();
						
						if(money < 1) {
							System.out.println("해당 금액은 출금하실 수 없습니다.");
							continue;
						}
						if(temp.withdraw(money)) {
							System.out.println("출금 성공!");
						}else {
							System.out.println("출금 실패 / 잔액 부족");
						}
					}else {
						System.out.println("잘못된 비밀번호입니다.");
					}
					break;
					
				// 잔액조회
				case 4:
					
					isDupAcc = false;
					
					System.out.println("계좌번호: ");
					account = sc.next();

					//모든 고객의 계좌번호와 비교
					for(int i=0;i<arMemberCnt.length;i++) {
						for(int j=0;j<arMemberCnt[i];j++) {
							if(arrBank[i][j].account.equals(account)) {
								//유효한 계좌번호
								temp = arrBank[i][j];
								isDupAcc = true;
								break;
							}
						}
						if(isDupAcc) {break;}
					}
					if(!isDupAcc) {
						System.out.println("잘못된 계좌번호입니다.");
						continue;
					}
					
					
					//비밀번호 비교
					System.out.print("비밀번호: ");
					pw = sc.next();
					
					//복호화 후 pw 비교
					if(Bank.decrypt(temp.pw).equals(pw)) {
						System.out.println("현재 잔액: "+temp.getBalance()+"원");
					}else {
						System.out.println("잘못된 비밀번호입니다.");
					}
					
					break;
					
				// 계좌번호 찾기
				case 5:
					boolean isDupPhone = false;
					
					System.out.print("핸드폰 번호(-제외) ");
					phone = sc.next();
					
					//유효성 검사
					for(int i=0;i<arMemberCnt.length;i++) {
						for(int j=0;j<arMemberCnt[i];j++) {
							if(arrBank[i][j].phone.equals(phone)) {
								isDupPhone = true;
								temp = arrBank[i][j];
								break;
							}
						}
						if(isDupPhone) {break;}
					}
					
					if(!isDupPhone) {
						System.out.println("잘못된 핸드폰 번호입니다.");
						continue;
					}
					
					System.out.print("비밀번호: ");
					//암호화
					pw = Bank.encrypt(sc.next());
					
					//암호화 된 pw끼리 비교
					if(temp.pw.equals(pw)) {
						while(true) {
							isDupAcc = false;
							account = r.nextInt(900000)+100000+"";
							
							//중복 검사
							for(int i=0;i<arMemberCnt.length;i++) {
								for(int j=0;j<arMemberCnt[i];j++) {
									if(arrBank[i][j].account.equals(account)) {
										//중복 있음
										isDupAcc = true;
										break;
									}
								}
								if(isDupAcc) {break;}
							}
							//중복이 없을때 while문 탈줄
							if(!isDupAcc) {break;}
						}
						
						//중복 없는 계좌 번호 생성 완료
						temp.account = account;
						System.out.println("본인 인증이 완료되었습니다.");
						System.out.println(temp.name+" 님의 새로운 계좌번호: "+temp.account);
					}else {
						System.out.println("잘못된 비밀번호입니다.");
					}
					
					break;
				
				default:
					System.out.println(errMsg);
				}
			}

		}

	}
}
