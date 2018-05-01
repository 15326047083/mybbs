<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<link
	href="<%=request.getContextPath()%>/js/head/plugin/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/head/css/common.css" />
<link href="<%=request.getContextPath()%>/js/head/logo.ico"
	rel="shortcut icon" />
<script src="<%=request.getContextPath()%>/js/head/plugin/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/head/plugin/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="w_header">
		<div class="container">
			<div class="w_header_top">
				<span class="w_header_nav">
					<ul>
						<li><a href="<%=basePath%>loginServlet?nowPages=1"
							class="active">首页</a></li>
						<li><a href="<%=basePath%>getPostListServlet?nowPages=1">帖子总览</a></li>
						<c:if test="${userSession.id==-1}">
							<li><a href="<%=basePath%>toUserServlet">登录</a></li>
						</c:if>
						<c:if test="${userSession.id!=-1}">
							<li><a href="<%=basePath%>toPostServlet">发帖</a></li>
							
							<li><a href="<%=basePath%>myPostServlet?nowPages=1">我的帖子</a></li>
							<li><a href="<%=basePath%>toUserServlet?flag=update">个人信息</a></li>
							<li><a href="<%=basePath%>toUserServlet?flag=look">退出登录</a></li>
						</c:if>
					</ul>
				</span>
				<div align="left" class="w_search">
					<div class="w_searchbox">
						<form action="<%=basePath%>serachPostServlet?nowPages=1" method="post">
							<input type="hidden" name="path" value="" /> <input type="text"
								name="queryStr" placeholder="search" /> <input type="submit"
								value="搜索" />
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>