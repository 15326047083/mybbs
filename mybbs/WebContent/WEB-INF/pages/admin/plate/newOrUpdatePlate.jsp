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
	<c:if test="${bj==1 }">
		<script type="text/javascript">
			alert("修改成功");
		</script>
	</c:if>
	<c:choose>
		<c:when test="${plate.id>0 }">
			<form action="<%=basePath%>updateAreaServlet" method="post">
		</c:when>
		<c:otherwise>
			<form action="<%=basePath%>newAreaServlet" method="post">
		</c:otherwise>
	</c:choose>
	<ul>
		<li>版块名称</li>
		<li><input type="text" name="name" value="${plate.name }">
		</li>
	</ul>
	<ul>
		<li>所属区域</li>
		<li><select name="areaId">
				<c:forEach var="area" items="${areaList }">
					<c:choose>
						<c:when test="${plate.areaId==area.id}">
							<option value="${area.id }" selected="selected">${area.name }</option>
						</c:when>
						<c:otherwise>
							<option value="${area.id }">${area.name }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
		</select></li>
	</ul>
	<ul>
		<li>选择版主</li>
		<li><select name="userId">
				<c:forEach var="user" items="${userList }">
					<c:choose>
						<c:when test="${plate.userId==user.id}">
							<option value="${user.id }" selected="selected">${user.name }</option>
						</c:when>
						<c:otherwise>
							<option value="${user.id }">${user.name }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
		</select></li>
	</ul>
	<ul>
		<li>版块简介</li>
		<li><input type="text" name="info" value="${plate.info }">
			<input type="hidden" value="${plate.postNum }" name="plateNum">
			<input type="hidden" value="${plate.id }" name="id"></li>
	</ul>
	<input type="submit" value="提交">
	</form>
</body>
</html>