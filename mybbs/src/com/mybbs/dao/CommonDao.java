package com.mybbs.dao;

import java.util.List;

public interface CommonDao<T> {

	void saveOrUpdate(T common, String sql);

	void delete(int id, String sql);

	T getById(T common, String sql);

	List<T> getAllList(T common, String sql);
}
