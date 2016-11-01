package cn.lic.dao;

import java.util.List;

import cn.lic.model.User;

public interface UserDao {

	List<User> getAll();
	User getById(int id);
	void deleteById(int id);
	void update(User user);
	void insertOne(User user);
	void insertList(List<User> list);
}
