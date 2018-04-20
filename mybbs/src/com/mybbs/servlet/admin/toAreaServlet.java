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
 * Servlet implementation class toNewAreaServlet
 */
public class toAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toAreaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag= request.getParameter("flag");
		if(flag!=null&&"new".equals(flag)) {
			request.setAttribute("str", "新增");
			request.getRequestDispatcher("WEB-INF/pages/admin/area/newOrUpdateArea.jsp").forward(request, response);
		}
		if(flag!=null&&"update".equals(flag)) {
			int id=Integer.parseInt(request.getParameter("id"));
			CommonService<Area> commonService =new CommonServiceImpl<Area>();
			Area area =new Area();
			area.setId(id);
			area=commonService.getById(area, SQLUtil.getByIdFirstSql, SQLUtil.getByIdSecondSql);
			request.setAttribute("area", area);
			request.setAttribute("str", "修改");
			request.getRequestDispatcher("WEB-INF/pages/admin/area/newOrUpdateArea.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
