package Dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.FAQVO;
import VO.NoticeVO;
import VO.Service_CenterVO;

public interface Service_CenterDao {
	//멤버단.
	public int insertService_Center(Service_CenterVO SC);
	//운영자는 업데이트만 하면됨. / /답변 , 답변일 달아주고 제목수정, 관리자아이디 등록
	public int updateService_Center(Service_CenterVO SC);

	public int deleteService_Center(Service_CenterVO SC);
	public Service_CenterVO selectOneService_Center(Service_CenterVO SC);
	public ArrayList<Service_CenterVO> getService_CenterList(HashMap<String, Object> params);
	
	// 전체 게시물 검색조건에 맞는 놈 카운트
	public int getCountService(HashMap<String, Object> params);
	
	
	// FAQ 
	public int insertFAQ(FAQVO faq);
	//운영자는 업데이트만 하면됨. / /답변 , 답변일 달아주고 제목수정, 관리자아이디 등록
	public int updateFAQ(FAQVO faq);

	public int deleteFAQ(FAQVO faq);
	public FAQVO selectOneFAQ(FAQVO faq);
	public ArrayList<FAQVO> getFAQList(HashMap<String, Object> params);
	
	// 전체 게시물 검색조건에 맞는 놈 카운트
	public int getCountFAQ(HashMap<String, Object> params);
	
	
	
	public ArrayList<HashMap<String, Object>> getNoticeList(HashMap<String, Object> params);
	public int getNoticeCount(HashMap<String, Object> params);
	public NoticeVO getOneNotice(NoticeVO notice);
	public int insertNotice(NoticeVO notice);
	public int updateNotice(NoticeVO notice);
	public int deleteNotice(NoticeVO notice);
	public int getNoticeSEQ();
}
