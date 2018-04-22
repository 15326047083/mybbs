package com.mybbs.servlet.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int id =Integer.parseInt(request.getParameter("id")) ;
		String name = request.getParameter("name"); 
		String email = request.getParameter("email");
		int sex =Integer.parseInt(request.getParameter("sex")) ;
		int age =Integer.parseInt(request.getParameter("age")) ;
		String birthday = request.getParameter("birthday");
		
		User user = new User();
		user.setId(id);
		CommonService<User> commonService= new CommonServiceImpl<User>();
		user=commonService.getById(user, SQLUtil.getByIdFirstSql, SQLUtil.getByIdSecondSql);
		user.setName(name);
		user.setEmail(email);
		user.setSex(sex);
		user.setAge(age);
		user.setBirthday(birthday);
		commonService.saveOrUpdate(user,SQLUtil.updateUser );
		commonService.closeDB();
		request.setAttribute("user", user);
		
		request.setAttribute("bj", 1);
		request.getRequestDispatcher("WEB-INF/pages/admin/user/UpdateUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
