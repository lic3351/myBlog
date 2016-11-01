package cn.lic.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.lic.model.User;

public class LoginInterceptor implements HandlerInterceptor {
	
	private List<String> passList;
	public void setPassList(List<String> passList) {
		this.passList = passList;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
//		System.out.println("--------------interceptor");
		User user=(User) request.getSession().getAttribute("user");
		if(user!=null)
			return true;
		
		String url=request.getRequestURL().toString();
//		System.out.println(url);
		for(String temp:passList){
			if(url.endsWith(temp))
				return true;
		}
		

		response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
		return false;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}
	

}
