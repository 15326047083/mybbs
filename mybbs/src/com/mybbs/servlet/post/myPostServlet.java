package com.mybbs.servlet.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.vo.CommonPages;
import com.mybbs.vo.vUserAndPost;

/**
 * Servlet implementation class myPostServlet
 */
public class myPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = new User();
		user = (User) session.getAttribute("userSession");
		
		int nowPages=Integer.parseInt(request.getParameter("nowPages"));
		CommonService<vUserAndPost> commonService =new CommonServiceImpl<vUserAndPost>();
		vUserAndPost v =new vUserAndPost();
		String sql="select post.id id,post.userId,user.name userName,post.plateId,plate.name plateName,title,post.info info,post.time time,photoNum from user,post,plate where user.id=post.userId and plate.id=post.plateId and user.id="+user.getId();
		int count=commonService.count(sql, v);
		int allPages=count/20;
		if(count%20!=0)
			allPages++;
		CommonPages<vUserAndPost> commonPages=new CommonPages<vUserAndPost>();
		commonPages.setCommonList(commonService.getAllList(v,sql," order by post.id desc limit ?,20", nowPages));
		commonPages.setCount(count);
		commonPages.setPages(nowPages);
		
		commonPages.setTotalpages(allPages);
		commonPages.setLimit(1);
		commonService.closeDB();
		//System.out.println(commonPages.toString());
		request.setAttribute("commonPages", commonPages);
		request.setAttribute("nowPages", nowPages);
		request.setAttribute("titleName", "我的帖子");
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
