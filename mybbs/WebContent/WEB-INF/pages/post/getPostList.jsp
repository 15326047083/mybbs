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

					<%@ include file="../head/left.jsp"%>

					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">${plate.name}${title}</h3>
						</div>

						<div class="panel-body">

							<!--文章列表开始-->
							<div class="contentList">
								<c:forEach var="post" items="${commonPages.commonList}"
									varStatus="loop">
									<div class="panel panel-default">
										<div class="panel-body">

											<h4>
												<a class="title" href="<%=basePath%>getPost">${post.title}</a>
												<c:if test="${bj==1}">
													<a href="" style="float: right">删除帖子</a>
												</c:if>
											</h4>
											<p class="overView">${post.time}</p>


										</div>
									</div>
								</c:forEach>
								<div align="right">
									<a class="span6 offset2 bm30" 
										href="<%=basePath%>getPostListServlet?nowPages=1">首页</a>
									<c:choose>
										<c:when test="${nowPages!=1 }">
											<a class="span6 offset2 bm30"
												href="<%=basePath%>getPostListServlet?nowPages=${nowPages-1}">上一页</a>
										</c:when>
										<c:otherwise>
											<a class="span6 offset2 bm30" href="javascript:return false;"
												onclick="return false;" style="cursor: default;"><i
												class="edit" style="opacity: 0.2"></i>上一页</a>
										</c:otherwise>
									</c:choose>
									<a> ${nowPages}</a>/<a>${commonPages.totalpages} </a>
									<c:choose>
										<c:when test="${nowPages!=commonPages.totalpages }">
											<a class="span6 offset2 bm30"
												href="<%=basePath%>getPostListServlet?nowPages=${nowPages+1}">下一页</a>
										</c:when>
										<c:otherwise>
											<a class="span6 offset2 bm30" href="javascript:return false;"
												onclick="return false;" style="cursor: default;"><i
												class="edit" style="opacity: 0.2"></i>下一页</a>
										</c:otherwise>
									</c:choose>
									<a class="span6 offset2 bm30"
										href="<%=basePath%>getPostListServlet?nowPages=${commonPages.totalpages}">尾页</a>
								</div>
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