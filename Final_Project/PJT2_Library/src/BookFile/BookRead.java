package BookFile;

import java.io.*;
import java.util.*;

import LibraryPage.BookIn;

public class BookRead {

	// 책 제목, 작가, 입고일자, 장르, 고유번호, 도서관보유권수, 대여가능권수

	List<String> bookNameTemp = new ArrayList<String>();
	List<String> authorTemp = new ArrayList<>();
	List<String> inDateTemp = new ArrayList<>();
	List<String> genreTemp = new ArrayList<>();
	List<String> uniqueNumTemp = new ArrayList<>();
	List<String> bookAmountTemp = new ArrayList<>();
	List<String> borrowAmountTemp = new ArrayList<>();

	public List<String> bookNameLoad() {
		try {
			BufferedReader bookNameRead = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/BookFile/bookName.txt")));

			// 파일에 저장되어 있는 id를 전부 불러올 변수
			String bookName = null;

			while ((bookName = bookNameRead.readLine()) != null) {
				// 파일에 저장되어 있는 id를 tmp 배열에 저장
				bookNameTemp.add(bookName);
			}
			bookNameRead.close();

		} catch (FileNotFoundException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookNameTemp;
	}

	public List<String> authorLoad() {
		try {
			BufferedReader authorRead = new BufferedReader(new InputStreamReader(new FileInputStream("src/BookFile/author.txt")));

			// 파일에 저장되어 있는 id를 전부 불러올 변수
			String author = null;

			while ((author = authorRead.readLine()) != null) {
				// 파일에 저장되어 있는 id를 tmp 배열에 저장
				authorTemp.add(author);
			}
			authorRead.close();

		} catch (FileNotFoundException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return authorTemp;
	}

	public List<String> inDateLoad() {
		try {
			BufferedReader inDateRead = new BufferedReader(new InputStreamReader(new FileInputStream("src/BookFile/inDate.txt")));

			// 파일에 저장되어 있는 id를 전부 불러올 변수
			String inDate = null;

			while ((inDate = inDateRead.readLine()) != null) {
				// 파일에 저장되어 있는 id를 tmp 배열에 저장
				inDateTemp.add(inDate);
			}
			inDateRead.close();
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inDateTemp;
	}

	public List<String> genreLoad() {
		try {
			BufferedReader genreRead = new BufferedReader(new InputStreamReader(new FileInputStream("src/BookFile/genre.txt")));

			// 파일에 저장되어 있는 id를 전부 불러올 변수
			String genre = null;

			while ((genre = genreRead.readLine()) != null) {
				// 파일에 저장되어 있는 id를 tmp 배열에 저장
				genreTemp.add(genre);
			}
			genreRead.close();

		} catch (FileNotFoundException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return genreTemp;
	}

	public List<String> uniqueNumLoad() {
		try {
			BufferedReader uniqueNumRead = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/BookFile/uniqueNum.txt")));

			// 파일에 저장되어 있는 id를 전부 불러올 변수
			String uniqueNum = null;

			while ((uniqueNum = uniqueNumRead.readLine()) != null) {
				// 파일에 저장되어 있는 id를 tmp 배열에 저장
				uniqueNumTemp.add(uniqueNum);
			}
			uniqueNumRead.close();
			uniqueNumRead.close();

		} catch (FileNotFoundException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uniqueNumTemp;
	}

	public List<String> bookAmountLoad() {
		try {
			BufferedReader bookAmountRead = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/BookFile/bookAmount.txt")));

			// 파일에 저장되어 있는 id를 전부 불러올 변수
			String bookAmount = null;

			while ((bookAmount = bookAmountRead.readLine()) != null) {
				// 파일에 저장되어 있는 id를 tmp 배열에 저장
				bookAmountTemp.add(bookAmount);
			}
			bookAmountRead.close();

		} catch (FileNotFoundException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookAmountTemp;
	}

	public List<String> borrowLoad() {
		try {
			BufferedReader borrowAmountRead = new BufferedReader(new InputStreamReader(new FileInputStream("src/BookFile/borrowAmount.txt")));

			// 파일에 저장되어 있는 id를 전부 불러올 변수
			String borrowAmount = null;

			while ((borrowAmount = borrowAmountRead.readLine()) != null) {
				// 파일에 저장되어 있는 id를 tmp 배열에 저장
				borrowAmountTemp.add(borrowAmount);
			}
			borrowAmountRead.close();

		} catch (FileNotFoundException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return borrowAmountTemp;
	}

}
