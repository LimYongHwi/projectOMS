package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Dao.Service_CenterDao;
import VO.NoticeVO;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
@Service
public class Notice_ServiceImp implements Notice_Service{

	@Autowired
	Service_CenterDao sDao;
	
	@Override
	public List<HashMap<String, Object>> getNoticeList(HashMap<String, Object> params, int page) {
		// TODO Auto-generated method stub
		params.put("STARTRN",page*10-9);
		params.put("ENDRN",page*10);
		return sDao.getNoticeList(params);
	}

	@Override
	public NoticeVO getOneNotice(NoticeVO notice) {
		// TODO Auto-generated method stub
		return sDao.getOneNotice(notice);
	}

	@Override
	public int noticeWrite(NoticeVO notice, MultipartFile ufile) {
		// TODO Auto-generated method stub
		String path = "C:/koitt/down";
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdirs();
		
		String fileName = ufile.getOriginalFilename();
		File attachFile = new File(path + fileName);
		
		try{
			ufile.transferTo(attachFile);
			notice.setNOTICE_FILE(fileName);
		}
		catch (IllegalStateException | IOException e) {
			// TODO: handle exception
		}
		sDao.insertNotice(notice);
		return sDao.getNoticeSEQ();
	}

	@Override
	public int updateNotice(NoticeVO notice, MultipartFile ufile) {
		// TODO Auto-generated method stub
		String path = "C:/koitt/down";
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdirs();
		
		String fileName = ufile.getOriginalFilename();
		File attachFile = new File(path + fileName);
		
		try{
			ufile.transferTo(attachFile);
			notice.setNOTICE_FILE(fileName);
		}
		catch (IllegalStateException | IOException e) {
			// TODO: handle exception
		}
		sDao.updateNotice(notice);
		return notice.getNOTICE_NO();
	}

	@Override
	public int deleteNotice(NoticeVO notice) {
		// TODO Auto-generated method stub
		return sDao.deleteNotice(notice);
	}

	@Override
	public HashMap<String, Object> paging(HashMap<String,Object> param, int page) {
		// TODO Auto-generated method stub
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("current", page);
		result.put("START", (page-1)/10*10+1);
		result.put("END", (page/10+1)*10);
		result.put("LAST", (sDao.getNoticeCount(param)-1)/10);
		return result;
	}

	
	
}
