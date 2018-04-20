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
<script type="text/javascript">
	var InterValObj; //timer变量，控制时间 
	var count = 30; //间隔函数，1秒执行 
	var curCount;//当前剩余秒数 
	var email;
	function username(value) {
		email = value;
		if (window.XMLHttpRequest) {
			req = new XMLHttpRequest();
		}
		if (window.ActiveXObject) {
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (req) {
			var url = "http://localhost:8080/mybbs/sendEmailServlet?bj=0&email"
					+ email;
			req.open("post", url, true);
			req.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			req.onreadystatechange = test;
			req.send("email=" + email);
		}
	}
	function sendMessage() {
		if (window.XMLHttpRequest) {
			req = new XMLHttpRequest();
		}
		if (window.ActiveXObject) {
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (req) {
			var url = "http://localhost:8080/mybbs/sendEmailServlet?bj=1&email="
					+ email;
			req.open("post", url, true);
			req.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			req.onreadystatechange = test1;
			req.send("email=" + email);
		}
		curCount = count;
		$("#btnSendCode").attr("disabled", "true");
		$("#btnSendCode").val(curCount + "秒后可重新发送");
		InterValObj = window.setInterval(SetRemainTime, 1000);
	}
	function test1() {
		if (req.readyState == 4) {
			if (req.status == 200) {
				var result = req.responseText;
				document.getElementById('sure').value = result;
			}
		}
	}
	function test() {
		if (req.readyState == 4) {
			if (req.status == 200) {
				var result = req.responseText;
				if (result == "1") {
					alert("邮箱以注册，请直接登录或更换邮箱！");
					window.location.reload();
				}
			}
		}
	}
	function SetRemainTime() {
		if (curCount == 0) {
			window.clearInterval(InterValObj);//停止计时器 
			$("#btnSendCode").removeAttr("disabled");//启用按钮 
			$("#btnSendCode").val("重新发送验证码");
		} else {
			curCount--;
			$("#btnSendCode").val(curCount + "秒后可重新发送");
		}
	}
</script>
</head>
<body
	background="<%=request.getContextPath()%>/js/login/assets/img/backgrounds/1.jpg">

	<c:if test="${flag==1}">
		<script type="text/javascript">
			alert("验证码错误！");
		</script>
	</c:if>
	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>
							<strong>BBS</strong> registered
						</h1>
						<div class="description">
							<p>Please use your E-mail for registered!</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3>Registered to our site</h3>
								<p>Use E-mail、Password and Birthday to registered:</p>
							</div>
							<div class="form-top-right">
								<i class="fa fa-lock"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form action="<%=basePath%>newUserServlet" method="post"
								class="login-form">
								<input type="hidden" id="sure" name="surecode" value="${code}" />

								<div class="form-group">
									<label class="sr-only" for="form-username">Email</label> <input
										type="email" name="email" placeholder="E-mail..."
										class="form-username form-control" id="form-username"
										id="email" onblur="username(this.value)" value="${user.email}">
								</div>

								<div class="form-group">
									<label class="sr-only" for="form-password">Password</label> <input
										type="password" name="password" placeholder="Password..."
										class="form-password form-control" id="form-password"
										value="${user.password}">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password">Sex</label> <select
										name="sex" class="form-password form-control"
										id="form-password">
										<option value="男">男</option>
										<option value="女">女</option>
									</select>
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password">Birthday</label> <input
										type="date" name="birthday" placeholder="Birthday..."
										class="form-password form-control" id="form-password"
										value="${user.birthday}">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password">Code</label> <input
										type="text" name="code" placeholder="Code..."
										class="form-password form-control" id="form-password">
								</div>
								<div align="center">
									<input id="btnSendCode" type="button" onclick="sendMessage()"
										value="发送验证码" class="btn" />
								</div>
								<button type="submit" class="btn">Registered!</button>
							</form>
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