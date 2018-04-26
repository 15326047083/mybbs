package com.mybbs.service;

import java.util.List;

import com.mybbs.vo.vDisscussAndReply;

public interface ReplyService {
	public List<vDisscussAndReply> getAllList(int id);
	void closeDB();
}
