package VO;

import java.io.File;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class PhotoVO {

	private int PHOTO_NO;			//게시물 번호
	private String M_ID;			//게시자 아이디
	private String PHOTO_TITLE;		//제목
	private String PHOTO_CONTENT;   //내용
	private String PHOTO_FILE;      //파일 이름
	private char PHOTO_PRIVATE;		//공개여부 설정
	private String PHOTO_HASHTAG;	//해시태그
	private int PHOTO_LIKE;			//좋아요 수 
	private Date PHOTO_CREATE_DATE;	//게시 일자
	private Date PHOTO_UPDATE_DATE; //수정일자
	private Date PHOTO_DELETE_DATE; //삭제일자
	private MultipartFile uFile;	//멀티파트 파일
	
	public PhotoVO() {}
	
	public PhotoVO(int pHOTO_NO, String m_ID, String pHOTO_TITLE,String pHOTO_CONTENT,String fILE, char pHOTO_PRIVATE, String pHOTO_HASHTAG, int pHOTO_LIKE,
			Date pHOTO_CREATE_DATE, Date pHOTO_UPDATE_DATE, Date pHOTO_DELETE_DATE, MultipartFile ufile) {
		this.PHOTO_NO = pHOTO_NO;
		M_ID = m_ID;
		PHOTO_TITLE = pHOTO_TITLE;
		PHOTO_CONTENT = pHOTO_CONTENT;
		PHOTO_FILE = fILE;
		PHOTO_PRIVATE = pHOTO_PRIVATE;
		PHOTO_HASHTAG = pHOTO_HASHTAG;
		PHOTO_LIKE = pHOTO_LIKE;
		PHOTO_CREATE_DATE = pHOTO_CREATE_DATE;
		PHOTO_UPDATE_DATE = pHOTO_UPDATE_DATE;
		PHOTO_DELETE_DATE = pHOTO_DELETE_DATE;
		uFile = ufile;
	}
	
	public PhotoVO(String m_ID) {
		M_ID = m_ID;
	} 

	public PhotoVO(int photo_no) {
		PHOTO_NO = photo_no;
	}

	public String getPHOTO_TITLE() {
		return PHOTO_TITLE;
	}

	public void setPHOTO_TITLE(String pHOTO_TITLE) {
		PHOTO_TITLE = pHOTO_TITLE;
	}

	public MultipartFile getuFile() {
		return uFile;
	}

	public void setuFile(MultipartFile uFile) {
		this.uFile = uFile;
	}

	public MultipartFile getUploadFile() {
		return uFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uFile = uploadFile;
	}


	public String getPHOTO_CONTENT() {
		return PHOTO_CONTENT;
	}

	public void setPHOTO_CONTENT(String pHOTO_CONTENT) {
		PHOTO_CONTENT = pHOTO_CONTENT;
	}

	

	public int getPHOTO_NO() {
		return PHOTO_NO;
	}
	public void setPHOTO_NO(int pHOTO_NO) {
		PHOTO_NO = pHOTO_NO;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	public String getFILE() {
		return PHOTO_FILE;
	}
	public void setFILE(String pHOTO_FILE) {
		PHOTO_FILE = pHOTO_FILE;
	}
	public char getPHOTO_PRIVATE() {
		return PHOTO_PRIVATE;
	}
	public void setPHOTO_PRIVATE(char pHOTO_PRIVATE) {
		PHOTO_PRIVATE = pHOTO_PRIVATE;
	}
	public String getPHOTO_HASHTAG() {
		return PHOTO_HASHTAG;
	}
	public void setPHOTO_HASHTAG(String pHOTO_HASHTAG) {
		PHOTO_HASHTAG = pHOTO_HASHTAG;
	}
	public int getPHOTO_LIKE() {
		return PHOTO_LIKE;
	}
	public void setPHOTO_LIKE(int pHOTO_LIKE) {
		PHOTO_LIKE = pHOTO_LIKE;
	}
	public Date getPHOTO_CREATE_DATE() {
		return PHOTO_CREATE_DATE;
	}
	public void setPHOTO_CREATE_DATE(Date pHOTO_CREATE_DATE) {
		PHOTO_CREATE_DATE = pHOTO_CREATE_DATE;
	}
	public Date getPHOTO_UPDATE_DATE() {
		return PHOTO_UPDATE_DATE;
	}
	public void setPHOTO_UPDATE_DATE(Date pHOTO_UPDATE_DATE) {
		PHOTO_UPDATE_DATE = pHOTO_UPDATE_DATE;
	}
	public Date getPHOTO_DELETE_DATE() {
		return PHOTO_DELETE_DATE;
	}
	public void setPHOTO_DELETE_DATE(Date pHOTO_DELETE_DATE) {
		PHOTO_DELETE_DATE = pHOTO_DELETE_DATE;
	}
	
	
}
