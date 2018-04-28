package MemberFile;

import java.io.*;
import java.util.*;

import LibraryPage.BookIn;

public class MemberWrite {

	public void idSave(List<String> list) {
		try {
			FileWriter fw = new FileWriter("src/MemberFile/member.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter idWrite = new PrintWriter(bw);

			for (int i = 0; i < list.size(); i++) {
				idWrite.write(list.get(i));
				idWrite.append("\n");
				idWrite.flush();
			}
			idWrite.close();
//			list.clear();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void bookCntSave(List<String> list) {
		try {
			FileWriter fw = new FileWriter("src/MemberFile/bookCount.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter bookCntWrite = new PrintWriter(bw);

			for (int i = 0; i < list.size(); i++) {
				bookCntWrite.write(list.get(i));
				bookCntWrite.append("\n");
				bookCntWrite.flush();
			}
			bookCntWrite.close();
//			list.clear();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void borrowBookSave(List<String> list) {
		try {
			FileWriter fw = new FileWriter("src/MemberFile/borrowBook.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter borrowwBookWrite = new PrintWriter(bw);

			for (int i = 0; i < list.size(); i++) {
				borrowwBookWrite.write(list.get(i));
				borrowwBookWrite.append("\n");
				borrowwBookWrite.flush();
			}
			borrowwBookWrite.close();
//			list.clear();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
