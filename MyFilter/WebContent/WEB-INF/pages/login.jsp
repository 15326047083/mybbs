<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<form action="UserServlet/login" method="post">
	<div align="center">
		用户名：<input type="text" name="username"/>
		密码：<input type="password" name="password"/>
		<input type="submit" value="Login"/>
	</div>
</form>
</body>
</html>