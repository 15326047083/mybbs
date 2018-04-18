package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/") + 1);
		String traget = "";
		switch (action) {
		case "login":
			String username = request.getParameter("username");
			String pwd = request.getParameter("password");
			if (notNull(username) && notNull(pwd)) {
				request.getSession().setAttribute("currentUser", username);
				traget = "/MyFilter/IndexServlet/sure";
			} else {
				traget = "/WEB-INF/pages/login.jsp";
			}
			break;
		case "a":
			traget = "/WEB-INF/pages/A.jsp";
			break;
		case "b":
			traget = "/WEB-INF/pages/B.jsp";
			break;
		case "c":
			traget = "/WEB-INF/pages/C.jsp";
			break;
		case "error":
			traget = "/WEB-INF/pages/error.jsp";
			break;
		}
		if(traget.endsWith(".jsp")) {
			request.getRequestDispatcher(traget).forward(request, response);
		}else {
			response.sendRedirect(traget);
		}
	}

	private boolean notNull(String str) {
		if (null != str && !"".equals(str)) {
			return true;
		}
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
