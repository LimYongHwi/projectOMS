package Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.instrument.classloading.tomcat.TomcatLoadTimeWeaver;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import Dao.PhotoDao;
import VO.CommentVO;
import VO.PhotoVO;
import VO.RecruitVO;

@Service
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	PhotoDao pDao;
	
	public int totalCnt=0;
	public int totalPage;
	public int cntPage=4;
	public int endPage;
	
	@Override
	public HashMap<String, Object> getMemberPhotos(PhotoVO photo,int page) {
		System.out.println("서비스에서 받은 페이지 : "+page);
		HashMap<String, Object> result = new HashMap<>();
		result.put("current", page);
		result.put("start", getStartPage(page));
		result.put("end", getEndPage(photo.getM_ID(),getStartPage(page)));
		result.put("skip", getSkip(page));
		result.put("last",getLastPage(photo.getM_ID(),page));
		
		result.put("STARTRN", page*8-7);
		result.put("ENDRN",page*8);
		int s =  page*8-7;
		int e = page*8;
		System.out.println("STARTRN :  " + s);
		System.out.println("ENDRN" + e);
		result.put("M_ID", photo.getM_ID());
		
		result.put("PhotoList", pDao.getListPhoto(result));
		
		return result;
	}

	@Override
	public void insertMemberPhoto(PhotoVO photo,MultipartHttpServletRequest mtfRequest){

		List<MultipartFile> fileList = mtfRequest.getFiles("ufile");
        String src = mtfRequest.getParameter("src");
       String path="D:/KOITT/";
       
        for (MultipartFile mf : fileList) {
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            long fileSize = mf.getSize(); // 파일 사이즈

            String safeFile = path + System.currentTimeMillis() + originFileName;
            try {
                mf.transferTo(new File(safeFile));
                photo.setFILE(originFileName);
        		pDao.insertPhoto(photo);
                System.out.println("get파일"+photo.getFILE());                
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
	}
	

	@Override
	public void deleteMemberPhoto(HashMap<String, PhotoVO> params) {
		
		for(String key : params.keySet()) {
			PhotoVO ph = new PhotoVO();
			ph = params.get(key);
			pDao.deletePhoto(ph);
		}
	}

	@Override
	public File getAttachFiles(PhotoVO photo) {
		System.out.println("서비스: " + photo.getPHOTO_NO());
		PhotoVO pht = pDao.selectOnePhoto(photo);
		System.out.println("서비스 파일 이름 출력: " + pht.getFILE());
		String fileName = pht.getFILE();
		String path="D:/KOITT/";
		return new File(path+fileName);
	}

	@Override
	public int getStartPage(int page) {
		return ((page-1)/4)*4+1;
	}
	
	@Override
	public int getTotalCount(String id) {
		totalCnt=pDao.getCount(id);
		System.out.println("전체 갯수:  "  + totalCnt);
		return totalCnt;
	}

	@Override
	public int getEndPage(String id,int startPage) {
		
//		if(getTotalCount(id) % 8 ==0)
			totalPage = getTotalCount(id) / 8;
//		else 
//			totalPage = (getTotalCount(id) / 8) +1;
		
		System.out.println("엔드페이지 계산 중 totalPage 계산 : " + totalPage);
		endPage=startPage + cntPage - 1;
		
		if (endPage > totalPage) {

		    endPage = totalPage;

		}
		System.out.println("엔드페이지 계산 후 : " + endPage);
		return endPage;
	}

	@Override
	public int getLastPage(String id, int page) {
		System.out.println("라스트 페이지에서 페이지" + page);

		totalPage = getTotalCount(id) / 8;

		if(getTotalCount(id) % 8 > 0) { //총 갯수에서 보여줄 게시글8를 나눈 후에 0보다 크면 페이지수를 플러스
			totalPage++;
		}
		if(totalPage < page) { //현재 페이지가 전체 페이지 보다 크다면 현재 페이지가 전체 페이지가 된다. 마지막 게시 페이지번호만 보여주기 위해서임.
			page = totalPage;
		}
		return totalPage;
	}

	@Override
	public int getSkip(int page) {
		System.out.println("getSkip에서 페이지" + page);
		return (page-1)*cntPage;
	}

	@Override
	public PhotoVO getPhoto(PhotoVO photo) {
		System.out.println(pDao.selectOnePhoto(photo));
		return pDao.selectOnePhoto(photo);
	}

	@Override
	public HashMap<String, Object> getFirstandLast(PhotoVO photo) {
		return pDao.getFirstAndLastNumber(photo);
	}

	@Override
	public int CommentTotalCount(PhotoVO photo) {
		return pDao.selectCommtTotalCount(photo);
	}

	@Override
	public void insertComment(CommentVO commt) {
		pDao.insertComment(commt);
		
	}

	@Override
	public ArrayList<CommentVO> selectComments(PhotoVO photo) {
		return pDao.getCommentsList(photo);
	}
	

	

	
}
