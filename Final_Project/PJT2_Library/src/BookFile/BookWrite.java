package BookFile;

import LibraryPage.*;
import java.io.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookWrite {

	public void bookSave(List<String> list, String src) {
		try {
			BufferedWriter bookWrite = new BufferedWriter
					(new FileWriter("src/BookFile/"+src+".txt"));

//			System.out.println(list);

			for (int i = 0; i < list.size(); i++) {
				bookWrite.write(list.get(i));
				bookWrite.append("\n");
				bookWrite.flush();
			}
			bookWrite.close();
//			list.clear();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public void uniqueNumSave(List<String> list) {
//		try {
//			FileWriter fw = new FileWriter("uniqueNum.txt");
//			BufferedWriter bw = new BufferedWriter(fw);
//			PrintWriter uniqueNumWrite = new PrintWriter(bw);
//
//			System.out.println(list);
//
//			for (int i = 0; i < list.size(); i++) {
//				uniqueNumWrite.write(list.get(i));
//				uniqueNumWrite.append("\n");
//				uniqueNumWrite.flush();
//			}
//			uniqueNumWrite.close();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	}
//
//	public void authorSave(List<String> list) {
//		try {
//			FileWriter fw = new FileWriter("author.txt");
//			BufferedWriter bw = new BufferedWriter(fw);
//			PrintWriter authorWrite = new PrintWriter(bw);
//
//			System.out.println(list);
//
//			for (int i = 0; i < list.size(); i++) {
//				authorWrite.write(list.get(i));
//				authorWrite.append("\n");
//				authorWrite.flush();
//			}
//			authorWrite.close();
//			list.clear();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void inDateSave(List<String> list) {
//		try {
//			FileWriter fw = new FileWriter("inDate.txt");
//			BufferedWriter bw = new BufferedWriter(fw);
//			PrintWriter inDateWrite = new PrintWriter(bw);
//
//			System.out.println(list);
//
//			for (int i = 0; i < list.size(); i++) {
//				inDateWrite.write(list.get(i));
//				inDateWrite.append("\n");
//				inDateWrite.flush();
//			}
//			inDateWrite.close();
//			list.clear();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void genreSave(List<String> list) {
//		try {
//			FileWriter fw = new FileWriter("genre.txt");
//			BufferedWriter bw = new BufferedWriter(fw);
//			PrintWriter genreWrite = new PrintWriter(bw);
//
//			System.out.println(list);
//
//			for (int i = 0; i < list.size(); i++) {
//				genreWrite.write(list.get(i));
//				genreWrite.append("\n");
//				genreWrite.flush();
//			}
//			genreWrite.close();
//			list.clear();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//

//
//	public void bookAmountSave(List<String> list) {
//		try {
//			FileWriter fw = new FileWriter("bookAmount.txt");
//			BufferedWriter bw = new BufferedWriter(fw);
//			PrintWriter bookAmountWrite = new PrintWriter(bw);
//
//			System.out.println(list);
//
//			for (int i = 0; i < list.size(); i++) {
//				bookAmountWrite.write(list.get(i));
//				bookAmountWrite.append("\n");
//				bookAmountWrite.flush();
//			}
//			bookAmountWrite.close();
//			list.clear();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void borrowSave(List<String> list) {
//		try {
//			FileWriter fw = new FileWriter("borrow.txt");
//			BufferedWriter bw = new BufferedWriter(fw);
//			PrintWriter borrowWrite = new PrintWriter(bw);
//
//			System.out.println(list);
//
//			for (int i = 0; i < list.size(); i++) {
//				borrowWrite.write(list.get(i));
//				borrowWrite.append("\n");
//				borrowWrite.flush();
//			}
//			borrowWrite.close();
//			list.clear();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
