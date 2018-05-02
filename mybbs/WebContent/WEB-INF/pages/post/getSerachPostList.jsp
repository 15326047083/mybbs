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
					${script}
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">${titleName}</h3>
						</div>

						<div class="panel-body">
							<!--文章列表开始-->
							<div class="contentList">
								<c:forEach var="post" items="${commonPages.commonList}"
									varStatus="loop">
									<div class="panel panel-default">
										<div class="panel-body">

											<h4>
												<a class="title"
													href="<%=basePath%>getPostServlet?postId=${post.id}&nowPages=1">${post.title}</a>
											</h4>
											<c:if test="${userSession.id==post.userId}">
												<a href="deletePostServlet?postId=${post.id}"
													style="float: right; color: gray">删除</a>
											</c:if>
											<c:if test="${post.flag==1}">
												<a href="" style="float: right; color: red">您的帖子因违规被删除！！（仅自己可见）</a>
											</c:if>

											<p class="overView">
												<span class="count"><i
													class="glyphicon glyphicon-user"></i>${post.userName} </span> <span
													class="count"><i class="glyphicon glyphicon-time"></i>${post.time}</span>
												<a href="<%=basePath%>getPostListByPlateIdServlet?nowPages=1&plateId=${post.plateId}" style="color: #FF6347;"> ${post.plateName}</a>
											</p>
										</div>
									</div>
								</c:forEach>
								<div align="right">
									<a class="span6 offset2 bm30"
										href="<%=basePath%>serachPostServlet?nowPages=1&queryStr=${str}">首页</a>
									<c:choose>
										<c:when test="${nowPages!=1 }">
											<a class="span6 offset2 bm30"
												href="<%=basePath%>serachPostServlet?nowPages=${nowPages-1}&queryStr=${str}">上一页</a>
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
												href="<%=basePath%>serachPostServlet?nowPages=${nowPages+1}&queryStr=${str}">下一页</a>
										</c:when>
										<c:otherwise>
											<a class="span6 offset2 bm30" href="javascript:return false;"
												onclick="return false;" style="cursor: default;"><i
												class="edit" style="opacity: 0.2"></i>下一页</a>
										</c:otherwise>
									</c:choose>
									<a class="span6 offset2 bm30"
										href="<%=basePath%>serachPostServlet?nowPages=${commonPages.totalpages}&queryStr=${str}">尾页</a>
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
	<%@include file="../head/down.jsp" %>
</body>
</html>