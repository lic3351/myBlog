package cn.lic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.lic.model.Article;
import cn.lic.model.User;
import cn.lic.service.ArticleService;
import cn.lic.service.UserService;

@Controller
public class UserContorller {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService articleService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/list")
	public String list(ModelMap map){
		map.addAttribute("list",userService.getAll());
//		System.out.println(userService.getAll());
		return "list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		userService.deleteById(id);
		//ע�� redirect:/list.do �˴��������'/' �� ���ص��� /delete/list.do 
		return "redirect:/list";
	}
	
	@RequestMapping("/add")
	public String add(User user){
		userService.insertOne(user);
		return "redirect:list";
	}
	
	@RequestMapping("/update")
	public String update(User user){
		userService.update(user);
		return "redirect:list";
		
	}
	@RequestMapping("/redirect")
	public void redirect(HttpServletResponse response) throws IOException{
		response.sendRedirect("http://oec2003.cnblogs.com");
	} 
	@RequestMapping("/main")
	public String main(HttpSession session ,ModelMap map){
		User user=(User) session.getAttribute("user");
//		if(null==user)
//			return "forward:/jsp/login.jsp";
		List<Article> list=articleService.searchByUid(user.getId());
		map.addAttribute("articles", list);
		return "forward:/jsp/main.jsp";
	}
}
