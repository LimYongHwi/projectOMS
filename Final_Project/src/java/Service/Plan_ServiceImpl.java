package Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Dao.PlanDao;
import VO.MemberVO;
import VO.PlanVO;
import VO.Plan_ApplyVO;
import VO.RecruitVO;
import VO.Recruit_ApplyVO;

@Service
public class Plan_ServiceImpl implements Plan_Service{
	@Autowired
	PlanDao Pdao;

	@Override
	public int writePlan(PlanVO plan, MultipartFile ufile) {
		// TODO Auto-generated method stub
		String path="C:/KOITT/down/";
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdirs();// 저 경로에 폴더 없으면 make directory
		
		String fileName= ufile.getOriginalFilename();
		File attachFile = new File(path, fileName);
		
		try {
			ufile.transferTo(attachFile);
			plan.setPLAN_FILE(fileName);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		plan.setPLAN_STATE("ing");
		Pdao.insertPlan(plan);
		return numcheck();
	
}
@Override
public File getAttachFile(PlanVO plan) {
	PlanVO p = Pdao.selectOnePlan(plan);
	String fileName = p.getPLAN_FILE();
	String path="C:/KOITT/down/";
	return new File(path+fileName);
}
	

	@Override
	public int deletePlan(PlanVO plan) {
		// TODO Auto-generated method stub
		String preid = plan.getM_ID();
		String bfoid = selectPlan(plan).getM_ID();
		System.out.println("이전"+preid+"이후"+bfoid);
		if(bfoid.equals(preid)){
			return Pdao.deletePlan(plan);			
		}
		return -1;
	}

	@Override
	public int updatePlan(PlanVO plan, MultipartFile ufile) {
		// TODO Auto-generated method stub
		PlanVO prePlan = Pdao.selectOnePlan(plan);
		Pdao.deletePlan(prePlan);
		return writePlan(plan, ufile);
	}

	@Override
	public PlanVO selectPlan(PlanVO plan) {
		// TODO Auto-generated method stub
		return Pdao.selectOnePlan(plan);
	}

	@Override
	public PlanVO readPlan(PlanVO plan, String id) {
		// TODO Auto-generated method stub
		PlanVO p=selectPlan(plan);
		try{
		if(p.getM_ID().equals(id))
			return p;
		}catch(Exception e){}
	
		p.setPLAN_VIEWS(p.getPLAN_VIEWS()+1);
		Pdao.updatePlan(p);
		return p;
	}

	@Override
	public HashMap<String,Object> getPlanList(int page, HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("STARTRN", page*10-9);
		params.put("ENDRN",page*10);
		HashMap<String,Object> result= new HashMap<>();
		result.put("current", page);
		result.put("START", getStartPage(page));
		result.put("END", getEndPage(page));
		ArrayList<PlanVO> plan=Pdao.getListPlan(params);
		result.put("plan", plan);
		result.put("LAST",getLastPage(params));
		result.put("SKIP", getSkip(page,10));
		
		return result;
	}

	@Override
	public HashMap<String, Object> getPlan_ApplyList(int page, HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("STARTRN", page*5-4);
		params.put("ENDRN",page*5);
		HashMap<String,Object> result= new HashMap<>();
		result.put("current", page);
		result.put("START", getStartPage(page));
		result.put("END", getEndPage(page));
		result.put("RefrenceList",Pdao.getPlan_ApplyList(params));
		result.put("LAST",getLastPage_Apply(params));
		result.put("SKIP", getSkip(page,5));
		return params;
	}
	
	@Override
	public int PlanApply(Plan_ApplyVO plan) {
		// TODO Auto-generated method stub
		plan.setPLAN_APPLY_CONFIRM('N');
		if(checkApply(plan)){
			return Pdao.insertPlan_Apply(plan);	
		}
		else{
			return -1;
		}
	}
	@Override
	public boolean checkApply(Plan_ApplyVO plan_Apply) {
		// TODO Auto-generated method stub
		if(Pdao.getPlan_Apply(plan_Apply)==null)
			return true;
		return false;
	}


	@Override
	public int planConfirm(Plan_ApplyVO plan_Apply) {
		// TODO Auto-generated method stub
		if(fullcheck(plan_Apply)){
			return -1;
		}else{
			HashMap<String, Object> params= new HashMap<>();
			params.put("plan", plan_Apply);
			
			Plan_ApplyVO rea=Pdao.getPlan_Apply(plan_Apply);
			if(rea.getPLAN_APPLY_CONFIRM()=='Y'){
				rea.setPLAN_APPLY_CONFIRM('N');
			}else
				rea.setPLAN_APPLY_CONFIRM('Y');
			Date date = new Date();
			plan_Apply.setPLAN_APPLY_UPDATE_DATE(date);
			updateApply(rea);
			return 1;
		}
	}

	public void updateApply(Plan_ApplyVO Plan_Apply){
		Pdao.deletePlan_Apply(Plan_Apply);
		Pdao.insertPlan_Apply(Plan_Apply);
	}

	@Override
	public boolean mycheck(PlanVO plan, String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numcheck() {
		// TODO Auto-generated method stub
		return Pdao.recseqcheck();
	}

	@Override
	public boolean fullcheck(Plan_ApplyVO Plan_Apply) {
		// TODO Auto-generated method stub
		PlanVO plan= new PlanVO();
		plan.setPLAN_NO(Plan_Apply.getPLAN_NO());
		int wantcount= Pdao.selectOnePlan(plan).getPLAN_MEMBER_COUNT();
		int applycount=Pdao.getApplyCount(Plan_Apply);
		if(wantcount>applycount)
			return false;
		return true;
	}

	@Override
	public int getStartPage(int num) {
		return (num-1)/10*10+1;
	}

	@Override
	public int getEndPage(int num) {
		return (num/10+1)*10;
	}

	@Override
	public int getLastPage(HashMap<String, Object> params) {
		return (Pdao.getListCount(params)-1)/10+1;
	}

	public int getLastPage_Apply(HashMap<String, Object> params){
		return (Pdao.getPlan_ApplyCount(params)-1)/5+1;
	}
	
	
	@Override
	public int getSkip(int page,int skip){ //10개가 점프
		// TODO Auto-generated method stub
		return (page-1)*skip;
	}
	
	
	
	
	
	
}
