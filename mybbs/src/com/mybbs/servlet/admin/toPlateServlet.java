package com.mybbs.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Area;
import com.mybbs.po.Plate;
import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;

import util.SQLUtil;

/**
 * Servlet implementation class toPalteServlet
 */
public class toPlateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public toPlateServlet() {
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
		String flag = request.getParameter("flag");
		CommonService<Area> acommonService = new CommonServiceImpl<Area>();
		CommonService<User> ucommonService = new CommonServiceImpl<User>();
		List<Area> areaList = new ArrayList<Area>();
		Area area = new Area();
		List<User> userList = new ArrayList<User>();
		User user = new User();
		userList = ucommonService.queryAll(user, SQLUtil.getListFirstSql);

		areaList = acommonService.queryAll(area, SQLUtil.getListFirstSql);

		if (flag != null && "new".equals(flag)) {

			request.setAttribute("str", "新增");
		}
		if (flag != null && "update".equals(flag)) {
			int id = Integer.parseInt(request.getParameter("id"));
			CommonService<Plate> commonService = new CommonServiceImpl<Plate>();
			Plate plate = new Plate();
			plate.setId(id);
			plate = commonService.getById(plate, SQLUtil.getByIdFirstSql, SQLUtil.getByIdSecondSql);
			request.setAttribute("plate", plate);
			request.setAttribute("str", "修改");

		}
		request.setAttribute("areaList", areaList);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("WEB-INF/pages/admin/plate/newOrUpdatePlate.jsp").forward(request, response);
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
