package Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Dao.RecruitDao;
import VO.MemberVO;
import VO.RecruitVO;
import VO.Recruit_ApplyVO;
import VO.Recruit_ReplyVO;
@Service
public class Recruit_ServiceImp implements Recruit_Service{
	@Autowired
	RecruitDao recDao;
	
	@Override
	public int writeRecruit(RecruitVO recruit, MultipartFile file) {
		// TODO Auto-generated method stub
			String path="C:/KOITT/down/";
			File dir = new File(path);
			if(!dir.exists())
				dir.mkdirs();// 저 경로에 폴더 없으면 make directory
			
			String fileName= file.getOriginalFilename();
			File attachFile = new File(path, fileName);
			
			try {
				file.transferTo(attachFile);
				recruit.setREC_FILE(fileName);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
			}
			recDao.insertRecruit(recruit);
			return numcheck();
		
	}
	@Override
	public File getAttachFile(RecruitVO recruit) {
		RecruitVO b = recDao.selectOneRecruit(recruit);
		String fileName = b.getREC_FILE();
		String path="C:/KOITT/down/";
		return new File(path+fileName);
	}
	
	@Override
	public int deleteRecruit(RecruitVO recruit, String id) {
		// TODO Auto-generated method stub
		if(mycheck(recruit, id)){
			
			return recDao.deleteRecruit(recruit);
		}
		return -1;
	}

	@Override
	public int updateRecruit(RecruitVO recruit ,MultipartFile ufile) {
		// TODO Auto-generated method stub
			Date date = new Date();
			recruit.setREC_UPDATE_DATE(date);
			recruit.titleset(recruit.getREC_GENDER(), recruit.getREC_DESTINATION(), recruit.getREC_MEMBER_COUNT());
			
			recDao.deleteRecruit(recruit);
			return writeRecruit(recruit, ufile);
		  
	}

	public int numcheck(){
	return recDao.recseqcheck();	
	}
	@Override
	public boolean mycheck(RecruitVO recruit, String id) {
		// TODO Auto-generated method stub
		try{
		if(recDao.selectOneRecruit(recruit).getM_ID().equals(id)){
			return true;
		}
		}catch(Exception e){}
		return false;
	}

	@Override
	public RecruitVO selectRecruit(RecruitVO recruit) {
		// TODO Auto-generated method stub
		return recDao.selectOneRecruit(recruit);
	}

	@Override
	public RecruitVO readRecruit(RecruitVO recruit,String id) {
		// TODO Auto-generated method stub
		RecruitVO rec=recDao.selectOneRecruit(recruit);
		try{
		if(rec.getM_ID().equals(id))
			return rec;
		}catch(Exception e){}
		try{
		rec.setREC_VIEWS(rec.getREC_VIEWS()+1);
		recDao.updateRecruit(rec);
		}catch(Exception e){}
		return rec;
	}

	@Override
	public HashMap<String,Object> getRecruitList(int page, HashMap<String,Object> params) {
		// TODO Auto-generated method stub
		params.put("current", page);
		params.put("START", getStartPage(page));
		params.put("END", getEndPage(page));
		params.put("STARTRN", page*10-9);
		params.put("ENDRN",page*10);
		ArrayList<RecruitVO> result=recDao.getListRecruit(params);
		params.put("Recruit", result);
		params.put("LAST",getLastPage(params));
		params.put("SKIP", getSkip(page,10));
		return params;
	}

	@Override
	public HashMap<String,Object> getRecruit_ApplyList(int page, HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("current", page);
		params.put("START", getStartPage(page));
		params.put("END", getEndPage(page));
		params.put("STARTRN", page*5-4);
		params.put("ENDRN",page*5);
		ArrayList<HashMap<String , Object>> result=recDao.getRecruit_ApplyList(params);
		params.put("RefrenceList", result);
		params.put("LAST",getLastPage_Apply(params));
		params.put("SKIP", getSkip(page,5));
		return params;
	}
	@Override
	public boolean checkApply(Recruit_ApplyVO recruit_Apply) {
		// TODO Auto-generated method stub
		if(recDao.getRecruit_Apply(recruit_Apply)==null)
			return true;
		return false;
		
	}
	@Override
	public int recruitApply(RecruitVO recruit, MemberVO member) {
		// TODO Auto-generated method stub
		Recruit_ApplyVO reA = new Recruit_ApplyVO(recruit.getREC_NO(),'N',member.getM_ID());
		
		if(checkApply(reA)){
			return recDao.insertRecruit_Apply(reA);	
		}
		else{
			return -1;
		}
	}



	@Override
	public int recruitConfirm(Recruit_ApplyVO recruit_Apply) {
		// TODO Auto-generated method stub
		if(fullcheck(recruit_Apply)){
			return -1;
		}else{
			HashMap<String, Object> params= new HashMap<>();
			params.put("recruit", recruit_Apply);
			
			Recruit_ApplyVO rea=recDao.getRecruit_Apply(recruit_Apply);
			if(rea.getREC_APPLY_CONFIRM()=='Y'){
				rea.setREC_APPLY_CONFIRM('N');
			}else
				rea.setREC_APPLY_CONFIRM('Y');
			Date date = new Date();
			recruit_Apply.setREC_APPLY_UPDATE_DATE(date);
			updateApply(rea);
			return 1;
		}
			
	}
	
	public void updateApply(Recruit_ApplyVO recruit_Apply){
		recDao.deleteRecruit_Apply(recruit_Apply);
		
		recDao.insertRecruit_Apply(recruit_Apply);
	}

	@Override
	public boolean fullcheck(Recruit_ApplyVO recruit_Apply) {
		// TODO Auto-generated method stub
		RecruitVO rev= new RecruitVO();
		rev.setREC_NO(recruit_Apply.getREC_NO());
		int wantcount= recDao.selectOneRecruit(rev).getREC_MEMBER_COUNT();
		int applycount=recDao.getApplyCount(recruit_Apply);
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
		return (recDao.getCount(params)-1)/10+1;
	}

	public int getLastPage_Apply(HashMap<String, Object> params){
		return (recDao.getRecruit_ApplyCount(params)-1)/5+1;
	}
	
	
	@Override
	public int getSkip(int page,int skip){ //10개가 점프
		// TODO Auto-generated method stub
		return (page-1)*skip;
	}
	
	
	@Override
	public Recruit_ReplyVO getReply(Recruit_ReplyVO rec_rep) {
		// TODO Auto-generated method stub
		return recDao.selectRec_Rep(rec_rep);
	}
	@Override
	public int writeReply(Recruit_ReplyVO rec_rep) {
		// TODO Auto-generated method stub
		if(rec_rep.getM_ID()==null){
			return -1;
		}
		return recDao.insertRec_Rep(rec_rep);
	}
	
	@Override
	public int updateReply(Recruit_ReplyVO rec_rep) {
		// TODO Auto-generated method stub
		try {
			Recruit_ReplyVO get = getReply(rec_rep);
			if(get.getM_ID().equals(rec_rep.getM_ID())){
				get.setRECRUIT_REPLY_CONTENT(rec_rep.getRECRUIT_REPLY_CONTENT());
				return recDao.updateRec_Rep(get);			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
		
	}
	
	@Override
	public int deleteReply(Recruit_ReplyVO rec_rep) {
		// TODO Auto-generated method stub
		try {
			System.out.println("삭제이전"+rec_rep);
			Recruit_ReplyVO get = getReply(rec_rep);
			System.out.println("삭제검색"+get);
			if(get.getM_ID().equals(rec_rep.getM_ID())){
				return recDao.deleteRec_Rep(rec_rep);			
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	@Override
	public HashMap<String, Object> getReplyList(HashMap<String, Object> params,int page) {
		// TODO Auto-generated method stub
		params.put("current", page);
		params.put("START", getStartPage(page));
		params.put("END", getEndPage(page));
		params.put("LAST",getLastReply(params));
		params.put("STARTRN", page*10-9);
		params.put("ENDRN",page*10);
		ArrayList<HashMap<String , Object>> result=recDao.getRec_RepList(params);
		params.put("replyList",result);
		return params;
	}
	
	@Override
	public int getLastReply(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return (recDao.getRec_RepCount(params)-1)/10+1;
	}
	@Override
	public int getNodeCount(Recruit_ReplyVO rec_rep) {
		// TODO Auto-generated method stub
		return recDao.levelcheck(rec_rep);
	}
	
	
	

}
