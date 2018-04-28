package VO;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Service_CenterVO {
	private int M_SVC_NO;
	private String M_SVC_TITLE;
	private String M_SVC_CONTENT;
	private String M_SVC_ANSR;
	private Date M_SVC_ANSR_DATE;
	private Date M_SVC_CREATE_DATE;
	private Date M_SVC_UPDATE_DATE;
	private Date M_SVC_DELETE_DATE;
	private String M_SVC_FILE;
	private String M_ID;
	private char M_ADMIN;
	private MultipartFile uploadFile;

	
	public char getM_ADMIN() {
		return M_ADMIN;
	}
	public void setM_ADMIN(char m_ADMIN) {
		M_ADMIN = m_ADMIN;
	}
	
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public int getM_SVC_NO() {
		return M_SVC_NO;
	}
	public void setM_SVC_NO(int m_SVC_NO) {
		M_SVC_NO = m_SVC_NO;
	}
	public String getM_SVC_TITLE() {
		return M_SVC_TITLE;
	}
	public void setM_SVC_TITLE(String m_SVC_TITLE) {
		M_SVC_TITLE = m_SVC_TITLE;
	}
	public String getM_SVC_CONTENT() {
		return M_SVC_CONTENT;
	}
	public void setM_SVC_CONTENT(String m_SVC_CONTENT) {
		M_SVC_CONTENT = m_SVC_CONTENT;
	}
	public String getM_SVC_ANSR() {
		return M_SVC_ANSR;
	}
	public void setM_SVC_ANSR(String m_SVC_ANSR) {
		M_SVC_ANSR = m_SVC_ANSR;
	}
	public Date getM_SVC_ANSR_DATE() {
		return M_SVC_ANSR_DATE;
	}
	public void setM_SVC_ANSR_DATE(Date m_SVC_ANSR_DATE) {
		M_SVC_ANSR_DATE = m_SVC_ANSR_DATE;
	}
	public Date getM_SVC_CREATE_DATE() {
		return M_SVC_CREATE_DATE;
	}
	public void setM_SVC_CREATE_DATE(Date m_SVC_CREATE_DATE) {
		M_SVC_CREATE_DATE = m_SVC_CREATE_DATE;
	}
	public Date getM_SVC_UPDATE_DATE() {
		return M_SVC_UPDATE_DATE;
	}
	public void setM_SVC_UPDATE_DATE(Date m_SVC_UPDATE_DATE) {
		M_SVC_UPDATE_DATE = m_SVC_UPDATE_DATE;
	}
	public Date getM_SVC_DELETE_DATE() {
		return M_SVC_DELETE_DATE;
	}
	public void setM_SVC_DELETE_DATE(Date m_SVC_DELETE_DATE) {
		M_SVC_DELETE_DATE = m_SVC_DELETE_DATE;
	}
	public String getM_SVC_FILE() {
		return M_SVC_FILE;
	}
	public void setM_SVC_FILE(String m_SVC_FILE) {
		M_SVC_FILE = m_SVC_FILE;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	@Override
	public String toString() {
		return "Service_CenterVO [M_SVC_NO=" + M_SVC_NO + ", M_SVC_TITLE=" + M_SVC_TITLE + ", M_SVC_CONTENT="
				+ M_SVC_CONTENT + ", M_SVC_ANSR=" + M_SVC_ANSR + ", M_SVC_ANSR_DATE=" + M_SVC_ANSR_DATE
				+ ", M_SVC_CREATE_DATE=" + M_SVC_CREATE_DATE + ", M_SVC_UPDATE_DATE=" + M_SVC_UPDATE_DATE
				+ ", M_SVC_DELETE_DATE=" + M_SVC_DELETE_DATE + ", M_SVC_FILE=" + M_SVC_FILE + ", M_ID=" + M_ID
				+ ", M_ADMIN=" + M_ADMIN + ", uploadFile=" + uploadFile + "]";
	}
	
	
	
	
	
}
