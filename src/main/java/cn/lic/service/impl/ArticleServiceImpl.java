package cn.lic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lic.dao.ArticleDao;
import cn.lic.model.Article;
import cn.lic.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;
	@Autowired
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public Article searchById(int id) {
		return articleDao.selectByAid(id);
	}

	@Override
	public List<Article> searchByUid(int id) {
		return articleDao.selectByUid(id);
	}

	@Override
	public void write(Article a) {
		articleDao.add(a);
	}

	@Override
	public void modify(Article a) {
		articleDao.update(a);
	}

	@Override
	public void delete(int id) {
		articleDao.delete(id);
	}

	@Override
	public int addlike(int id) {
		articleDao.addLike(id);
		return articleDao.getLike(id);
	}

}
