package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import Service.Member_Service;
import Service.PhotoService;
import VO.MemberVO;
import VO.PhotoVO;
import Controller.DownloadView;

@Controller
public class MemberController {

	@Autowired
	private Member_Service memberSvc;
	
	@Autowired
	private PhotoService photoSvc;
	
	@Autowired
	private JavaMailSender mailSender;
		
	//회원가입페이지 요청
	@RequestMapping("joinform.do")
	public String showJoinForm(){
		return "Member/joinForm2";
	}
	
	//아이디 중복 검사 페이지 요청 
	@RequestMapping("idChkForm.do")
	public String duplChkForm(){
		return "Member/Id_chk";
	}
	
	//로그인 페이지 요청
	@RequestMapping("loginform.do")
	public String showLoinForm() {
		return "Member/LoginForm";
	}
	
	//아이디/비밀번호 찾기 페이지 요청
	@RequestMapping("searchMyInfo.do")
	public String showSearMyinfo() {
		return "Member/SearchMyInfo";
	}
	
	//회원 가입 요청
	@RequestMapping("join.do")
	public String joinMember(MemberVO member,@RequestParam("ufile") MultipartFile ufile){
		System.out.println("join.do임"+member.toString());
		if(member.getM_PRIVATE()=='\0'){
			member.setM_PRIVATE('N');
		}
		 memberSvc.join(member,ufile);
		return "redirect:main.do";
	};
	
	
	//중복체크
	@RequestMapping(value="duplChk.do", method=RequestMethod.GET)
	@ResponseBody 
	public void dupl(String m_id,HttpServletResponse resp){
		String msg="";
		String flag="";
		MemberVO mv = new MemberVO(m_id);
		JSONObject obj = new JSONObject();
		resp.setCharacterEncoding("UTF-8");
			
				if(memberSvc.selectOneMember(mv)==null){
					msg= "사용 가능한 아이디 입니다.";
					flag="true";
				}else {
					msg="이미 존재하는 아이디입니다.";
					flag="false";
				}
				
				obj.append("msg",msg);
				obj.append("flag",flag);
				try {
					
					resp.getWriter().print(obj);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	//프로필 뷰 요청
		@RequestMapping("m_Info.do")
		public ModelAndView showMinfo(MemberVO member){
			System.out.println(member.toString());
			ModelAndView mav = new ModelAndView();
			MemberVO mv = memberSvc.selectOneMember(member);
			mav.addObject("mv", mv);
			mav.setViewName("Member/M_info");
			return mav;
		}
	
	
	//업데이트폼 요청
		@RequestMapping(value="updateForm.do")
		public ModelAndView showMyPage(HttpSession session){
			ModelAndView mav = new ModelAndView();
			String id=(String)session.getAttribute("id");
			MemberVO mv = new MemberVO(id);
			mv = memberSvc.selectOneMember(mv);
			List<String> contact = new ArrayList();
			List<String> email = new ArrayList();
			
			StringTokenizer st = new StringTokenizer(mv.getM_PHONE(), ",");
			while(st.hasMoreElements()) {
				contact.add(st.nextToken());
			}
			
			st = new StringTokenizer(mv.getM_EMAIL(),",");
			while(st.hasMoreElements()) {
				email.add(st.nextToken());
			}
			
			System.out.println(mv.toString());
			mav.addObject("mv",mv);
			mav.addObject("m_gender", mv.getM_GENDER());
			mav.addObject("phone1",contact.get(0));
			mav.addObject("phone2",contact.get(1));
			mav.addObject("phone3", contact.get(2));
			mav.addObject("email1", email.get(0));
			mav.addObject("email2", email.get(1));
			mav.setViewName("Member/MemberUpdateForm");
			return mav;
		}
	
    //로그인 처리
	@RequestMapping("login.do") //2: 아이디 없음 1:정상 3:비번틀림
	public ModelAndView tryLogin(HttpSession session,String m_id,String m_password) {
		ModelAndView mav = new ModelAndView();
		MemberVO mv=new MemberVO(m_id,m_password);
		int result = memberSvc.checkPw(mv);
		switch(result){
		case 1:{
			session.setAttribute("id", m_id);
			mav.addObject("flag", "1");
			break;
		}
		case 2:{
			mav.addObject("msg", "존재하지 않는 아이디 입니다.");
			mav.addObject("flag", "2");
			break;
		}
		case 3:{
			mav.addObject("msg", "비밀번호가 일치하지 않습니다.");
			mav.addObject("flag", "3");
			break;
		}}
		mav.setViewName("Member/LoginForm");			
		return mav;
	}
	
	@RequestMapping("logout.do")
	public String tryLogout(HttpSession session,String id) {
		session.removeAttribute("id");
		return "redirect:main.do";
	}
	
	//정보 수정
	@RequestMapping("update.do")
	public ModelAndView updateMemberInfo(MemberVO member,@RequestParam("ufile") MultipartFile ufile) {
		ModelAndView mav = new ModelAndView();
		memberSvc.updateMember(member,ufile);
		mav.setViewName("redirect:main.do");
		return mav;
	}
	
	
	@RequestMapping("profileDownload.do")
	public View download(MemberVO member)
	{
		View view = new DownloadView(memberSvc.getAttachFile(member));
		return view;
		
	}
	
	//마이페이지
	@RequestMapping("my.do")
	public ModelAndView showMymain(HttpSession session) {
		String m_id = (String)session.getAttribute("id");
		System.out.println(m_id);
		ModelAndView mav = new ModelAndView(m_id);
		mav.addObject("M_ID", m_id);
		mav.setViewName("Member/MyPage");
		return mav;
	}
	
	
	@RequestMapping("myAlbum.do")
	public ModelAndView showAlbum(HttpSession session,String m_id) {
		System.out.println("마이앨범컨트롤러들어옴");
		ModelAndView mav = new ModelAndView();
		System.out.println(m_id);
		PhotoVO ph = new PhotoVO(m_id);
		mav.addObject("photoList", photoSvc.getMemberPhotos(ph));
		mav.setViewName("Member/MyAlbumView");
		return mav;
	}
	
	@RequestMapping("sendPw.do")
	public void sendMail(String M_ID,String M_PHONE,String mAddress,String from, String to,
						 String subject, String text, String formUrl)
					     throws FileNotFoundException,URISyntaxException {
		 String mailText="";
		if(M_ID !="" && M_PHONE=="") {
		System.out.println("아이디인거니"+M_ID);
		MemberVO mv = new MemberVO(M_ID);
		  mv = memberSvc.selectOneMember(mv);
		  String password = mv.getM_PASSWORD();
		  mailText= "회원님의 비밀번호는" + password + "입니다.";
		  System.out.println(password);
		  System.out.println(mAddress);
		}
		else if(M_ID ==null && M_PHONE!="") {
			MemberVO mv = new MemberVO();
			mv.setM_PHONE(M_PHONE);
			ArrayList<MemberVO> list = new ArrayList();
			list.addAll(memberSvc.selectSearchMember(mv));
			System.out.println(list.get(0));
			mv = list.get(0);
			String memberId = mv.getM_ID();
			 mailText= "회원님의 아이디는" + memberId + "입니다.";
;			 System.out.println(memberId);
			  System.out.println(mAddress);
		}
		  try {
		      MimeMessage message = mailSender.createMimeMessage();
		      MimeMessageHelper messageHelper 
		                        = new MimeMessageHelper(message, true, "UTF-8");
		      messageHelper.setFrom("chonami89@gmail.com");  
		      messageHelper.setTo(mAddress);  
		      messageHelper.setSubject("오마쏘로 요청하신  정보 입니다."); 
		      messageHelper.setText(mailText); 
		      mailSender.send(message);
		    } catch(Exception e){
		      System.out.println(e);
		    }
		}
	
	
	@RequestMapping("jusoPopup.do")
	 public String jusoPopup(){
        return "Member/jusoPopup";
    }
	
	
//	@RequestMapping("myActivity.do")
//	public ModelAndView showMyboard(HttpSession session) {
//		ModelAndView mav = new ModelAndView();
//		String m_id= (String)session.getAttribute("M_ID");
//		MemberVO member = new MemberVO(m_id);
//		memberSvc
//		mav.addObject("keyword", (String)session.getAttribute("M_ID"));
//		System.out.println((String)session.getAttribute("M_ID"));
//		
//		mav.setViewName("Member/MyActivity");
//		return mav;
//	}
}

	
