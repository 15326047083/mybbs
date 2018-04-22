package com.mybbs.dao;

import com.mybbs.po.User;

public interface UserDao {
	int countEmail(String email);

	User getUserByEmail(String email);

	void closeDB();
}
