package Dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.RecruitVO;
import VO.Recruit_ApplyVO;
import VO.Recruit_ReplyVO;

public interface RecruitDao {
	public int insertRecruit(RecruitVO recruit);
	public int updateRecruit(RecruitVO recruit);
	public int deleteRecruit(RecruitVO recruit);
	public RecruitVO selectOneRecruit(RecruitVO recruit);
	//모집게시판 리스트 뿌려주기 , StartPage, endPage , 등등 받아오기 
	public ArrayList<RecruitVO> getListRecruit(HashMap<String,Object> params);
	public int getCount(HashMap<String,Object>params);
	public int recseqcheck();
	
	
	//해쉬맵으로 받되 모집게시판 번호와 멤버 아이디 를 함께 저장,, 기본으로 확정여부는 false>>(0,1)
	public int insertRecruit_Apply(Recruit_ApplyVO recruit_Apply);
	public int updateRecruit_Apply(Recruit_ApplyVO recruit_Apply);
	public int deleteRecruit_Apply(Recruit_ApplyVO recruit_Apply);
	//신청체크용
	public Recruit_ApplyVO getRecruit_Apply(Recruit_ApplyVO recruit_Apply);
	//인원수 뱉어줄꺼 .. count()함수사용
	public int getRecruit_ApplyCount(HashMap<String,Object> params);
	//신청한 리스트 뱉어줄놈
	public ArrayList<HashMap<String,Object>> getRecruit_ApplyList(HashMap<String,Object> params);
	//확정된 인원수 뱉어줄놈
	public int getApplyCount(Recruit_ApplyVO recruit_ApplyVO);
	
	
	//댓글부분..
	public Recruit_ReplyVO selectRec_Rep(Recruit_ReplyVO rec_rep);
	public int insertRec_Rep(Recruit_ReplyVO rec_rep);
	public int updateRec_Rep(Recruit_ReplyVO rec_rep);
	public int deleteRec_Rep(Recruit_ReplyVO rec_rep);
	public ArrayList<HashMap<String,Object>> getRec_RepList(HashMap<String, Object> params);
	public int getRec_RepCount(HashMap<String,Object> params);
	
}
