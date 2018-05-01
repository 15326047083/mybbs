package com.mybbs.dao;

import java.util.List;

import com.mybbs.vo.vUserAndPost;

public interface PostDao {
	public List<vUserAndPost> getSerachPostList(String str);

	public void closeDB();
}
