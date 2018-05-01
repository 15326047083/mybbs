package com.mybbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mybbs.dao.PostDao;
import com.mybbs.vo.vUserAndPost;

import util.DButil;

public class PostDaoImpl implements PostDao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	/**
	 * 获取数据库连接
	 */
	public PostDaoImpl() {
		try {
			connection = DButil.getInstance().getConnetion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<vUserAndPost> getSerachPostList(String str) {
		List<vUserAndPost> list = new ArrayList<vUserAndPost>();
		String sql = "select post.id id,post.userId userId,user.name userName,post.plateId plateId,post.flag flag,plate.name plateName,"
				+ "title,post.info info,post.time time,photoNum from user,post,plate where user.id=post.userId and plate.id=post.plateId"
				+ " and flag<>1 and (post.title like '%" + str + "%' or user.name like '%" + str + "%')";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				vUserAndPost userAndPost = new vUserAndPost();
				userAndPost.setFlag(resultSet.getInt("flag"));
				userAndPost.setId(resultSet.getInt("id"));
				userAndPost.setInfo(resultSet.getString("info"));
				userAndPost.setPhotoNum(resultSet.getInt("photoNum"));
				userAndPost.setPlateId(resultSet.getInt("plateId"));
				userAndPost.setPlateName(resultSet.getString("plateName"));
				userAndPost.setTime(resultSet.getString("time"));
				userAndPost.setTitle(resultSet.getString("title"));
				userAndPost.setUserId(resultSet.getInt("userId"));
				userAndPost.setUserName(resultSet.getString("userName"));
				list.add(userAndPost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
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
