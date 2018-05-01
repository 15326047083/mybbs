package com.mybbs.service;

import java.util.List;

import com.mybbs.vo.vUserAndPost;

public interface PostService {
	public List<vUserAndPost> getSerachPostList(String str);

	public void closeDB();
}
