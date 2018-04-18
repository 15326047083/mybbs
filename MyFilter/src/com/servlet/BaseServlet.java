package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BaseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String u1a = request.getParameter("u1a");
		String u2a = request.getParameter("u2a");
		String u1b = request.getParameter("u1b");
		String u2b = request.getParameter("u2b");
		String u1c = request.getParameter("u1c");
		String u2c = request.getParameter("u2c");
		//System.out.println(u1a+"-"+u2a+"-"+u1b+"-"+u2b+"-"+u1c+"-"+u2c);
		if(notnull(u1a)) {
			request.getSession().setAttribute("u1a", u1a);
		}
		if(notnull(u2a)) {
			request.getSession().setAttribute("u2a", u2a);
		}
		if(notnull(u1b)) {
			request.getSession().setAttribute("u1b", u1b);
		}
		if(notnull(u2b)) {
			request.getSession().setAttribute("u2b", u2b);
		}
		if(notnull(u1c)) {
			request.getSession().setAttribute("u1c", u1c);
		}
		if(notnull(u2c)) {
			request.getSession().setAttribute("u2c", u2c);
		}
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);

	}

	private boolean notnull(String str) {
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
