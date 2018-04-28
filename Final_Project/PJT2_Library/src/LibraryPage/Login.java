package LibraryPage;

import java.util.InputMismatchException;
import java.util.List;

import MemberFile.MemberRead;
import MemberFile.MemberWrite;

public class Login extends MenuSelect {
	public void menu1() {

		int menu1Select = 0;
		
		System.out.println("도서관리 프로그램을 시작합니다.\n");
		System.out.println("<<로그인 페이지>>");

		memberRead();

		while (menu1Exit == 0) {
			System.out.println("메뉴를 입력해 주세요.\n1. 로그인       2. 회원가입       3. 종료");
			System.out.print("->");	
			menu1Select = checkInt(menu1Select);
			scan.nextLine();
			
			switch (menu1Select) {
			case 1:
				memberLogin();
				break;
			case 2:
				memberJoin();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다. 이용해 주셔서 감사합니다.");
				menu1Exit = 1;
				break;
			default:
				System.out.println("메뉴 번호를 확인해 주세요.\n");
			}

		}
	}
}
