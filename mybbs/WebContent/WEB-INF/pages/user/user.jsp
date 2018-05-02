<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../head/head.jsp"%>
<!doctype html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="w_container">
		<div class="container">
			<div class="row w_main_row">
				<div class="col-lg-9 col-md-9 w_main_left">
					<%@ include file="../head/left.jsp"%>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">用户信息</h3>
						</div>

						<div class="panel-body">

							<!--文章列表开始-->
							<div class="contentList">
								<form class="row" action="<%=basePath%>user/changeUser"
									method="post" enctype="multipart/form-data">
									<input type="hidden" name="userId"
										class="required input-xlarge" value="${user.userId}" />

									<div class="span2">
										<label for="name">E-mail</label>
									</div>
									<div class="span6">
										<input type="text" name="email" class="required input-xlarge"
											title="Please provide your email" value="${user.email}" readonly="readonly">
									</div>

									<div class="span2">
										<label for="name">密码</label>
									</div>
									<div class="span6">
										<input type="text" name="password"
											class="required input-xlarge"
											title="Please provide your password">
									</div>

									<div class="span2">
										<label for="name">性别</label>
									</div>
									<div class="span6">
										<select name="sex" id="form-password">
											<c:if test="${'男'==user.sex}">
												<option value="男" selected="selected">男</option>
												<option value="女">女</option>
											</c:if>
											<c:if test="${'女'==user.sex}">
												<option value="男">男</option>
												<option value="女" selected="selected">女</option>
											</c:if>
										</select>
									</div>
									<div class="span2">
										<label for="name">生日</label>
									</div>
									<div class="span6">
										<input type="date" name="birthday" value="${user.birthday}"/>
									</div>
									<div class="span6 offset2 bm30">
										<input type="submit" name="submit" value="修改"
											class="btn btn-inverse"> 
									</div>
								</form>
							</div>
							<!--文章列表结束-->

						</div>
					</div>
				</div>

				<!--左侧开始-->
				<%@ include file="../head/right.jsp"%>
			</div>
		</div>
	</div>
	<%@include file="../head/down.jsp" %>
</body>
</html>