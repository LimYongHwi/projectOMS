package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Dao.MemberDao;
import Dao.RecruitDao;
import VO.MemberVO;
import VO.PlanVO;
import VO.RecruitVO;
import VO.Recruit_ApplyVO;
import VO.Recruit_ReplyVO;

public interface Recruit_Service {
	
	//모집게시판 내부의 기능 // 글쓰기, 수정, 삭제, 신청,조회,전체검색,한가지 게시물 뱉기, 확정등등
	//게시물쓰기
	public int writeRecruit(RecruitVO recruit, MultipartFile file);
	//파일얻어오기
	public File getAttachFile(RecruitVO recruit);
	//게시물 지우기
	public int deleteRecruit(RecruitVO recruit, String id);
	
	//게시물 수정
	public int updateRecruit(RecruitVO recruit, MultipartFile ufile);
	
	//한가지 조회
	public RecruitVO selectRecruit(RecruitVO recruit);
	
	//내글인지확인
	public boolean mycheck(RecruitVO recruit, String id); 
	
	//조회수 증가
	public RecruitVO readRecruit(RecruitVO recruit,String id);
	
	//게시물 뿌려주기
	public HashMap<String,Object> getRecruitList(int page, HashMap<String, Object>params);
	
	//신청목록 불러주기
	public HashMap<String,Object> getRecruit_ApplyList(int page, HashMap<String, Object>params);
		
	//하나 신청체크
	public boolean checkApply(Recruit_ApplyVO recruit_Apply);
	
	//모집 신청
	public int recruitApply(RecruitVO recruit, MemberVO member);
	

	//모집 확정
	public int recruitConfirm(Recruit_ApplyVO recruit_Apply);
	//시퀀스번호체크
	public int numcheck();
	//한명 확정했을떄 항상 체크할것.(만약 모집하고자하는 인원수와 확정인원수가 같으면 모집중>>모집완료로 변환하고, 상태 변환)
	public boolean fullcheck(Recruit_ApplyVO recruit);
	
	public int getStartPage(int num) ;
	public int getEndPage(int num);
	public int getLastPage(HashMap<String, Object> params);
	public int getSkip(int page,int skip);
	
	
	//댓글부분
	public Recruit_ReplyVO getReply(Recruit_ReplyVO rec_rep);
	public int writeReply(Recruit_ReplyVO rec_rep);
	public int updateReply(Recruit_ReplyVO rec_rep);
	public int deleteReply(Recruit_ReplyVO rec_rep);
	public HashMap<String,Object> getReplyList(HashMap<String, Object> params,int page);
	public int getLastReply(HashMap<String, Object> params);
	
}
