package Dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.InformationVO;
import VO.Information_RecommendVO;
import VO.ReviewVO;
import VO.Review_RecommendVO;

public interface InformationDao {
	public int insertInformation(InformationVO information);
	public int updateInformation(InformationVO information);
	public int deleteInformation(InformationVO information);
	public InformationVO selectOneInformation(InformationVO information);
	public ArrayList<InformationVO> getInformationList(HashMap<String, Object> params);
	public int getInformationCount(HashMap<String, Object> params);
	public int infoseqcheck();
	
	public int insertInformation_Recommend(HashMap<String, Object> params);
	public int updateInformation_Recommend(HashMap<String, Object> params);
	public int deleteInformation_Recommend(HashMap<String, Object> params);
	public Information_RecommendVO getInformation_Recommend(HashMap<String, Object> params);
	public int getRCM(HashMap<String, Object> params);
	public int getUNRCM(HashMap<String, Object> params);
}
