package Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Dao.ReviewDao;
import VO.MemberVO;
import VO.RecruitVO;
import VO.ReviewVO;
import VO.Review_RecommendVO;

@Service
public class Review_ServiceImpl implements Review_Service{
	
	@Autowired
	private ReviewDao RDao;
	
	@Override
	public int writeReview(ReviewVO review,MultipartFile file) {
		String path = "C:/koitt/down/";
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdirs();
		
		String fileName = file.getOriginalFilename();
		File attachFile = new File(path + fileName);
		
		try{
			file.transferTo(attachFile);
			review.setREV_FILE(fileName);
		}
		catch (IllegalStateException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		RDao.insertReview(review);
		return RDao.revseqcheck()-1;
		
		
	}

	@Override
	public int deleteReview(ReviewVO review) {
		return RDao.deleteReview(review);
	}

	@Override
	public int updateReview(ReviewVO review,MultipartFile ufile) {
		String path = "C:/koitt/down/";
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdirs();
		
		String fileName = ufile.getOriginalFilename();
		File attachFile = new File(path + fileName);
		
		try{
			ufile.transferTo(attachFile);
			review.setREV_FILE(fileName);
		}
		catch (IllegalStateException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		RDao.updateReview(review);
		return review.getREV_NO();
	}

	@Override
	public ReviewVO selectReview(ReviewVO review) {
		// TODO Auto-generated method stub
		return RDao.selectOneReview(review);
		
	}

	@Override
	public ReviewVO ReadCount(ReviewVO review,String id) {
		// TODO Auto-generated method stub
		review = selectReview(review);
		if(review.getM_ID().equals(id)){
			return review;
		}else{
			review.setREV_VIEWS(review.getREV_VIEWS()+1);
			RDao.updateReview(review);
			return review;
		}
		
		
	}
	@Override
	public File getAttachFile(ReviewVO review) {
		ReviewVO b = RDao.selectOneReview(review);
		String fileName = b.getREV_FILE();
		String path="C:/KOITT/down/";
		return new File(path+fileName);
	}

	@Override
	public ReviewVO getPreBestReview() {
		// TODO Auto-generated method stub
		return RDao.getPreBestReview();
	}
	@Override
	public ReviewVO getBestReview() {
		// TODO Auto-generated method stub
		return RDao.getBestReview();
	}

	@Override
	public HashMap<String, Object> getReviewList(HashMap<String, Object> params, int page) {
		// TODO Auto-generated method stub
		params.put("current", page);
		params.put("START", ((page-1)/10*10+1));
		params.put("END", ((page/10+1)*10));
		params.put("STARTRN",page*10-9);
		params.put("ENDRN",page*10);
		params.put("reviewList", RDao.getReviewList(params));
		params.put("SKIP", ((page-1)*10));
		params.put("LAST",getLastPage(params));
		return params;
	}

	@Override
	public HashMap<String, Object> recommendReview(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		System.out.println(params.toString());
		Review_RecommendVO result =RDao.getReview_Recommend(params);// 추천
		if(result==null)
			RDao.insertReview_Recommend(params);
		else{
			if((char)params.get("REV_RCM")==result.getREV_RCM()){
				params.put("REV_RCM", "C");
			}
			params.put("REV_RCM_NO", result.getREV_RCM_NO());
			RDao.updateReview_Recommend(params);
			
		}
		params.put("RCMCNT", RDao.getRCM(params));
		params.put("UNRCMCNT", RDao.getUNRCM(params));
		REMSetReview(params);
		return params;
	}

	@Override
	public void REMSetReview(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		
		ReviewVO review =new ReviewVO((int)params.get("REV_NO"));
		review =RDao.selectOneReview(review);
		review.setREV_REM_COUNT((int)params.get("RCMCNT"));
		review.setREV_UNREM_COUNT((int)params.get("UNRCMCNT"));
		RDao.updateReview(review);		
	}

	@Override
	public int getLastPage(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return (RDao.getReviewCount(params)-1)/10+1;
	}

	
	
	
	
	
	
}
