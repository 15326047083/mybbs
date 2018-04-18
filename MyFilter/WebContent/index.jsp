<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
<% request.getSession().invalidate();%>
	<form action="BaseServlet" method="post">
		<div align="center">
			PageA:<input type="checkbox" name="u1a" />
			PageB:<input type="checkbox" name="u1b" />
			PageC:<input type="checkbox" name="u1c" />
		</div>
		<div align="center">
			PageA:<input type="checkbox" name="u2a" />
			PageB:<input type="checkbox" name="u2b" />
			PageC:<input type="checkbox" name="u2c" />
		</div>
		<div align="center">
			<input type="submit" value="Confirm"/>
		</div>
	</form>
</body>
</html>