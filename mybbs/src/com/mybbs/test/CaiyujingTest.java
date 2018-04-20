package com.mybbs.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mybbs.service.CommonService;
import com.mybbs.service.PlateService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.service.impl.PlateServiceImpl;
import com.mybbs.vo.vUserAndPlate;

public class CaiyujingTest {

	@Test
	public void testplate() {
		PlateService plateService =new PlateServiceImpl();
		List<vUserAndPlate> list =new ArrayList<vUserAndPlate>();
		list=plateService.getAllList();
		System.out.println(list);
	}
	@Test
	public void testCommon() {
		/*CommonService<vUserAndPlate> commonService =new CommonServiceImpl<vUserAndPlate>();
		vUserAndPlate userAndPlate =new vUserAndPlate();
		List<vUserAndPlate> list=commonService.getAllList(userAndPlate, "select user.id userId ,user.name userName,email,plate.id plateId,plate.name plateName,info,postNum,areaId from user,plate where user.id=plate.id", " limit ?,20", 1);
		System.out.println(list);*/
	}
	
}
