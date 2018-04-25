package com.mybbs.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mybbs.po.User;
import com.mybbs.service.UserService;
import com.mybbs.service.impl.UserServiceImpl;

/**
 * Servlet implementation class loginUserServlet
 */
public class loginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginUserServlet() {
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
		String email = null;
		if (request.getParameter("email") == null) {
			request.setAttribute("flag", 1);
			request.getRequestDispatcher("WEB-INF/pages/user/login.jsp").forward(request, response);
		} else {
			email = request.getParameter("email");
			UserService userService = new UserServiceImpl();
			User user = userService.getUserByEmail(email);
			String password = request.getParameter("password");
			if (password.equals(user.getPassword())) {
				// 登陆成功
				HttpSession session = request.getSession();
				session.setAttribute("userSession", user);
				response.sendRedirect("loginServlet");
			} else {
				// 用户名或密码错误
				request.setAttribute("flag", 1);
				request.getRequestDispatcher("WEB-INF/pages/user/login.jsp").forward(request, response);
			}
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
