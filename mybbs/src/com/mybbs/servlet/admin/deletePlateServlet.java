package com.mybbs.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Plate;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;

import util.SQLUtil;

/**
 * Servlet implementation class deletePlateServlet
 */
public class deletePlateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deletePlateServlet() {
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
		int plateId = Integer.parseInt(request.getParameter("id"));
		int postNum = Integer.parseInt(request.getParameter("postNum"));
		CommonService<Plate> commonService = new CommonServiceImpl<Plate>();
		String script = null;
		// 可删
		if (postNum <= 0) {
			commonService.delete(plateId, SQLUtil.deletePlate);
			script = "ok";
		} else {
			// 不可删
			script = "not delete";
		}
		commonService.closeDB();
		response.sendRedirect("getPlateListServlet?nowPages=1&script=" + script);
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
