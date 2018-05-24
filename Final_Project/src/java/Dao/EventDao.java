package Dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.EventVO;
import VO.FAQVO;
import VO.Service_CenterVO;

public interface EventDao {
	//멤버단.
	public int insertEvent(EventVO event);
	//업데이트
	public int updateEvent(EventVO event);
	//삭제
	public int deleteEvent(EventVO event);
	
	//하나뽑기
	public EventVO selectOneEvent(EventVO event);
	
	//리스트뽑기
	public ArrayList<HashMap<String, Object>> getEventList(HashMap<String, Object> params);
	
	//시퀀스에 다음번호 뽑을놈
	public int getEventSeqNum();
	
	// 전체 게시물 검색조건에 맞는 놈 카운트
	public int getCountEvent(HashMap<String, Object> params);
	
}
