package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import VO.CommentVO;
import VO.MemberVO;
import VO.PhotoVO;

public interface PhotoService {

	public HashMap<String, Object> getMemberPhotos(PhotoVO photo,int page);
	public void insertMemberPhoto(PhotoVO photo,MultipartHttpServletRequest mtfRequest);
	public void deleteMemberPhoto(HashMap<String,PhotoVO> params);
	public File getAttachFiles(PhotoVO photo);
	public int getStartPage(int page);
	public int getEndPage(String id,int page);
	public int getLastPage(String id,int page);
	public int getSkip(int page);
	public PhotoVO getPhoto(PhotoVO photo);
	public int getTotalCount(String id);
	public HashMap<String, Object> getFirstandLast(PhotoVO photo);
	public int CommentTotalCount(PhotoVO photo);
	public void insertComment(CommentVO commt);
	public ArrayList<CommentVO> selectComments(PhotoVO photo);
}
