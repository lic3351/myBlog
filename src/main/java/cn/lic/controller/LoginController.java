package cn.lic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lic.model.User;
import cn.lic.service.UserService;
import cn.lic.vo.UserVO;


@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/user")
	public String userLogin(UserVO userVO,HttpSession session) throws Exception{
		if("lic".equals(userVO.getName())&&"123".equals(userVO.getPasswd())){
			User user=userService.getById(1);
			session.setAttribute("user", user);
			return "redirect:/main.do";
		}
		return "redirect:/jsp/login.jsp";
	}
}
