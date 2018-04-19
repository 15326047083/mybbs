<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: #edf6fa;">
	<c:choose>
		<c:when test="${area.id>0 }">
			<form action="<%=basePath%>updateAreaServlet" method="post">
		</c:when>
		<c:otherwise>
			<form action="<%=basePath%>newAreaServlet" method="post">
		</c:otherwise>
	</c:choose>
	<ul>
		<li>区域名称</li>
		<li><input type="text" name="name" value="${area.name }">
		</li>
	</ul>
	<ul>
		<li>区域简介</li>
		<li><input type="text" name="info" value="${area.info }">
			<input type="hidden" value="${area.plateNum }" name="plateNum">
		</li>
	</ul>
	<input type="submit" value="提交">
	</form>
</body>
</html>