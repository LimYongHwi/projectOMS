package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import VO.MemberVO;
import VO.PhotoVO;

public interface PhotoService {

	public List<HashMap<String, Object>> getMemberPhotos(PhotoVO photo);
	public void insertMemberPhoto(PhotoVO photo);
	public void deleteMemberPhoto(HashMap<String,PhotoVO> params);
	
}
