package cn.lic.service;

import java.util.List;

import cn.lic.model.User;

public interface Social {
	void follow(User me, User other);
	void disfollow(User me,User other);
	
	List<User> searchFensi(User me);
	List<User> searchLike(User me);
	
	int searchFensi_c(User me);
	int searchLike_c(User me);
}
