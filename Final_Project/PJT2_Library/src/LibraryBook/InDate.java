package LibraryBook;

import java.util.*;

public class InDate implements Book{
	List<String> inDate = new ArrayList<String>();

	@Override
	public void in(String in) {
		inDate.add(in);
	}

	@Override
	public void out(int out) {
		inDate.remove(out);
	}

	@Override
	public boolean Keyword(String key) {
		return false;
	}

	@Override
	public String print(int x) {
		return inDate.get(x);
	}
	
	@Override
	public List<String> list() {
		return inDate;
	}

	@Override
	public void read(List<String> list) {
		for (int i = 0; i< list.size(); i++) {
			inDate.add(list.get(i));
		}
	}


}

