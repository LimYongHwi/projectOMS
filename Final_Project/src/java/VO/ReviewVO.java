package VO;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ReviewVO {
	
	
	
	private int REV_NO;
	private String REV_TITLE;
	private String REV_CONTENT;
	private String REV_FILE;
	private String M_ID;
	private String REV_DESTINATION;
	private Date REV_START;
	private Date REV_END;
	private int REV_REM_COUNT;
	private int REV_UNREM_COUNT;
	private int REV_VIEWS;
	private Date REV_CREATE_DATE;
	private Date REV_UPDATE_DATE;
	private Date REV_DELETE_DATE;
	private MultipartFile ufile;
	
	
	
	public ReviewVO() {
	}


	public MultipartFile getUfile() {
		return ufile;
	}


	public void setUfile(MultipartFile ufile) {
		this.ufile = ufile;
	}


	
	public ReviewVO(int REV_NO,String REV_TITLE, String REV_CONTENT, String M_ID, String REV_DESTINATION, Date REV_START,
			Date REV_END) {
		this.REV_NO = REV_NO;
		this.REV_TITLE = REV_TITLE;
		this.REV_CONTENT = REV_CONTENT;
		this.M_ID = M_ID;
		this.REV_DESTINATION = REV_DESTINATION;
		this.REV_START = REV_START;
		this.REV_END = REV_END;
	}
	public ReviewVO(String REV_TITLE, String REV_CONTENT, String M_ID, String REV_DESTINATION, Date REV_START,
			Date REV_END) {
		this.REV_TITLE = REV_TITLE;
		this.REV_CONTENT = REV_CONTENT;
		this.M_ID = M_ID;
		this.REV_DESTINATION = REV_DESTINATION;
		this.REV_START = REV_START;
		this.REV_END = REV_END;
	}


	
	
	public ReviewVO(int REV_NO) {
		this.REV_NO = REV_NO;
	}
	
	
	public int getREV_NO() {
		return REV_NO;
	}
	public void setREV_NO(int REV_NO) {
		this.REV_NO = REV_NO;
	}
	public String getREV_TITLE() {
		return REV_TITLE;
	}
	public void setREV_TITLE(String REV_TITLE) {
		this.REV_TITLE = REV_TITLE;
	}
	public String getREV_CONTENT() {
		return REV_CONTENT;
	}
	public void setREV_CONTENT(String REV_CONTENT) {
		this.REV_CONTENT = REV_CONTENT;
	}
	public String getREV_FILE() {
		return REV_FILE;
	}
	public void setREV_FILE(String REV_FILE) {
		this.REV_FILE = REV_FILE;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String M_ID) {
		this.M_ID = M_ID;
	}
	public String getREV_DESTINATION() {
		return REV_DESTINATION;
	}
	public void setREV_DESTINATION(String REV_DESTINATION) {
		this.REV_DESTINATION = REV_DESTINATION;
	}
	public Date getREV_START() {
		return REV_START;
	}
	public void setREV_START(Date REV_START) {
		this.REV_START = REV_START;
	}
	public Date getREV_END() {
		return REV_END;
	}
	public void setREV_END(Date REV_END) {
		this.REV_END = REV_END;
	}
	public Date getREV_CREATE_DATE() {
		return REV_CREATE_DATE;
	}
	public void setREV_CREATE_DATE(Date REV_CREATE_DATE) {
		this.REV_CREATE_DATE = REV_CREATE_DATE;
	}
	public int getREV_REM_COUNT() {
		return REV_REM_COUNT;
	}
	public void setREV_REM_COUNT(int REV_REM_COUNT) {
		this.REV_REM_COUNT = REV_REM_COUNT;
	}
	public int getREV_UNREM_COUNT() {
		return REV_UNREM_COUNT;
	}
	public void setREV_UNREM_COUNT(int REV_UNREM_COUNT) {
		this.REV_UNREM_COUNT = REV_UNREM_COUNT;
	}
	public int getREV_VIEWS() {
		return REV_VIEWS;
	}
	public void setREV_VIEWS(int REV_VIEWS) {
		this.REV_VIEWS = REV_VIEWS;
	}
	public Date getREV_UPDATE_DATE() {
		return REV_UPDATE_DATE;
	}
	public void setREV_UPDATE_DATE(Date REV_UPDATE_DATE) {
		this.REV_UPDATE_DATE = REV_UPDATE_DATE;
	}
	public Date getREV_DELETE_DATE() {
		return REV_DELETE_DATE;
	}
	public void setREV_DELETE_DATE(Date REV_DELETE_DATE) {
		this.REV_DELETE_DATE = REV_DELETE_DATE;
	}
	@Override
	public String toString() {
		return "Review [REV_NO=" + REV_NO + ", REV_TITLE=" + REV_TITLE + ", REV_CONTENT=" + REV_CONTENT + ", REV_FILE="
				+ REV_FILE + ", M_ID=" + M_ID + ", REV_DESTINATION=" + REV_DESTINATION + ", REV_START=" + REV_START
				+ ", REV_END=" + REV_END + ", REV_CREATE_DATE=" + REV_CREATE_DATE + ", REV_REM_COUNT=" + REV_REM_COUNT
				+ ", REV_UNREM_COUNT=" + REV_UNREM_COUNT + ", REV_VIEWS=" + REV_VIEWS + ", REV_UPDATE_DATE="
				+ REV_UPDATE_DATE + ", REV_DELETE_DATE=" + REV_DELETE_DATE + "]";
	}
	
	
	
	
	
	
}
