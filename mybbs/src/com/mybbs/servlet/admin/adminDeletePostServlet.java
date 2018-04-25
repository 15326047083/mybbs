package com.mybbs.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Post;
import com.mybbs.service.CommonService;
import com.mybbs.service.PlateService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.service.impl.PlateServiceImpl;

import util.SQLUtil;

/**
 * Servlet implementation class adminDeletePostServlet
 */
public class adminDeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminDeletePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int postId=Integer.parseInt(request.getParameter("postId"));
		CommonService<Post> commonService=new CommonServiceImpl<Post>();
		Post post =new Post();
		post.setId(postId);
		post=commonService.getById(post, SQLUtil.getByIdFirstSql, SQLUtil.getByIdSecondSql);
		int plateId=post.getPlateId();
		post.setFlag(1);
	//	System.out.println(post.toString());
		commonService.saveOrUpdate(post, SQLUtil.updatePost);
		commonService.closeDB();
		String script = "ok";
		response.sendRedirect("adminPostListServlet?nowPages=1&script="+script+"&plateId="+plateId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
