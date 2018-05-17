package Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Dao.InformationDao;
import Dao.MemberDao;
import VO.InformationVO;
import VO.Information_RecommendVO;
import VO.MemberVO;
import VO.ReviewVO;
import VO.Review_RecommendVO;

@Service
public class Information_ServiceImp implements Information_Service{
	
	@Autowired
	private InformationDao infoDao;
	
	
	@Override
	public int writeInformation(InformationVO information, MultipartFile ufile) {
		// TODO Auto-generated method stub
		String path = "C:/koitt/down/";
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdirs();
		
		String fileName = ufile.getOriginalFilename();
		File attachFile = new File(path + fileName);
		
		try{
			ufile.transferTo(attachFile);
			information.setINFO_FILE(fileName);
		}
		catch (IllegalStateException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		infoDao.insertInformation(information);
		return infoDao.infoseqcheck()-1;
	}

	@Override
	public int deleteInformation(InformationVO information) {
		// TODO Auto-generated method stub
		return infoDao.deleteInformation(information);
	}

	@Override
	public int updateInformation(InformationVO information,MultipartFile ufile) {
		// TODO Auto-generated method stub
		deleteInformation(information);
		return writeInformation(information, ufile);
	}

	@Override
	public InformationVO selectInformation(InformationVO information) {
		// TODO Auto-generated method stub
		return infoDao.selectOneInformation(information);
	}

	@Override
	public InformationVO ReadCount(InformationVO information,String id) {
		// TODO Auto-generated method stub
		information = selectInformation(information);
		if(information.getM_ID().equals(id)){
			return information;
		}else{
			information.setINFO_VIEWS(information.getINFO_VIEWS()+1);
			infoDao.updateInformation(information);
			return information;
		}
	}

	@Override
	public HashMap<String, Object> getInfomationList(HashMap<String, Object> params, int page) {
		// TODO Auto-generated method stub
		params.put("STARTRN",page*10-9);
		params.put("ENDRN",page*10);
		HashMap<String,Object> result = new HashMap<>();
		result.put("current", page);
		result.put("START", ((page-1)/10*10+1));
		result.put("END", ((page/10+1)*10));
		result.put("infoList", infoDao.getInformationList(params));
		result.put("SKIP", ((page-1)*10));
		result.put("LAST",getLastPage(params));
		return result;
	}

	@Override
	public HashMap<String, Object> recommendInfomation(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		Information_RecommendVO result =infoDao.getInformation_Recommend(params);// 추천
		if(result==null)
			infoDao.insertInformation_Recommend(params);
		else{
			if((char)params.get("INFO_RCM")==result.getINFO_RCM()){
				params.put("INFO_RCM", "C");
			}
			params.put("INFO_RCM_NO", result.getINFO_RCM_NO());
			infoDao.updateInformation_Recommend(params);
			
		}
		params.put("RCMCNT", infoDao.getRCM(params));
		params.put("UNRCMCNT", infoDao.getUNRCM(params));
		REMSetInfomation(params);
		return params;
	}

	@Override
	public void REMSetInfomation(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		InformationVO info =new InformationVO((int)params.get("INFO_NO"));
		info =infoDao.selectOneInformation(info);
		info.setINFO_RCM((int)params.get("RCMCNT"));
		info.setINFO_UNRCM((int)params.get("UNRCMCNT"));
		infoDao.updateInformation(info);	
	}

	@Override
	public int getLastPage(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return (infoDao.getInformationCount(params)-1)/10+1;
	}
}