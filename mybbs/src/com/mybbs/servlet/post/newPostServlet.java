package com.mybbs.servlet.post;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mybbs.po.Post;
import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;
import util.SQLUtil;

/**
 * Servlet implementation class newPostServlet
 */
public class newPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public newPostServlet() {
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
		// 从session获取user
		HttpSession session = request.getSession();
		User user = new User();
		user = (User) session.getAttribute("userSession");

		// 页面获取
		int plateId = Integer.parseInt(request.getParameter("plateId"));
		String title = request.getParameter("title");
		String info = request.getParameter("info");
		Post post = new Post();
		post.setTitle(title);
		post.setInfo(info);
		post.setPlateId(plateId);
		post.setUserId(user.getId());
		post.setTime(new Date().toString());
		/**
		 * 图片
		 */
		post.setPhotonum(-1);
		post.setFlag(0);
		CommonService<Post> commonService = new CommonServiceImpl<Post>();
		String sql = "update plate set postNum=postNum+1 where id =" + plateId;
		commonService.saveOrUpdate(post, SQLUtil.newPost, sql);
		commonService.closeDB();
		response.sendRedirect("myPostServlet?nowPages=1");
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
