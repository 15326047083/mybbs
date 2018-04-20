package com.mybbs.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Area;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;

import util.SQLUtil;

/**
 * Servlet implementation class updateAreaServlet
 */
public class updateAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateAreaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		String info =new String(request.getParameter("info").getBytes("iso-8859-1"), "utf-8");
		int  plateNum=Integer.parseInt(request.getParameter("plateNum"));
		Area area =new Area();
		area.setId(id);
		area.setName(name);
		area.setInfo(info);
		area.setPlateNum(plateNum);
		CommonService<Area> commonService=new CommonServiceImpl<Area>();
		commonService.saveOrUpdate(area, SQLUtil.updateArea);
		request.setAttribute("area", area);
		request.setAttribute("bj", 1);
		request.getRequestDispatcher("WEB-INF/pages/admin/area/newOrUpdateArea.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
