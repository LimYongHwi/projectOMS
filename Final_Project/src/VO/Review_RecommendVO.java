package VO;

import java.util.Date;

public class Review_RecommendVO {
	

	private String REV_RCM_NO;
	private String M_ID;
	private char REV_RCM;
	private int REV_NO;
	private Date REV_RCM_CREATE_DATE;
	private Date REV_RCM_UPDATE_DATE;
	private Date REV_RCM_DELETE_DATE;
	public String getREV_RCM_NO() {
		return REV_RCM_NO;
	}
	public void setREV_RCM_NO(String rEV_RCM_NO) {
		REV_RCM_NO = rEV_RCM_NO;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	
	public char getREV_RCM() {
		return REV_RCM;
	}
	public void setREV_RCM(char rEV_RCM) {
		REV_RCM = rEV_RCM;
	}
	public int getREV_NO() {
		return REV_NO;
	}
	public void setREV_NO(int rEV_NO) {
		REV_NO = rEV_NO;
	}
	public Date getREV_RCM_CREATE_DATE() {
		return REV_RCM_CREATE_DATE;
	}
	public void setREV_RCM_CREATE_DATE(Date rEV_RCM_CREATE_DATE) {
		REV_RCM_CREATE_DATE = rEV_RCM_CREATE_DATE;
	}
	public Date getREV_RCM_UPDATE_DATE() {
		return REV_RCM_UPDATE_DATE;
	}
	public void setREV_RCM_UPDATE_DATE(Date rEV_RCM_UPDATE_DATE) {
		REV_RCM_UPDATE_DATE = rEV_RCM_UPDATE_DATE;
	}
	public Date getREV_RCM_DELETE_DATE() {
		return REV_RCM_DELETE_DATE;
	}
	public void setREV_RCM_DELETE_DATE(Date rEV_RCM_DELETE_DATE) {
		REV_RCM_DELETE_DATE = rEV_RCM_DELETE_DATE;
	}
	@Override
	public String toString() {
		return "Review_Recommend [REV_RCM_NO=" + REV_RCM_NO + ", M_ID=" + M_ID + ", REV_RCM=" + REV_RCM + ", REV_NO="
				+ REV_NO + ", REV_RCM_CREATE_DATE=" + REV_RCM_CREATE_DATE + ", REV_RCM_UPDATE_DATE="
				+ REV_RCM_UPDATE_DATE + ", REV_RCM_DELETE_DATE=" + REV_RCM_DELETE_DATE + "]";
	}
	
	
	
	
}
