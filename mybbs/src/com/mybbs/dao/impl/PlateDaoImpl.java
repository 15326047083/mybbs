package com.mybbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mybbs.dao.PlateDao;
import com.mybbs.vo.vUserAndPlate;


import util.DButil;

public class PlateDaoImpl implements PlateDao{

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	/**
	 * 获取数据库连接
	 */
	public PlateDaoImpl() {
		try {
			connection = DButil.getInstance().getConnetion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	 * 查找全部列表 以及版主信息
	 */
	@Override
	public List<vUserAndPlate> getAllList() {
		List<vUserAndPlate> list =new ArrayList<vUserAndPlate>();
		try {
			preparedStatement=connection.prepareStatement("select user.id uid ,user.name uname,email,plate.id pid,plate.name pname,info,postnum,areaid from user,plate where user.id=plate.id");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				vUserAndPlate ueUserAndPlate = new vUserAndPlate();
				ueUserAndPlate.setUserId(resultSet.getInt("uid"));
				ueUserAndPlate.setPlateId(resultSet.getInt("pid"));
				ueUserAndPlate.setAreaId(resultSet.getInt("areaid"));
				ueUserAndPlate.setPostNum(resultSet.getInt("postnum"));
				ueUserAndPlate.setUserName(resultSet.getString("uname"));
				ueUserAndPlate.setPlateName(resultSet.getString("pname"));
				ueUserAndPlate.setEmail(resultSet.getString("email"));
				ueUserAndPlate.setInfo(resultSet.getString("info"));
				list.add(ueUserAndPlate);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
