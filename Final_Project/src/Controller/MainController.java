package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import Service.Event_Service;
import Service.Information_Service;
import Service.Member_Service;
import Service.Notice_Service;
import Service.Plan_Service;
import Service.Recruit_Service;
import Service.Review_Service;
import Service.Service_Center_Service;
import VO.MemberVO;
import Controller.DownloadView;

@Controller
public class MainController {

	// @Autowired
	// private MainService mainSvc;

	@Autowired
	private Member_Service memberSvc;
	@Autowired
	Recruit_Service recService;
	@Autowired
	Plan_Service pService;
	@Autowired
	Review_Service revService;
	@Autowired
	Information_Service infoService;
	@Autowired
	Event_Service eService;
	@Autowired
	Service_Center_Service SCservice;
	@Autowired
	Notice_Service nService;

	@RequestMapping("main.do")
	public ModelAndView goMain(HttpSession session, String id) {
		ModelAndView mav = new ModelAndView();
		MemberVO member = new MemberVO(id);
		if (id != null) {
			session.setAttribute("id", id);
			if (memberSvc.checkAdmin(member) == true) {
				session.setAttribute("id", id);
				mav.addObject("admin", 'Y');
			} else {
				session.setAttribute("id", id);
				mav.addObject("admin", 'N');
			}
		}
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("type", 0);
		result.put("EVT_END", "Y");
		result.put("EVT_FILE", "getfile");

		
		mav.addObject("plan", pService.getPlanList(1, result));
		mav.addObject("event",  eService.getEventList(result, -1));
		mav.addObject("recruit", recService.getRecruitList(1, result));
		mav.addObject("notice", nService.getNoticeList(result, 1));
		mav.setViewName("Main");
		return mav;
	}

	@RequestMapping("getBestReview.do")
	public void getBest(HttpServletResponse resp) {
		JSONObject job = new JSONObject();
		resp.setContentType("text/html;charset=UTF-8");
		HashMap<String, Object> result = new HashMap<>();
		result.put("bestReview", revService.getBestReview());
		result.put("PreBestReview", revService.getPreBestReview());
		job.append("result", result);
		try {
			resp.getWriter().println(job);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("SearchForm.do")
	public String searchForm(){
		return "redirect:search.do";
	}
	@RequestMapping("search.do")
	public ModelAndView search(
			@RequestParam(defaultValue="1") int recPage,
			@RequestParam(defaultValue="1") int planPage,
			@RequestParam(defaultValue="1")int revPage,
			@RequestParam(defaultValue="1")int infoPage,
			@RequestParam(defaultValue="0")int type,
			@RequestParam(defaultValue="5")String[] select,
			@RequestParam(required=false)String keyword,
			@RequestParam()HashMap<String, Object> params){
		//전체검색부분  
		
		//타입에 따라서 분개, 타이틀 이름 컬럼명 ?<<테이블마다 다르기떄문에...문제있네//검색어로 title , content 이름 다 변경.
		//
		ModelAndView mav = new ModelAndView();
		mav.addObject("keyword", keyword);
		mav.addObject("type", type);
		if(type==1||type==3){
			params.put("TITLE", keyword);			
		}
		if(type==2||type==3){
			params.put("CONTENT", keyword);
		}if(type==4){
			params.put("M_ID", keyword);
		}
		
		if(select[0].equals("5")){
		select = new String[4];
			select[0]="1";
			select[1]="2";
			select[2]="3";
			select[3]="4";
		}
		System.out.println("검색조건:"+params.toString());
		for(String a:select){
			switch(a){
			case "1":
				HashMap<String,Object> recruit=recService.getRecruitList(recPage, params);
				System.out.println("mav에담길 recruit"+recruit);
				mav.addObject("recruit",recruit);
				mav.addObject("rec_check","checked");
				break;
			case "2":
				HashMap<String,Object> plan=pService.getPlanList(planPage, params);
				mav.addObject("plan",plan);
				mav.addObject("plan_check","checked");
				break;
			case "3":
				HashMap<String,Object> review=revService.getReviewList(params, revPage);
				mav.addObject("rev",review);
				mav.addObject("rev_check","checked");
				break;
			case "4":
				HashMap<String,Object> info=infoService.getInfomationList(params, infoPage);
				mav.addObject("info",info);
				mav.addObject("info_check","checked");
				break;
			}			
		}
		mav.setViewName("Search_Form");
		return mav;		
	}
	
}
