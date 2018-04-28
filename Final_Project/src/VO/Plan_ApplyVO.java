package VO;

import java.util.Date;

public class Plan_ApplyVO {
	private int PLAN_APPLY_NO;
	private int PLAN_NO;
	private char PLAN_APPLY_CONFIRM;
	private String M_ID;
	private Date PLAN_APPLY_CREATE_DATE;
	private Date PLAN_APPLY_UPDATE_DATE;
	private Date PLAN_APPLY_DELETE_DATE;
	
	
	
	
	
	public Plan_ApplyVO(int pLAN_APPLY_NO, int pLAN_NO, String m_ID) {
		super();
		PLAN_APPLY_NO = pLAN_APPLY_NO;
		PLAN_NO = pLAN_NO;
		M_ID = m_ID;
	}
	public Plan_ApplyVO() {
		super();
	}
	public Plan_ApplyVO(int pLAN_APPLY_NO, int pLAN_NO, char pLAN_APPLY_CONFIRM, String m_ID,
			Date pLAN_APPLY_CREATE_DATE, Date pLAN_APPLY_UPDATE_DATE, Date pLAN_APPLY_DELETE_DATE) {
		super();
		PLAN_APPLY_NO = pLAN_APPLY_NO;
		PLAN_NO = pLAN_NO;
		PLAN_APPLY_CONFIRM = pLAN_APPLY_CONFIRM;
		M_ID = m_ID;
		PLAN_APPLY_CREATE_DATE = pLAN_APPLY_CREATE_DATE;
		PLAN_APPLY_UPDATE_DATE = pLAN_APPLY_UPDATE_DATE;
		PLAN_APPLY_DELETE_DATE = pLAN_APPLY_DELETE_DATE;
	}
	public int getPLAN_APPLY_NO() {
		return PLAN_APPLY_NO;
	}
	public void setPLAN_APPLY_NO(int pLAN_APPLY_NO) {
		PLAN_APPLY_NO = pLAN_APPLY_NO;
	}
	public int getPLAN_NO() {
		return PLAN_NO;
	}
	public void setPLAN_NO(int pLAN_NO) {
		PLAN_NO = pLAN_NO;
	}
	public char getPLAN_APPLY_CONFIRM() {
		return PLAN_APPLY_CONFIRM;
	}
	public void setPLAN_APPLY_CONFIRM(char pLAN_APPLY_CONFIRM) {
		PLAN_APPLY_CONFIRM = pLAN_APPLY_CONFIRM;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	public Date getPLAN_APPLY_CREATE_DATE() {
		return PLAN_APPLY_CREATE_DATE;
	}
	public void setPLAN_APPLY_CREATE_DATE(Date pLAN_APPLY_CREATE_DATE) {
		PLAN_APPLY_CREATE_DATE = pLAN_APPLY_CREATE_DATE;
	}
	public Date getPLAN_APPLY_UPDATE_DATE() {
		return PLAN_APPLY_UPDATE_DATE;
	}
	public void setPLAN_APPLY_UPDATE_DATE(Date pLAN_APPLY_UPDATE_DATE) {
		PLAN_APPLY_UPDATE_DATE = pLAN_APPLY_UPDATE_DATE;
	}
	public Date getPLAN_APPLY_DELETE_DATE() {
		return PLAN_APPLY_DELETE_DATE;
	}
	public void setPLAN_APPLY_DELETE_DATE(Date pLAN_APPLY_DELETE_DATE) {
		PLAN_APPLY_DELETE_DATE = pLAN_APPLY_DELETE_DATE;
	}
	@Override
	public String toString() {
		return "Plan_ApplyVO [PLAN_APPLY_NO=" + PLAN_APPLY_NO + ", PLAN_NO=" + PLAN_NO + ", PLAN_APPLY_CONFIRM="
				+ PLAN_APPLY_CONFIRM + ", M_ID=" + M_ID + ", PLAN_APPLY_CREATE_DATE=" + PLAN_APPLY_CREATE_DATE
				+ ", PLAN_APPLY_UPDATE_DATE=" + PLAN_APPLY_UPDATE_DATE + ", PLAN_APPLY_DELETE_DATE="
				+ PLAN_APPLY_DELETE_DATE + "]";
	}
	
	
	
	
}
