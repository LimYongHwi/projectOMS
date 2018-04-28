package Controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import Service.Service_Center_Service;
import VO.FAQVO;
import VO.MemberVO;
import VO.Service_CenterVO;

@Controller
public class Service_Center_Controller {
	
	@Autowired
	Service_Center_Service SCservice;
	
	@RequestMapping("service_writeForm.do")
	public String writeFormSerivce(Model model, HttpSession session){
		String id=(String)session.getAttribute("id");

		model.addAttribute("M_ID", id);
		return "Service_Center/Service_Center_WriteForm";
	}
	
	@RequestMapping("service_write.do")
	public String writeService(Service_CenterVO SC,@RequestParam("ufile")MultipartFile ufile){
		Date date = SC.getM_SVC_CREATE_DATE();
		SCservice.writeService(SC, ufile);
		System.out.println(date);
		return "redirect:service_center_main.do";
	}
	
	@RequestMapping("service_download.do")
	public View downloadService(Service_CenterVO SC){
		View view = new DownloadView(SCservice.getAttachFile(SC));
		return view;
	}

	@RequestMapping("service_center_main.do")
	public ModelAndView mainService(@RequestParam(defaultValue="1") int page,
			@RequestParam(required=false) String keyword,
			@RequestParam(defaultValue="0") int type,
			HttpSession session){
		
		ModelAndView mav = new ModelAndView();

		
		HashMap<String, Object> params = new HashMap<>();
		
//		if((Character) session.getAttribute("admin") == 'N'){
//		params.put("M_ID",(String) session.getAttribute("id"));}
		
		
		if(keyword == null || keyword.equals("")){
			type=0;
		}
		params.put("keyword", keyword);
		params.put("type", type);

		if(keyword != null || type != 0) {params.put("title", keyword); params.put("content", keyword);}
		
		HashMap<String, Object> result = (HashMap<String, Object>) SCservice.selectAllService(params,page);
		mav.addAllObjects(result);
		mav.setViewName("Service_Center/Service_Center_Main");
		return mav;
	}
	
	@RequestMapping("service_modifyForm.do")
	public void modifyFormService(Model model, int num,
			@RequestParam(defaultValue="1") int page,
			@RequestParam(required=false) String keyword,
			@RequestParam(defaultValue="0") int type,
			HttpSession session){
		
//		model.addAttribute("Service_Center", SCservice.selectAllService(params, page));
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		model.addAttribute("type", type);
		
	}
	
	@RequestMapping("service_modify.do")
	public String modifyService(HttpSession session, Service_CenterVO SC,
			@RequestParam(defaultValue="1") int page,
			@RequestParam(required=false) String keyword,
			@RequestParam(defaultValue="0") int type){
		
		
		session.getAttribute("id");

		SCservice.updateService(SC);
		return "redirect:view.do?num="+SC.getM_SVC_NO()+"&page="+page+"&keyword="+keyword+"&type="+type;
		
	}
	
	@RequestMapping("service_view.do")
	public ModelAndView viewService(@RequestParam(defaultValue="1") int page,
			@RequestParam(required=false) String keyword,
			@RequestParam(defaultValue="0") int type,
			HttpSession session){
		
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> params = new HashMap<>();
		
//		if((Character) session.getAttribute("admin") == 'N'){
//		params.put("M_ID",(String) session.getAttribute("id"));}
		
		if(keyword == null || keyword.equals("")){
			type=0;
		}
		params.put("keyword", keyword);
		params.put("type", type);

		if(keyword != null || type != 0) {params.put("title", keyword); params.put("content", keyword);}
		
		HashMap<String, Object> result = (HashMap<String, Object>) SCservice.selectAllService(params,page);
		mav.addAllObjects(result);
		mav.setViewName("Service_Center/Service_Center_View");
		return mav;
	}
	
	@RequestMapping("faq_main.do")
	public String mainFAQ(){
		return "FAQ/FAQ_Main";
	}
	
	@RequestMapping("faq_writeForm.do")
	public String writeFormFAQ(Model model, HttpSession session){

		String id =(String)session.getAttribute("id");
		model.addAttribute("M_ID", id);

		return "FAQ/FAQ_Write";		
	}
	
	@RequestMapping("faq_write.do")
	public String writeFAQ(FAQVO faq){
		System.out.println("들어옴???");
		SCservice.writeFAQ(faq);
		return "redirect:faq_main.do";
		
	}
	
	@RequestMapping("faq_view.do")
	public ModelAndView viewFAQ(@RequestParam(defaultValue="1") int page,
			@RequestParam(required=false) String keyword,
			@RequestParam(defaultValue="0") int type,
			HttpSession session){
		
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> params = new HashMap<>();
		
//		if((Character) session.getAttribute("admin") == 'N'){
//		params.put("M_ID",(String) session.getAttribute("id"));}
		
		if(keyword == null || keyword.equals("")){
			type=0;
		}
		params.put("keyword", keyword);
		params.put("type", type);

		if(keyword != null || type != 0) {params.put("title", keyword); params.put("content", keyword);}
		
		HashMap<String, Object> result = (HashMap<String, Object>) SCservice.getFAQList(params,page);
		mav.addAllObjects(result);
		mav.setViewName("FAQ/FAQ_View");
		return mav;
	}
	
	
	@RequestMapping(value="getFAQList.do", method=RequestMethod.GET)
	@ResponseBody
	public void getFAQList(
			@RequestParam(defaultValue="1") int page,
			int tab_no,
			HttpServletResponse resp)
	{
	System.out.println(tab_no+"탭번호");
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("FAQ_TAB",tab_no);
		JSONObject json = new JSONObject();
		System.out.println("결과"+SCservice.getFAQList(params, page).toString());
		json.append("result", SCservice.getFAQList(params, page));
		try {
			resp.getWriter().println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
