package VO;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class RecruitVO {
	private int REC_NO;
	private String REC_TITLE;
	private String REC_CONTENT;
	private String REC_FILE;
	private String M_ID;
	private int REC_MEMBER_COUNT;
	private String REC_DESTINATION;
	private Date REC_START;
	private Date REC_END;
	private String REC_STATE;
	private char REC_GENDER;
	private int REC_VIEWS;
	private Date REC_CREATE_DATE;
	private Date REC_UPDATE_DATE;
	private Date REC_DELETE_DATE;
	private MultipartFile UPLOADFILE;
	
	
	public MultipartFile getUPLOADFILE() {
		return UPLOADFILE;
	}

	public void setUPLOADFILE(MultipartFile uPLOADFILE) {
		UPLOADFILE = uPLOADFILE;
	}
public void titleset(char rEC_GENDER, String rEC_DESTINATION, int rEC_MEMBER_COUNT){
	String gen="무관";
	if(rEC_GENDER=='M'){
		gen="남자";
	}else if(rEC_GENDER=='W'){
		gen="여자";
	}
	REC_TITLE=rEC_DESTINATION+"로 성별"+gen+" "+rEC_MEMBER_COUNT+"명 갑시다";
}
	public RecruitVO(String rEC_CONTENT, String m_ID, int rEC_MEMBER_COUNT, String rEC_DESTINATION, Date rEC_START,
			Date rEC_END, char rEC_GENDER) {
		titleset(rEC_GENDER, rEC_DESTINATION, rEC_MEMBER_COUNT);
		REC_CONTENT = rEC_CONTENT;
		M_ID = m_ID;
		REC_MEMBER_COUNT = rEC_MEMBER_COUNT;
		REC_DESTINATION = rEC_DESTINATION;
		REC_START = rEC_START;
		REC_END = rEC_END;
		REC_GENDER = rEC_GENDER;
	}

	public RecruitVO(String rEC_TITLE, String rEC_CONTENT, String m_ID, int rEC_MEMBER_COUNT, String rEC_DESTINATION,
			Date rEC_START, Date rEC_END, char rEC_GENDER) {
		super();
		REC_TITLE = rEC_TITLE;
		REC_CONTENT = rEC_CONTENT;
		M_ID = m_ID;
		REC_MEMBER_COUNT = rEC_MEMBER_COUNT;
		REC_DESTINATION = rEC_DESTINATION;
		REC_START = rEC_START;
		REC_END = rEC_END;
		REC_GENDER = rEC_GENDER;
	}

	public RecruitVO() {
	}


	
	public RecruitVO(int rEC_NO, String rEC_TITLE, String rEC_CONTENT, String rEC_FILE, String m_ID, int rEC_MEMBER_COUNT,
			String rEC_DESTINATION, Date rEC_START, Date rEC_END, String rEC_STATE, char rEC_GENDER, int rEC_VIEWS,
			Date rEC_CREATE_DATE, Date rEC_UPDATE_DATE, Date rEC_DELETE_DATE) {
		REC_NO = rEC_NO;
		REC_TITLE = rEC_TITLE;
		REC_CONTENT = rEC_CONTENT;
		REC_FILE = rEC_FILE;
		M_ID = m_ID;
		REC_MEMBER_COUNT = rEC_MEMBER_COUNT;
		REC_DESTINATION = rEC_DESTINATION;
		REC_START = rEC_START;
		REC_END = rEC_END;
		REC_STATE = rEC_STATE;
		REC_GENDER = rEC_GENDER;
		REC_VIEWS = rEC_VIEWS;
		REC_CREATE_DATE = rEC_CREATE_DATE;
		REC_UPDATE_DATE = rEC_UPDATE_DATE;
		REC_DELETE_DATE = rEC_DELETE_DATE;
	}

	@Override
	public String toString() {
		return "Recruit [REC_NO=" + REC_NO + ", REC_TITLE=" + REC_TITLE + ", REC_CONTENT=" + REC_CONTENT + ", REC_FILE="
				+ REC_FILE + ", M_ID=" + M_ID + ", REC_MEMBER_COUNT=" + REC_MEMBER_COUNT + ", REC_DESTINATION="
				+ REC_DESTINATION + ", REC_START=" + REC_START + ", REC_END=" + REC_END + ", REC_STATE=" + REC_STATE
				+ ", REC_GENDER=" + REC_GENDER + ", REC_VIEWS=" + REC_VIEWS + ", REC_CREATE_DATE=" + REC_CREATE_DATE
				+ ", REC_UPDATE_DATE=" + REC_UPDATE_DATE + ", REC_DELETE_DATE=" + REC_DELETE_DATE + "]";
	}

	public int getREC_NO() {
		return REC_NO;
	}
	public void setREC_NO(int rEC_NO) {
		REC_NO = rEC_NO;
	}
	public String getREC_TITLE() {
		return REC_TITLE;
	}
	public void setREC_TITLE(String rEC_TITLE) {
		REC_TITLE = rEC_TITLE;
	}
	public String getREC_CONTENT() {
		return REC_CONTENT;
	}
	public void setREC_CONTENT(String rEC_CONTENT) {
		REC_CONTENT = rEC_CONTENT;
	}
	public String getREC_FILE() {
		return REC_FILE;
	}
	public void setREC_FILE(String rEC_FILE) {
		REC_FILE = rEC_FILE;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String M_ID) {
		this.M_ID = M_ID;
	}
	public int getREC_MEMBER_COUNT() {
		return REC_MEMBER_COUNT;
	}
	public void setREC_MEMBER_COUNT(int rEC_MEMBER_COUNT) {
		REC_MEMBER_COUNT = rEC_MEMBER_COUNT;
	}
	public String getREC_DESTINATION() {
		return REC_DESTINATION;
	}
	public void setREC_DESTINATION(String rEC_DESTINATION) {
		REC_DESTINATION = rEC_DESTINATION;
	}
	public Date getREC_START() {
		return REC_START;
	}
	public void setREC_START(Date rEC_START) {
		REC_START = rEC_START;
	}
	public Date getREC_END() {
		return REC_END;
	}
	public void setREC_END(Date rEC_END) {
		REC_END = rEC_END;
	}
	public String getREC_STATE() {
		return REC_STATE;
	}
	public void setREC_STATE(String rEC_STATE) {
		REC_STATE = rEC_STATE;
	}
	public char getREC_GENDER() {
		return REC_GENDER;
	}
	public void setREC_GENDER(char rEC_GENDER) {
		REC_GENDER = rEC_GENDER;
	}
	public int getREC_VIEWS() {
		return REC_VIEWS;
	}
	public void setREC_VIEWS(int rEC_VIEWS) {
		REC_VIEWS = rEC_VIEWS;
	}
	public Date getREC_CREATE_DATE() {
		return REC_CREATE_DATE;
	}
	public void setREC_CREATE_DATE(Date rEC_CREATE_DATE) {
		REC_CREATE_DATE = rEC_CREATE_DATE;
	}
	public Date getREC_UPDATE_DATE() {
		return REC_UPDATE_DATE;
	}
	public void setREC_UPDATE_DATE(Date rEC_UPDATE_DATE) {
		REC_UPDATE_DATE = rEC_UPDATE_DATE;
	}
	public Date getREC_DELETE_DATE() {
		return REC_DELETE_DATE;
	}
	public void setREC_DELETE_DATE(Date rEC_DELETE_DATE) {
		REC_DELETE_DATE = rEC_DELETE_DATE;
	}
	
	
}
