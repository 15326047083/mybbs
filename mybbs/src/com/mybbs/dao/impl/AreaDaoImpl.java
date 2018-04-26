package com.mybbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mybbs.dao.AreaDao;

import util.DButil;

public class AreaDaoImpl implements AreaDao {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * 获取数据库连接
	 */
	public AreaDaoImpl() {
		try {
			connection = DButil.getInstance().getConnetion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void lessPlateNum(int id) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("update area set plateNum=plateNum-1 where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
