package VO;

import java.util.Date;

public class CommentVO {
	
	public int COMMT_NO;
	public int PHOTO_NO;
	public String COMMT_CONTENT;
	public int COMMT_PARENT;
	public String M_ID;
	public String PHT_COMMT_CREATE_DATE;
	public String PHT_COMMT_UPDATE_DATE;
	public Date PHT_COMMT_DELETE_DATE;
	public String PARENT_ID;
	
	
	
	public String getPARENT_ID() {
		return PARENT_ID;
	}



	public void setPARENT_ID(String pARENT_ID) {
		PARENT_ID = pARENT_ID;
	}



	public CommentVO() {}
	
	

	public CommentVO(int cOMMT_NO, int pHOTO_NO, String cOMMT_CONTENT, int cOMMT_PARENT, String m_ID,
			String pHT_COMMT_CREATE_DATE, String pHT_COMMT_UPDATE_DATE, Date pHT_COMMT_DELETE_DATE) {
		COMMT_NO = cOMMT_NO;
		PHOTO_NO = pHOTO_NO;
		COMMT_CONTENT = cOMMT_CONTENT;
		COMMT_PARENT = cOMMT_PARENT;
		M_ID = m_ID;
		PHT_COMMT_CREATE_DATE = pHT_COMMT_CREATE_DATE;
		PHT_COMMT_UPDATE_DATE = pHT_COMMT_UPDATE_DATE;
		PHT_COMMT_DELETE_DATE = pHT_COMMT_DELETE_DATE;
	}


	public CommentVO(String cOMMT_CONTENT, String m_ID,int pHOTO_NO, int cOMMT_PARENT) {
		PHOTO_NO = pHOTO_NO;
		COMMT_CONTENT = cOMMT_CONTENT;
		COMMT_PARENT = cOMMT_PARENT;
		M_ID = m_ID;
	}



	public int getCOMMT_NO() {
		return COMMT_NO;
	}
	public void setCOMMT_NO(int cOMMT_NO) {
		COMMT_NO = cOMMT_NO;
	}
	public int getPHOTO_NO() {
		return PHOTO_NO;
	}
	public void setPHOTO_NO(int pHOTO_NO) {
		PHOTO_NO = pHOTO_NO;
	}
	public String getCOMMT_CONTENT() {
		return COMMT_CONTENT;
	}
	public void setCOMMT_CONTENT(String cOMMT_CONTENT) {
		COMMT_CONTENT = cOMMT_CONTENT;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	public String getPHT_COMMT_CREATE_DATE() {
		return PHT_COMMT_CREATE_DATE;
	}
	public void setPHT_COMMT_CREATE_DATE(String pHT_COMMT_CREATE_DATE) {
		PHT_COMMT_CREATE_DATE = pHT_COMMT_CREATE_DATE;
	}
	public String getPHT_COMMT_UPDATE_DATE() {
		return PHT_COMMT_UPDATE_DATE;
	}
	public void setPHT_COMMT_UPDATE_DATE(String pHT_COMMT_UPDATE_DATE) {
		PHT_COMMT_UPDATE_DATE = pHT_COMMT_UPDATE_DATE;
	}
	public Date getPHT_COMMT_DELETE_DATE() {
		return PHT_COMMT_DELETE_DATE;
	}
	public void setPHT_COMMT_DELETE_DATE(Date pHT_COMMT_DELETE_DATE) {
		PHT_COMMT_DELETE_DATE = pHT_COMMT_DELETE_DATE;
	}


	public int getCOMMT_PARENT() {
		return COMMT_PARENT;
	}

	public void setCOMMT_PARENT(int cOMMT_PARENT) {
		COMMT_PARENT = cOMMT_PARENT;
	}



	@Override
	public String toString() {
		return "CommentVO [COMMT_NO=" + COMMT_NO + ", COMMT_CONTENT=" + COMMT_CONTENT + ",  M_ID=" + M_ID
				+ ", PHOTO_NO=" + PHOTO_NO + ", M_ID=" + M_ID + 
				", COMMT_PARENT= " + COMMT_PARENT+ " DATE = " + PHT_COMMT_CREATE_DATE +
				"]";
			
				
	}
	
	
}
