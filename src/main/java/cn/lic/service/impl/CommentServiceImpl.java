package cn.lic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lic.dao.ArticleDao;
import cn.lic.model.Comment;


@Service("commentService")
public class CommentServiceImpl implements cn.lic.service.CommentService {

	@Autowired
	private ArticleDao articleDao;
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	@Override
	public List<Comment> searchByAid(int id) {
		return null;
	}

	@Override
	public void write(Comment comment) {
		articleDao.addComment(comment);
	}

	@Override
	public void delete(int id) {
		articleDao.deleteCommnet(id);
	}

}
