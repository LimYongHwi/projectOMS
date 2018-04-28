package LibraryBook;

import java.util.*;

public class Author implements Book {
	List<String> author = new ArrayList<String>();

	@Override
	public void in(String in) {
		author.add(in);
	}

	@Override
	public void out(int out) {
		author.remove(out);
	}

	@Override
	public boolean Keyword(String keySearch) {
		boolean check = false;

		if (author == null) {
			System.out.println("입고된 책이 한 권도 없습니다.");
			check = false;
		} else {
			for (int i = 0; i < author.size(); i++) {
				if (author.get(i).equals(keySearch)) {
					check = true;
				}
			}
		}
		return check;
	}

	@Override
	public String print(int x) {
		return author.get(x);
	}

	@Override
	public List<String> list() {
		return author;
	}

	@Override
	public void read(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			author.add(list.get(i));
		}
	}

}
