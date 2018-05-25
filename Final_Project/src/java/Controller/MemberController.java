package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.catalina.connector.Request;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import Service.DownloadView;
import Service.Member_Service;
import Service.PhotoService;
import VO.CommentVO;
import VO.MemberVO;
import VO.PhotoVO;

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
	public ModelAndView showLoinForm(@RequestParam(defaultValue="true")boolean ispop) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ispop",ispop);
		mav.setViewName("Member/LoginForm");
		return mav;
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
			@RequestMapping(value="updateForm.do",method = RequestMethod.POST)
			@ResponseBody 
			public void showMyPage(HttpSession session,HttpServletResponse resp){
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
					
					JSONObject obj = new JSONObject();
					resp.setCharacterEncoding("UTF-8");
					
					obj.append("id",mv.getM_ID());
					obj.append("name",mv.getM_NAME());
					obj.append("pwd",mv.getM_PASSWORD());
					obj.append("profile", mv.getM_PROFILE());
					obj.append("gender", mv.getM_GENDER());
					obj.append("age", mv.getM_AGE());
					obj.append("phone1",contact.get(0));
					obj.append("phone2",contact.get(1));
					obj.append("phone3",contact.get(2));
					obj.append("private", mv.getM_PRIVATE());
					obj.append("nation", mv.getM_NATION());
					obj.append("address", mv.getM_ADDRESS());
					obj.append("eId", email.get(0));
					obj.append("eAddress", email.get(1));
					
					try {
						
						resp.getWriter().print(obj);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					
				}
	
    //로그인 처리
	@RequestMapping("login.do") //2: 아이디 없음 1:정상 3:비번틀림
	public ModelAndView tryLogin(HttpSession session,String m_id,String m_password,HttpServletRequest req) {
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
		}
		case 4:{
			mav.addObject("flag","1");
			session.setAttribute("id", m_id);
			session.setAttribute("admin", 'Y');
			break;
		}
		}
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
		mav.setViewName("redirect:my.do");
		return mav;
	}
	
	
	@RequestMapping("profileDownload.do")
	public View download(MemberVO member)
	{
		View view = new DownloadView(memberSvc.getAttachFile(member));
		return view;
	}
	
	@RequestMapping("photodownload.do")
	public View phtDownload(PhotoVO photo) {
		System.out.println("컨트롤러 : " +photo);
		View view = new DownloadView(photoSvc.getAttachFiles(photo));
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
	
	//마이 앨범
	@RequestMapping(value="myAlbum.do",method=RequestMethod.GET) 
	public ModelAndView showAlbum(String id,String s_id,HttpSession session,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(required = false) String startDate,
			@RequestParam(required = false) String endDate) {
		
		String  m_id = (String)session.getAttribute("id");
		ModelAndView mav = new ModelAndView();
		PhotoVO ph = new PhotoVO(m_id);
		MemberVO mv = new MemberVO(m_id);
		mv = memberSvc.selectOneMember(mv);
		int rank = mv.getM_RANK(); 
		
		switch(rank) {
		case 0:
			mav.addObject("rank", "TEST");
			break;
		case 1:
			mav.addObject("rank", "BRONZE");
			break;
		case 2:
			mav.addObject("rank", "SILVER");
			break;
		case 3:
			mav.addObject("rank", "DIAMOND");
			break;
		}
		
		mav.addObject("m_id",mv.getM_ID());
		mav.addAllObjects(photoSvc.getMemberPhotos(ph,page));
		mav.setViewName("Member/MyAlbumView");
		return mav;
	}
	
	//사진 상세 뷰 요청
	@RequestMapping("inDetail.do")
	public ModelAndView showDetail(int photo_no,HttpSession session) {
		String  m_id = (String)session.getAttribute("id");
		ModelAndView mav = new ModelAndView();
		
		MemberVO mv = new MemberVO(m_id); 
		PhotoVO photo = new PhotoVO(photo_no);
		photo =  photoSvc.getPhoto(photo);
		System.out.println("여기는 컨트롤러. 포토의 M_ID :   " + photo.getM_ID());
		
		ArrayList<CommentVO> list= new ArrayList<>();
		list = photoSvc.selectComments(photo);
		
		for(int i=0 ; i< list.size();i++) {
			System.out.println("★★댓글리스트:   "+ list.get(i).toString());
		}
		
		
		mav.addObject("CommentList", photoSvc.selectComments(photo));
		mav.addObject("commentTotalCnt", photoSvc.CommentTotalCount(photo));
		mav.addObject("fl", photoSvc.getFirstandLast(photo));
		mav.addObject("id",mv.getM_ID());
		mav.addObject("p", photoSvc.getPhoto(photo));
		mav.setViewName("Member/Photo_View");
		return mav;
	}
	
	//댓글 등록
	 @RequestMapping(value="commt_write.do", method=RequestMethod.POST)
	 public void writeComment(@RequestParam("COMMT_CONTENT")String commt_content,
			 				  @RequestParam("id")String id,
			 				  @RequestParam("PHOTO_NO")int photo_no,
			 				  @RequestParam("COMMT_PARENT")int parent,
			 				  HttpSession session,HttpServletResponse resp)throws Exception {
		 
		 System.out.println(commt_content + " " + id + " "+ photo_no+ " " + parent);
		 CommentVO commt = new CommentVO(commt_content,id,photo_no,parent);
		 Calendar calendar = Calendar.getInstance();
         java.util.Date date = calendar.getTime();
         String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));

         commt.setPHT_COMMT_CREATE_DATE(today);
         
		 photoSvc.insertComment(commt);
		 JSONObject obj = new JSONObject();
		 resp.setCharacterEncoding("UTF-8");
		 
		 obj.append("content", commt.getCOMMT_CONTENT());
		 obj.append("id",commt.getM_ID());
		 obj.append("photo_no", commt.getPHOTO_NO());
		 obj.append("parent",commt.getCOMMT_PARENT());
		 obj.append("date", today);
		 
		 
		 try {
			 resp.getWriter().print(obj);
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}

	 }
	
	
	@RequestMapping("sendPw.do")
	public void sendMail(String M_ID,String M_PHONE,String mAddress,String from, String to,
						 String subject, String text, String formUrl)
					     throws FileNotFoundException,URISyntaxException {
		 String mailText="";
		if(M_ID !="" && M_PHONE=="") {
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


	@RequestMapping(value="uldMyPhoto.do",method = RequestMethod.POST)
	public String uploadMyPhoto(@RequestParam("PHOTO_TITLE") String pHOTO_TITLE ,@RequestParam("PHOTO_CONTENT")String pHOTO_CONTENT,
			MultipartHttpServletRequest mtfRequest
			,HttpSession session,HttpServletResponse resp
			)throws Exception {
		PhotoVO photo = new PhotoVO();
		
		String id=(String)session.getAttribute("id");
		photo.setM_ID(id);
		photo.setPHOTO_TITLE(pHOTO_TITLE);
		photo.setPHOTO_CONTENT(pHOTO_CONTENT);
		photo.setPHOTO_PRIVATE('n');
		System.out.println("내용" + "" +photo.getPHOTO_CONTENT());
		photoSvc.insertMemberPhoto(photo,mtfRequest);
		
		return "redirect:myAlbum.do";

	}

}


	
