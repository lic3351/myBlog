package cn.lic.service;

import java.util.List;

import cn.lic.model.User;

public interface UserService {
	List<User> getAll();
	User getById(int id);
	void deleteById(int id);
	void update(User user);
	void insertOne(User user);
	void insertList(List<User> list);
}
