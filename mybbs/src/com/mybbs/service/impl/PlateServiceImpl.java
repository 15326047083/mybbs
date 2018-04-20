package com.mybbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.mybbs.dao.PlateDao;
import com.mybbs.dao.impl.PlateDaoImpl;
import com.mybbs.service.PlateService;
import com.mybbs.vo.vUserAndPlate;

public class PlateServiceImpl implements PlateService{

	@Override
	public List<vUserAndPlate> getAllList() {
		// TODO Auto-generated method stub
		List<vUserAndPlate> list =new ArrayList<vUserAndPlate>();
		PlateDao plateDao =new PlateDaoImpl();
		list=plateDao.getAllList();
		return list;
	}

}
