package com.mybbs.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.vo.CommonPages;
import com.mybbs.vo.vUserAndPlate;

/**
 * Servlet implementation class getPlateListServlet
 */
public class getPlateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getPlateListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int nowPages=Integer.parseInt(request.getParameter("nowPages"));
		CommonService<vUserAndPlate> commonService =new CommonServiceImpl<vUserAndPlate>();
		vUserAndPlate v= new vUserAndPlate();
		int count=commonService.count("select count(*) from plate", v);
		int allPages=count/20;
		if(count%20!=0)
			allPages++;
		String areaId;
		CommonPages<vUserAndPlate> commonPages=new CommonPages<vUserAndPlate>();
		if(request.getParameter("areaId")==null) {
			areaId="";
		}else {
			areaId=" and areaId="+request.getParameter("areaId");
		}
		commonPages.setCommonList(commonService.getAllList(v,"select user.id userId ,user.name userName,email,plate.id plateId,plate.name plateName,plate.info info,area.name areaName,postNum,areaId from user,plate,area where user.id=plate.id and areaId=area.id"+areaId," limit ?,20", nowPages));
		commonPages.setCount(count);
		commonPages.setPages(nowPages);
		commonPages.setTotalpages(allPages);
		commonPages.setLimit(1);
		commonService.closeDB();
		request.setAttribute("commonPages", commonPages);
		request.setAttribute("nowPages", nowPages);
		request.getRequestDispatcher("WEB-INF/pages/admin/plate/getPlateList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
