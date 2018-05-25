package Controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import Service.Information_Service;
import VO.InformationVO;
@Controller
public class InfoController {
	@Autowired
	Information_Service infoService;
	////////////////여행정보게시판//////

	@RequestMapping("info_main.do")
	public ModelAndView info_Main(
			@RequestParam(defaultValue="0") int type, // 0일떄 >>전체검색, 1제목 2내용 3제목+내용4작성자
			@RequestParam(defaultValue="1") int page,
			@RequestParam(required=false) String keyword,
			@RequestParam(required=false) Date startdate,
			@RequestParam(required=false) Date enddate){
		ModelAndView mav = new ModelAndView();
		HashMap<String,Object> params=new HashMap<>();
		params.put("type", type);
		if(type==1||type==3){
			params.put("TITLE",keyword);
		}if(type==2||type==3){
			params.put("CONTENT",keyword);
		}
		if(type==4){
			params.put("M_ID",keyword);
		}
		
		if(startdate!=null&&enddate!=null){
			params.put("startdate", startdate);
			params.put("enddate", enddate);			
		}
		mav.addAllObjects(infoService.getInfomationList(params, page));
		mav.setViewName("Information/Information_Main");
		return mav;
	
	
	}
	@RequestMapping("info_writeForm.do")
	public ModelAndView info_WriteForm(HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Information/Information_WriteForm");
		mav.addObject("M_ID",session.getAttribute("id"));		
		//세션에 아이디 확인해서 분개해서 보내
		return mav;
	}

	@RequestMapping("info_write.do")
	public String info_Write(InformationVO InformationVO, @RequestParam(required=false) MultipartFile ufile){
		int num=infoService.writeInformation(InformationVO, ufile);
		return "redirect:info_view.do?num="+num;
	}

	@RequestMapping("info_view.do")
	public ModelAndView info_view(int num,HttpSession session){
		
		String id=null;
		try{
		id = (String)session.getAttribute("id");
		}catch(Exception e){}		
		ModelAndView mav = new ModelAndView();
		InformationVO info = new InformationVO(num);
		info = infoService.ReadCount(info,id);
		mav.addObject("INFO",info);
		try{
		if(info.getM_ID().equals(id))
			mav.addObject("ismine",true);
		else
			mav.addObject("ismine",false);
		}catch(Exception e){mav.addObject("ismine",false);}			
		mav.addObject("INFO",info);
		mav.setViewName("Information/Information_View");
		return mav;
	}
	@RequestMapping("info_updateForm.do")
	public ModelAndView info_UpdateForm(InformationVO informationVO){
		ModelAndView mav = new ModelAndView();
		mav.addObject("INFO",infoService.selectInformation(informationVO));	
		mav.setViewName("Information/Information_UpdateForm");
		return mav;
	}
	@RequestMapping("info_update.do")
	public String info_Update(InformationVO informationVO,
			@RequestParam("ufile")MultipartFile ufile){
		int num = infoService.updateInformation(informationVO,ufile);
		return "redirect:review_view.do?num="+num;
	}
	
	
	@RequestMapping(value="infoRCM.do", method=RequestMethod.GET)
	@ResponseBody
	public void infoRCM(
			int INFO_NO,
			int isRCM,
			HttpSession session,
			HttpServletResponse resp)
	{
		String id = (String)session.getAttribute("id");
		JSONObject json = new JSONObject();
		if(id!=null){
		HashMap<String, Object> params = new HashMap<>();
		char INFO_RCM='Y';
		if(isRCM==1){ //1이면비추
			INFO_RCM='N';
		}
		params.put("INFO_RCM", INFO_RCM);
		params.put("INFO_NO", INFO_NO);
		params.put("M_ID", id);
		json.append("result", infoService.recommendInfomation(params));
		}else{
			json.append("fail", true);
		}
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
