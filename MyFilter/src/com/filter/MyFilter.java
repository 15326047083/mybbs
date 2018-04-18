package com.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class MyFilter implements Filter {

	public MyFilter() {
	}
啊啊啊啊
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		confi(req,resp);
		String uri = req.getRequestURI();
		String power = uri.substring(uri.lastIndexOf("/") + 1);
		if ("a".equals(power) || "b".equals(power) || "c".equals(power)) {
			String user = (String) req.getSession().getAttribute("currentUser");
			String pass = (String) req.getSession().getAttribute(user + power);
			if (null == pass) {
				request.getRequestDispatcher("UserServlet/error").forward(request, response);
			}else {
				chain.doFilter(request, response);
			}
		}else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	private void confi(HttpServletRequest request,HttpServletResponse response) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		request.setAttribute("basePath", basePath);
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}
