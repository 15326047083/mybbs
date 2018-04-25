package com.mybbs.servlet.disscuss;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Discuss;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;

import util.SQLUtil;

/**
 * Servlet implementation class newDisscussServlet
 */
public class newDisscussServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newDisscussServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int nowPages=Integer.parseInt(request.getParameter("nowPages"));
		int postId=Integer.parseInt(request.getParameter("postId"));
		int userId=Integer.parseInt(request.getParameter("userId"));
		String dissDussInfo=new String(request.getParameter("dissDussInfo").getBytes("iso-8859-1"), "utf-8");
		Discuss discuss=new Discuss();
		discuss.setUserId(userId);
		discuss.setPostId(postId);
		discuss.setInfo(dissDussInfo);
		discuss.setTime(new Date().toString());
		//图片
		discuss.setPhotoNum(-1);
		CommonService<Discuss> commonService=new CommonServiceImpl<Discuss>();
		commonService.saveOrUpdate(discuss, SQLUtil.newDiscuss);
		response.sendRedirect("getPostServlet?postId="+postId+"&nowPages="+nowPages);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
