<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/js/login/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/js/login/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/js/login/assets/css/form-elements.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/js/login/assets/css/style.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

<!-- Favicon and touch icons -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<%=request.getContextPath()%>/js/login/assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<%=request.getContextPath()%>/js/login/assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<%=request.getContextPath()%>/js/login/assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=request.getContextPath()%>/js/login/assets/ico/apple-touch-icon-57-precomposed.png">
</head>
<body
	background="<%=request.getContextPath()%>/js/login/assets/img/backgrounds/1.jpg">

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>
							<strong>BBS</strong> Login
						</h1>
						<div class="description">
							<p>Please use your mailbox for login!</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3>Login to our site</h3>
								<p>Enter your email and password to log on:</p>
							</div>
							<div class="form-top-right">
								<i class="fa fa-lock"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form action="<%=basePath%>user/userLogin" method="post"
								class="login-form">
								<div class="form-group">
									<label class="sr-only" for="form-username">Username</label> <input
										type="text" name="email" placeholder="E-mail..."
										class="form-username form-control" id="form-username">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password">Password</label> <input
										type="password" name="password" placeholder="Password..."
										class="form-password form-control" id="form-password">
								</div>
								<c:if test="${flag==1}">
									<div class="form-group">
										<span>用户名或密码错误</span>
									</div>
								</c:if>
								<button type="submit" class="btn">Sign in!</button>
							</form>
							<div align="center">
								<a href="<%=basePath%>toUserServlet?flag=new">立即注册</a> <a
									href="<%=basePath%>toUserServlet?flag=find">忘记密码</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Javascript -->
	<script
		src="<%=request.getContextPath()%>/js/login/assets/js/jquery-1.11.1.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/js/login/assets/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/js/login/assets/js/jquery.backstretch.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/js/login/assets/js/scripts.js"></script>
</body>

</html>