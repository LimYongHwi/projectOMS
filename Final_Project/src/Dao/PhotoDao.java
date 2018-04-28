package Dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.MemberVO;
import VO.PhotoVO;
import VO.Photo_LikeVO;

public interface PhotoDao {
	public int insertPhoto(PhotoVO photo);
	public int updatePhoto(PhotoVO photo);
	public int deletePhoto(PhotoVO photo);
	public PhotoVO selectOnePhoto(PhotoVO photo);
	public ArrayList<PhotoVO> getListPhoto(PhotoVO photo);
	
	public int insertPhoto_Like(PhotoVO photo);
	public int deletePhoto_Like(PhotoVO photo);	
	//
	public Photo_LikeVO selectPhoto_Like(PhotoVO photo, MemberVO member);
	
	//좋아요 갯수뽑기
	public int getPhoto_Like(PhotoVO photo);
}
