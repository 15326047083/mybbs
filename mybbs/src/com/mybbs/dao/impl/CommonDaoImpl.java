package com.mybbs.dao.impl;

import com.mybbs.dao.CommonDao;

public class CommonDaoImpl<T> implements CommonDao<T> {

	public void newCommon(T common) {
		// TODO Auto-generated method stub
		System.out.println(common.getClass().toString());
	}

}
