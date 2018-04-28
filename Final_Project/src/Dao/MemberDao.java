package Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import VO.MemberVO;
import VO.MemberVO;

public interface MemberDao {
	public int insertMember(MemberVO member);
	public int updateMember(MemberVO member);
	public int deleteMember(String M_ID);
	public MemberVO selectOneMember(MemberVO member);
	public ArrayList<MemberVO> selectAllMember(HashMap<String,Object> params);
	public HashMap<String,Object> selectBoard(MemberVO member);
	public ArrayList<MemberVO> selectSearchPhoneMember(MemberVO member);
}
