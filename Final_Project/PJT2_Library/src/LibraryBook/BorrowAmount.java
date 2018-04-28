package LibraryBook;

import java.util.*;

public class BorrowAmount implements Book{
	List<String> borrowAmount = new ArrayList<String>();

	@Override
	public void in(String in) {
		borrowAmount.add(in);
	}

	@Override
	public void out(int out) {
		borrowAmount.remove(out);
	}

	@Override
	public boolean Keyword(String key) {
		return false;
	}

	@Override
	public String print(int x) {
		return borrowAmount.get(x);
	}
	
	@Override
	public List<String> list() {
		return borrowAmount;
	}

	@Override
	public void read(List<String> list) {
		for (int i = 0; i< list.size(); i++) {
			borrowAmount.add(list.get(i));
		}
	}
	
}
