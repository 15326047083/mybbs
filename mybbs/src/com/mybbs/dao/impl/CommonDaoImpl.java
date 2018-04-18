package com.mybbs.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mybbs.dao.CommonDao;

import util.DButil;

public class CommonDaoImpl<T> implements CommonDao<T> {

	private Connection connection = null;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public CommonDaoImpl() {
		try {
			connection = DButil.getInstance().getConnetion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void newCommon(T common, String sql) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement(sql);
			Class<?> clazz = Class.forName(common.getClass().getName());
			Field[] fields = clazz.getDeclaredFields();// 根据Class对象获得属性 私有的也可以获得
			System.out.println(fields.length);
			int i = 1;
			for (Field f : fields) {
				f.setAccessible(true);
				String typeName = f.getType().getSimpleName();
				String name = f.getName();
				if ("id".equals(name))
					continue;
				else {
					System.out.println(f.get(common));
					if ("String".equals(typeName)) {
						preparedStatement.setString(i, (String) f.get(common));
					} else if ("int".equals(typeName)) {
						preparedStatement.setInt(i, (Integer) f.get(common));
					} else if ("long".equals(typeName)) {
						preparedStatement.setLong(i, (Long) f.get(common));
					}
					i++;
				}
			}
			preparedStatement.execute();
		} catch (ClassNotFoundException | SQLException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateCommon(T common, String sql) {
		// TODO Auto-generated method stub

	}

}
