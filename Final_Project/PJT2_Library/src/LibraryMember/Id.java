package LibraryMember;

import java.io.*;
import java.util.*;

public class Id implements Member {
	// id 저장할 배열
	private static List<String> Id = new ArrayList<String>();
	// 대여한 책 저장할 배열
	private static List<String> borrowBook = new ArrayList<String>();

	@Override
	public boolean IdCheck(String id) {
		if (Id == null) {
			return false;
		} else {
			Iterator<String> itr = Id.iterator();
			while (itr.hasNext()) {
				if (itr.next().equals(id)) {
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public void IdInput(String idInput) {
		Id.add(idInput);
	}

	@Override
	public List<String> list() {
		return Id;
	}

	@Override
	public void read(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			Id.add(list.get(i));
		}
	}

	@Override
	public void print() {
		for (int i = 0; i < Id.size(); i++)
			System.out.println(Id.get(i) + " 님");
	}

	// public void check() {
	// System.out.println((borrowBook.toString()));
	// }

}
