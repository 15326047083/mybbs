package com.mybbs.dao;

public interface UserDao {
	int countEmail(String email);
	void closeDB();
}
