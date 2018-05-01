package com.mybbs.servlet.admin;

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
 * Servlet implementation class getReportListServlet
 */
public class getReportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getReportListServlet() {
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
		int nowPages = Integer.parseInt(request.getParameter("nowPages"));
		CommonService<vUserAndPost> commonService = new CommonServiceImpl<vUserAndPost>();
		// get userId in Session
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		int sessionUserId = user.getId();
		String sql="";
		String countSql="";
		if(user.getPower()==0) {//admin
			sql = "select post.id id,post.userId,user.name userName,post.plateId,post.flag flag,plate.name plateName,"
					+ "title,post.info info,post.time time,photoNum from user,post,plate where user.id=post.userId "
					+ "and plate.id=post.plateId and post.flag=3";
			countSql = "select count(*) from user,post,plate where user.id=post.userId and plate.id=post.plateId "
					+ "and post.flag=3";
		}
		else {
			sql = "select post.id id,post.userId,user.name userName,post.plateId,post.flag flag,plate.name plateName,"
					+ "title,post.info info,post.time time,photoNum from user,post,plate where user.id=post.userId "
					+ "and plate.id=post.plateId and post.flag=3 and plate.userId=" + sessionUserId;
			countSql = "select count(*) from user,post,plate where user.id=post.userId and plate.id=post.plateId "
					+ "and post.flag=3 and plate.userId=" + sessionUserId;
		}
		vUserAndPost v = new vUserAndPost();
		
		int count = commonService.count(countSql, v);
		int allPages = count / 20;
		if (count % 20 != 0)
			allPages++;
		if (allPages == 0)
			allPages = 1;
		CommonPages<vUserAndPost> commonPages = new CommonPages<vUserAndPost>();
		commonPages.setCommonList(commonService.getAllList(v, sql, " order by post.id desc limit ?,20", nowPages));
		commonPages.setCount(count);
		commonPages.setPages(nowPages);

		commonPages.setTotalpages(allPages);
		commonPages.setLimit(1);
		commonService.closeDB();
		// 判断是否删除
		if ("ok".equals(request.getParameter("script"))) {
			String script = "	<script type=\"text/javascript\">\r\n" + "		alert(\"删除成功！！！\");\r\n"
					+ "	</script>";
			request.setAttribute("script", script);
		}
		// System.out.println(commonPages.toString());
		request.setAttribute("commonPages", commonPages);
		request.setAttribute("nowPages", nowPages);
		request.getRequestDispatcher("WEB-INF/pages/admin/post/getReportList.jsp").forward(request, response);
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
