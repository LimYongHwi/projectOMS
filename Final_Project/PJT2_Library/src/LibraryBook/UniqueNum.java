package LibraryBook;

import java.util.*;

public class UniqueNum implements Book {
	static List<String> uniqueNum = new ArrayList<String>();

	@Override
	public void in(String in) {
		uniqueNum.add("YO"+in);
	}

	@Override
	public void out(int out) { // 인덱스 값을 받아 와서 삭제
		uniqueNum.remove(out);
	}

	@Override
	public boolean Keyword(String keySearch) {
		boolean check = false;
		if (uniqueNum == null) {
			System.out.println("입고된 책이 한 권도 없습니다.");
			check = false;
		} else {
			for (int i = 0; i < uniqueNum.size(); i++) {
				if (uniqueNum.get(i).equals(keySearch)) {
					return true;
				}
			}
		}
		return check;
	}

	@Override
	public String print(int x) {
		return uniqueNum.get(x);
	}

	@Override
	public List<String> list() {
		return uniqueNum;
	}

	@Override
	public void read(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			uniqueNum.add(list.get(i));
		}
	}

}
