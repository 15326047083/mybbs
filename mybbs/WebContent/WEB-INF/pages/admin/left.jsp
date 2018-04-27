<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=request.getContextPath()%>/js/admin/css/style.css"
	rel="stylesheet" type="text/css" />
<script language="JavaScript"
	src="<%=request.getContextPath()%>/js/admin/js/jquery.js"></script>

<script type="text/javascript">
	$(function() {
		//导航切换
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});

		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
	})
</script>

</head>

<body style="background: #f0f9fd;">
	<div class="lefttop">
		<span></span>操作栏
	</div>
	<dl class="leftmenu">

		<dd>
			<div class="title">
				<span><img
					src="<%=request.getContextPath()%>/js/admin/images/leftico03.png" /></span>论坛管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="<%=basePath%>getAreaListServlet?nowPages=1"
					target="rightFrame">区域管理</a><i></i></li>
				<li><cite></cite><a href="<%=basePath%>getPlateListServlet?nowPages=1"
					target="rightFrame">板块管理</a><i></i></li>
				<li><cite></cite><a href="<%=basePath%>getUserListServlet?nowPages=1"
					target="rightFrame">用户管理</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img
					src="<%=request.getContextPath()%>/js/admin/images/leftico03.png" /></span>审核管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="<%=basePath%>getAreaListServlet?nowPages=1"
					target="rightFrame">被举报的帖子</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img
					src="<%=request.getContextPath()%>/js/admin/images/leftico01.png" /></span>公告管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="<%=basePath%>jumpServlet?flag=message"
					target="rightFrame">发送公告</a><i></i></li>
				<li><cite></cite><a
					href="<%=basePath%>getMessageServlet?nowPages=1" target="rightFrame">已发公告</a><i></i></li>
			</ul>
		</dd>

	</dl>
</body>
</html>