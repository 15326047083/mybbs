package com.mybbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.mybbs.dao.PostDao;
import com.mybbs.dao.impl.PostDaoImpl;
import com.mybbs.service.PostService;
import com.mybbs.vo.vUserAndPost;

public class PostServiceImpl implements PostService {
	PostDao postDao=new PostDaoImpl();
	@Override
	public List<vUserAndPost> getSerachPostList(String str) {
		List<vUserAndPost> list = new ArrayList<vUserAndPost>();
		list=postDao.getSerachPostList(str);
		return list;
	}

	@Override
	public void closeDB() {
		// TODO Auto-generated method stub

	}

}
