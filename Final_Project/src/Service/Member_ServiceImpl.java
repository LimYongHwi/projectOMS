package Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.html.HTMLEditorKit.InsertHTMLTextAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Dao.MemberDao;
import VO.MemberVO;
import VO.MemberVO;
import VO.PhotoVO;
import VO.PlanVO;

@Service
public class Member_ServiceImpl implements Member_Service{
	
	@Autowired
	public MemberDao mDao;
	
	@Override
	public int checkPw(MemberVO member) {
		
		if(mDao.selectOneMember(member)==null)
			return 2;
			else{
				if(mDao.selectOneMember(member).getM_PASSWORD().equals(member.getM_PASSWORD())){
				return 1;
		}else return 3;
			}
	}
	
	@Override
	public MemberVO selectAllMember(HashMap<String, Object> member) {
		mDao.selectAllMember(member);
		return null;
	}

	@Override
	public void updateMember(MemberVO member,MultipartFile ufile) {
		String path="D:/KOITT/";
		File dir = new File(path);

		if(!dir.exists())
			dir.mkdirs();// 저 경로에 폴더 없으면 make directory
		
		String fileName= ufile.getOriginalFilename();
		System.out.println(fileName);
		File attachFile = new File(path, fileName);
		
		try {
			ufile.transferTo(attachFile);
			member.setM_PROFILE(fileName);
			System.out.println(member.getM_PROFILE());
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mDao.updateMember(member);
	}

	@Override
	public int changeRank(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int changePrivate(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PhotoVO selectPhoto(MemberVO member, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PhotoVO> getPhotoList(MemberVO member, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int likePhoto(PhotoVO photo, MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void join(MemberVO member,MultipartFile ufile) {
		String path="D:/KOITT/";
		File dir = new File(path);

		if(!dir.exists())
			dir.mkdirs();// 저 경로에 폴더 없으면 make directory
		
		String fileName= ufile.getOriginalFilename();
		System.out.println(fileName);
		File attachFile = new File(path, fileName);
		
		try {
			ufile.transferTo(attachFile);
			member.setM_PROFILE(fileName);
			System.out.println(member.getM_PROFILE());
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mDao.insertMember(member);
		
	}

	@Override
	public  MemberVO selectOneMember(MemberVO member) {
		System.out.println("여기는 서비스  셀렉트 원멤버" + "  " + member.getM_ID());
		return mDao.selectOneMember(member);
	}

	@Override
	public File getAttachFile(MemberVO member) {
		MemberVO mem = mDao.selectOneMember(member);
		String fileName = mem.getM_PROFILE();
		String path="D:/KOITT/";
		return new File(path+fileName);
	}

	@Override
	public ArrayList<MemberVO> selectSearchMember(MemberVO member) {
		return mDao.selectSearchPhoneMember(member);
	}
	
	
	@Override
	public boolean checkAdmin(MemberVO member) {
		
		if(mDao.selectOneMember(member).getM_ADMIN()=='Y')
			return true;	
		else return false;
	} 
	

//	@Override
//	public HashMap<String, Object> getMyList(MemberVO member) {
//		mDao.selectBoard()
//		return null;
//	}


	




}
