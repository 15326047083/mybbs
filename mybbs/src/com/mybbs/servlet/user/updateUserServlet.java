package com.mybbs.servlet.user;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mybbs.po.Plate;
import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;

import util.SQLUtil;

/**
 * Servlet implementation class updateUserServlet
 */
public class updateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		User user = new User();
		user = (User) session.getAttribute("userSession");
		System.out.println(user);
		//从页面获取值
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int sex =Integer.parseInt(request.getParameter("sex")) ;
		int age =Integer.parseInt(request.getParameter("age")) ;
		String birthday = request.getParameter("birthday");
		user.setName(name);
		user.setEmail(email);
		user.setSex(sex);
		user.setAge(age);
		user.setBirthday(birthday);
		CommonService<User> commonservice = new CommonServiceImpl<User>();
		commonservice.saveOrUpdate(user,SQLUtil.updateUser);
		commonservice.closeDB();
		request.getRequestDispatcher("WEB-INF/pages/user/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
