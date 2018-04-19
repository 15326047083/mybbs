package com.mybbs.dao;

import com.mybbs.po.User;

public interface UserDao {

	void newUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	void getUserById(int id);
	void fuck();
	int sas();
	void getAllUser();
}
