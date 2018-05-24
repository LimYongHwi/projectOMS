package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import VO.EventVO;
import VO.FAQVO;
import VO.MemberVO;
import VO.Service_CenterVO;

public interface Service_Center_Service {
	
	
	//1:1질문관련
	//1:1질문올리기
	public int writeService(Service_CenterVO SC, MultipartFile file);

	//1:1질문 한개 검색
	public Service_CenterVO selectOneService(Service_CenterVO SC);
	//1:1질문 전체 검색 / 리스트
	public HashMap<String, Object> selectAllService(HashMap<String, Object> params, int page);
	//1:1질문 올린 질문 삭제
	public int deleteService(Service_CenterVO SC);
	//1:1질문 올린 질문 수정
	public int updateService(Service_CenterVO SC);
	
	public int getLastService(HashMap<String, Object> params);
	
	
	//FAQ 게시물 등록
	public int writeFAQ(FAQVO faq);	
	//FAQ게시물 조회
	public HashMap<String, Object> getFAQList(HashMap<String, Object>params, int page);
	//FAQ게시물한개 상세 조회
	public FAQVO selectFAQ(FAQVO faq);
	
	public int getLastFAQ(HashMap<String, Object> params);
	
	
	
	//이벤트 조회
	public EventVO selectEvent(EventVO Event);	
	//이벤트 게시물조회
	public ArrayList<EventVO> getEventList(int page);
	
	public File getAttachFile(Service_CenterVO SC);
	
	
}
