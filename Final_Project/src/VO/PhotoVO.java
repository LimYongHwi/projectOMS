package VO;

import java.io.File;
import java.util.Date;

public class PhotoVO {

	private int PHOTO_NO;
	private String M_ID;
	private String FILE;
	private String PHOTO_PRIVATE;
	private String PHOTO_HASHTAG;
	private int PHOTO_LIKE;
	private Date PHOTO_CREATE_DATE;
	private Date PHOTO_UPDATE_DATE;
	private Date PHOTO_DELETE_DATE;
	
	public PhotoVO() {}
	
	public PhotoVO(int pHOTO_NO, String m_ID, String fILE, String pHOTO_PRIVATE, String pHOTO_HASHTAG, int pHOTO_LIKE,
			Date pHOTO_CREATE_DATE, Date pHOTO_UPDATE_DATE, Date pHOTO_DELETE_DATE) {
		PHOTO_NO = pHOTO_NO;
		M_ID = m_ID;
		FILE = fILE;
		PHOTO_PRIVATE = pHOTO_PRIVATE;
		PHOTO_HASHTAG = pHOTO_HASHTAG;
		PHOTO_LIKE = pHOTO_LIKE;
		PHOTO_CREATE_DATE = pHOTO_CREATE_DATE;
		PHOTO_UPDATE_DATE = pHOTO_UPDATE_DATE;
		PHOTO_DELETE_DATE = pHOTO_DELETE_DATE;
	}
	
	


	public PhotoVO(String m_ID) {
		M_ID = m_ID;
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
		return FILE;
	}
	public void setFILE(String fILE) {
		FILE = fILE;
	}
	public String getPHOTO_PRIVATE() {
		return PHOTO_PRIVATE;
	}
	public void setPHOTO_PRIVATE(String pHOTO_PRIVATE) {
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
