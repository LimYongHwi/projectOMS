package LibraryPage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

import BookFile.BookRead;
import BookFile.BookWrite;
import LibraryBook.*;
import LibraryMember.*;
import MemberFile.MemberRead;
import MemberFile.MemberWrite;

public class BookIn {

	protected Member member;
	protected Book book;

	Member id = new Id();
	Member bookCount = new BookCount();

	BorrowBook borrowBook = new BorrowBook();

	Book bookName = new BookName();
	Book author = new Author();
	Book bookAmount = new BookAmount();
	Book genre = new Genre();
	Book borrowAmount = new BorrowAmount();
	Book inDate = new InDate();
	Book uniqueNum = new UniqueNum();
	

	static Scanner scan = new Scanner(System.in);

	public void bookRead() {
		BookRead bookRead = new BookRead();
		List<String> bookNameList = bookRead.bookNameLoad();
		bookName.read(bookNameList);
		List<String> authorList = bookRead.authorLoad();
		author.read(authorList);
		List<String> inDateList = bookRead.inDateLoad();
		inDate.read(inDateList);
		List<String> genreList = bookRead.genreLoad();
		genre.read(genreList);
		List<String> uniqueNumList = bookRead.uniqueNumLoad();
		uniqueNum.read(uniqueNumList);
		List<String> bookAmountList = bookRead.bookAmountLoad();
		bookAmount.read(bookAmountList);
		List<String> borrowList = bookRead.borrowLoad();
		borrowAmount.read(borrowList);
	}
	
	BookWrite bookWrite = new BookWrite();

	public void bookWriteDynamic() {
		bookWrite.bookSave(bookAmount.list(), "bookAmount");
		bookWrite.bookSave(borrowAmount.list(), "borrowAmount");
	}
	
	public void bookWrite() {
		bookWrite.bookSave(bookName.list(), "bookName");
		bookWrite.bookSave(author.list(), "author");
		bookWrite.bookSave(inDate.list(), "inDate");
		bookWrite.bookSave(genre.list(), "genre");
		bookWrite.bookSave(uniqueNum.list(), "uniqueNum");
		bookWrite.bookSave(bookAmount.list(), "bookAmount");
		bookWrite.bookSave(borrowAmount.list(), "borrowAmount");
	}

	public static int checkInt(int select) {
		try {
			select = scan.nextInt(); // menu1의 메뉴 선택 변수
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력해 주세요.");
		}
		return select;
	}

	public void bookInDirect() {
		System.out.println("입고하실 책의 정보를 입력하세요.");
		System.out.print("책 제목 : ");
		scan.nextLine(); // 입력버퍼 비우기(White space 방지)
		String inbookName = scan.nextLine();

		System.out.print("저자 : ");
		String inauthor = scan.nextLine();

		int bookInSelect = 0; // 입고 여부 선택 변수
		System.out.println("해당 책을 입고하시겠습니까? \n 1. 입고 2. 취소");
		System.out.print(" >>");
		bookInSelect = checkInt(bookInSelect);
		
		switch (bookInSelect) {
		case 1:
			if (bookName.Keyword(inbookName) && author.Keyword(inauthor)) {
				for (int i = 0; i < bookName.list().size(); i++) {
					// bookAmount(도서관 보여 권수) 배열의 i번째 index 값
					int bookAmtIdx = Integer.parseInt(bookAmount.list().get(i));
					String uniNum = "";
					
					uniNum = uniqueNum.list().get(i);

					if (bookName.list().get(i).equals(inbookName) && author.list().get(i).equals(inauthor)) {
						if (bookAmtIdx >= 3) {
							System.out.println("이 책은 더 이상 입고가 안 됩니다.");
						} else {
							bookAmount.list().set(i, String.valueOf(bookAmtIdx + 1));
							System.out.println("[책 제목 : " + inbookName + "], [저자 : " + inauthor + "], [고유번호 : " + uniNum+"]");
							System.out.println(" 해당 책의 권수가 " + String.valueOf(bookAmtIdx + 1) + "권으로 늘었습니다.");
						}
					}
				}
			} else {
				bookInGenre(inbookName, inauthor); // 장르&고유번호 입력
				bookName.in(inbookName);
				author.in(inauthor);
				bookAmount.in("1"); // 도서관 보유 권수 입력
				borrowAmount.in("0"); // 대여한 권수 입력
				bookInDate(); // 입고 일자 입력
			}
			break;
		case 2:
			break;
		default:
			System.out.println("번호를 확인해 주세요.");
		}
	}

	public String genreCheck(int num) {
		int check = 0;
		if (uniqueNum.list().size() > 0) {
			for (int i = 0; i < uniqueNum.list().size(); i++) {
				if (uniqueNum.list().get(i).contains(String.valueOf(num))) {
					check++;
					num++;
				}
			}
		}
		if (check == 0) {
			return String.valueOf(num);
		} else {
			return genreCheck(num);
		}
	}

	public void bookInGenre(String inbookName, String inauthor) {
		int genreSelect = 0; // 책의 장르 선택 변수
		int bookInSelect = 0; // 입고 여부 선택 변수

		System.out.println("책의 장르를 선택해 주세요.");
		System.out.println(" 1.문학 2.자기계발 3.경제/경영 4.인문/사회 5.교육 6.과학/기술 7.취미/예술 8.기타");
		System.out.print(" >> ");
		genreSelect = checkInt(genreSelect);

		int cnt = 0;
		cnt = genreSelect * 10000;
		String genreCnt = genreCheck(cnt);

		String bookInMsg = "[책 제목 : " + inbookName + "], [저자 : " + inauthor + "], [고유번호 : YO" + genreCnt +"]";

		switch (genreSelect) {
		case 1:
			genre.in("문학");
			uniqueNum.in(genreCnt);
			System.out.println(bookInMsg);
			break;
		case 2:
			genre.in("자기계발");
			uniqueNum.in(genreCnt);
			System.out.println(bookInMsg);
			break;
		case 3:
			genre.in("경제/경영");
			uniqueNum.in(genreCnt);
			System.out.println(bookInMsg);
			break;
		case 4:
			genre.in("인문/사회");
			uniqueNum.in(genreCnt);
			System.out.println(bookInMsg);
			break;
		case 5:
			genre.in("교육");
			uniqueNum.in(genreCnt);
			System.out.println(bookInMsg);
			break;
		case 6:
			genre.in("과학/기술");
			uniqueNum.in(genreCnt);
			System.out.println(bookInMsg);
			break;
		case 7:
			genre.in("취미/예술");
			uniqueNum.in(genreCnt);
			System.out.println(bookInMsg);
			break;
		case 8:
			genre.in("기타");
			uniqueNum.in(genreCnt);
			System.out.println(bookInMsg);
			break;
		default:
			System.out.println("장르 번호를 확인해 주세요.");
			break;
		}
	}

	public void bookInDate() {
		Date now = new Date();
		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
		String indate = today.format(now);
		inDate.in(indate);
	}

	public void fileIn() {
		BufferedReader bw = null;
		try {
			bw = new BufferedReader(new InputStreamReader(new FileInputStream("addBook.txt")));
			int c;
			while ((c = bw.read()) != -1) {
				String inbookName = bw.readLine().trim();
				String inauthor = bw.readLine().trim();
				String ingenre = bw.readLine().trim();
				int genreSelect;
				if (ingenre.equals("문학"))
					genreSelect = 1;
				else if (ingenre.equals("자기계발"))
					genreSelect = 2;
				else if (ingenre.equals("경제/경영"))
					genreSelect = 3;
				else if (ingenre.equals("인문/사회"))
					genreSelect = 4;
				else if (ingenre.equals("교육"))
					genreSelect = 5;
				else if (ingenre.equals("과학/기술"))
					genreSelect = 6;
				else if (ingenre.equals("취미/예술"))
					genreSelect = 7;
				else
					genreSelect = 8;

				if (bookName.Keyword(inbookName) && author.Keyword(inauthor)) {
					for (int i = 0; i < bookName.list().size(); i++) {
						// bookAmount(도서관 보여 권수) 배열의 i번째 index 값
						int bookAmtIdx = Integer.parseInt(bookAmount.list().get(i));

						if (bookName.list().get(i).equals(inbookName) && author.list().get(i).equals(inauthor)) {
							if (bookAmtIdx >= 3) {
								System.out.println("이 책은 더 이상 입고가 안 됩니다.");
							} else {
								bookAmount.list().set(i, String.valueOf(bookAmtIdx + 1));
								System.out.println("해당 책의 권수가 " + String.valueOf(bookAmtIdx + 1) + "권으로 늘었습니다.");
							}
						}
					}
				} else {
					bookName.in(inbookName);
					author.in(inauthor);
					bookInGenre(inbookName, inauthor); // 장르&고유번호 입력
					bookAmount.in("1"); // 도서관 보유 권수 입력
					borrowAmount.in("0"); // 대여한 권수 입력
					bookInDate(); // 입고 일자 입력
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일 로딩에 실패하였습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
