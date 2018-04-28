package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Dao.Service_CenterDao;
import VO.EventVO;
import VO.FAQVO;
import VO.MemberVO;
import VO.Service_CenterVO;

@Service
public class Service_Center_ServiceImp implements Service_Center_Service{

	@Autowired
	Service_CenterDao SCDao;

	
	
	@Override
	public int writeService(Service_CenterVO SC, MultipartFile file) {
		// TODO Auto-generated method stub
		String path="C:koitt/down/";
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdirs();
		String fileName = file.getOriginalFilename();
		File attachFile = new File(path+fileName);
		
		try {
			file.transferTo(attachFile);
			SC.setM_SVC_FILE(fileName);;
		} catch (Exception e) {
			// TODO: handle exception
		}
		SCDao.insertService_Center(SC);
		return SC.getM_SVC_NO();
	}


	@Override
	public Service_CenterVO selectOneService(Service_CenterVO SC) {
		// TODO Auto-generated method stub
		return SCDao.selectOneService_Center(SC);
	}

	@Override
	public HashMap<String, Object> selectAllService(HashMap<String, Object> params, int page) {
		// TODO Auto-generated method stub
		params.put("start", getStart(page));
		params.put("end", getEnd(page));
		params.put("last", getLastService(params));
		params.put("STARTRN", page*10-9);
		params.put("ENDRN", page*10);
		params.put("current", page);
		params.put("sevList", SCDao.getService_CenterList(params));
		return params;
		
	}
	
	public int getStart(int page){
		return (page-1)/10*10+1;
	}
	
	public int getEnd(int page){
		int a=(page/10+1);
		if(page%10==0)
			a=page/10;
		return a*10;
	}
	
	@Override
	public int deleteService(Service_CenterVO SC) {
		// TODO Auto-generated method stub
		return SCDao.deleteService_Center(SC);
	}

	@Override
	public int updateService(Service_CenterVO SC) {
		// TODO Auto-generated method stub
			return SCDao.updateService_Center(SC);
	}

	
	@Override
	public HashMap<String, Object> getFAQList(HashMap<String, Object>params, int page) {
		// TODO Auto-generated method stub
		params.put("start", getStart(page));
		params.put("end", getEnd(page));
		params.put("last", getLastFAQ(params));
		params.put("STARTRN", page*10-9);
		params.put("ENDRN", page*10);
		params.put("current", page);
		params.put("List", SCDao.getFAQList(params));
		return params;
	}
	
	@Override
	public int writeFAQ(FAQVO faq) {
		// TODO Auto-generated method stub
		SCDao.insertFAQ(faq);
		return faq.getFAQ_NO();
	}

	@Override
	public FAQVO selectFAQ(FAQVO faq) {
		return faq;
		// TODO Auto-generated method stub
	}

	@Override
	public EventVO selectEvent(EventVO Event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EventVO> getEventList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getAttachFile(Service_CenterVO SC) {
		// TODO Auto-generated method stub
		Service_CenterVO sc = SCDao.selectOneService_Center(SC);
		String fileName = sc.getM_SVC_FILE();
		String path = "C:/koitt/down/";
		return new File(path+fileName);
	}


	@Override
	public int getLastService(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return (SCDao.getCountService(params)-1)/10+1;
	}


	@Override
	public int getLastFAQ(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return (SCDao.getCountService(params)-1)/10+1;
	}


	


}
