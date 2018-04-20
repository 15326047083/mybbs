package com.mybbs.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;

import util.EmailUtil;
import util.SQLUtil;

/**
 * Servlet implementation class newUserServlet
 */
public class newUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public newUserServlet() {
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
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setBirthday(request.getParameter("birthday"));
		user.setEmail(request.getParameter("email"));
		user.setName(new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8"));
		user.setPassword(request.getParameter("password"));
		user.setSex(Integer.parseInt(request.getParameter("sex")));
		user.setTime(0);
		user.setPower(-1);
		user.setPlateId(0);
		if (request.getParameter("surecode").equals(request.getParameter("code"))) {
			CommonService<User> commonService = new CommonServiceImpl<User>();
			commonService.saveOrUpdate(user, SQLUtil.newUser);
			EmailUtil.sendUserInfo(user);
		} else {
			request.setAttribute("user", user);
			request.setAttribute("code", request.getParameter("surecode"));
			request.setAttribute("flag", 1);
			request.getRequestDispatcher("WEB-INF/pages/user/new.jsp").forward(request, response);
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
