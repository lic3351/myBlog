package cn.lic.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.lic.dao.UserDao;
import cn.lic.model.User;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<User> getAll() {
//		private offset;
//		private limit;
//		RowBounds rbs=new RowBounds(2, 2);
		return getSqlSession().selectList("cn.lic.mapper.userMapper.getAll");
	}

	@Override
	public User getById(int id) {
		return getSqlSession().selectOne("cn.lic.mapper.userMapper.getOne",id);
	}

	@Override
	public void deleteById(int id) {
		getSqlSession().delete("cn.lic.mapper.userMapper.delete", id);
	}

	@Override
	public void update(User user) {
		getSqlSession().update("cn.lic.mapper.userMapper.update",user);
	}

	@Override
	public void insertOne(User user) {
		getSqlSession().insert("cn.lic.mapper.userMapper.add",user);
	}

	@Override
	public void insertList(List<User> list) {
		
	}

}
