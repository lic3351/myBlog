package cn.lic.dao;

import java.util.List;

import cn.lic.model.Article;
import cn.lic.model.Comment;

public interface ArticleDao {
	
	Article selectByAid(int id);
	List<Article> selectByUid(int id);
	
	void add(Article article);
	void update(Article article);
	void delete(int id);
	void addLike(int id);
	int getLike(int id);
	void addComment(Comment comment);
	void deleteCommnet(int id);
}
