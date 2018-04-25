package com.mybbs.servlet.post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Post;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.vo.CommonPages;
import com.mybbs.vo.vDisscussAndUser;
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
		int nowPages=Integer.parseInt(request.getParameter("nowPages"));
		CommonService<vUserAndPost> commonService =new CommonServiceImpl<vUserAndPost>();
		CommonService<vDisscussAndUser> dcommonService =new CommonServiceImpl<vDisscussAndUser>();
		vUserAndPost v =new vUserAndPost();
		v.setId(postId);
		String sql="select post.id id,post.userId,user.name userName,post.plateId,plate.name plateName,title,post.info info,post.time time,photoNum,post.flag flag from user,post,plate where user.id=post.userId and plate.id=post.plateId";
		v=commonService.getById(v, sql, " and post.id=?");
		commonService.closeDB();
		request.setAttribute("post", v);
		
		//get评论类表
		List<vDisscussAndUser> list =new ArrayList<vDisscussAndUser>();
		vDisscussAndUser dv=new vDisscussAndUser();
		String dsql="select discuss.id id,userId,user.name userName,postId,info,discuss.time time,photoNum from user,discuss where user.id=discuss.userId";
		int count=dcommonService.count(dsql,dv);
		int allPages=count/20;
		if(count%20!=0)
			allPages++;
		CommonPages<vDisscussAndUser> commonPages=new CommonPages<vDisscussAndUser>();
		commonPages.setCommonList(dcommonService.getAllList(dv,dsql," limit ?,20", nowPages));
		commonPages.setCount(count);
		commonPages.setPages(nowPages);
		commonPages.setTotalpages(allPages);
		commonPages.setLimit(1);
		commonService.closeDB();
		request.setAttribute("commonPages", commonPages);
		request.setAttribute("nowPages", nowPages);
		request.setAttribute("titleName", "全部帖子");
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
