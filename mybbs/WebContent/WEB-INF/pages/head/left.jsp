<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<div class="panel panel-default contenttop">
		<strong>管理员通知</strong>
		<div class="panel panel-default">
			<div class="panel-body">
				<h4>
					<c:forEach var="message" items="${messageList}">
						<a class="title">${message.info }</a>
					</c:forEach>
				</h4>
			</div>
		</div>
	</div>
</body>
</html>