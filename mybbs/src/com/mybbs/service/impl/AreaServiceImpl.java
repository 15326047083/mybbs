package com.mybbs.service.impl;

import com.mybbs.dao.AreaDao;
import com.mybbs.dao.impl.AreaDaoImpl;
import com.mybbs.service.AreaService;
import com.mybbs.servlet.admin.newAreaServlet;

public class AreaServiceImpl implements AreaService {

	@Override
	public void lessPlateNum(int id) {
		// TODO Auto-generated method stub
		AreaDao areaDao =new AreaDaoImpl() ;
		areaDao.lessPlateNum(id);
	}

}
