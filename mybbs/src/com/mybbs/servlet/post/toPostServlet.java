package com.mybbs.servlet.post;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mybbs.po.Plate;
import com.mybbs.po.User;
import com.mybbs.service.CommonService;
import com.mybbs.service.impl.CommonServiceImpl;

import util.SQLUtil;

/**
 * Servlet implementation class toPostServlet
 */
public class toPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//存入user到session
		User user=new User();
		CommonService<User> ucommonService=new CommonServiceImpl<User>();
		user.setId(1);
		user=ucommonService.getById(user, SQLUtil.getByIdFirstSql, SQLUtil.getByIdSecondSql);
		HttpSession session=request.getSession();
		session.setAttribute("userSession",user);		
		
		//判断是否被禁言
		long nowDate =new Date().getTime();
		//转化时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是你要转成后的时间的格式
		String sd = sdf.format(new Date(Long.parseLong(String.valueOf(user.getTime()))));   // 时间戳转换成时间
		if(user.getTime()>nowDate) {
			/*String script="<script type=\"text/javascript\">\r\n" + 
					"	alert(\"您已被禁言到"+sd+"，请联系管理员！！\")\r\n" + 
					"</script>";*/
			//request.setAttribute("script", script);
			//request.getRequestDispatcher("WEB-INF/pages/index/index.jsp").forward(request, response);
			response.sendRedirect("loginServlet?bj=1&sd="+sd);
		}
		else {
			user.setTime(0);
		ucommonService.saveOrUpdate(user, SQLUtil.updateUser);
		CommonService<Plate> commonService=new CommonServiceImpl<Plate>();
		Plate plate = new Plate();
		List<Plate> list=new ArrayList<Plate>();
		list=commonService.queryAll(plate, SQLUtil.getListFirstSql);
		 //发送到页面
		
		request.setAttribute("plateList", list);
		request.getRequestDispatcher("WEB-INF/pages/post/newPost.jsp").forward(request, response);
		}
		
		//从数据库获取全部版块
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
