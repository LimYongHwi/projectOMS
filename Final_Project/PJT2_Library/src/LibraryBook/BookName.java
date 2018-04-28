package LibraryBook;

import java.util.*;

public class BookName implements Book {
	List<String> bookName = new ArrayList<String>();

	@Override
	public void in(String in) {
		bookName.add(in);
	}

	@Override
	public void out(int out) {
		bookName.remove(out);
	}

	@Override
	public boolean Keyword(String keySearch) {
		boolean check = false;

		if (bookName == null) {
			System.out.println("입고된 책이 한 권도 없습니다.");
			check = false;
		} else {
			for (int i = 0; i < bookName.size(); i++) {
				if (bookName.get(i).equals(keySearch)) {
					return true;
				}
			}
		}
		return check;
	}

	@Override
	public String print(int x) {
		return bookName.get(x);
	}

	@Override
	public List<String> list() {
		return bookName;
	}

	@Override
	public void read(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			bookName.add(list.get(i));
		}
	}

}
