package LibraryBook;

import java.util.List;

public interface Book {

	public void in(String in);
	public void out(int out);
	public boolean Keyword(String keySearch);
	public String print(int x);
	
	public List<String> list();
	public void read(List<String> list);

}
