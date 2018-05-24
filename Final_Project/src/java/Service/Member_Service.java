package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import VO.MemberVO;
import VO.MemberVO;
import VO.PhotoVO;
import VO.RecruitVO;

public interface Member_Service {
	//�쉶�썝媛��엯, 濡쒓렇�씤 , �쉶�썝議고쉶, �궗吏꾩꺽�뱾�뼱媛�湲� ,�쉶�썝 �븳紐� 寃��깋, �븳紐낆쓽 �궗吏꾩꺽肉뚮젮二쇨린, 醫뗭븘�슂湲곕뒫(�궗吏꾩꺽�궡遺�)
	
	//�쉶�썝媛��엯
	public void join(MemberVO member,MultipartFile file);
	//�븘�씠�뵒 以묐났泥댄겕
	public boolean checkAdmin(MemberVO member);
	
	//鍮꾨쾲泥댄겕
	public int checkPw(MemberVO member);
	
	//�븳紐� 議고쉶
	public  MemberVO selectOneMember(MemberVO member);
	
	//�뿬�윭紐� 議고쉶
	public MemberVO selectAllMember(HashMap<String, Object> member);
	
	//�쉶�썝 �젙蹂댁닔�젙
	public void updateMember(MemberVO member,MultipartFile file);
	
	
	//�옲�겕 �삱�씪媛��뒗吏� 泥댄겕
	public int changeRank(MemberVO member);
	
	//怨듦컻�뿬遺��닔�젙
	public int changePrivate(MemberVO member);	
	//�궗吏꾩꺽 �븳媛� 議고쉶
	public PhotoVO selectPhoto(MemberVO member, int page);
	
	//�궗吏꾩꺽 議고쉶 // 蹂몄씤�씤吏� �솗�씤... �븘�땺�뻹 怨듦컻�뿬遺� �뙋�떒�빐�꽌 蹂댁뿬以꾧쾬
	public ArrayList<PhotoVO> getPhotoList(MemberVO member, int page);
		
	
	public int likePhoto(PhotoVO photo, MemberVO member);
	
	public File getAttachFile(MemberVO member);
	
	public ArrayList<MemberVO> selectSearchMember(MemberVO member);
	
//	public HashMap<String,Object> getMyList(MemberVO member);
	
	
}
