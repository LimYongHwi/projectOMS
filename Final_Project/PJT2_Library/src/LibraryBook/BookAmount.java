package LibraryBook;

import java.util.*;

public class BookAmount implements Book {
	private List<String> bookAmount = new ArrayList<String>();

	@Override
	public void in(String in) {
		bookAmount.add(in);
	}

	@Override
	public void out(int out) {
		bookAmount.remove(out);
	}

	@Override
	public boolean Keyword(String key) {
		return false;
	}

	@Override
	public String print(int x) {
		return bookAmount.get(x);
	}
	
	@Override
	public List<String> list() {
		return bookAmount;
	}

	@Override
	public void read(List<String> list) {
		for (int i = 0; i< list.size(); i++) {
			bookAmount.add(list.get(i));
		}
	}

//	public void bookInAmt(int index) {
//		int idx = Integer.parseInt(bookAmount.get(index));
//		if (idx >= 3) {
//			System.out.println("이 책은 더 이상 입고가 안됩니다.");
//		} else {
//			bookAmount.set(index, String.valueOf(idx-1));
//			System.out.println("해당 책의 권수가" + idx + "권으로 늘었습니다.");
//		}
//	}

//	public int bookOutAmt(int index) { // 5. 출고에만 사용
//		int idx = Integer.parseInt(bookAmount.get(index));
//		if (idx > 1) {
//			bookAmount.set(index, String.valueOf(idx-1));
//			System.out.println("해당 책의 권수가" + idx + "권으로 줄었습니다.");
//			return 1; // 책의 권수가 2권 이상일 경우, 1권으로 줄인다.
//		} else if (idx == 1) {
//			return 2; // 책의 권수가 1권일 경우, 해당 배열을 remove한다.
//		} else {
//			return 3; // 책이 없을 경우
//		}
//	}
}
