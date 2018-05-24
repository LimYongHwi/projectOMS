package VO;

import java.util.Date;

public class FAQVO {
	
	private int FAQ_NO;
	private String FAQ_TITLE;
	private String FAQ_CONTENT;
	private Date FAQ_CREATE_DATE;
	private Date FAQ_UPDATE_DATE;
	private Date FAQ_DELETE_DATE;
	private int FAQ_TAB;
	
	
	
	
	public int getFAQ_TAB() {
		return FAQ_TAB;
	}
	public void setFAQ_TAB(int fAQ_TAB) {
		FAQ_TAB = fAQ_TAB;
	}
	public void setFAQ_CREATE_DATE(Date fAQ_CREATE_DATE) {
		FAQ_CREATE_DATE = fAQ_CREATE_DATE;
	}
	public int getFAQ_NO() {
		return FAQ_NO;
	}
	public void setFAQ_NO(int fAQ_NO) {
		FAQ_NO = fAQ_NO;
	}
	public String getFAQ_TITLE() {
		return FAQ_TITLE;
	}
	public void setFAQ_TITLE(String fAQ_TITLE) {
		FAQ_TITLE = fAQ_TITLE;
	}
	public String getFAQ_CONTENT() {
		return FAQ_CONTENT;
	}
	public void setFAQ_CONTENT(String fAQ_CONTENT) {
		FAQ_CONTENT = fAQ_CONTENT;
	}

	public Date getFAQ_CREATE_DATE() {
		return FAQ_CREATE_DATE;
	}
	public void setFAQ_DATE(Date fAQ_DATE) {
		FAQ_CREATE_DATE = fAQ_DATE;
	}
	public Date getFAQ_UPDATE_DATE() {
		return FAQ_UPDATE_DATE;
	}
	public void setFAQ_UPDATE_DATE(Date fAQ_UPDATE_DATE) {
		FAQ_UPDATE_DATE = fAQ_UPDATE_DATE;
	}
	public Date getFAQ_DELETE_DATE() {
		return FAQ_DELETE_DATE;
	}
	public void setFAQ_DELETE_DATE(Date fAQ_DELETE_DATE) {
		FAQ_DELETE_DATE = fAQ_DELETE_DATE;
	}
	@Override
	public String toString() {
		return "FAQVO [FAQ_NO=" + FAQ_NO + ", FAQ_TITLE=" + FAQ_TITLE + ", FAQ_CONTENT=" + FAQ_CONTENT
				+ ", FAQ_CREATE_DATE=" + FAQ_CREATE_DATE + ", FAQ_UPDATE_DATE=" + FAQ_UPDATE_DATE + ", FAQ_DELETE_DATE="
				+ FAQ_DELETE_DATE + ", FAQ_TAB=" + FAQ_TAB + "]";
	}

	

	

}
