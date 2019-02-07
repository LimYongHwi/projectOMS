package Dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.CommentVO;
import VO.MemberVO;
import VO.PhotoVO;
import VO.Photo_LikeVO;

public interface PhotoDao {
	public int insertPhoto(PhotoVO photo);
	public int updatePhoto(PhotoVO photo);
	public int deletePhoto(PhotoVO photo);
	public PhotoVO selectOnePhoto(PhotoVO photo);
	public ArrayList<PhotoVO> getListPhoto(HashMap<String,Object> params);
	public int insertPhoto_Like(PhotoVO photo);
	public int deletePhoto_Like(PhotoVO photo);	
	//
	public Photo_LikeVO selectPhoto_Like(PhotoVO photo, MemberVO member);
	
	//���ƿ� �����̱�
	public int getPhoto_Like(PhotoVO photo);
	public int getCount(String id);
	
	//ó�� �Խù��� ������ �Խù� ��ȣ
	public HashMap<String, Object> getFirstAndLastNumber(PhotoVO photo);
	public int selectCommtTotalCount(PhotoVO photo);
	public void insertComment(CommentVO commt);
	public ArrayList<CommentVO> getCommentsList(PhotoVO photo);
}
