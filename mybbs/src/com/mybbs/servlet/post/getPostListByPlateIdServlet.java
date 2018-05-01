package com.mybbs.servlet.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Plate;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.vo.CommonPages;
import com.mybbs.vo.vUserAndPost;

import util.SQLUtil;

/**
 * Servlet implementation class getPostListByPlateIdServlet
 */
public class getPostListByPlateIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getPostListByPlateIdServlet() {
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
		int plateId = Integer.parseInt(request.getParameter("plateId"));
		CommonService<vUserAndPost> commonService = new CommonServiceImpl<vUserAndPost>();
		vUserAndPost v = new vUserAndPost();
		String sql = "select post.id id,post.userId,user.name userName,post.plateId,post.flag flag,plate.name plateName"
				+ ",title,post.info info,post.time time,photoNum from user,post,plate where user.id=post.userId "
				+ "and plate.id=post.plateId and flag=0 and post.plateId=" + plateId;
		String countSql = "select count(*) user,post,plate where user.id=post.userId "
				+ "and plate.id=post.plateId and flag=0 and post.plateId=" + plateId;
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

		// plateName
		CommonService<Plate> pcommonService = new CommonServiceImpl<Plate>();
		Plate plate = new Plate();
		plate.setId(plateId);
		plate = pcommonService.getById(plate, SQLUtil.getByIdFirstSql, SQLUtil.getByIdSecondSql);

		commonService.closeDB();

		request.setAttribute("commonPages", commonPages);
		request.setAttribute("nowPages", nowPages);
		request.setAttribute("plateId", plateId);
		request.setAttribute("titleName", plate.getName() + " 板块下的全部帖子");

		request.getRequestDispatcher("WEB-INF/pages/post/getListByPlateId.jsp").forward(request, response);

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
