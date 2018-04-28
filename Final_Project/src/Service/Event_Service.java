package Service;

import java.io.File;
import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import VO.EventVO;

public interface Event_Service {
	
	
	
	//조회하는놈(조회수 증가)
	public EventVO readEvent(EventVO eventVO, char admin);
	
	//그냥 하나 게시물 뽑아올놈 
	public EventVO getEvent(EventVO eventVO);
	
	//글쓰기
	public int writeEvent(EventVO eventVO, MultipartFile ufile);
	
	//수정
	public int updateEvent(EventVO eventVO,MultipartFile ufile);
	
	//삭제
	public void deleteEvent(EventVO eventVO);
	
	//전체 게시물 읽어줄놈 페이징포함
	public HashMap<String, Object> getEventList(HashMap<String,Object>params,int page);
	
	
	
	
	public int getLast(HashMap<String, Object> params);
	
	public File getAttachFile(EventVO event);
	
	
}
