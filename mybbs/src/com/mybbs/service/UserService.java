package com.mybbs.service;

import com.mybbs.po.User;

public interface UserService {

	int countEmail(String email);

	User getUserByEmail(String email);

	void closeDB();
}
