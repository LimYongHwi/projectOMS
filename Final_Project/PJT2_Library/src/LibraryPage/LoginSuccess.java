package LibraryPage;

public class LoginSuccess extends MenuSelect {

	public int menu2(String loginId) {
		bookRead(); // 저장되어 있는 book 정보 모두 불러오기
		int menu2Exit = 0; // LoginSuccess_menu2 종료할 비교 변수
		int menu2Select = 0;

		while (menu2Exit == 0) {
			System.out.println("\n메뉴를 입력해 주세요.\n1. 조회 2. 대여 3. 반납 4. 입고 5. 출고 6. 정보조회 7. 로그아웃 8. 종료");
			System.out.print("->");
			menu2Select = checkInt(menu2Select); // menu2의 메뉴 선택 변수
			scan.nextLine();

			switch (menu2Select) {
			case 1: // 1. 조회
				bookSearch();
				break;
			case 2: // 2. 대여
				bookRental(loginId);
				bookWriteDynamic();
				memberWrite();
				break;
			case 3: // 3. 반납
				bookReturn(loginId);
				bookWriteDynamic();
				memberWrite();
				break;
			case 4: // 4. 입고
				bookIn();
				bookWrite();
				memberWrite();
				break;
			case 5: // 5. 출고
				bookOut();
				bookWrite();
				memberWrite();
				break;
			case 6: // 6. 정보조회
				memberInfo(loginId);
				break;
			case 7: // 7. 로그아웃
				// 1. 로그아웃 : return 1을 받기 때문에 true 이므로 return 0 -> Login menu1()
				// 2. 취소 : return 0을 받아서 while 문 그대로 돎
				if (logout() == 1) {
					return 0;
				} else {
					menu2Exit = 0;
				}
				break;
			case 8: // 8. 종료
				// 1. 종료 : return 1을 받기 때문에 true 이므로 return 1
				// 2. 취소 : return 0을 받기 때문에 while 문 그대로 돎
				if (exit() == 1) {
					return 1;
				} else {
					menu2Exit = 0;
				}
				break;
			default:
				System.out.println("메뉴 번호를 확인해 주세요.");
				break;
			}
		}
		return 0;

	}

}
