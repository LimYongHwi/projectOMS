package VO;

import java.util.Date;

public class InformationVO { 
	private int INFO_NO;
	private String INFO_TITLE;
	private String INFO_CONTENT;
	private String INFO_FILE;
	private String M_ID;
	private String INFO_PLACE;
	private int INFO_RCM;
	private int INFO_UNRCM;
	private int INFO_VIEWS;
	private Date INFO_CREATE_DATE;
	private Date INFO_UPDATE_DATE;
	private Date INFO_DELETE_DATE;
	
	
	
	
	public InformationVO(int iNFO_NO) {
		super();
		INFO_NO = iNFO_NO;
	}
	public InformationVO() {
		super();
	}
	public InformationVO(int iNFO_NO, String iNFO_TITLE, String iNFO_CONTENT, String iNFO_FILE, String m_ID,
			String iNFO_PLACE, int iNFO_RCM, int iNFO_UNRCM, int iNFO_VIEWS, Date iNFO_CREATE_DATE,
			Date iNFO_UPDATE_DATE, Date iNFO_DELETE_DATE) {
		super();
		INFO_NO = iNFO_NO;
		INFO_TITLE = iNFO_TITLE;
		INFO_CONTENT = iNFO_CONTENT;
		INFO_FILE = iNFO_FILE;
		M_ID = m_ID;
		INFO_PLACE = iNFO_PLACE;
		INFO_RCM = iNFO_RCM;
		INFO_UNRCM = iNFO_UNRCM;
		INFO_VIEWS = iNFO_VIEWS;
		INFO_CREATE_DATE = iNFO_CREATE_DATE;
		INFO_UPDATE_DATE = iNFO_UPDATE_DATE;
		INFO_DELETE_DATE = iNFO_DELETE_DATE;
	}
	@Override
	public String toString() {
		return "InformationVO [INFO_NO=" + INFO_NO + ", INFO_TITLE=" + INFO_TITLE + ", INFO_CONTENT=" + INFO_CONTENT
				+ ", INFO_FILE=" + INFO_FILE + ", M_ID=" + M_ID + ", INFO_PLACE=" + INFO_PLACE + ", INFO_RCM="
				+ INFO_RCM + ", INFO_UNRCM=" + INFO_UNRCM + ", INFO_VIEWS=" + INFO_VIEWS + ", INFO_CREATE_DATE="
				+ INFO_CREATE_DATE + ", INFO_UPDATE_DATE=" + INFO_UPDATE_DATE + ", INFO_DELETE_DATE=" + INFO_DELETE_DATE
				+ "]";
	}
	public int getINFO_NO() {
		return INFO_NO;
	}
	public void setINFO_NO(int iNFO_NO) {
		INFO_NO = iNFO_NO;
	}
	public String getINFO_TITLE() {
		return INFO_TITLE;
	}
	public void setINFO_TITLE(String iNFO_TITLE) {
		INFO_TITLE = iNFO_TITLE;
	}
	public String getINFO_CONTENT() {
		return INFO_CONTENT;
	}
	public void setINFO_CONTENT(String iNFO_CONTENT) {
		INFO_CONTENT = iNFO_CONTENT;
	}
	public String getINFO_FILE() {
		return INFO_FILE;
	}
	public void setINFO_FILE(String iNFO_FILE) {
		INFO_FILE = iNFO_FILE;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	public String getINFO_PLACE() {
		return INFO_PLACE;
	}
	public void setINFO_PLACE(String iNFO_PLACE) {
		INFO_PLACE = iNFO_PLACE;
	}
	public int getINFO_RCM() {
		return INFO_RCM;
	}
	public void setINFO_RCM(int iNFO_RCM) {
		INFO_RCM = iNFO_RCM;
	}
	public int getINFO_UNRCM() {
		return INFO_UNRCM;
	}
	public void setINFO_UNRCM(int iNFO_UNRCM) {
		INFO_UNRCM = iNFO_UNRCM;
	}
	public int getINFO_VIEWS() {
		return INFO_VIEWS;
	}
	public void setINFO_VIEWS(int iNFO_VIEWS) {
		INFO_VIEWS = iNFO_VIEWS;
	}
	public Date getINFO_CREATE_DATE() {
		return INFO_CREATE_DATE;
	}
	public void setINFO_CREATE_DATE(Date iNFO_CREATE_DATE) {
		INFO_CREATE_DATE = iNFO_CREATE_DATE;
	}
	public Date getINFO_UPDATE_DATE() {
		return INFO_UPDATE_DATE;
	}
	public void setINFO_UPDATE_DATE(Date iNFO_UPDATE_DATE) {
		INFO_UPDATE_DATE = iNFO_UPDATE_DATE;
	}
	public Date getINFO_DELETE_DATE() {
		return INFO_DELETE_DATE;
	}
	public void setINFO_DELETE_DATE(Date iNFO_DELETE_DATE) {
		INFO_DELETE_DATE = iNFO_DELETE_DATE;
	}
	
	
	
	

}
