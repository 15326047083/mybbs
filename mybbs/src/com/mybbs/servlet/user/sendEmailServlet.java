package com.mybbs.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.service.UserService;
import com.mybbs.service.impl.UserServiceImpl;

import util.EmailUtil;

/**
 * Servlet implementation class sendEmailServlet
 */
public class sendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sendEmailServlet() {
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
		if ("0".equals(request.getParameter("bj"))) {
			// 判断该email是否已经注册过
			UserService userService = new UserServiceImpl();
			int num = userService.countEmail(request.getParameter("email"));
			response.setHeader("Access-Control-Allow-Origin", "*");
			try {
				PrintWriter out = response.getWriter();
				if (num >= 1) {
					out.write("1");
				} else {
					out.write("0");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.setHeader("Access-Control-Allow-Origin", "*");
			String email = request.getParameter("email");
			String code = EmailUtil.sendEmail(email);
			try {
				PrintWriter out = response.getWriter();
				out.write(code);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
