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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- 富文本编辑器 -->

<script type="text/javascript" charset="utf-8"
	src="<%=request.getContextPath()%>/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=request.getContextPath()%>/ueditor/ueditor.all.min.js">
	
</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="<%=request.getContextPath()%>/ueditor/lang/zh-cn/zh-cn.js"></script>
<!-- 结束 -->
</head>
<body>
	<div class="w_container">
		<div class="container">
			<div class="row w_main_row">
				<div class="col-lg-9 col-md-9 w_main_left">
					<article class="type-page hentry clearfix">
						<h1 class="post-title">发表帖子</h1>
						<hr>
						<p style="color: red">发表你的帖子，请注意言辞，不然会被版主和管理删除！</p>
					</article>
					<form class="row" id="form" action="<%=basePath%>newPostServlet"
						method="post">
						<!--   图片  enctype="multipart/form-data" -->

						<div class="span2">
							<label for="name">请选择板块</label>
						</div>
						<div class="span6">
							<select name="plateId">
								<c:forEach var="plate" items="${plateList}">
									<option value="${plate.id}">${plate.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="span2">
							<label for="name">标题</label>
						</div>
						<div class="span6">
							<input type="text" name="title" class="required input-xlarge"
								title="Please provide your title">
						</div>
						<div class="span2">
							<label for="name">内容</label>
						</div>
						<div class="span6">
							<input type="hidden" id="info" name="info" />

							<script id="editor" type="text/plain"
								style="width: 650px; height: 350px;">
								<p >在这里输入文章！！！</p>
							</script>

							<script type="text/javascript">
								//实例化编辑器
								var ue = UE.getEditor('editor');
							</script>
							<script type="text/javascript">
								function submitInfo() {
									document.getElementById('info').value = UE
											.getEditor('editor').getContent();
								}
							</script>
						</div>
						<div class="span6 offset2 bm30">
							<img src="images/loading.gif" id="contact-loader"
								alt="Loading...">
							<button type="submit" onclick="submitInfo()"
								class="btn btn-inverse">发布</button>
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