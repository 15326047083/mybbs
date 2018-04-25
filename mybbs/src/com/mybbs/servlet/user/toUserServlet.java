package com.mybbs.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mybbs.po.Area;
import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;

import util.SQLUtil;

/**
 * Servlet implementation class toUserServlet
 */
public class toUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public toUserServlet() {
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
		if ("new".equals(request.getParameter("flag"))) {
			request.getRequestDispatcher("WEB-INF/pages/user/new.jsp").forward(request, response);
		} else if ("update".equals(request.getParameter("flag"))) {
			request.getRequestDispatcher("WEB-INF/pages/user/update.jsp").forward(request, response);
		} else if ("find".equals(request.getParameter("flag"))) {
			request.getRequestDispatcher("WEB-INF/pages/user/find.jsp").forward(request, response);
		} else if ("look".equals(request.getParameter("flag"))) {
			HttpSession session = request.getSession();
			session.invalidate();
			session = request.getSession();
			User user = new User();
			user.setId(-1);
			user.setName("游客");
			session.setAttribute("userSession", user);
			CommonService<Area> commonService = new CommonServiceImpl<Area>();
			List<Area> areaList = new ArrayList<Area>();
			Area area = new Area();
			areaList = commonService.queryAll(area, SQLUtil.getListFirstSql);
			session.setAttribute("areaListSession", areaList);
			response.sendRedirect("loginServlet");
		} else {
			request.getRequestDispatcher("WEB-INF/pages/user/login.jsp").forward(request, response);
		}
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
