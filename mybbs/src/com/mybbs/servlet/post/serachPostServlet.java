package com.mybbs.servlet.post;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.vo.CommonPages;
import com.mybbs.vo.vUserAndPost;

/**
 * Servlet implementation class serachPost
 */
public class serachPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serachPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nowPages = Integer.parseInt(request.getParameter("nowPages"));
		String queryStr = new String(request.getParameter("queryStr").getBytes("iso-8859-1"), "utf-8");
		vUserAndPost v = new vUserAndPost();
		CommonService<vUserAndPost> commonService = new CommonServiceImpl<vUserAndPost>();
		String sql = "select post.id id,post.userId userId,user.name userName,post.plateId plateId,post.flag flag,plate.name plateName,"
				+ "title,post.info info,post.time time,photoNum from user,post,plate where user.id=post.userId and plate.id=post.plateId"
				+ " and flag<>1 and (post.title like '%" + queryStr + "%' or user.name like '%" + queryStr + "%')";
		String countSql = "select count(*) from user,post,plate where user.id=post.userId and plate.id=post.plateId"
				+ " and flag<>1 and (post.title like '%" + queryStr + "%' or user.name like '%" + queryStr + "%')";
		int count = commonService.count(countSql, v);
		
		int allPages = count / 20;
		if (count % 20 != 0)
			allPages++;
		if(allPages==0) {
			allPages=1;
		}
		CommonPages<vUserAndPost> commonPages = new CommonPages<vUserAndPost>();
		commonPages.setCommonList(commonService.getAllList(v, sql, " order by post.id desc limit ?,20", nowPages));
		commonPages.setCount(count);
		commonPages.setPages(nowPages);

		commonPages.setTotalpages(allPages);
		commonPages.setLimit(1);
		commonService.closeDB();

		request.setAttribute("str", queryStr);
		request.setAttribute("commonPages", commonPages);
		request.setAttribute("nowPages", nowPages);
		request.setAttribute("titleName", "为您找到有关"+queryStr+"的全部帖子");

		request.getRequestDispatcher("WEB-INF/pages/post/getSerachPostList.jsp").forward(request, response);
	} 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
