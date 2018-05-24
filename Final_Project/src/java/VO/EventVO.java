package VO;

import java.util.Date;

public class EventVO {    
	private int EVT_NO;
	private String EVT_TITLE;
	private String EVT_CONTENT;
	private String EVT_FILE;
	private char EVT_END;
	private int EVT_VIEW;
	private Date EVT_CREATE_DATE;
	private Date EVT_UPDATE_DATE;
	private Date EVT_DELETE_DATE;
	
	
	
	
	public EventVO(String eVT_TITLE, String eVT_CONTENT) {
		super();
		EVT_TITLE = eVT_TITLE;
		EVT_CONTENT = eVT_CONTENT;
	}
	public EventVO(int eVT_NO) {
		EVT_NO = eVT_NO;
	}
	public EventVO() {
		
	}
	public EventVO(int eVT_NO, String eVT_TITLE, String eVT_CONTENT, String eVT_FILE,
			char eVT_END, int eVT_VIEW,
			Date eVT_CREATE_DATE, Date eVT_UPDATE_DATE, Date eVT_DELETE_DATE) {
		EVT_NO = eVT_NO;
		EVT_TITLE = eVT_TITLE;
		EVT_CONTENT = eVT_CONTENT;
		EVT_FILE = eVT_FILE;
		EVT_END=eVT_END;
		EVT_VIEW = eVT_VIEW;
		EVT_CREATE_DATE = eVT_CREATE_DATE;
		EVT_UPDATE_DATE = eVT_UPDATE_DATE;
		EVT_DELETE_DATE = eVT_DELETE_DATE;
	}
	
	public char getEVT_END() {
		return EVT_END;
	}
	public void setEVT_END(char eVT_END) {
		EVT_END = eVT_END;
	}
	public int getEVT_NO() {
		return EVT_NO;
	}
	public void setEVT_NO(int eVT_NO) {
		EVT_NO = eVT_NO;
	}
	public String getEVT_TITLE() {
		return EVT_TITLE;
	}
	public void setEVT_TITLE(String eVT_TITLE) {
		EVT_TITLE = eVT_TITLE;
	}
	public String getEVT_CONTENT() {
		return EVT_CONTENT;
	}
	public void setEVT_CONTENT(String eVT_CONTENT) {
		EVT_CONTENT = eVT_CONTENT;
	}
	public String getEVT_FILE() {
		return EVT_FILE;
	}
	public void setEVT_FILE(String eVT_FILE) {
		EVT_FILE = eVT_FILE;
	}
	public int getEVT_VIEW() {
		return EVT_VIEW;
	}
	public void setEVT_VIEW(int eVT_VIEW) {
		EVT_VIEW = eVT_VIEW;
	}
	public Date getEVT_CREATE_DATE() {
		return EVT_CREATE_DATE;
	}
	public void setEVT_CREATE_DATE(Date eVT_CREATE_DATE) {
		EVT_CREATE_DATE = eVT_CREATE_DATE;
	}
	public Date getEVT_UPDATE_DATE() {
		return EVT_UPDATE_DATE;
	}
	public void setEVT_UPDATE_DATE(Date eVT_UPDATE_DATE) {
		EVT_UPDATE_DATE = eVT_UPDATE_DATE;
	}
	public Date getEVT_DELETE_DATE() {
		return EVT_DELETE_DATE;
	}
	public void setEVT_DELETE_DATE(Date eVT_DELETE_DATE) {
		EVT_DELETE_DATE = eVT_DELETE_DATE;
	}
	@Override
	public String toString() {
		return "EventVO [EVT_NO=" + EVT_NO + ", EVT_TITLE=" + EVT_TITLE + ", EVT_CONTENT=" + EVT_CONTENT + ", EVT_FILE="
				+ EVT_FILE + ", EVT_VIEW=" + EVT_VIEW + ", EVT_CREATE_DATE=" + EVT_CREATE_DATE + ", EVT_UPDATE_DATE="
				+ EVT_UPDATE_DATE + ", EVT_DELETE_DATE=" + EVT_DELETE_DATE + "]";
	}
	
}
