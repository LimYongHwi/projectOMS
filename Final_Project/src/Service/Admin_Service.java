package Service;

import java.util.ArrayList;

import VO.EventVO;
import VO.FAQVO;
import VO.Service_CenterVO;

public interface Admin_Service{
	//공지사항 , FAQ, 고객센터 , 이벤트,조회,전체검색,한가지 게시물 뱉기, 등등 처리
	
	//FAQ작성
	public int writeFAQ(FAQVO faq);
	//FAQ수정
	public int updateFAQ(FAQVO faq);
	//FAQ삭제
	public int deleteFAQ(FAQVO faq);
	
	//답변
	public int AnswerService(Service_CenterVO SC);
	//답변수정
	public int updateAnswerService(Service_CenterVO SC);
	//답변삭제
	public int deleteAnswerService(Service_CenterVO SC);
	//셀렉트는 공용/어드민, 유저모두사용/
	
	//이벤트 글쓰기
	public int writeEvent(EventVO event);
	//이벤트 글 수정
	public int updateEvent(EventVO event);
	//이벤트 글 삭제
	public int deleteEvent(EventVO event);
	
	
	
	
	
	
}
