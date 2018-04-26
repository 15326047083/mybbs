<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../head/head.jsp"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
					<c:if test="${userSession.id!=-1 }">
						<form
							action="<%=basePath%>newDisscussServlet?nowPages=${commonPages.totalpages}"
							method="post">

							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">发表评论</h3>
								</div>
								<div class="panel-body">
									<input name="postId" value="${post.id}" type="hidden" /> <input
										name="userId" value="${userSession.id}" type="hidden" />
									<textarea rows="6" name="dissDussInfo"
										style="margin: 0px 0px 11px; width: 536px; height: 132px;"></textarea>
									<br />
									<div>
										<input type="submit" name="submit" value="发布"
											class="btn btn-inverse"> <img
											src="images/loading.gif" id="contact-loader" alt="Loading...">
									</div>
								</div>
							</div>
						</form>
					</c:if>


					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">评论列表</h3>
						</div>
						<div class="panel-body">
							<div class="contentList">
								<c:forEach var="disscuss" items="${commonPages.commonList}"
									varStatus="loop">
									${loop.count+(nowPages-1)*20}楼
									<div class="panel panel-default">
										<div class="panel-body">
											<i class="glyphicon glyphicon-user"></i> <a
												style="color: blue">${disscuss.userName}</a>
											<c:if test="${post.userId==disscuss.userId}">
												<a style="color: red">(楼主)</a>
											</c:if>

											<a>评论：${disscuss.info}</a> <a
												style="color: gray; font-size: 9px"><br> <i
												class="glyphicon glyphicon-time"></i>${disscuss.time }</a>
											

											<div class="panel panel-default" style="width: 750px;float: right;" >				
												<h4>回复列表</h4>
												<c:forEach var="r" items="${replyList}" varStatus="l">

													<c:if test="${disscuss.id==r.discussId}">
														<hr
															style="height: 1px; border: none; border-top: 1px dashed gray ;">
															${r.userName}
																<c:if test="${post.userId==r.userId}">
															<a style="color: red">(楼主)</a>
														</c:if>
															的回复：${r.info}
												<a style="color: gray; font-size: 9px"><br> <i
															class="glyphicon glyphicon-time"></i>${r.time }</a>
													</c:if>
												</c:forEach>									
											</div>
											
											<button style="float: right;border: none"
												onclick="add(${comments.id})">说点什么。。。</button>
										
										
											<%-- 	<form action="<%=basePath%>reply/newReply" method="post">
												<input name="postId" type="hidden" value="${post.id}" /> <input
													name="commentsId" type="hidden" value="${comments.id}" />
												<input name="userId" type="hidden" value="${user.userId}" />
												<span id="${comments.id}"></span>
											</form>  --%>
										</div>
									</div>
								</c:forEach>
							</div>
							<div align="right">
								<a href="<%=basePath%>getPostServlet?nowPages=1">首页</a>
								<c:choose>
									<c:when test="${nowPages!=1 }">
										<a href="<%=basePath%>getPostServlet?nowPages=${nowPages-1}">上一页</a>
									</c:when>
									<c:otherwise>
										<a href="javascript:return false;" onclick="return false;"
											style="cursor: default;"><i class="edit"
											style="opacity: 0.2"></i>上一页</a>
									</c:otherwise>
								</c:choose>
								<a> ${nowPages}</a>/<a>${commonPages.totalpages} </a>
								<c:choose>
									<c:when test="${nowPages!=commonPages.totalpages }">
										<a href="<%=basePath%>getPostServlet?nowPages=${nowPages+1}">下一页</a>
									</c:when>
									<c:otherwise>
										<a href="javascript:return false;" onclick="return false;"
											style="cursor: default;"><i class="edit"
											style="opacity: 0.2"></i>下一页</a>
									</c:otherwise>
								</c:choose>
								<a
									href="<%=basePath%>getPostervlet?nowPages=${commonPages.totalpages}">尾页</a>

							</div>
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