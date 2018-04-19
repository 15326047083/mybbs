package com.mybbs.test;

import java.util.List;

import org.junit.Test;

import com.mybbs.dao.CommonDao;
import com.mybbs.dao.impl.CommonDaoImpl;
import com.mybbs.po.Area;
import com.mybbs.po.Plate;
import com.mybbs.vo.CommonPages;

import util.SQLUtil;

public class LeiyuanTest {

	/**
	 * 测试通用saveOrUpdate
	 */
	@Test
	public void testSaveOrUpdate() {
		/**
		 * 当传入数据中包含id且id值不为0则表示update否则表示新增
		 */
		CommonDao<Area> commonDao = new CommonDaoImpl<Area>();
		for (int i = 0; i < 150; i++) {
			Area u = new Area();
			u.setInfo("小宝贝" + i);
			u.setName("雷园" + i);
			u.setPlateNum(0);
			commonDao.saveOrUpdate(u, SQLUtil.newArea);
		}
		commonDao.closeDB();
	}

	/**
	 * 根据id查询测试
	 */
	@Test
	public void testGetById() {
		CommonDao<Plate> commonDao = new CommonDaoImpl<Plate>();
		Plate u = new Plate();
		u.setId(2);
		u = commonDao.getById(u, SQLUtil.getByIdFirstSql, SQLUtil.getByIdSecondSql);
		System.out.println(u.toString());
	}

	/**
	 * 测试通用删除
	 */
	@Test
	public void testDelete() {
		CommonDao<Plate> commonDao1 = new CommonDaoImpl<Plate>();
		commonDao1.delete(3, SQLUtil.deletePlate);
	}

	/**
	 * 通用分页测试
	 */
	@Test
	public void testPages() {
		CommonDao<Area> cDao = new CommonDaoImpl<Area>();
		Area area = new Area();
		int nowPages = 1;// 从前台接收需要展示的页面
		List<Area> area2 = cDao.getAllList(area, SQLUtil.getListFirstSql, SQLUtil.getListSecondSql, nowPages);
		int allNum = cDao.count(SQLUtil.firstCountSql, area);// 统计获取当前总数量
		int totalpages = allNum / 15;
		if (allNum % 15 != 0)
			totalpages++;// 获取当前数据总页数
		/**
		 * 将数据封装至范性分页vo类中以备展示所用
		 */
		CommonPages<Area> commonPages = new CommonPages<Area>();
		commonPages.setCommonList(area2);
		commonPages.setCount(allNum);
		commonPages.setPages(nowPages);
		commonPages.setTotalpages(totalpages);
		System.out.println(commonPages.toString());
		cDao.closeDB();
	}
}
