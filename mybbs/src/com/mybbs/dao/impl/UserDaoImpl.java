package com.mybbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mybbs.dao.UserDao;

import util.DButil;

public class UserDaoImpl implements UserDao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	/**
	 * 获取数据库连接
	 */
	public UserDaoImpl() {
		try {
			connection = DButil.getInstance().getConnetion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int countEmail(String email) {
		// TODO Auto-generated method stubtry {
		int num = 0;
		try {
			preparedStatement = connection.prepareStatement("select count(*) from user where email='" + email + "'");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				num = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public void closeDB() {
		// TODO Auto-generated method stub
		try {
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
