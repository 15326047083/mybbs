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
	${script }
	<div class="w_container">
		<div class="container">
			<div class="row w_main_row">
				<div class="col-lg-9 col-md-9 w_main_left">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3>${post.title}</h3>
							<hr>
							<a class="overView"> <span class="count"><i
									class="glyphicon glyphicon-user"></i>${post.userName} </span> <span
								class="count"><i class="glyphicon glyphicon-time"></i>${post.time}</span>
								<a style="color: #FF6347;"> ${post.plateName}</a>
								<div align="right">
									<a href="updatePostServlet?postId=${post.id}"
										style="color: black;">【举报】</a>
								</div>
							</a>
						</div>

						<div class="panel-body">


							<!--文章列表开始-->
							<div style="float: left;">${post.info}</div>
						</div>
					</div>
					<!-- 百度分享开始 -->
					<div class="bdsharebuttonbox" align="right">
						<a href="#" class="bds_more" data-cmd="more"></a><a href="#"
							class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a
							href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a
							href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a
							href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a
							href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
					</div>
					<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":["qzone","tsina","bdysc","weixin","tieba","sqq","mail","ty","fbook","copy"],"bdPic":"","bdStyle":"0","bdSize":"24"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>

					<!-- 百度分享结束 -->
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
									<textarea rows="6" name="dissDussInfo" id="dissDussInfo"
										style="margin: 0px 0px 11px; width: 536px; height: 132px;"></textarea>
									<br />
									<div>
										<input type="submit" name="submit" value="发布"
											onclick="return submitDiscuss()" class="btn btn-inverse">
										<img src="images/loading.gif" id="contact-loader"
											alt="Loading...">
									</div>
								</div>
							</div>
						</form>
					</c:if>
					<!-- 判断评论是否够字数begin -->
					<script type="text/javascript">
					function submitDiscuss() {
						if(document.getElementById('dissDussInfo').value.length<=15||document.getElementById('dissDussInfo').value.length>=100){
							alert("文本不符合规定，请输入大于15个字符并且小于100个字符");
							return false;
						}else{
							return true;
						}
					}
					</script>
					<!-- 判断评论是否够字数end -->
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


											<div class="panel panel-default"
												style="width: 750px; float: right;" id="reply${disscuss.id}">
												<h4>回复列表</h4>
												<c:forEach var="r" items="${replyList}" varStatus="l">

													<c:if test="${disscuss.id==r.discussId}">
														<hr
															style="height: 1px; border: none; border-top: 1px dashed gray;">
															${r.userName}
																<c:if test="${post.userId==r.userId}">
															<a style="color: red">(楼主)</a>
														</c:if>
															的回复：${r.info}
												<br>
														<i class="glyphicon glyphicon-time"></i>${r.time }
													</c:if>
												</c:forEach>
											</div>
											<c:if test="${userSession.id!=-1 }">
												<button
													style="float: right; border: none; border-radius: 20px; font-weight: bold; color: red;"
													onclick="add(${disscuss.id})">说点什么. . .</button>
											</c:if>

											<form id="${disscuss.id}">
												<input name="discussId" type="hidden" value="${disscuss.id}" />
												<input name="userId" type="hidden" value="${userSession.id}" />
												<span id="span${disscuss.id}"></span>
											</form>
										</div>
									</div>
								</c:forEach>
							</div>
							<div align="right">
								<a
									href="<%=basePath%>getPostServlet?nowPages=1&postId=${post.id}">首页</a>
								<c:choose>
									<c:when test="${nowPages!=1 }">
										<a
											href="<%=basePath%>getPostServlet?nowPages=${nowPages-1}&postId=${post.id}">上一页</a>
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
										<a
											href="<%=basePath%>getPostServlet?nowPages=${nowPages+1}&postId=${post.id}">下一页</a>
									</c:when>
									<c:otherwise>
										<a href="javascript:return false;" onclick="return false;"
											style="cursor: default;"><i class="edit"
											style="opacity: 0.2"></i>下一页</a>
									</c:otherwise>
								</c:choose>
								<a
									href="<%=basePath%>getPostServlet?nowPages=${commonPages.totalpages}&postId=${post.id}">尾页</a>

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
	var formId;
		function add(id) {
			formId=id;
			var input = document.createElement('textarea'); //创建input节点
			input.setAttribute('rows', '6'); //定义类型是文本输
			input.setAttribute('name', 'info'); //定义类型是文本输入
			input.setAttribute('id', 'info'+formId); //定义类型是文本输入
			input
					.setAttribute('style',
							'float: left; height: 30px; margin: 0px 0px 11px; width: 536px; height: 132px;'); //定义类型是文本输
			document.getElementById('span'+id).appendChild(input); //添加到form中显示
			var input = document.createElement('input'); //创建input节点
			input.setAttribute('type', 'button'); //定义类型是文本输
			input.setAttribute('value', '确定'); //定义类型是文本输
			input.setAttribute('class', 'btn btn-inverse'); //定义类型是文本输
			input.setAttribute('style', 'Float:left;height:30px'); //定义类型是文本输
			input.setAttribute('id', 'save-btn'); //定义类型是文本输onclick="add(${disscuss.id})"
			input.setAttribute('onclick', 'submitReply()'); //定义类型是文本输onclick="add(${disscuss.id})"
			document.getElementById('span'+id).appendChild(input); //添加到form中显示
		}
	</script>
	<script type="text/javascript">
	function submitReply() {
		if(document.getElementById('info'+formId).value.length<=15||document.getElementById('info'+formId).value.length>=100){
			alert("文本不符合规定，请输入大于15个字符并且小于100个字符");
		}else{
	        var hr=document.createElement('hr');
	        hr.setAttribute('style', 'height: 1px; border: none; border-top: 1px dashed gray;'); //定义类型是文本输
			document.getElementById('reply'+formId).appendChild(hr); //添加到form中显示
			var textNode=document.createTextNode("${userSession.name}"+"的回复："+document.getElementById('info'+formId).value);
			document.getElementById('reply'+formId).appendChild(textNode); //添加到form中显示
			var br=document.createElement('br');
			document.getElementById('reply'+formId).appendChild(br); //添加到form中显示
			var i=document.createElement('i');
	        i.setAttribute('class', 'glyphicon glyphicon-time'); //定义类型是文本输
			document.getElementById('reply'+formId).appendChild(i); //添加到form中显示
			var date = new Date();
		    var seperator1 = "-";
		    var seperator2 = ":";
		    var month = date.getMonth() + 1;
		    var strDate = date.getDate();
		    if (month >= 1 && month <= 9) {
		        month = "0" + month;
		    }
		    if (strDate >= 0 && strDate <= 9) {
		        strDate = "0" + strDate;
		    }
		    var currentdate = document.createTextNode(date.getFullYear() + seperator1 + month + seperator1 + strDate
		            + " " + date.getHours() + seperator2 + date.getMinutes()
		            + seperator2 + date.getSeconds());
			document.getElementById('reply'+formId).appendChild(currentdate); //添加到form中显示
	        $.ajax({ 
	            type: 'post', 
	            data:$('#'+formId).serialize(),
			    url:'newReplyServlet',  
	            dataType:"json",
	            async:true,
	            success: function () {
	            },
	            error:function()
	            {
	        		document.getElementById('span'+formId).parentNode.removeChild(document.getElementById('span'+formId)); //添加到form中显示
	                var span=document.createElement('span');
	                span.setAttribute('id', 'span'+formId); //定义类型是文本输
	        		document.getElementById(formId).appendChild(span); //添加到form中显示
	            },            
	        });
		}
	}
	</script>
</body>
</html>