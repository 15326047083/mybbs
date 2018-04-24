package com.mybbs.dao;

import java.util.List;

public interface CommonDao<T> {

	void saveOrUpdate(T common, String sql);
	void saveOrUpdate(T common, String sql,String secondSql);

	void delete(int id, String sql);

	T getById(T common, String firstSql, String secondSql);

	List<T> getAllList(T common, String firstSql, String secondSql, int pages);

	void closeDB();

	int count(String firstSql, T common);

	List<T> queryAll(T common, String firstSql);
}
