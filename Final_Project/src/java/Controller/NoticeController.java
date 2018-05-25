package Controller;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import Service.Event_Service;
import Service.Notice_Service;
import VO.EventVO;
import VO.NoticeVO;
import VO.RecruitVO;

@Controller
public class NoticeController {
	@Autowired
	Notice_Service nService;

	@RequestMapping("notice_main.do")
	public ModelAndView noticeMain(@RequestParam(defaultValue = "0") int type,
			@RequestParam(required = false) String keyword,
			@RequestParam(required = false) Date startdate,
			@RequestParam(required = false) Date enddate,
			@RequestParam(defaultValue = "1") int page,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("type", type);
		if (type == 1 || type == 3) {
			params.put("TITLE", keyword);
		}
		if (type == 2 || type == 3) {
			params.put("CONTENT", keyword);
		}
		if (startdate != null && enddate != null) {
			params.put("startdate", startdate);
			params.put("enddate", enddate);
		}
		try {
			char admin = (char) session.getAttribute("admin");
			params.put("admin", admin);
		} catch (Exception e) {
			char admin = 'N';
			params.put("admin", admin);
		}
		
		mav.addObject("notice", nService.getNoticeList(params,page));
		mav.addObject("current",page);
		mav.addObject(nService.paging(params,page));
		mav.setViewName("Notice/Notice_Main");
		return mav;
	}
	
	@RequestMapping("notice_writeForm.do")
	public String notice_writeForm(){
		return "Notice/Notice_WriteForm";
	}
	@RequestMapping("notice_write.do")
	public String noticeWrite(NoticeVO notice, @RequestParam("ufile") MultipartFile ufile) {
		int num = nService.noticeWrite(notice, ufile);
		return "redirect:notice_view.do?NOTICE_NO=" + num;
	}
	
	@RequestMapping("notice_view.do")
	public ModelAndView noticeView(NoticeVO notice,HttpSession session){
		ModelAndView mav = new ModelAndView();
		char admin = 'N';
		try {
			admin = (char) session.getAttribute("admin");
		} catch (Exception e) {
			admin = 'N';
		}
		mav.addObject("admin",admin);
		mav.addObject("notice",nService.getOneNotice(notice));
		mav.setViewName("Notice/Notice_View");
		return mav;
	}
	
	@RequestMapping("notice_updateForm.do")
	public ModelAndView noticeUpdateForm(NoticeVO notice){
		ModelAndView mav = new ModelAndView();
		mav.addObject("notice",nService.getOneNotice(notice));
		mav.setViewName("Notice/Notice_UpdateForm");
		return mav;
	}
	
	@RequestMapping("notice_update.do")
	public String noticeUpdate(NoticeVO notice,@RequestParam(required=false)MultipartFile ufile){
		int num =nService.updateNotice(notice, ufile);
		return "redirect:notice_view.do?NOTICE_NO="+num;
	}
	
	
	@RequestMapping("notice_delete.do")
	public String noticeDelete(NoticeVO notice){
		nService.deleteNotice(notice);
		return "redirect:notice_main.do";
	}

}
