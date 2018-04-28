package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.PhotoDao;
import VO.PhotoVO;

@Service
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	PhotoDao pDao;
	
	@Override
	public List<HashMap<String, Object>> getMemberPhotos(PhotoVO photo) {
		ArrayList<HashMap<String, Object>> list = new ArrayList();
		HashMap<String, Object> result = new HashMap();
		result.put("result", pDao.getListPhoto(photo));
		list.add(result);
		return list;
	}

	@Override
	public void insertMemberPhoto(PhotoVO photo) {
		pDao.insertPhoto(photo);
	}

	@Override
	public void deleteMemberPhoto(HashMap<String, PhotoVO> params) {
		
		for(String key : params.keySet()) {
			PhotoVO ph = new PhotoVO();
			ph = params.get(key);
			pDao.deletePhoto(ph);
		}
	}

	
}
