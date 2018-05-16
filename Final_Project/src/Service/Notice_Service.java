package Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import VO.NoticeVO;

public interface Notice_Service {


	public List<HashMap<String,Object>> getNoticeList(HashMap<String,Object>params, int page);
	public NoticeVO getOneNotice(NoticeVO notice);
	public int noticeWrite(NoticeVO notice, MultipartFile ufile);
	public int updateNotice(NoticeVO notice, MultipartFile ufile);
	public int deleteNotice(NoticeVO notice);
	public HashMap<String,Object> paging(HashMap<String,Object> param, int page);
}
