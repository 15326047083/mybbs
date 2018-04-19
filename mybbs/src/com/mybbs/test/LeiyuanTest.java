package com.mybbs.test;

import java.util.List;

import org.junit.Test;

import com.mybbs.dao.CommonDao;
import com.mybbs.dao.impl.CommonDaoImpl;
import com.mybbs.po.Area;
import com.mybbs.po.Plate;

import util.SQLUtil;

public class LeiyuanTest {
	@Test
	public void test() {
		// CommonDao<Plate> commonDao = new CommonDaoImpl<Plate>();
		// Plate u = new Plate();
		// u.setId(4);
		// u.setInfo("小宝贝");
		// u.setName("雷园");
		// u.setAreaId(1);
		// u.setpostNum(13);
		// commonDao.saveOrUpdate(u, SQLUtil.updatePlate);
		// CommonDao<Plate> commonDao1 = new CommonDaoImpl<Plate>();
		// commonDao1.delete(3, SQLUtil.deletePlate);
		CommonDao<Area> cDao = new CommonDaoImpl<Area>();
		Area area = new Area();
		area.setId(1);
		List<Area> area2 = cDao.getAllList(area, SQLUtil.getAreaList);
		for (Area p : area2) {
			System.out.println(p.toString());
		}
	}
}
