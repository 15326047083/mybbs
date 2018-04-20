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
 * Servlet implementation class newAreaServlet
 */
public class newAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newAreaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name =  new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		String info =new String(request.getParameter("info").getBytes("iso-8859-1"), "utf-8");
		
		Area area =new Area();
		CommonService<Area> commonService= new CommonServiceImpl<Area>();
		int count=commonService.count(SQLUtil.firstCountSql, area);
		int allPages=count/20;
		if(count%20!=0)
			allPages++;		
		area.setName(name);
		area.setInfo(info);
		area.setPlateNum(0);
		commonService.saveOrUpdate(area, SQLUtil.newArea);
		response.sendRedirect("getAreaListServlet?nowPages="+allPages);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
