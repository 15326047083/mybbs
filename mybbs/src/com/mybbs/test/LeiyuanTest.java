package com.mybbs.test;

import org.junit.Test;

import com.mybbs.dao.CommonDao;
import com.mybbs.dao.impl.CommonDaoImpl;
import com.mybbs.po.Area;

import util.SQLUtil;

public class LeiyuanTest {
	@Test
	public void test() {
		CommonDao<Area> commonDao = new CommonDaoImpl<Area>();
		Area u = new Area();
		u.setId(1);
		u.setInfo("asdasdsad");
		u.setName("asdasdsadasd");
		u.setPlateNum(11);
		commonDao.newCommon(u, SQLUtil.newUser);
	}
}
