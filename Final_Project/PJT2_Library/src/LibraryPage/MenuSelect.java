package LibraryPage;

import java.io.*;
import java.util.*;

import BookFile.BookRead;
import BookFile.BookWrite;
import LibraryBook.*;
import LibraryMember.*;
import MemberFile.MemberRead;
import MemberFile.MemberWrite;

public class MenuSelect extends BookIn {

	static int menu1Exit = 0; // StartPage_menu1 종료할 비교 변수

	public void memberRead() {
		MemberRead memberRead = new MemberRead();

		List<String> idList = memberRead.idLoad();
		id.read(idList);

		List<String> bookCntList = memberRead.bookCntLoad();
		bookCount.read(bookCntList);

		List<String> borrowBookList = memberRead.borrowBookLoad();
		borrowBook.read(borrowBookList);
	}

	public void memberWrite() {
		MemberWrite memberWrite = new MemberWrite();
		memberWrite.idSave(id.list());
		memberWrite.bookCntSave(bookCount.list());
		memberWrite.borrowBookSave(borrowBook.list());
	}

	public void memberLogin() { // Login - 1. 로그인

		// login 성공할 경우 LoginSuccess.class 불러올 new생성자
		LoginSuccess loginSuccess = new LoginSuccess();

		System.out.println("로그인하실 아이디를 입력하세요.");
		System.out.print("아이디 : ");
		// scan.nextLine(); // 입력 버퍼 비우기(White space 방지)
		String loginId = scan.nextLine();

		if (id.IdCheck(loginId) == true) {
			System.out.println(loginId + "님 반갑습니다.");
			// 로그인 성공하면 menu2() 호출,
			// 로그아웃이면 return 0, 종료면 return 1
			menu1Exit = loginSuccess.menu2(loginId);
		} else {
			System.out.println("아이디를 다시 확인해 주세요.");
		}
	}

	public void memberJoin() { // Login - 2. 회원가입

		System.out.println("회원가입하실 아이디를 입력하세요.");
		System.out.print("아이디 : ");
		String joinId = scan.nextLine();

		if (id.IdCheck(joinId) == false) {
			System.out.println(joinId + "님 회원가입 완료되었습니다.\n");

			// LibraryMember.Id의 배열 1개에 입력한 회원가입 아이디 추가
			id.IdInput(joinId);
			// LibraryMember.bookCount의 배열 1개에 3개 추가
			bookCount.IdInput(joinId);
			borrowBook.in();
			memberWrite();
		} else {
			System.out.println("중복되는 아이디가 있습니다.\n");
		}

	}

	public void bookSearch() { // LoginSuccess - 1. 조회

		System.out.println("조회하실 키워드를 입력하세요.");
		System.out.print("키워드 : ");
//		scan.nextLine(); // 입력 버퍼 비우기(White space 방지)
		String keySearch = "" ;
		keySearch = scan.nextLine();
		if (true) {
			bookPrint(keySearch);
		} else {
			System.out.println("해당 키워드를 포함하는 책이 없습니다.");
		}
	}

	public void bookRental(String loginId) { // LoginSuccess - 2. 대여
		System.out.println("대여하실 책의 고유번호를 입력하세요.");
		System.out.print("고유번호 : ");
		String uniNum = "";
		uniNum = scan.nextLine();

		int bookBorrowPossible = 0;

		if (uniqueNum.Keyword(uniNum)) {
			// int i = uniqueNum 배열에서 해당 고유번호가 있는 index 값
			for (int u = 0; u < uniqueNum.list().size(); u++) {
				if (uniqueNum.list().get(u).equals(uniNum)) {
					// 도서관 대여가능권수 =
					// 도서관 보유권수 - 다른 유저가 대여한 권수
					bookBorrowPossible = (Integer.parseInt(bookAmount.list().get(u))
							- Integer.parseInt(borrowAmount.list().get(u)));

					// int i = id 배열에서 loginId가 있는 index 값
					for (int i = 0; i < id.list().size(); i++) {
						if (id.list().get(i).equals(loginId)) {

							// bookCount(id 하나당 부여된 대여 가능한 권수) 배열에서
							// int i와 같은 index 값
							int bookCntIdx = Integer.parseInt(bookCount.list().get(i));

							// id 하나당 부여된 대여 가능한 권수가 0 이상이고,
							if (bookCntIdx > 0) {

								// 도서관에서 대여 가능한 권수가 0이 아닐 경우
								if (bookBorrowPossible != 0) {
									bookPrint(uniNum);
									System.out.println("해당 책을 대여하시겠습니까?\n 1. 대여 2. 취소");
									System.out.print(" >>");
									int rentalSelect = 0;
									rentalSelect = checkInt(rentalSelect);

									if (rentalSelect == 1) {
										// borrowAmount(다른 유저가 대여한 권수) 배열에서
										// int u와 같은 index 값
										int borrowAmtIdx = Integer.parseInt(borrowAmount.list().get(u));
										// id 하나당 대여 가능한 권수 중
										// 빈 값인 index를 책 제목/고유번호 로 변경
										borrowBook.borrowBookRental(loginId, bookName.list().get(u),
												uniqueNum.list().get(u));
										// 대여한 권수 +1
										borrowAmount.list().set(u, String.valueOf(borrowAmtIdx + 1));
										// id 하나당 부여된 대여 가능한 권수 -1
										bookCount.list().set(i, String.valueOf(bookCntIdx - 1));

										System.out.println(loginId + "님, <" + bookName.list().get(u) + "> 대여 완료되었습니다.");
									} else if (rentalSelect == 2) {
										return;
									} else {
										System.out.println("번호를 다시 입력해 주세요.");
									}

								} else {
									System.out.println("대여 가능한 책이 없습니다. 죄송합니다.");
								}
							} else {
								System.out.println("대여 가능한 책의 권수는 3권입니다.");
							}
						}
					} // End of for (int i)
				}
			} // End of for (int u)
		} else {
			System.out.println("고유번호를 다시 한 번 확인해 주세요.");
		}
	}

	public void bookReturn(String loginId) { // LoginSuccess - 3. 반납
		System.out.println("반납하실 책의 고유번호를 입력하세요.");
		System.out.print("고유번호 : ");
		String uniNum = "";
		uniNum = scan.next();

		int borrowAmtIdx = 0;

		if (borrowBook.borrowBookList(loginId)) {
			System.out.println("대여하신 책이 없습니다.");
		} else if (uniqueNum.Keyword(uniNum)) {
			// int u = uniqueNum 배열에서 해당 고유번호가 있는 index 값
			for (int u = 0; u < uniqueNum.list().size(); u++) {
				if (uniqueNum.list().get(u).equals(uniNum)) {

					// int i = id 배열에서 loginId가 있는 index 값
					for (int i = 0; i < id.list().size(); i++) {
						if (id.list().get(i).equals(loginId)) {
							// int z = loginId가 있는 값 * 3
							// 왜냐하면 loginId 하나당 borrowBook 배열 3개
							int z = i * 3;
							// int j = loginId가 있는 index 값 포함 3개까지
							for (int j = z; j < z + 3; j++) {
								if (borrowBook.list().get(j).contains(uniNum)) {

									// borrowAmount(다른 유저가 대여한 권수) 배열에서
									// int u와 같은 index 값
									borrowAmtIdx = Integer.parseInt(borrowAmount.list().get(u));
									// bookCount(id 하나당 부여된 대여 가능한 권수) 배열에서
									// int i 와 같은 index 값
									int bookCntIdx = Integer.parseInt(bookCount.list().get(i));

									borrowBook.borrowBookReturn(loginId, uniNum);

									// 대여한 권수 -1
									borrowAmount.list().set(u, String.valueOf(borrowAmtIdx - 1));
									// id 하나당 부여된 대여 가능한 권수 +1
									bookCount.list().set(i, String.valueOf(bookCntIdx + 1));

									System.out.println(loginId + "님, <" + bookName.list().get(u) + "> 반납 완료되었습니다.");
								}
							} // End of for (int z)
						}
					} // End of for (int i)
				}
			} // End of for (int u)
		} else {
			System.out.println("고유번호를 다시 한 번 확인해 주세요.");
		}
	}

	public void bookIn() { // LoginSuccess - 4. 입고

		int bookInExit = 0;
		// LoginSuccess_menu2_4.입고 종료할 비교 변수로,
		// 0이 아닌 숫자가 되면 나간다.

		int bookInSelect = 0;
		while (bookInExit == 0) {
			System.out.println("입고하실 방법을 선택해 주세요.\n 1. 직접 입력  2. 파일 입력  3. 메뉴로");
			bookInSelect = checkInt(bookInSelect);
			switch (bookInSelect) {
			case 1: // 1. 직접 입력
				bookInDirect();
				bookInExit = 1;
				break;
			case 2:
				fileIn();
				bookInExit = 1;
				break;
			case 3:
				bookInExit = 1;
				break;
			default:
				System.out.println("메뉴 번호를 확인해 주세요.");
				break;
			}
		}
	}

	public void bookOut() { // LoginSuccess - 5. 출고
		List<String> temp = new ArrayList<String>();

		System.out.println("출고하실 책의 고유번호를 입력하세요.");
		System.out.print("고유번호 : ");
		String uniNum = "";
		uniNum = scan.nextLine();

		for (int b = 0; b < borrowBook.list().size(); b++) {
			if (borrowBook.list().get(b).contains(uniNum)) {
				System.out.println("해당 책은 대여 중이기 때문에 출고가 안 됩니다.");
				return;
			}
		}
		// 입력 받은 고유번호가 uniqueNum 배열에 포함되어 있는지 확인
		if (uniqueNum.Keyword(uniNum)) {
			temp = uniqueNum.list();
			for (int u = 0; u < temp.size(); u++) {
				// uniqueNumber(고유번호) 배열의 u번째 index
				if (temp.get(u).equals(uniNum)) {
					// bookAmount(도서관 보유 권수) 배열의 u번째 index
					int bookAmtIdx = Integer.parseInt(bookAmount.list().get(u));

					if (bookAmtIdx > 1) {
						bookAmount.list().set(u, String.valueOf(bookAmtIdx - 1));
						System.out.println("해당 책의 권수가 " + u + "권으로 줄었습니다.");
					} else if (bookAmtIdx == 1) {
						System.out.println(bookName.print(u) + "책이 출고되었습니다.");
						bookName.out(u);
						author.out(u);
						inDate.out(u);
						genre.out(u);
						uniqueNum.out(u);
						borrowAmount.out(u);
						bookAmount.out(u);
					}
				}
			}
		} else {
			System.out.println("고유번호를 다시 한 번 확인해 주세요.");
		}
	}

	public void memberInfo(String loginId) { // LoginSuccess - 6. 정보조회

		for (int i = 0; i < id.list().size(); i++) {
			if (id.list().get(i).equals(loginId)) {
				System.out.println("아이디 : " + loginId + " 님");
				System.out.println("대여하신 책 정보(책제목, 고유번호) \n" + borrowBook.getBorrowBook(i));
				// bookPrint(borrowBook.getBorrowBook(i));
			}
		}
	}

	public int logout() { // LoginSuccess - 7. 로그아웃
		int box;
		int logoutExit = 0;
		while (logoutExit == 0) {
			System.out.println("정말로 로그아웃하시겠습니까? \n 1. 로그아웃 2. 취소");
			System.out.print(" >>");
			box = scan.nextInt();
			if (box == 1) {
				logoutExit = 1; // while 문을 빠져나가서 return 1
			} else if (box == 2) {
				return 0; // return 0
			} else {
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
			continue;
		}
		return 1;
	}

	public int exit() { // LoginSuccess - 8. 종료
		int exitExit = 0; //
		int exitSelec;
		// 종료 여부 확인 변수
		while (exitExit == 0) {
			System.out.println("정말로 종료하시겠습니까? \n 1. 종료 2. 취소");
			System.out.print(" >>");
			exitSelec = scan.nextInt();
			if (exitSelec == 1) {
				System.out.println("프로그램을 종료합니다. 이용해 주셔서 감사합니다.");
				menu1Exit = 1;
				exitExit = 1;
				// while 문을 나가서 return 1;
			} else if (exitSelec == 2) {
				return 0;
				// return 0
			} else {
				System.out.println("번호를 잘못 입력하셨습니다.");
				continue;
			}
		}
		return 1;
	}

	public void bookPrint(String keySearch) {
		int bookBorrowPossible = 0;
		try {
			System.out.println(
					"=================================================================================================");
			System.out.println("책제목" + "\t\t\t\t\t\t" + "저자" + "\t\t\t\t" + "입고일자" + "\t\t\t" + "장르" + "\t\t\t" + "고유번호"
					+ "\t\t" + "도서관보유권수" + "\t" + "대여가능권수");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < bookName.list().size(); i++) {
				bookBorrowPossible = Integer.parseInt(bookAmount.print(i)) - Integer.parseInt(borrowAmount.print(i));
				if ((bookName.list().get(i).contains(keySearch)) || (author.list().get(i).contains(keySearch))
						|| (uniqueNum.list().get(i).equals(keySearch)
								|| (borrowBook.list().get(i).contains(keySearch)))) {

					String s1 = bookName.print(i);

					if (s1.length() < 6) {
						System.out.print(bookName.print(i));
						System.out.print("\t\t\t\t\t\t");
						System.out.print(author.print(i));
						System.out.print("\t\t");
						System.out.print(inDate.print(i));
						System.out.print("\t\t\t");
						System.out.print(genre.print(i));
						System.out.print("\t\t\t");
						System.out.print(uniqueNum.print(i) + "번");
						System.out.print("\t\t\t");
						System.out.print(bookAmount.print(i) + "권");
						System.out.print("\t\t\t");
						System.out.println(String.valueOf(bookBorrowPossible) + "권");
					} 
					else if (s1.length() < 14) {
						System.out.print(bookName.print(i));
						System.out.print("\t\t\t\t");
						System.out.print(author.print(i));
						System.out.print("\t\t");
						System.out.print(inDate.print(i));
						System.out.print("\t\t\t");
						System.out.print(genre.print(i));
						System.out.print("\t\t\t");
						System.out.print(uniqueNum.print(i) + "번");
						System.out.print("\t\t\t");
						System.out.print(bookAmount.print(i) + "권");
						System.out.print("\t\t\t");
						System.out.println(String.valueOf(bookBorrowPossible) + "권");
					}
					else if (s1.length() < 20) {
						System.out.print(bookName.print(i));
						System.out.print("\t\t\t");
						System.out.print(author.print(i));
						System.out.print("\t\t");
						System.out.print(inDate.print(i));
						System.out.print("\t\t\t");
						System.out.print(genre.print(i));
						System.out.print("\t\t\t");
						System.out.print(uniqueNum.print(i) + "번");
						System.out.print("\t\t\t");
						System.out.print(bookAmount.print(i) + "권");
						System.out.print("\t\t\t");
						System.out.println(String.valueOf(bookBorrowPossible) + "권");
					} else {
						System.out.print(bookName.print(i));
						System.out.print(" ");
						System.out.print(author.print(i));
						System.out.print("\t\t");
						System.out.print(inDate.print(i));
						System.out.print("\t\t\t");
						System.out.print(genre.print(i));
						System.out.print("\t\t\t");
						System.out.print(uniqueNum.print(i) + "번");
						System.out.print("\t\t\t");
						System.out.print(bookAmount.print(i) + "권");
						System.out.print("\t\t\t");
						System.out.println(String.valueOf(bookBorrowPossible) + "권");
					}
				}
			}
			System.out.println(
					"================================================================================================");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("보유하고 있는 책이 한 권도 없습니다. 죄송합니다.");
		}
	}
}
