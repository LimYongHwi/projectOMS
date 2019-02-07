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
	//�ؽ������� �޵� �����Խ��� ��ȣ�� ��� ���̵� �� �Բ� ����,, �⺻���� Ȯ�����δ� false>>(0,1)
	public int insertPlan_Apply(Plan_ApplyVO Plan_Apply);
	public int updatePlan_Apply(Plan_ApplyVO Plan_Apply);
	public int deletePlan_Apply(Plan_ApplyVO Plan_Apply);
	
	//�ο��� ����ٲ� .. count()�Լ����
	public int getPlan_ApplyCount(HashMap<String,Object> params);
	
	//�ϳ��� ��û����Ʈ üũ��
	public Plan_ApplyVO getPlan_Apply(Plan_ApplyVO plan_apply);
	//��û�� ����Ʈ ����ٳ�
	public ArrayList<HashMap<String,Object>> getPlan_ApplyList(HashMap<String,Object> params);
	
	
	//Ȯ���� �ο��� ����ٳ�
		public int getApplyCount(Plan_ApplyVO Plan_ApplyVO);
	
	
}
