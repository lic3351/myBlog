package cn.lic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lic.dao.UserDao;
import cn.lic.model.User;
import cn.lic.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public void deleteById(int id) {
		userDao.deleteById(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);	
	}

	@Override
	public void insertOne(User user) {
		userDao.insertOne(user);
	}

	@Override
	public void insertList(List<User> list) {
		// TODO Auto-generated method stub
		
	}

}
