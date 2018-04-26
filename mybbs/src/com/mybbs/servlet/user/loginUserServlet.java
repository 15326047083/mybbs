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
import com.mybbs.po.Message;
import com.mybbs.po.Plate;
import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.UserService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.service.impl.UserServiceImpl;

import util.SQLUtil;

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
				CommonService<Area> commonService = new CommonServiceImpl<Area>();
				List<Area> areaList = new ArrayList<Area>();
				Area area = new Area();
				areaList = commonService.queryAll(area, SQLUtil.getListFirstSql);
				HttpSession session = request.getSession();
				session.invalidate();
				session = request.getSession();
				// plateList
				List<Plate> plateList = new ArrayList<Plate>();
				CommonService<Plate> pcommonService = new CommonServiceImpl<Plate>();
				Plate plate = new Plate();
				plateList = pcommonService.getAllList(plate, SQLUtil.getListFirstSql, " limit ?", 2);
				session.setAttribute("plateListSession", plateList);
				/**
				 * 获取最新的公告
				 */
				CommonService<Message> mcommonService = new CommonServiceImpl<Message>();
				Message message = new Message();
				List<Message> messageList = new ArrayList<Message>();
				messageList = mcommonService.getAllList(message, SQLUtil.getListFirstSql,
						" where id<>? order by id desc limit 1", -11);
				commonService.closeDB();
				pcommonService.closeDB();
				session.setAttribute("messageList", messageList);
				session.setAttribute("userSession", user);
				session.setAttribute("areaListSession", areaList);
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
