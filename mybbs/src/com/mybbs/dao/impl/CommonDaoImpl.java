package com.mybbs.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mybbs.dao.CommonDao;

import util.DButil;

/**
 * 通用DAO层 包含增删改查功能
 * 
 * @author leiyuan
 *
 * @param <T>
 */
public class CommonDaoImpl<T> implements CommonDao<T> {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	/**
	 * 获取数据库连接
	 */
	public CommonDaoImpl() {
		try {
			connection = DButil.getInstance().getConnetion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 新增或修改操作
	 */
	@Override
	public void saveOrUpdate(T common, String sql) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement(sql);
			Class<?> clazz = Class.forName(common.getClass().getName());
			Field[] fields = clazz.getDeclaredFields();// 根据Class对象获得属性 私有的也可以获得
			int size = fields.length;
			int i = 1;
			for (Field f : fields) {
				f.setAccessible(true);
				String typeName = f.getType().getSimpleName();
				String name = f.getName();
				if ("id".equals(name)) {
					int id = (int) f.get(common);
					if (id != 0) {
						preparedStatement.setInt(size, id);
					}
					continue;
				} else {
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

	/**
	 * 删除方法
	 */
	public void delete(int id, String sql) {
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据id获取详细信息
	 */
	public T getById(T common, String firstSql, String secondSql) {
		try {
			Class<?> clazz = Class.forName(common.getClass().getName());
			Field[] fields = clazz.getDeclaredFields();// 根据Class对象获得属性 私有的也可以获得
			preparedStatement = connection.prepareStatement(firstSql + common.getClass().getSimpleName() + secondSql);
			int id = 0;
			for (Field f : fields) {
				f.setAccessible(true);
				String name = f.getName();
				if ("id".equals(name)) {
					id = (int) f.get(common);
					break;
				}
			}
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				for (Field f : fields) {
					f.setAccessible(true);
					String typeName = f.getType().getSimpleName();
					String name = f.getName();
					if ("String".equals(typeName)) {
						f.set(common, resultSet.getString(name));
					} else if ("int".equals(typeName)) {
						f.set(common, resultSet.getInt(name));
					} else if ("long".equals(typeName)) {
						f.set(common, resultSet.getLong(name));
					}
				}
			}
		} catch (SQLException | ClassNotFoundException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return common;
	}

	/**
	 * 获取所有列表 pages为所要展示第几页
	 */
	@Override
	public List<T> getAllList(T common, String firstSql, String secondSql, int pages) {
		// TODO Auto-generated method stub
		List<T> result = new ArrayList<T>();
		try {
			Class<?> clazz = Class.forName(common.getClass().getName());
			Field[] fields = clazz.getDeclaredFields();// 根据Class对象获得属性 私有的也可以获得
			preparedStatement = connection.prepareStatement(firstSql + common.getClass().getSimpleName() + secondSql);
			preparedStatement.setInt(1, (pages - 1) * 20);
			resultSet = preparedStatement.executeQuery();
			@SuppressWarnings("unchecked")
			Class<T> cl = (Class<T>) common.getClass();
			while (resultSet.next()) {
				common = cl.newInstance();
				for (Field f : fields) {
					f.setAccessible(true);
					String typeName = f.getType().getSimpleName();
					String name = f.getName();
					if ("String".equals(typeName)) {
						f.set(common, resultSet.getString(name));
					} else if ("int".equals(typeName)) {
						f.set(common, resultSet.getInt(name));
					} else if ("long".equals(typeName)) {
						f.set(common, resultSet.getLong(name));
					}
				}

				result.add(common);
			}
		} catch (SQLException | ClassNotFoundException | IllegalArgumentException | IllegalAccessException
				| InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 关闭通道
	 */
	public void closeDB() {
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

	/**
	 * 统计总数
	 */
	@Override
	public int count(String firstSql, T common) {
		int allNum = 0;
		try {
			preparedStatement = connection.prepareStatement(firstSql + common.getClass().getSimpleName());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				allNum = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return allNum;
	}

}
