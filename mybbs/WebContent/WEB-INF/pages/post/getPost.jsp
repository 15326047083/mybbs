<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../head/head.jsp"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="w_container">
		<div class="container">
			<div class="row w_main_row">
				<div class="col-lg-9 col-md-9 w_main_left">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3>${post.title}</h3>
							<hr>
							<p class="overView">
								<span class="count"><i class="glyphicon glyphicon-user"></i>${post.userName}
								</span> <span class="count"><i class="glyphicon glyphicon-time"></i>${post.time}</span>
								<a style="color: #FF6347;"> ${post.plateName}</a>
							</p>
						</div>

						<div class="panel-body">


							<!--文章列表开始-->
							<div style="float: left;">${post.info}</div>

							<%-- 	<c:if test="${post.photoNum>=0}">
								<c:forEach var="x" begin="0" end="${post.photoNum}" step="1">
									<br />
									<br />
									<a href="<%=basePath %>moyifan/${post.id}/${x}.jpg"
										target="_Blank"><img
										src="<%=basePath %>moyifan/${post.id}/${x}.jpg" height="350px"
										width="350px" /></a>
									<br />
								</c:forEach>
							</c:if> --%>
							<!--文章列表结束-->

						</div>
					</div>
					<form action="<%=basePath%>comments/newComments" method="post">

						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">发表评论</h3>
							</div>
							<%-- 	<div class="panel-body">
								<input name="postId" value="${post.id}" type="hidden" /> <input
									name="userId" value="${post.userId}" type="hidden" />
								<textarea rows="6" name="info"
									style="margin: 0px 0px 11px; width: 536px; height: 132px;"></textarea>
								<br /> <input type="submit" value="发表" />
							</div> --%>
						</div>
					</form>
					<%-- <div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">评论列表</h3>
						</div>
						<div class="panel-body">
							<div class="contentList">
								<c:forEach var="comments" items="${commentsList}"
									varStatus="loop">
									<div class="panel panel-default">
										<div class="panel-body">
											<h4>
												<a class="title">${comments.info}</a>
												<button onclick="add(${comments.id})">回复</button>
												<c:if test="${comments.userId==user.userId}">
													<a
														href="<%=basePath%>comments/${comments.id}/${post.id}/${user.userId}/deleteComments"
														style="float: right">删除评论</a>
												</c:if>
											</h4>
											<p>
												<span class="count"><i
													class="glyphicon glyphicon-user"></i><a href="#">${userList[loop.count-1].email}</a></span>
											</p>
											<div style="border: 2px solid;">
												<h4>回复列表</h4>
												<c:forEach var="r" items="${replylist}" varStatus="l">
													<c:if test="${comments.id==r.commentsId}">
												用户：${replyUserList[l.count-1].email}的回复：
												<div style="font-size: 15px">${r.info}</div>
													</c:if>
												</c:forEach>
											</div>
											<form action="<%=basePath%>reply/newReply" method="post">
												<input name="postId" type="hidden" value="${post.id}" /> <input
													name="commentsId" type="hidden" value="${comments.id}" />
												<input name="userId" type="hidden" value="${user.userId}" />
												<span id="${comments.id}"></span>
											</form>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div> --%>
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
		function add(id) {
			var input = document.createElement('textarea'); //创建input节点
			input.setAttribute('rows', '6'); //定义类型是文本输
			input.setAttribute('name', 'info'); //定义类型是文本输入
			input
					.setAttribute('style',
							'float: left; height: 30px; margin: 0px 0px 11px; width: 536px; height: 132px;'); //定义类型是文本输
			document.getElementById(id).appendChild(input); //添加到form中显示
			var input = document.createElement('input'); //创建input节点
			input.setAttribute('type', 'submit'); //定义类型是文本输
			input.setAttribute('value', '确定'); //定义类型是文本输
			input.setAttribute('class', 'btn btn-inverse'); //定义类型是文本输
			input.setAttribute('style', 'Float:left;height:30px'); //定义类型是文本输
			document.getElementById(id).appendChild(input); //添加到form中显示
		}
	</script>
</body>
</html>