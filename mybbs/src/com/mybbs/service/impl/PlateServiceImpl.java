package com.mybbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.mybbs.dao.PlateDao;
import com.mybbs.dao.impl.PlateDaoImpl;
import com.mybbs.service.PlateService;
import com.mybbs.vo.UserAndPlate;

public class PlateServiceImpl implements PlateService{

	@Override
	public List<UserAndPlate> getAllList() {
		// TODO Auto-generated method stub
		List<UserAndPlate> list =new ArrayList<UserAndPlate>();
		PlateDao plateDao =new PlateDaoImpl();
		list=plateDao.getAllList();
		return list;
	}

}
