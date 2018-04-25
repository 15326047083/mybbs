package com.mybbs.servlet.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Post;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.vo.CommonPages;
import com.mybbs.vo.vUserAndPost;

import util.SQLUtil;

/**
 * Servlet implementation class getPostServlet
 */
public class getPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int postId=Integer.parseInt(request.getParameter("postId"));
		
		CommonService<vUserAndPost> commonService =new CommonServiceImpl<vUserAndPost>();
		vUserAndPost v =new vUserAndPost();
		v.setId(postId);
		String sql="select post.id id,post.userId,user.name userName,post.plateId,plate.name plateName,title,post.info info,post.time time,photoNum,post.flag flag from user,post,plate where user.id=post.userId and plate.id=post.plateId";
		v=commonService.getById(v, sql, " and post.id=?");
		commonService.closeDB();
		request.setAttribute("post", v);
		
		//get评论类表
		
		
		
		request.getRequestDispatcher("WEB-INF/pages/post/getPost.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
