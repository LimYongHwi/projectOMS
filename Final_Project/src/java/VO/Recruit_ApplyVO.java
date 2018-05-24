package VO;

import java.util.Date;

public class Recruit_ApplyVO {
 private int REC_APPLY_NO;
 private int REC_NO;
 private char REC_APPLY_CONFIRM;
 private String M_ID;
 private Date REC_APPLY_CREATE_DATE;
 private Date REC_APPLY_UPDATE_DATE;
 private Date REC_APPLY_DELETE_DATE;
 
public Recruit_ApplyVO() {
}


public Recruit_ApplyVO(int rEC_APPLY_NO, int rEC_NO, String m_ID) {
	REC_APPLY_NO = rEC_APPLY_NO;
	REC_NO = rEC_NO;
	M_ID = m_ID;
}


public Recruit_ApplyVO(int rEC_NO, char rEC_APPLY_CONFIRM, String m_ID) {
	REC_NO = rEC_NO;
	REC_APPLY_CONFIRM = rEC_APPLY_CONFIRM;
	M_ID = m_ID;
}
@Override
public String toString() {
	return "Recruit_Apply [REC_APPLY_NO=" + REC_APPLY_NO + ", REC_NO=" + REC_NO + ", REC_APPLY_CONFIRM="
			+ REC_APPLY_CONFIRM + ", M_ID=" + M_ID + ", REC_APPLY_CREATE_DATE=" + REC_APPLY_CREATE_DATE
			+ ", REC_APPLY_UPDATE_DATE=" + REC_APPLY_UPDATE_DATE + ", REC_APPLY_DELETE_DATE=" + REC_APPLY_DELETE_DATE
			+ "]";
}

public Recruit_ApplyVO(int REC_APPLY_NO, int REC_NO, char REC_APPLY_CONFIRM, String M_ID,
		Date REC_APPLY_CREATE_DATE,Date REC_APPLY_UPDATE_DATE, Date REC_APPLY_DELETE_DATE) {
	this.REC_APPLY_NO = REC_APPLY_NO;
	this.REC_NO = REC_NO;
	this.REC_APPLY_CONFIRM = REC_APPLY_CONFIRM;
	this.M_ID = M_ID;
	this.REC_APPLY_CREATE_DATE = REC_APPLY_CREATE_DATE;
	this.REC_APPLY_UPDATE_DATE = REC_APPLY_UPDATE_DATE;
	this.REC_APPLY_DELETE_DATE = REC_APPLY_DELETE_DATE;
}

public int getREC_APPLY_NO() {
	return REC_APPLY_NO;
}
public void setREC_APPLY_NO(int rEC_APPLY_NO) {
	REC_APPLY_NO = rEC_APPLY_NO;
}
public int getREC_NO() {
	return REC_NO;
}
public void setREC_NO(int rEC_NO) {
	REC_NO = rEC_NO;
}
public char getREC_APPLY_CONFIRM() {
	return REC_APPLY_CONFIRM;
}
public void setREC_APPLY_CONFIRM(char rEC_APPLY_CONFIRM) {
	REC_APPLY_CONFIRM = rEC_APPLY_CONFIRM;
}
public String getM_ID() {
	return M_ID;
}
public void setM_ID(String m_ID) {
	M_ID = m_ID;
}
public Date getREC_APPLY_CREATE_DATE() {
	return REC_APPLY_CREATE_DATE;
}
public void setREC_APPLY_CREATE_DATE(Date rEC_APPLY_CREATE_DATE) {
	REC_APPLY_CREATE_DATE = rEC_APPLY_CREATE_DATE;
}
public Date getREC_APPLY_UPDATE_DATE() {
	return REC_APPLY_UPDATE_DATE;
}
public void setREC_APPLY_UPDATE_DATE(Date rEC_APPLY_UPDATE_DATE) {
	REC_APPLY_UPDATE_DATE = rEC_APPLY_UPDATE_DATE;
}
public Date getREC_APPLY_DELETE_DATE() {
	return REC_APPLY_DELETE_DATE;
}
public void setREC_APPLY_DELETE_DATE(Date rEC_APPLY_DELETE_DATE) {
	REC_APPLY_DELETE_DATE = rEC_APPLY_DELETE_DATE;
}
 
 
 
 
 
}
