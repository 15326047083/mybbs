package com.mybbs.test;

import com.mybbs.dao.CommonDao;
import com.mybbs.dao.impl.CommonDaoImpl;
import com.mybbs.po.Area;

public class Test {
	@org.junit.Test
	public void test() {
		CommonDao<Area> commonDao = new CommonDaoImpl<Area>();
		Area u = new Area();
		u.setId(1);
		u.setInfo("asdasdsad");
		u.setName("asdasdsadasd");
		u.setPlateNum(11);
		commonDao.newCommon(u,"insert into area values(null,?,?,?)");
	}
}
