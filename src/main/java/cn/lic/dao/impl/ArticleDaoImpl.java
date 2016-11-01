package cn.lic.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.lic.dao.ArticleDao;
import cn.lic.model.Article;
import cn.lic.model.Comment;


@Repository("articleDao")
public class ArticleDaoImpl extends SqlSessionDaoSupport implements ArticleDao {
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public Article selectByAid(int id) {
		
		return getSqlSession().selectOne("cn.lic.mapper.articleMapper.selectByAid",id);
	}

	@Override
	public List<Article> selectByUid(int id) {
		return getSqlSession().selectList("cn.lic.mapper.articleMapper.selectByUid",id);
	}

	@Override
	public void add(Article article) {
		getSqlSession().insert("cn.lic.mapper.articleMapper.add", article);
	}

	@Override
	public void update(Article article) {
		getSqlSession().update("cn.lic.mapper.articleMapper.update", article);
	}

	@Override
	public void delete(int id) {
		getSqlSession().update("cn.lic.mapper.articleMapper.delete", id);
	}

	@Override
	public void addLike(int id) {
		getSqlSession().update("cn.lic.mapper.articleMapper.addlike",id);
	}

	@Override
	public int getLike(int id) {
		return getSqlSession().selectOne("cn.lic.mapper.articleMapper.getlike",id);
	}

	@Override
	public void addComment(Comment comment) {
		getSqlSession().insert("cn.lic.mapper.articleMapper.addcomment",comment);
	}

	@Override
	public void deleteCommnet(int  id) {
		getSqlSession().delete("cn.lic.mapper.articleMapper.delcommnet",id);
	}

}
