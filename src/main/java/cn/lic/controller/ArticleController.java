package cn.lic.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lic.model.Article;
import cn.lic.model.Comment;
import cn.lic.model.User;
import cn.lic.service.ArticleService;
import cn.lic.service.CommentService;
import cn.lic.vo.CommentVO;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentService;
	public void setUserService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	@RequestMapping("/add")
	public String add(Article article,HttpSession session){
		User user=(User)session.getAttribute("user");
		article.setTime(new Date());
		article.setUser(user);
		articleService.write(article);
		return "redirect:/main.do";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
		articleService.delete(id);
		return "redirect:/main.do";
	}
	@RequestMapping("/like")
	@ResponseBody
	public int like(int id){
		return articleService.addlike(id);
	}
	
	@RequestMapping("/addcomment")
	@ResponseBody
	public CommentVO addcomment(int id,String content,HttpSession session){
		User user=(User)session.getAttribute("user");
		Comment comment=new Comment();
		comment.setC_time(new Date());
		comment.setContent(content);
		comment.setArticle_id(id);
		comment.setUser_id(user.getId());
		commentService.write(comment);
		
		CommentVO commentvo=new CommentVO();
		commentvo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		commentvo.setUser_id(user.getId());
		commentvo.setUser_name(user.getName());
		return commentvo;
	}
	
	
	
	
	
	
}
