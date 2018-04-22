<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%
	String path1 = request.getContextPath();
	String basePath1 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path1 + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-lg-3 col-md-3 w_main_right">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">全部区域</h3>
			</div>
			<div class="panel-body">
				<div class="labelList">
				
						<a class="label label-default" href=""></a>
				
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">全部板块</h3>
			</div>
			<div class="panel-body">
				<div class="labelList">
				
						<a class="label label-default" href=""></a>
				
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">随机推荐</h3>
			</div>
			<div class="panel-body">
				<ul class="list-unstyled sidebar">
			
					<li><a href="">title</a></li>
			
				</ul>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">友情链接</h3>
			</div>
			<div class="panel-body">
				<div class="newContent">
					<ul class="list-unstyled sidebar shiplink">
						<li><a href="https://www.baidu.com/" target="_blank">百度</a></li>
						<li><a href="https://www.oschina.net/" target="_blank">开源中国</a>
						</li>
						<li><a href="http://www.ulewo.com/" target="_blank">有乐网</a></li>
						<li><a href="http://www.sina.com.cn/" target="_blank">新浪网</a>
						</li>
						<li><a href="http://www.qq.com/" target="_blank">腾讯网</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>