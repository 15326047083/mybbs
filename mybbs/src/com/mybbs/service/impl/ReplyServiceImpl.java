package com.mybbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.mybbs.dao.ReplyDao;
import com.mybbs.dao.impl.ReplyDaoImpl;
import com.mybbs.service.ReplyService;
import com.mybbs.vo.vDisscussAndReply;

public class ReplyServiceImpl implements ReplyService{

	@Override
	public List<vDisscussAndReply> getAllList(int id) {
		// TODO Auto-generated method stub
		List<vDisscussAndReply> list=new ArrayList<vDisscussAndReply>();
		ReplyDao replyDao=new ReplyDaoImpl();
		list=replyDao.getAllList(id);
		return list;
	}

	@Override
	public void closeDB() {
		// TODO Auto-generated method stub
		ReplyDao replyDao=new ReplyDaoImpl();
		replyDao.closeDB();
	}

}
