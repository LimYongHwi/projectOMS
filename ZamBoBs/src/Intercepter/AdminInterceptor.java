package Intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
//		return super.preHandle(request, response, handler);
		HttpSession session = request.getSession();
		try{
		char admin = (char) session.getAttribute("admin");
		if(admin=='N')
		{
			response.sendRedirect("error.do");
			return false;
		}
		return true;
		}
		catch(NullPointerException e){
			response.sendRedirect("error.do");
			return false;
		}
		
	}
	
	
}