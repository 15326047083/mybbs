package com.mybbs.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Area;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;
import com.mybbs.vo.CommonPages;

import util.SQLUtil;

/**
 * Servlet implementation class getAreaListServlet
 */
public class getAreaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAreaListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int nowPages=Integer.parseInt(request.getParameter("nowPages"));
		CommonService<Area> commonService =new CommonServiceImpl<Area>();
		Area area =new Area();
		int count=commonService.count(SQLUtil.firstCountSql, area);
		int allPages=count/20;
		if(count%20!=0)
			allPages++;
		CommonPages<Area> commonPages=new CommonPages<Area>();
		commonPages.setCommonList(commonService.getAllList(area, SQLUtil.getListFirstSql, SQLUtil.getListSecondSql, nowPages));
		commonPages.setCount(count);
		commonPages.setPages(nowPages);
		
		commonPages.setTotalpages(allPages);
		commonPages.setLimit(1);
		commonService.closeDB();
		request.setAttribute("commonPages", commonPages);
		request.setAttribute("nowPages", nowPages);
		if("not delete".equals(request.getParameter("script"))) {
			String script="	<script type=\"text/javascript\">\r\n" + 
					"		alert(\"该区域尚有版块存在，不可进行删除操作！！！\");\r\n" + 
					"	</script>";
			request.setAttribute("script", script);
		}
		if("ok".equals(request.getParameter("script"))) {
			String script="	<script type=\"text/javascript\">\r\n" + 
					"		alert(\"删除成功！！！\");\r\n" + 
					"	</script>";
			request.setAttribute("script", script);
		}
		request.getRequestDispatcher("WEB-INF/pages/admin/area/getAreaList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
