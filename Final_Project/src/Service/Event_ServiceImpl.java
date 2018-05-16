package Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Dao.EventDao;
import VO.EventVO;
import VO.RecruitVO;

@Service
public class Event_ServiceImpl implements Event_Service {
	@Autowired
	EventDao eDao;

	@Override
	public EventVO readEvent(EventVO eventVO, char admin) {
		// TODO Auto-generated method stub
		eventVO = getEvent(eventVO);
		try {
			if (admin == 'Y') {
				return eventVO;
			} else {
				eventVO.setEVT_VIEW(eventVO.getEVT_VIEW() + 1);
				eDao.updateEvent(eventVO);
				return eventVO;
			}
		} catch (Exception e) {
			eventVO.setEVT_VIEW(eventVO.getEVT_VIEW() + 1);
			eDao.updateEvent(eventVO);
			return eventVO;
		}
	}

	@Override
	public EventVO getEvent(EventVO eventVO) {
		// TODO Auto-generated method stub
		return eDao.selectOneEvent(eventVO);
	}

	@Override
	public int writeEvent(EventVO eventVO, MultipartFile ufile) {
		// TODO Auto-generated method stub
		String path = "C:/koitt/down/";
		File dir = new File(path);
		if (!dir.exists())
			dir.mkdirs();

		String fileName = ufile.getOriginalFilename();
		File attachFile = new File(path + fileName);

		try {
			ufile.transferTo(attachFile);
			eventVO.setEVT_FILE(fileName);
		} catch (IllegalStateException | IOException e) {
			// TODO: handle exception
		}
		eDao.insertEvent(eventVO);
		return eDao.getEventSeqNum();
	}

	@Override
	public File getAttachFile(EventVO event) {
		EventVO e = eDao.selectOneEvent(event);
		String fileName = e.getEVT_FILE();
		String path = "C:/koitt/down/";
		return new File(path + fileName);
	}

	@Override
	public int updateEvent(EventVO eventVO, MultipartFile ufile) {
		// TODO Auto-generated method stub
		eDao.deleteEvent(eventVO);
		return writeEvent(eventVO, ufile);
	}

	@Override
	public void deleteEvent(EventVO eventVO) {
		// TODO Auto-generated method stub
		eDao.deleteEvent(eventVO);
	}

	@Override
	public HashMap<String, Object> getEventList(HashMap<String, Object> params, int page) {
		// TODO Auto-generated method stub
		if (page == -1) {
			params.put("STARTRN", 1);
			params.put("ENDRN", 5);
		} else {
			params.put("current", page);
			params.put("START", ((page - 1) / 10 * 10 + 1));
			params.put("END", ((page / 10 + 1) * 10));
			params.put("STARTRN", page * 10 - 9);
			params.put("ENDRN", page * 10);
			params.put("LAST", getLast(params));
			params.put("SKIP", ((page - 1) * 10));
		}

		List<HashMap<String, Object>> result = eDao.getEventList(params);
		params.put("eventList", result);
		return params;

	}

	@Override
	public int getLast(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return (eDao.getCountEvent(params) - 1) / 10 + 1;
	}

}
