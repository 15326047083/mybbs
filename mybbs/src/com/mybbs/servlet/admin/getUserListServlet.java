package com.mybbs.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Area;
import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.vo.CommonPages;

import util.SQLUtil;

/**
 * Servlet implementation class getUserList
 */
public class getUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getUserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int nowPages=Integer.parseInt(request.getParameter("nowPages"));
		CommonService<User> commonService =new CommonServiceImpl<User>();
		User user = new User();
		int count=commonService.count(SQLUtil.firstCountSql, user);
		int allPages=count/20;
		if(count%20!=0)
			allPages++;
		CommonPages<User> commonPages=new CommonPages<User>();
		commonPages.setCommonList(commonService.getAllList(area, SQLUtil.getListFirstSql, SQLUtil.getListSecondSql, nowPages));
		commonPages.setCount(count);
		commonPages.setPages(nowPages);
		
		commonPages.setTotalpages(allPages);
		commonPages.setLimit(1);
		commonService.closeDB();
		request.setAttribute("commonPages", commonPages);
		request.setAttribute("nowPages", nowPages);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
