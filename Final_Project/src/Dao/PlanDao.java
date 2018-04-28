package Dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.PlanVO;
import VO.Plan_ApplyVO;
import VO.Recruit_ApplyVO;

public interface PlanDao {
	public int insertPlan(PlanVO plan);
	public int deletePlan(PlanVO plan);
	public int updatePlan(PlanVO plan);
	public PlanVO selectOnePlan(PlanVO plan);
	public ArrayList<PlanVO> getListPlan(HashMap<String, Object> params);
	public int getListCount(HashMap<String, Object> params);
	public int recseqcheck();
	//해쉬맵으로 받되 모집게시판 번호와 멤버 아이디 를 함께 저장,, 기본으로 확정여부는 false>>(0,1)
	public int insertPlan_Apply(Plan_ApplyVO Plan_Apply);
	public int updatePlan_Apply(Plan_ApplyVO Plan_Apply);
	public int deletePlan_Apply(Plan_ApplyVO Plan_Apply);
	
	//인원수 뱉어줄꺼 .. count()함수사용
	public int getPlan_ApplyCount(HashMap<String,Object> params);
	
	//하나의 신청리스트 체크용
	public Plan_ApplyVO getPlan_Apply(Plan_ApplyVO plan_apply);
	//신청한 리스트 뱉어줄놈
	public ArrayList<HashMap<String,Object>> getPlan_ApplyList(HashMap<String,Object> params);
	
	
	//확정된 인원수 뱉어줄놈
		public int getApplyCount(Plan_ApplyVO Plan_ApplyVO);
	
	
}
