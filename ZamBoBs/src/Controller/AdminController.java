package Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@RequestMapping("login")
	public String login(){
		return "Login";
	}
	
	
	@RequestMapping("adminLogin.do")
	public ModelAndView adminLogin(String id, String password, HttpSession session){
		ModelAndView mav = new ModelAndView();
		try{
		if(session.getAttribute("admin").equals("Y")){
			mav.setViewName("redirect:main.do");
			return mav;
		}
		}catch(NullPointerException e){
			
		}
			if(id.equals("zambobs")){
			if(password.equals("41106")){
				session.setAttribute("admin", "Y");
				mav.setViewName("redirect:main.do");
				return mav;
			}	
			else{
				mav.addObject("msg","<p style='color:red'>패스워드가 다릅니다</p>");
			}
		}else{
			mav.addObject("msg", "<p style='color:red'>아이디가 다릅니다</p>");
		}
		mav.setViewName("Login");
		return mav;
	}
}
