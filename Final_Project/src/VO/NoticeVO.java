package VO;

public class NoticeVO {
	private int NOTICE_NO;
	private String NOTICE_TITLE;
	private String NOTICE_CONTENT;
	private String NOTICE_FILE;
	private String NOTICE_CREATE_DATE;
	private String NOTICE_UPDATE_DATE;
	private String NOTICE_DELETE_DATE;
	
	
	
	public NoticeVO(String nOTICE_TITLE, String nOTICE_CONTENT, String nOTICE_FILE) {
		super();
		NOTICE_TITLE = nOTICE_TITLE;
		NOTICE_CONTENT = nOTICE_CONTENT;
		NOTICE_FILE = nOTICE_FILE;
	}
	public NoticeVO() {
		super();
	}
	public NoticeVO(int nOTICE_NO, String nOTICE_TITLE, String nOTICE_CONTENT, String nOTICE_FILE,
			String nOTICE_CREATE_DATE, String nOTICE_UPDATE_DATE, String nOTICE_DELETE_DATE) {
		super();
		NOTICE_NO = nOTICE_NO;
		NOTICE_TITLE = nOTICE_TITLE;
		NOTICE_CONTENT = nOTICE_CONTENT;
		NOTICE_FILE = nOTICE_FILE;
		NOTICE_CREATE_DATE = nOTICE_CREATE_DATE;
		NOTICE_UPDATE_DATE = nOTICE_UPDATE_DATE;
		NOTICE_DELETE_DATE = nOTICE_DELETE_DATE;
	}
	public int getNOTICE_NO() {
		return NOTICE_NO;
	}
	public void setNOTICE_NO(int nOTICE_NO) {
		NOTICE_NO = nOTICE_NO;
	}
	public String getNOTICE_TITLE() {
		return NOTICE_TITLE;
	}
	public void setNOTICE_TITLE(String nOTICE_TITLE) {
		NOTICE_TITLE = nOTICE_TITLE;
	}
	public String getNOTICE_CONTENT() {
		return NOTICE_CONTENT;
	}
	public void setNOTICE_CONTENT(String nOTICE_CONTENT) {
		NOTICE_CONTENT = nOTICE_CONTENT;
	}
	public String getNOTICE_FILE() {
		return NOTICE_FILE;
	}
	public void setNOTICE_FILE(String nOTICE_FILE) {
		NOTICE_FILE = nOTICE_FILE;
	}
	public String getNOTICE_CREATE_DATE() {
		return NOTICE_CREATE_DATE;
	}
	public void setNOTICE_CREATE_DATE(String nOTICE_CREATE_DATE) {
		NOTICE_CREATE_DATE = nOTICE_CREATE_DATE;
	}
	public String getNOTICE_UPDATE_DATE() {
		return NOTICE_UPDATE_DATE;
	}
	public void setNOTICE_UPDATE_DATE(String nOTICE_UPDATE_DATE) {
		NOTICE_UPDATE_DATE = nOTICE_UPDATE_DATE;
	}
	public String getNOTICE_DELETE_DATE() {
		return NOTICE_DELETE_DATE;
	}
	public void setNOTICE_DELETE_DATE(String nOTICE_DELETE_DATE) {
		NOTICE_DELETE_DATE = nOTICE_DELETE_DATE;
	}
	@Override
	public String toString() {
		return "NoticeVO [NOTICE_NO=" + NOTICE_NO + ", NOTICE_TITLE=" + NOTICE_TITLE + ", NOTICE_CONTENT="
				+ NOTICE_CONTENT + ", NOTICE_FILE=" + NOTICE_FILE + ", NOTICE_CREATE_DATE=" + NOTICE_CREATE_DATE
				+ ", NOTICE_UPDATE_DATE=" + NOTICE_UPDATE_DATE + ", NOTICE_DELETE_DATE=" + NOTICE_DELETE_DATE + "]";
	}
	
	
}
