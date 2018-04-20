package com.mybbs.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mybbs.service.PlateService;
import com.mybbs.service.impl.PlateServiceImpl;
import com.mybbs.vo.UserAndPlate;

public class CaiyujingTest {

	@Test
	public void test() {
		PlateService plateService =new PlateServiceImpl();
		List<UserAndPlate> list =new ArrayList<UserAndPlate>();
		list=plateService.getAllList();
		System.out.println(list);
	}
}
