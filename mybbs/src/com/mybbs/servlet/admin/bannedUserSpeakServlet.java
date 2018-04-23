package com.mybbs.servlet.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;

import util.SQLUtil;

/**
 * Servlet implementation class bannedUserSpeakServlet
 */
public class bannedUserSpeakServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public bannedUserSpeakServlet() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String time = request.getParameter("time");
	//	System.out.println(time);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date date = simpleDateFormat.parse(time);
			long ts = date.getTime();
			CommonService<User> commonService = new CommonServiceImpl<User>();
			User user = new User();
			//获取user ID 并赋值
			user.setId(Integer.parseInt(request.getParameter("id")));
			
			user = commonService.getById(user, SQLUtil.getByIdFirstSql,SQLUtil.getByIdSecondSql);
			
			user.setTime(ts);
			
			commonService.saveOrUpdate(user, SQLUtil.updateUser);
			commonService.closeDB();
		//	request.setAttribute("user", user);
		//	request.getRequestDispatcher("WEB-INF/pages/admin/user/getUserList.jsp?nowPages=1").forward(request, response);
			response.sendRedirect("getUserListServlet?nowPages=1");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
