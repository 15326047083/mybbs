<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../head/head.jsp"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>发帖</title>

<!-- Style Sheet-->
<link rel='stylesheet' id='bootstrap-css-css'
	href='<%=request.getContextPath()%>/js/index/css/bootstrap5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='responsive-css-css'
	href='<%=request.getContextPath()%>/js/index/css/responsive5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='pretty-photo-css-css'
	href='<%=request.getContextPath()%>/js/index/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4'
	type='text/css' media='all' />
<link rel='stylesheet' id='main-css-css'
	href='<%=request.getContextPath()%>/js/index/css/main5152.css?ver=1.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='custom-css-css'
	href='<%=request.getContextPath()%>/js/index/css/custom5152.html?ver=1.0'
	type='text/css' media='all' />
</head>
<body>
	<div class="w_container">
		<div class="container">
			<div class="row w_main_row">
				<div class="col-lg-9 col-md-9 w_main_left">
					<article class="type-page hentry clearfix">
						<h1 class="post-title">修改个人信息</h1>
						<hr>

					</article>
					<form class="row" action="<%=basePath%>updateUserServlet"
						method="post">
						<!--   图片  enctype="multipart/form-data" -->
						<input type="hidden" name="id" class="required input-xlarge"
							value="${userSession.id}">
						<div class="span2">
							<label for="name">用户姓名</label>
						</div>
						<div class="span6">
							<input type="text" name="name" class="required input-xlarge"
								value="${userSession.name }">
						</div>
						<div class="span2">
							<label for="name">用户邮箱</label>
						</div>
						<div class="span6">
							<input type="text" name="email" class="required input-xlarge"
								value="${userSession.email }" readonly="readonly">
						</div>
						<div class="span2">
							<label for="name">用户性别</label>
						</div>
						<div class="span6">
							<!-- <input type="radio" name="sex" class=""
								value="0">男 <input type="radio" name="sex"
								class="" value="1"/>女 -->
							<select name="sex">
							<c:if test="${userSession.sex==0 }">
								<option value="0" selected="selected">男</option>
								<option value="1" >女</option>
							</c:if>
								<c:if test="${userSession.sex==1 }">
								<option value="0">男</option>
								<option value="1" selected="selected">女</option>
							</c:if>
							</select>
						</div>
						<div class="span2">
							<label for="name">用户年龄</label>
						</div>
						<div class="span6">
							<input type="text" name="age" class="required input-xlarge"
								value="${userSession.age }">
						</div>
						<div class="span2">
							<label for="name">用户生日</label>
						</div>
						<div class="span6">
							<input type="date" name="birthday" class="required input-xlarge"
								value="${userSession.birthday }">
						</div>

						<div class="span6 offset2 bm30">
							<input type="submit" name="submit" value="修改"
								class="btn btn-inverse"> <img src="images/loading.gif"
								id="contact-loader" alt="Loading...">
						</div>
					</form>
				</div>
				<!--左侧开始-->
				<%@ include file="../head/right.jsp"%>
			</div>
		</div>
	</div>
	<div class="w_foot">
		<div class="w_foot_copyright">
			Copyright &copy; 2017-2020, www.genban.org. All Rights Reserved. <span>|</span>
			<a target="_blank" href="http://www.miitbeian.gov.cn/" rel="nofollow">皖ICP备17002922号</a>
		</div>
	</div>
	<script type="text/javascript">
		function add() {
			var input = document.createElement('input'); //创建input节点
			input.setAttribute('type', 'file'); //定义类型是文本输
			input.setAttribute('name', 'file'); //定义类型是文本输入
			input.setAttribute('onchange', 'add()'); //定义类型是文本输入
			document.getElementById('form').appendChild(input); //添加到form中显示
			var br = document.createElement('br');
			document.getElementById('form').appendChild(br);
		}
	</script>
</body>
</html>