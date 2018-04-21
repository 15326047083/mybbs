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
 * Servlet implementation class deleteAreaServlet
 */
public class deleteAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deleteAreaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int areaId = Integer.parseInt(request.getParameter("id"));
		int plateNum = Integer.parseInt(request.getParameter("plateNum"));
		CommonService<Area> commonService = new CommonServiceImpl<Area>();
		String script = null;
		// 可删
		if (plateNum <= 0) {
			commonService.delete(areaId, SQLUtil.deleteArea);
			script = "ok";
		} else {
			// 不可删
			script = "not delete";
		}
		commonService.closeDB();
		response.sendRedirect("getAreaListServlet?nowPages=1&script=" + script);
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
