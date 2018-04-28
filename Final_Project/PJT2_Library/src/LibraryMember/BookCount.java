package LibraryMember;

import java.util.*;

public class BookCount implements Member { // Id 하나당 빌릴 수 있는 책 3권
	private static List<String> bookCount = new ArrayList<String>();

	@Override
	public boolean IdCheck(String idCheck) {
		return false;
	}

	@Override
	public void IdInput(String idInput) {
		bookCount.add("3");
	}

	@Override
	public void print() {
		for (int i = 0; i < bookCount.size(); i++)
			System.out.println(bookCount.get(i));
	}
	
	@Override
	public void read(List<String> list) {
		for (int i = 0; i< list.size(); i++) {
			bookCount.add(list.get(i));
		}
	}
	
	@Override
	public List<String> list() {
		return bookCount;
	}

}
