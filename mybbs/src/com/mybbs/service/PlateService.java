package com.mybbs.service;

import java.util.List;

import com.mybbs.vo.vUserAndPlate;

public interface PlateService {
	public List<vUserAndPlate> getAllList();
	public void lessPostNum (int id);
}
