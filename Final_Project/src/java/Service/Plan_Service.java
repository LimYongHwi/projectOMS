package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import VO.MemberVO;
import VO.PlanVO;
import VO.Plan_ApplyVO;
import VO.RecruitVO;
import VO.Recruit_ApplyVO;

public interface Plan_Service {
	//계획게시판 내부의 기능 // 글쓰기, 수정, 삭제, 신청,조회,전체검색,한가지 게시물 뱉기, 확정등등
	
	//게시물쓰기
		public int writePlan(PlanVO plan,MultipartFile ufile);

		//파일얻어오기
		public File getAttachFile(PlanVO plan);
		//게시물 지우기
		public int deletePlan(PlanVO plan);
		
		//게시물 수정
		public int updatePlan(PlanVO plan,MultipartFile ufile);
		
		//한가지 조회
		public PlanVO selectPlan(PlanVO plan);
		
		//조회수 증가
		public PlanVO readPlan(PlanVO Plan,String id);
		
		//게시물 뿌려주기
		public HashMap<String,Object> getPlanList(int page,HashMap<String, Object>params);
		
		//신청목록 불러주기
		public HashMap<String,Object> getPlan_ApplyList(int page, HashMap<String, Object>params);
		
		//하나 신청체크
		public boolean checkApply(Plan_ApplyVO plan_Apply);
		
		//모집 신청
		public int PlanApply(Plan_ApplyVO plan_Apply);
		
		
		//모집 확정
		public int planConfirm(Plan_ApplyVO plan_Apply);
		
		//내글인지확인
		public boolean mycheck(PlanVO plan, String id); 
		
		//시퀀스번호체크
		public int numcheck();
		
		//한명 확정했을떄 항상 체크할것.(만약 모집하고자하는 인원수와 확정인원수가 같으면 모집중>>모집완료로 변환하고, 상태 변환)
		public boolean fullcheck(Plan_ApplyVO plna_Apply);
		
		public int getStartPage(int num) ;
		public int getEndPage(int num);
		public int getLastPage(HashMap<String, Object> params);
		public int getSkip(int page,int skip);
		
	
	
}
