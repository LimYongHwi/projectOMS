package VO;

import java.util.Date;

public class Information_RecommendVO {
	private int INFO_RCM_NO;
	private String M_ID;
	private char INFO_RCM;
	private Date INFO_RCM_CREATE_DATE;
	private Date INFO_RCM_UPDATE_DATE;
	private Date INFO_RCM_DELETE_DATE;
	
	
	
	public Information_RecommendVO(int iNFO_RCM_NO) {
		super();
		INFO_RCM_NO = iNFO_RCM_NO;
	}
	public Information_RecommendVO() {
		super();
	}
	public Information_RecommendVO(int iNFO_RCM_NO, String m_ID, char iNFO_RCM, Date iNFO_RCM_CREATE_DATE,
			Date iNFO_RCM_UPDATE_DATE, Date iNFO_RCM_DELETE_DATE) {
		super();
		INFO_RCM_NO = iNFO_RCM_NO;
		M_ID = m_ID;
		INFO_RCM = iNFO_RCM;
		INFO_RCM_CREATE_DATE = iNFO_RCM_CREATE_DATE;
		INFO_RCM_UPDATE_DATE = iNFO_RCM_UPDATE_DATE;
		INFO_RCM_DELETE_DATE = iNFO_RCM_DELETE_DATE;
	}
	public int getINFO_RCM_NO() {
		return INFO_RCM_NO;
	}
	public void setINFO_RCM_NO(int iNFO_RCM_NO) {
		INFO_RCM_NO = iNFO_RCM_NO;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	public char getINFO_RCM() {
		return INFO_RCM;
	}
	public void setINFO_RCM(char iNFO_RCM) {
		INFO_RCM = iNFO_RCM;
	}
	public Date getINFO_RCM_CREATE_DATE() {
		return INFO_RCM_CREATE_DATE;
	}
	public void setINFO_RCM_CREATE_DATE(Date iNFO_RCM_CREATE_DATE) {
		INFO_RCM_CREATE_DATE = iNFO_RCM_CREATE_DATE;
	}
	public Date getINFO_RCM_UPDATE_DATE() {
		return INFO_RCM_UPDATE_DATE;
	}
	public void setINFO_RCM_UPDATE_DATE(Date iNFO_RCM_UPDATE_DATE) {
		INFO_RCM_UPDATE_DATE = iNFO_RCM_UPDATE_DATE;
	}
	public Date getINFO_RCM_DELETE_DATE() {
		return INFO_RCM_DELETE_DATE;
	}
	public void setINFO_RCM_DELETE_DATE(Date iNFO_RCM_DELETE_DATE) {
		INFO_RCM_DELETE_DATE = iNFO_RCM_DELETE_DATE;
	}
	@Override
	public String toString() {
		return "Information_RecommendVO [INFO_RCM_NO=" + INFO_RCM_NO + ", M_ID=" + M_ID + ", INFO_RCM=" + INFO_RCM
				+ ", INFO_RCM_CREATE_DATE=" + INFO_RCM_CREATE_DATE + ", INFO_RCM_UPDATE_DATE=" + INFO_RCM_UPDATE_DATE
				+ ", INFO_RCM_DELETE_DATE=" + INFO_RCM_DELETE_DATE + "]";
	}
	
	
	
	
}
