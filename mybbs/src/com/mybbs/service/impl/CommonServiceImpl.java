package com.mybbs.service.impl;

import java.util.List;

import com.mybbs.dao.CommonDao;
import com.mybbs.dao.impl.CommonDaoImpl;
import com.mybbs.service.CommonService;

public class CommonServiceImpl<T> implements CommonService<T> {

	private CommonDao<T> commonDao;

	public CommonServiceImpl() {
		// TODO Auto-generated constructor stub
		commonDao = new CommonDaoImpl<T>();
	}

	@Override
	public void saveOrUpdate(T common, String sql) {
		// TODO Auto-generated method stub
		commonDao.saveOrUpdate(common, sql);
	}

	@Override
	public void delete(int id, String sql) {
		// TODO Auto-generated method stub
		commonDao.delete(id, sql);
	}

	@Override
	public T getById(T common, String firstSql, String secondSql) {
		// TODO Auto-generated method stub
		return commonDao.getById(common, firstSql, secondSql);
	}

	@Override
	public List<T> getAllList(T common, String firstSql, String secondSql, int pages) {
		// TODO Auto-generated method stub
		return commonDao.getAllList(common, firstSql, secondSql, pages);
	}

	@Override
	public void closeDB() {
		// TODO Auto-generated method stub
		commonDao.closeDB();
	}

	@Override
	public int count(String firstSql, T common) {
		// TODO Auto-generated method stub
		return commonDao.count(firstSql, common);
	}

}
