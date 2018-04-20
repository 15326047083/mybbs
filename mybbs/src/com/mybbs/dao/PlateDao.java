package com.mybbs.dao;

import java.util.List;

import com.mybbs.vo.vUserAndPlate;

public interface PlateDao {
	/**
	 * 查找全部列表 以及版主信息
	 */
	public List<vUserAndPlate> getAllList();
}
