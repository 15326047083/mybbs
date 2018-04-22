package com.mybbs.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.UserService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.service.impl.UserServiceImpl;

import util.EmailUtil;
import util.SQLUtil;

/**
 * Servlet implementation class findUserServlet
 */
public class findUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public findUserServlet() {
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
		User user = new User();
		String email = request.getParameter("email");
		UserService userService = new UserServiceImpl();
		user = userService.getUserByEmail(email);
		if (request.getParameter("surecode").equals(request.getParameter("code"))) {
			user.setPassword(request.getParameter("password"));
			CommonService<User> commonService = new CommonServiceImpl<User>();
			commonService.saveOrUpdate(user, SQLUtil.updateUser);
			commonService.closeDB();
			EmailUtil.sendUserInfo(user);
		} else {
			request.setAttribute("user", user);
			request.setAttribute("code", request.getParameter("surecode"));
			request.setAttribute("flag", 1);
			request.getRequestDispatcher("WEB-INF/pages/user/find.jsp").forward(request, response);
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
