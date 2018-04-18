package com.mybbs.dao.impl;

import com.mybbs.dao.CommonDao;

public class CommonDaoImpl<T> implements CommonDao<T> {

	public void newCommon(T common) {
		// TODO Auto-generated method stub
		System.out.println(common.getClass().getFields());
		System.out.println(common.getClass().getDeclaredFields());
		System.out.println(common.getClass().getSimpleName());
	}

	@Override
	public void updateCommon(T common) {
		// TODO Auto-generated method stub
		
	}

}
