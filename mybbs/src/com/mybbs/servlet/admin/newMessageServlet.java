package com.mybbs.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Message;
import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;

import util.SQLUtil;

/**
 * Servlet implementation class newMessageServlet
 */
public class newMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());String info = request.getParameter("info");
		String info = request.getParameter("info");
		System.out.println(info);
		Message message = new Message();
		message.setInfo(info);
		CommonService<Message> commonService = new CommonServiceImpl<Message>();
		commonService.saveOrUpdate(message, SQLUtil.newnotice);
		commonService.closeDB();

		request.getRequestDispatcher("WEB-INF/pages/admin/message/newMessage.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
