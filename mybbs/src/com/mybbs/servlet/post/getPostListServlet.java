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


import util.SQLUtil;

/**
 * Servlet implementation class getPostListServlet
 */
public class getPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getPostListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int nowPages=Integer.parseInt(request.getParameter("nowPages"));
		CommonService<Post> commonService =new CommonServiceImpl<Post>();
		Post post =new Post();
		int count=commonService.count(SQLUtil.firstCountSql, post);
		int allPages=count/20;
		if(count%20!=0)
			allPages++;
		CommonPages<Post> commonPages=new CommonPages<Post>();
		commonPages.setCommonList(commonService.getAllList(post, SQLUtil.getListFirstSql, SQLUtil.getListSecondSql, nowPages));
		commonPages.setCount(count);
		commonPages.setPages(nowPages);
		
		commonPages.setTotalpages(allPages);
		commonPages.setLimit(1);
		commonService.closeDB();
		//System.out.println(commonPages.toString());
		request.setAttribute("commonPages", commonPages);
		request.setAttribute("nowPages", nowPages);
		request.getRequestDispatcher("WEB-INF/pages/post/getPostList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
