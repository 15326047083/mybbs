package com.mybbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mybbs.dao.ReplyDao;
import com.mybbs.vo.vDisscussAndReply;

import util.DButil;

public class ReplyDaoImpl implements ReplyDao {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	/**
	 * 获取数据库连接
	 */
	public ReplyDaoImpl() {
		try {
			connection = DButil.getInstance().getConnetion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	@Override
	public List<vDisscussAndReply> getAllList(int id) {
		// TODO Auto-generated method stub
		List<vDisscussAndReply> list=new ArrayList<vDisscussAndReply>();
		try {
			preparedStatement = connection.prepareStatement("select reply.id id,reply.userId userId,discussId,discuss.postId postId,user.name userName,reply.info info,reply.time time from discuss,reply,user where user.id=reply.userId and discuss.id=reply.discussId and postId=?");
			preparedStatement.setInt(1, id);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				vDisscussAndReply v=new vDisscussAndReply();
				v.setId(resultSet.getInt("id"));
				v.setDiscussId(resultSet.getInt("discussId"));
				v.setInfo(resultSet.getString("info"));
				v.setPostId(resultSet.getInt("postId"));
				v.setTime(resultSet.getString("time"));
				v.setUserId(resultSet.getInt("userId"));
				v.setUserName(resultSet.getString("userName"));
				list.add(v);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
