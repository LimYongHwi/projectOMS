package VO;

import java.util.Date;

public class PlanVO {
 private int PLAN_NO ;
 private String	PLAN_TITLE;
 private String PLAN_CONTENT;
 private String PLAN_FILE;
 private String M_ID;
 private int PLAN_MEMBER_COUNT;
 private String PLAN_DESTINATION; 
 private Date PLAN_START;
 private Date PLAN_END;
 private int PLAN_VIEWS;
 private String PLAN_STATE;
 private char PLAN_GENDER; 
 private Date PLAN_CREATE_DATE;
 private Date PLAN_DELETE_DATE;
 private Date PLAN_UPDATE_DATE;
 
 
 
 
 
public PlanVO(int pLAN_NO) {
	super();
	PLAN_NO = pLAN_NO;
}
public PlanVO(String pLAN_TITLE, String pLAN_CONTENT, String pLAN_FILE, String m_ID, int pLAN_MEMBER_COUNT,
		String pLAN_DESTINATION, Date pLAN_START, Date pLAN_END,int pLAN_VIEWS, String pLAN_STATE, char pLAN_GENDER) {
	super();
	PLAN_TITLE = pLAN_TITLE;
	PLAN_CONTENT = pLAN_CONTENT;
	PLAN_FILE = pLAN_FILE;
	M_ID = m_ID;
	PLAN_MEMBER_COUNT = pLAN_MEMBER_COUNT;
	PLAN_DESTINATION = pLAN_DESTINATION;
	PLAN_START = pLAN_START;
	PLAN_VIEWS =pLAN_VIEWS;
	PLAN_END = pLAN_END;
	PLAN_STATE = pLAN_STATE;
	PLAN_GENDER = pLAN_GENDER;
}
public PlanVO() {
	super();
}
public PlanVO(int pLAN_NO, String pLAN_TITLE, String pLAN_CONTENT, String pLAN_FILE, String m_ID, int pLAN_MEMBER_COUNT,
		String pLAN_DESTINATION, Date pLAN_START, Date pLAN_END,int pLAN_VIEWS, String pLAN_STATE, char pLAN_GENDER,
		Date pLAN_CREATE_DATE, Date pLAN_DELETE_DATE, Date pLAN_UPDATE_DATE) {
	super();
	PLAN_NO = pLAN_NO;
	PLAN_TITLE = pLAN_TITLE;
	PLAN_CONTENT = pLAN_CONTENT;
	PLAN_FILE = pLAN_FILE;
	M_ID = m_ID;
	PLAN_MEMBER_COUNT = pLAN_MEMBER_COUNT;
	PLAN_DESTINATION = pLAN_DESTINATION;
	PLAN_START = pLAN_START;
	PLAN_VIEWS =pLAN_VIEWS;
	PLAN_END = pLAN_END;
	PLAN_STATE = pLAN_STATE;
	PLAN_GENDER = pLAN_GENDER;
	PLAN_CREATE_DATE = pLAN_CREATE_DATE;
	PLAN_DELETE_DATE = pLAN_DELETE_DATE;
	PLAN_UPDATE_DATE = pLAN_UPDATE_DATE;
}

public int getPLAN_VIEWS() {
	return PLAN_VIEWS;
}
public void setPLAN_VIEWS(int pLAN_VIEWS) {
	PLAN_VIEWS = pLAN_VIEWS;
}
public int getPLAN_NO() {
	return PLAN_NO;
}
public void setPLAN_NO(int pLAN_NO) {
	PLAN_NO = pLAN_NO;
}
public String getPLAN_TITLE() {
	return PLAN_TITLE;
}
public void setPLAN_TITLE(String pLAN_TITLE) {
	PLAN_TITLE = pLAN_TITLE;
}
public String getPLAN_CONTENT() {
	return PLAN_CONTENT;
}
public void setPLAN_CONTENT(String pLAN_CONTENT) {
	PLAN_CONTENT = pLAN_CONTENT;
}
public String getPLAN_FILE() {
	return PLAN_FILE;
}
public void setPLAN_FILE(String pLAN_FILE) {
	PLAN_FILE = pLAN_FILE;
}
public String getM_ID() {
	return M_ID;
}
public void setM_ID(String m_ID) {
	M_ID = m_ID;
}
public int getPLAN_MEMBER_COUNT() {
	return PLAN_MEMBER_COUNT;
}
public void setPLAN_MEMBER_COUNT(int pLAN_MEMBER_COUNT) {
	PLAN_MEMBER_COUNT = pLAN_MEMBER_COUNT;
}
public String getPLAN_DESTINATION() {
	return PLAN_DESTINATION;
}
public void setPLAN_DESTINATION(String pLAN_DESTINATION) {
	PLAN_DESTINATION = pLAN_DESTINATION;
}
public Date getPLAN_START() {
	return PLAN_START;
}
public void setPLAN_START(Date pLAN_START) {
	PLAN_START = pLAN_START;
}
public Date getPLAN_END() {
	return PLAN_END;
}
public void setPLAN_END(Date pLAN_END) {
	PLAN_END = pLAN_END;
}
public String getPLAN_STATE() {
	return PLAN_STATE;
}
public void setPLAN_STATE(String pLAN_STATE) {
	PLAN_STATE = pLAN_STATE;
}
public char getPLAN_GENDER() {
	return PLAN_GENDER;
}
public void setPLAN_GENDER(char pLAN_GENDER) {
	PLAN_GENDER = pLAN_GENDER;
}
public Date getPLAN_CREATE_DATE() {
	return PLAN_CREATE_DATE;
}
public void setPLAN_CREATE_DATE(Date pLAN_CREATE_DATE) {
	PLAN_CREATE_DATE = pLAN_CREATE_DATE;
}
public Date getPLAN_DELETE_DATE() {
	return PLAN_DELETE_DATE;
}
public void setPLAN_DELETE_DATE(Date pLAN_DELETE_DATE) {
	PLAN_DELETE_DATE = pLAN_DELETE_DATE;
}
public Date getPLAN_UPDATE_DATE() {
	return PLAN_UPDATE_DATE;
}
public void setPLAN_UPDATE_DATE(Date pLAN_UPDATE_DATE) {
	PLAN_UPDATE_DATE = pLAN_UPDATE_DATE;
}
@Override
public String toString() {
	return "PlanVO [PLAN_NO=" + PLAN_NO + ", PLAN_TITLE=" + PLAN_TITLE + ", PLAN_CONTENT=" + PLAN_CONTENT
			+ ", PLAN_FILE=" + PLAN_FILE + ", M_ID=" + M_ID + ", PLAN_MEMBER_COUNT=" + PLAN_MEMBER_COUNT
			+ ", PLAN_DESTINATION=" + PLAN_DESTINATION + ", PLAN_START=" + PLAN_START + ", PLAN_END=" + PLAN_END
			+ ", PLAN_VIEWS=" + PLAN_VIEWS + ", PLAN_STATE=" + PLAN_STATE + ", PLAN_GENDER=" + PLAN_GENDER
			+ ", PLAN_CREATE_DATE=" + PLAN_CREATE_DATE + ", PLAN_DELETE_DATE=" + PLAN_DELETE_DATE
			+ ", PLAN_UPDATE_DATE=" + PLAN_UPDATE_DATE + "]";
}

 }
