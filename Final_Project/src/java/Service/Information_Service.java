package Service;
import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import VO.InformationVO;
import VO.MemberVO;

public interface Information_Service {
	//여행정보 게시판 내부의 기능 // 글쓰기, 수정, 삭제,조회,전체검색,한가지 게시물 뱉기 추천 등등

	//게시물쓰기
	public int writeInformation(InformationVO information, MultipartFile ufile);

	//게시물 지우기
	public int deleteInformation(InformationVO information);
	
	//게시물 수정
	public int updateInformation(InformationVO information, MultipartFile ufile);
	
	//한가지 조회
	public InformationVO selectInformation(InformationVO information);
	
	//조회수 증가
	public InformationVO ReadCount(InformationVO information,String id);
			
	//게시물 뿌려주기
	public HashMap<String, Object> getInfomationList(HashMap<String, Object> params,int page);
	
	//게시물 추천,비추천하기
	public HashMap<String, Object> recommendInfomation(HashMap<String, Object> params);
	
	//게시물 추천셋팅
	public void REMSetInfomation(HashMap<String, Object> params);

		//마지막 페이지 ? 확인할꺼 ... 글수에 따라서
	public int getLastPage(HashMap<String, Object> params);
	
}
