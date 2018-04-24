package com.mybbs.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybbs.po.Area;
import com.mybbs.po.Plate;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;

import util.SQLUtil;

/**
 * Servlet implementation class newPlateServlet
 */
public class newPlateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newPlateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name =  new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		String info =new String(request.getParameter("info").getBytes("iso-8859-1"), "utf-8");
		int areaId =Integer.parseInt(request.getParameter("areaId"));
		int userId =Integer.parseInt(request.getParameter("userId"));
		int postNum =Integer.parseInt(request.getParameter("postNum"));
		Plate plate =new Plate();
		
		CommonService<Plate> commonService= new CommonServiceImpl<Plate>();
		plate.setAreaId(areaId);
		plate.setInfo(info);
		plate.setName(name);
		plate.setpostNum(postNum);
		plate.setUserId(userId);
		commonService.saveOrUpdate(plate, SQLUtil.newPlate);
		int count=commonService.count(SQLUtil.firstCountSql, plate);
		int allPages=count/20;
		if(count%20!=0)
			allPages++;		
		
		//areaNum ++
		CommonService<Area> acommonService= new CommonServiceImpl<Area>();
		Area area = new Area();
		area.setId(areaId);
		area =acommonService.getById(area, SQLUtil.getByIdFirstSql, SQLUtil.getByIdSecondSql);
		area.setPlateNum(area.getPlateNum()+1);
		acommonService.saveOrUpdate(area, SQLUtil.updateArea);
		
		commonService.closeDB();
		response.sendRedirect("getPlateListServlet?nowPages="+allPages);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
