package com.mybbs.dao;

import java.util.List;

import com.mybbs.vo.UserAndPlate;

public interface PlateDao {
	/**
	 * 查找全部列表 以及版主信息
	 */
	public List<UserAndPlate> getAllList();
}
