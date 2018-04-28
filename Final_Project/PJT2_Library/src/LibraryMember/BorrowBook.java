package LibraryMember;

import java.util.ArrayList;
import java.util.List;

import LibraryPage.BookIn;

public class BorrowBook { // 대여한 책

	private static List<String> borrowBook = new ArrayList<String>();

	static Member id = new Id();

	public void in() {
		borrowBook.add(" ");
		borrowBook.add(" ");
		borrowBook.add(" ");
	}

	public List<String> list() {
		return borrowBook;
	}

	public void read(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			borrowBook.add(list.get(i));
		}
	}
	
	public boolean borrowBookList(String loginId) {
		for (int i = 0; i< id.list().size(); i++) {
			if(id.list().get(i).equals(" ")) {
				int z = (i*3);
				for (int j = z; j < z+3; j++) {
					if (borrowBook.get(z).equals(" ") && borrowBook.get(z+1).equals(" ") &&
							borrowBook.get(z+2).equals(" ")) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
		return false;
	}
	
	// id 하나당 대여 가능한 권수 3권
	public int borrowBookRental(String loginId, String bookName, String uniNum) {
		for (int i = 0; i < id.list().size(); i++) {
			// id 배열에 loginId 가 저장되어 있다면 i = loginId가 저장되어 있는 id 배열의 index
			if (id.list().get(i).equals(loginId)) {
				// j = 해당 index 포함 3개까지 ex) 1~3, 4~6, 7~9
				int z = (i*3);
				for (int j = z; j < z + 3; j++) {
					// 해당 배열에서 빈 값(" ")인 배열의 index를 return
					if (borrowBook.get(j).equals(" ")) {
						borrowBook.set(j, (bookName + ", " + uniNum));
						return j + i;
					}
				}
			}
		}
		return -1;
	}

	// 반납
	public int borrowBookReturn(String loginId, String uniNum) {
		for (int i = 0; i < id.list().size(); i++) {
			if (id.list().get(i).equals(loginId)) {
				int z = (i*3);
				for (int j = z; j < z + 3; j++) {
					if (borrowBook.get(j).contains(uniNum)) {
						borrowBook.set(j, (" "));
						return j + i;
					}
				}
			}
		}
		return 4;
	}

	// LoginSuccess - 6. 정보조회
	public static String getBorrowBook(int index) {
		String temp = " 1. " + borrowBook.get(index * 3) + "\t 2. " + borrowBook.get((index * 3) + 1) + "\t 3. "
				+ borrowBook.get((index * 3) + 2);
		return temp;
	}

}