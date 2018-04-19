package com.mybbs.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.dao.CommonDao;
import com.mybbs.dao.impl.CommonDaoImpl;
import com.mybbs.po.Area;
import com.mybbs.vo.CommonPages;

import util.SQLUtil;

/**
 * Servlet implementation class getAreaListServlet
 */
public class getAreaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAreaListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int nowPages=Integer.parseInt(request.getParameter("nowPages"));
		CommonDao<Area> commonDao=new CommonDaoImpl<Area>();
		Area area =new Area();
		int count=commonDao.count(SQLUtil.firstCountSql, area);
		int allPages=count/20;
		if(count%20!=0)
			allPages++;
		CommonPages<Area> commonPages=new CommonPages<Area>();
		commonPages.setCommonList(commonDao.getAllList(area, SQLUtil.getListFirstSql, SQLUtil.getListSecondSql, nowPages));
		commonPages.setCount(count);
		commonPages.setPages(nowPages);
		
		commonPages.setTotalpages(allPages);
		commonPages.setLimit(1);
		request.setAttribute("commonPages", commonPages);
		request.setAttribute("nowPages", nowPages);
		request.getRequestDispatcher("WEB-INF/pages/admin/area/getAreaList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
