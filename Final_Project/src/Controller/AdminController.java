package Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

	@RequestMapping("Alogin.do")
	public String Alogin(String id, HttpSession session){
		session.setAttribute("id", id);
		return "redirect:main.do";
	}
	@RequestMapping("AloginForm.do")
	public String AloginForm(){
		return "Alogin";
	}
	
	
	
}
