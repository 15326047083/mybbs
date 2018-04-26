package com.mybbs.dao;

import java.util.List;

import com.mybbs.vo.vDisscussAndReply;

public interface ReplyDao {
	/**
	 * 查找reply表和disscuss表信息
	 * @return
	 */
	public List<vDisscussAndReply> getAllList(int id);

	void closeDB();
}
