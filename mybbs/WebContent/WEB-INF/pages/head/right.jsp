<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%
	String path1 = request.getContextPath();
	String basePath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
			<div class="panel-body">
				<c:choose>
					<c:when test="${userSession.id==-1}">
						<h3 style="color: red" class="panel-title">登录后有更多体验哦 亲！</h3>
					</c:when>
					<c:otherwise>
						<h3 style="color: red" class="panel-title">欢迎您：${userSession.name }
						<c:if test="${userSession.power!=-1 }">
				<div align="right">
								<a  class="label label-default"
							style="background-color:#FF6347;color: white "href="<%=basePath1%>loginAdminServlet">管理模式</a>
							</c:if></div>
						</h3>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">全部区域</h3>
			</div>
			<div class="panel-body">
				<div class="labelList">
					<c:forEach varStatus="loop" var="area" items="${areaListSession }">
						<a href="<%=basePath1 %>toUserServlet?flag=area&areaId=${area.id}&nowPages=1"
							class="label label-default"
							style="background-color:rgb(${loop.count*30},${loop.count*10},${255-loop.count*30})">${area.name }</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">全部板块</h3>

			</div>
			<div class="panel-body">
				<div class="labelList">

					<c:forEach varStatus="loop" var="plate"
						items="${plateListSession }">
						<a href="<%=basePath1 %>getPostListByPlateIdServlet?nowPages=1&plateId=${plate.id}" class="label label-default"
							style="background-color:rgb(${loop.count*5},80,${255-loop.count*5})">${plate.name }</a>
					</c:forEach>

				</div>
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