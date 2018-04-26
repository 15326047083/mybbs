package com.mybbs.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mybbs.po.Area;
import com.mybbs.po.Message;
import com.mybbs.po.Plate;
import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.vo.CommonPages;
import com.mybbs.vo.vUserAndPost;

import util.SQLUtil;

/**
 * Servlet implementation class toUserServlet
 */
public class toUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public toUserServlet() {
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
		if ("new".equals(request.getParameter("flag"))) {
			request.getRequestDispatcher("WEB-INF/pages/user/new.jsp").forward(request, response);
		} else if ("update".equals(request.getParameter("flag"))) {
			request.getRequestDispatcher("WEB-INF/pages/user/update.jsp").forward(request, response);
		} else if ("find".equals(request.getParameter("flag"))) {
			request.getRequestDispatcher("WEB-INF/pages/user/find.jsp").forward(request, response);
		} else if ("look".equals(request.getParameter("flag"))) {
			System.out.println(1212121);
			HttpSession session = request.getSession();
			session.invalidate();
			session = request.getSession();
			User user = new User();
			user.setId(-1);
			user.setName("游客");
			session.setAttribute("userSession", user);
			CommonService<Area> commonService = new CommonServiceImpl<Area>();
			List<Area> areaList = new ArrayList<Area>();
			Area area = new Area();
			areaList = commonService.queryAll(area, SQLUtil.getListFirstSql);
			// get plate
			List<Plate> plateList = new ArrayList<Plate>();
			CommonService<Plate> pcommonService = new CommonServiceImpl<Plate>();
			Plate plate = new Plate();
			plateList = pcommonService.getAllList(plate, SQLUtil.getListFirstSql, " limit ?", 2);
			session.setAttribute("plateListSession", plateList);
			/**
			 * 获取最新的公告
			 */
			CommonService<Message> mcommonService = new CommonServiceImpl<Message>();
			Message message = new Message();
			List<Message> messageList = new ArrayList<Message>();
			messageList = mcommonService.getAllList(message, SQLUtil.getListFirstSql,
					" where id<>? order by id desc limit 1", -11);
			commonService.closeDB();
			pcommonService.closeDB();
			session.setAttribute("areaListSession", areaList);

			session.setAttribute("messageList", messageList);
			response.sendRedirect("loginServlet");
		} else if ("area".equals(request.getParameter("flag"))) {
			int areaId = Integer.parseInt(request.getParameter("areaId"));
			List<Plate> plateList = new ArrayList<Plate>();
			CommonService<Plate> pcommonService = new CommonServiceImpl<Plate>();
			Plate plate = new Plate();
			plateList = pcommonService.getAllList(plate, SQLUtil.getListFirstSql,
					" where postNum <>? and areaId=" + areaId, -2);
			HttpSession session = request.getSession();
			session.setAttribute("plateListSession", plateList);
			
			//area下的帖子
			int nowPages=Integer.parseInt(request.getParameter("nowPages"));
			CommonService<vUserAndPost> commonService =new CommonServiceImpl<vUserAndPost>();
			vUserAndPost v =new vUserAndPost();
			String sql="select post.id id,post.userId,user.name userName,post.plateId,post.flag flag,plate.name plateName,title,post.info info,post.time time,photoNum from user,post,plate where user.id=post.userId and plate.id=post.plateId and flag=0 and plate.areaId="+areaId;
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
		 
			//拿到area名字
			CommonService<Area> acommonService = new CommonServiceImpl<Area>();
			Area area=new Area();
			area.setId(areaId);
			area=acommonService.getById(area, SQLUtil.getByIdFirstSql, SQLUtil.getByIdSecondSql);
			String areaName=area.getName();
			commonService.closeDB();
			request.setAttribute("commonPages", commonPages);
			request.setAttribute("nowPages", nowPages);
			request.setAttribute("titleName", areaName+" 区域下的全部帖子");
			
			request.getRequestDispatcher("WEB-INF/pages/post/getPostList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("WEB-INF/pages/user/login.jsp").forward(request, response);
		}
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
