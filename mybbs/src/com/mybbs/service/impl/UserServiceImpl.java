package com.mybbs.service.impl;

import com.mybbs.dao.UserDao;
import com.mybbs.dao.impl.UserDaoImpl;
import com.mybbs.po.User;
import com.mybbs.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
		userDao = new UserDaoImpl();
	}

	@Override
	public int countEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.countEmail(email);
	}

	@Override
	public void closeDB() {
		// TODO Auto-generated method stub
		userDao.closeDB();
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.getUserByEmail(email);
	}

}
