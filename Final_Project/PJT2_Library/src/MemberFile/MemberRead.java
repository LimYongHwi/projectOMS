package MemberFile;

import java.io.*;
import java.util.*;

public class MemberRead {

	List<String> idTemp = new ArrayList<String>();
	List<String> bookCntTemp = new ArrayList<String>();
	List<String> borrowBookTemp = new ArrayList<String>();

	public List<String> idLoad() {
		try {
			BufferedReader idRead = new BufferedReader
					(new InputStreamReader(new FileInputStream("src/MemberFile/member.txt")));

			// 파일에 저장되어 있는 id를 전부 불러올 변수
			String id = null;

			while ((id = idRead.readLine()) != null) {
				// 파일에 저장되어 있는 id를 tmp 배열에 저장
				idTemp.add(id);
			}
			idRead.close();

		} catch (FileNotFoundException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// id가 전부 저장되어 있는 임시 배열을 return
		return idTemp;
	}

	public List<String> bookCntLoad() {
		try {
			BufferedReader bookCntRead = new BufferedReader
					(new InputStreamReader(new FileInputStream("src/MemberFile/bookCount.txt")));

			String bookCnt = null;

			while ((bookCnt = bookCntRead.readLine()) != null) {
				bookCntTemp.add(bookCnt);
			}
			bookCntRead.close();
//			bookCntTemp.clear();
			
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookCntTemp;
	}
	
	public List<String> borrowBookLoad() {
		try {
			BufferedReader borrowBookRead = new BufferedReader
					(new InputStreamReader(new FileInputStream("src/MemberFile/borrowBook.txt")));

			String borrowBook = null;

			while ((borrowBook = borrowBookRead.readLine()) != null) {
				 borrowBookTemp.add(borrowBook);
			}
			borrowBookRead.close();
//			bookCntTemp.clear();
			
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  borrowBookTemp;
	}

}
