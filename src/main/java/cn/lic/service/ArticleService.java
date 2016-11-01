package cn.lic.service;

import java.util.List;

import cn.lic.model.Article;

public interface ArticleService {
	Article searchById(int id);
	List<Article> searchByUid(int id);
	void write(Article a);
	void modify(Article a);
	void delete(int id);
	int addlike(int id);
}
