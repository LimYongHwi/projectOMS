package LibraryBook;

import java.util.*;

public class Genre implements Book{
	List<String> genre = new ArrayList<String>();

	@Override
	public void in(String in) {
		genre.add(in);		
	}

	@Override
	public void out(int out) {
		genre.remove(out);		
	}

	@Override
	public boolean Keyword(String key) {
		return false;
	}

	@Override
	public String print(int x) {
		return genre.get(x);
	}
	
	@Override
	public List<String> list() {
		return genre;
	}

	@Override
	public void read(List<String> list) {
		for (int i = 0; i< list.size(); i++) {
			genre.add(list.get(i));
		}
	}


	
}
