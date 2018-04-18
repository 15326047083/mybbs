package com.mybbs.dao;

public interface CommonDao<T> {

	void newCommon(T common, String sql);

	void updateCommon(T common, String sql);
}
