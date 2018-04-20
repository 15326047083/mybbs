package com.mybbs.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Area;
import com.mybbs.po.Plate;
import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;

import util.SQLUtil;

/**
 * Servlet implementation class updatePlateServlet
 */
public class updatePlateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePlateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//从页面获取值
		int id=Integer.parseInt(request.getParameter("id"));
		String name =  new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		String info =new String(request.getParameter("info").getBytes("iso-8859-1"), "utf-8");
		int areaId =Integer.parseInt(request.getParameter("areaId"));
		int userId =Integer.parseInt(request.getParameter("userId"));
		int postNum =Integer.parseInt(request.getParameter("postNum"));
		//获取当前数据库 area的plate数量
		Plate plate =new Plate();
		plate.setId(id);
		CommonService<Plate> commonService= new CommonServiceImpl<Plate>();
		CommonService<Area> acommonService = new CommonServiceImpl<Area>();
		CommonService<User> ucommonService = new CommonServiceImpl<User>();
		plate=commonService.getById(plate, SQLUtil.getByIdFirstSql, SQLUtil.getByIdSecondSql);
		//为原始的area的 plateNum-1
		Area area = new Area();
		area.setId(plate.getAreaId());
		area=acommonService.getById(area, SQLUtil.getByIdFirstSql, SQLUtil.getByIdSecondSql);
		area.setPlateNum(area.getPlateNum()-1);
		acommonService.saveOrUpdate(area, SQLUtil.updateArea);
		//将修改后的plate值存入对象
		plate.setAreaId(areaId);
		plate.setInfo(info);
		plate.setName(name);
		plate.setpostNum(postNum);
		plate.setUserId(userId);
		//执行更新操作
		commonService.saveOrUpdate(plate, SQLUtil.updatePlate);
		//修改后的area的plateNum +1
		area.setId(areaId);
		area=acommonService.getById(area, SQLUtil.getByIdFirstSql, SQLUtil.getByIdSecondSql);
		area.setPlateNum(area.getPlateNum()+1);
		acommonService.saveOrUpdate(area, SQLUtil.updateArea);
		//获取页面所需的用户列表和区域列表
		List<Area> areaList = new ArrayList<Area>();
		List<User> userList = new ArrayList<User>();
		User user = new User();
		userList = ucommonService.queryAll(user, SQLUtil.getListFirstSql);
		areaList = acommonService.queryAll(area, SQLUtil.getListFirstSql);
		//关流
		commonService.closeDB();
		
		//向新的页面传递参数
		request.setAttribute("plate", plate);
		request.setAttribute("areaList", areaList);
		request.setAttribute("userList", userList);
		request.setAttribute("bj", 1);
		request.getRequestDispatcher("WEB-INF/pages/admin/plate/newOrUpdatePlate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
