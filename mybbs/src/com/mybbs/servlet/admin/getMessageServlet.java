package com.mybbs.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Message;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.vo.CommonPages;

import util.SQLUtil;

/**
 * Servlet implementation class getMessageServlet
 */
public class getMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int nowPages=Integer.parseInt(request.getParameter("nowPages"));
		CommonService<Message> commonService =new CommonServiceImpl<Message>();
		Message message = new Message();
		int count=commonService.count(SQLUtil.firstCountSql, message);
		int allPages=count/20;
		if(count%20!=0)
			allPages++;
		CommonPages<Message> commonPages=new CommonPages<Message>();
		commonPages.setCommonList(commonService.getAllList(message, SQLUtil.getListFirstSql, SQLUtil.getListSecondSql, nowPages));
		commonPages.setCount(count);
		commonPages.setPages(nowPages);
		
		commonPages.setTotalpages(allPages);
		commonPages.setLimit(1);
		commonService.closeDB();
		request.setAttribute("commonPages", commonPages);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
