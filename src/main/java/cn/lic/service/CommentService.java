package cn.lic.service;

import java.util.List;

import cn.lic.model.Comment;

public interface CommentService {
	List<Comment> searchByAid(int id);
	
	void write(Comment coment);
	
	void delete(int id);
	
}
