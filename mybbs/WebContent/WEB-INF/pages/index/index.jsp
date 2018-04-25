<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../head/head.jsp"%>
<!doctype html>
<html>

<head>
<meta charset="UTF-8">
<title>mytbbs</title>
</head>

<body>
${script }
	<div class="w_container">
		<div class="container">
			<div class="row w_main_row">
				<div class="col-lg-9 col-md-9 w_main_left">
				<%@ include file="../head/left.jsp"%> 
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">最新发布</h3>
						</div>

						<div class="panel-body">

							<!--文章列表开始-->
							<div class="contentList">
						<c:forEach var="post" items="${commonPages.commonList}"
									varStatus="loop">
									<div class="panel panel-default">
										<div class="panel-body">

											<h4>
												<a class="title" href="<%=basePath%>getPostServlet?postId=${post.id}&nowPages=1">${post.title}</a>
												<c:if test="${bj==1}">
													<a href="" style="float: right">删除帖子</a>
												</c:if>
											</h4>
											<p class="overView">
											<span class="count"><i
													class="glyphicon glyphicon-user"></i>${post.userName} </span>
													<span
													class="count"><i class="glyphicon glyphicon-time"></i>${post.time}</span>
													<a style="color:#FF6347;"> ${post.plateName}</a></p>


										</div>
									</div>
								</c:forEach>
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
	<div class="w_foot">
		<div class="w_foot_copyright">
			Copyright &copy; 2017-2020, www.genban.org. All Rights Reserved. <span>|</span>
			<a target="_blank" href="http://www.miitbeian.gov.cn/" rel="nofollow">皖ICP备17002922号</a>
		</div>
	</div>
</body>
</html>