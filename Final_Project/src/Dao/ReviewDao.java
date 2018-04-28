package Dao;

import java.util.ArrayList;
import java.util.HashMap;
import VO.ReviewVO;
import VO.Review_RecommendVO;

public interface ReviewDao {
	public int insertReview(ReviewVO review);
	public int updateReview(ReviewVO review);
	public int deleteReview(ReviewVO review);
	public ReviewVO selectOneReview(ReviewVO review);
	public ArrayList<ReviewVO> getReviewList(HashMap<String, Object> params);
	public int getReviewCount(HashMap<String, Object> params);
	public int revseqcheck();
	public ReviewVO getBestReview();
	public ReviewVO getPreBestReview();
	public int insertReview_Recommend(HashMap<String, Object> params);
	public int updateReview_Recommend(HashMap<String, Object> params);
	public int deleteReview_Recommend(HashMap<String, Object> params);
	public Review_RecommendVO getReview_Recommend(HashMap<String, Object> params);
	public int getRCM(HashMap<String, Object> params);
	public int getUNRCM(HashMap<String, Object> params);
}
