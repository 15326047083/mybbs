package com.mybbs.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		} else if ("uodate".equals(request.getParameter("flag"))) {

		} else if ("find".equals(request.getParameter("flag"))) {
			request.getRequestDispatcher("WEB-INF/pages/user/find.jsp").forward(request, response);
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
