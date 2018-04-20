package com.mybbs.servlet.post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class toPostServlet
 */
public class toPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//存入user到session
		User user=new User();
		CommonService<User> ucommonService=new CommonServiceImpl<User>();
		user.setId(1);
		user=ucommonService.getById(user, SQLUtil.getByIdFirstSql, SQLUtil.getByIdSecondSql);
		HttpSession session=request.getSession();
		session.setAttribute("userSession",user);		
		
		
		//从数据库获取全部版块
		CommonService<Plate> commonService=new CommonServiceImpl<Plate>();
		Plate plate = new Plate();
		List<Plate> list=new ArrayList<Plate>();
		list=commonService.queryAll(plate, SQLUtil.getListFirstSql);
		 //发送到页面
		request.setAttribute("plateList", list);
		request.getRequestDispatcher("WEB-INF/pages/post/newPost.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
