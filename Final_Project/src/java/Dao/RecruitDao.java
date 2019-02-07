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
	//�����Խ��� ����Ʈ �ѷ��ֱ� , StartPage, endPage , ��� �޾ƿ��� 
	public ArrayList<RecruitVO> getListRecruit(HashMap<String,Object> params);
	public int getCount(HashMap<String,Object>params);
	public int recseqcheck();
	
	
	//�ؽ������� �޵� �����Խ��� ��ȣ�� ��� ���̵� �� �Բ� ����,, �⺻���� Ȯ�����δ� false>>(0,1)
	public int insertRecruit_Apply(Recruit_ApplyVO recruit_Apply);
	public int updateRecruit_Apply(Recruit_ApplyVO recruit_Apply);
	public int deleteRecruit_Apply(Recruit_ApplyVO recruit_Apply);
	//��ûüũ��
	public Recruit_ApplyVO getRecruit_Apply(Recruit_ApplyVO recruit_Apply);
	//�ο��� ����ٲ� .. count()�Լ����
	public int getRecruit_ApplyCount(HashMap<String,Object> params);
	//��û�� ����Ʈ ����ٳ�
	public ArrayList<HashMap<String,Object>> getRecruit_ApplyList(HashMap<String,Object> params);
	//Ȯ���� �ο��� ����ٳ�
	public int getApplyCount(Recruit_ApplyVO recruit_ApplyVO);
	
	
	//��ۺκ�..
	public Recruit_ReplyVO selectRec_Rep(Recruit_ReplyVO rec_rep);
	public int insertRec_Rep(Recruit_ReplyVO rec_rep);
	public int updateRec_Rep(Recruit_ReplyVO rec_rep);
	public int deleteRec_Rep(Recruit_ReplyVO rec_rep);
	public ArrayList<HashMap<String,Object>> getRec_RepList(HashMap<String, Object> params);
	public int getRec_RepCount(HashMap<String,Object> params);
	//�ڽĳ�� ����üũ
	public int levelcheck(Recruit_ReplyVO rec_rep);
	
	
	
}
