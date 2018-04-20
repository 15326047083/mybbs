<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/js/admin/css/index.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/admin/js/jquery.js"></script>

<script language="javascript">
	$(function() {
		$('.error').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 490) / 2
		});
		$(window).resize(function() {
			$('.error').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 490) / 2
			});
		})
	});
</script>
<style type="text/css">
.t1 {
	clear: both;
	border: 1px solid #c9dae4;
}

.t1 tr th {
	color: #0d487b;
	background: #f2f4f8 url(../CSS/Table/images/sj_title_pp.jpg) repeat-x
		left bottom;
	line-height: 28px;
	border-bottom: 1px solid #9cb6cf;
	border-top: 1px solid #e9edf3;
	font-weight: normal;
	text-shadow: #e6ecf3 1px 1px 0px;
	padding-left: 5px;
	padding-right: 5px;
}

.t1 tr td {
	border-bottom: 1px solid #e9e9e9;
	padding-bottom: 5px;
	padding-top: 5px;
	color: #444;
	border-top: 1px solid #FFFFFF;
	padding-left: 5px;
	padding-right: 5px;
	word-break: break-all;
}
/* white-space:nowrap; text-overflow:ellipsis; */
tr.alt td {
	background: #ecf6fc; /*这行将给所有的tr加上背景色*/
}

tr.over td {
	background: #bcd4ec; /*这个将是鼠标高亮行的背景色*/
}
</style>
<script type="text/javascript">
	$(document).ready(function() { //这个就是传说的ready  
		$(".t1 tr").mouseover(function() {
			//如果鼠标移到class为stripe的表格的tr上时，执行函数  
			$(this).addClass("over");
		}).mouseout(function() {
			//给这行添加class值为over，并且当鼠标一出该行时执行函数  
			$(this).removeClass("over");
		}) //移除该行的class  
		$(".t1 tr:even").addClass("alt");
		//给class为stripe的表格的偶数行添加class值为alt
	});
</script>
<!-- a标签的样式 -->
<style>
.sel_btn {
	height: 21px;
	line-height: 21px;
	padding: 0 11px;
	background: #02bafa;
	border: 1px #26bbdb solid;
	border-radius: 3px;
	/*color: #fff;*/
	display: inline-block;
	text-decoration: none;
	font-size: 12px;
	outline: none;
}

.ch_cls {
	background: #e4e4e4;
}
</style>
<title>Insert title here</title>
</head>
<body style="background: #edf6fa;">
	<h2 style="color: gray">
		&nbsp;&nbsp;&nbsp;<a href="index.jsp">主页</a> > <a href="<%=basePath%>getAreaListServlet?nowPages=1">区域管理</a> > <a>${str}区域</a>
	</h2>

	<c:if test="${bj==1 }">
		<script type="text/javascript">
			alert("修改成功");
		</script>
	</c:if>
	<c:choose>
		<c:when test="${area.id>0 }">
			<form action="<%=basePath%>updateAreaServlet" method="post">
		</c:when>
		<c:otherwise>
			<form action="<%=basePath%>newAreaServlet" method="post">
		</c:otherwise>
	</c:choose>
	<ul>
		<li>区域名称</li>
		<li><input type="text" name="name" value="${area.name }">
		</li>
	</ul>
	<ul>
		<li>区域简介</li>
		<li><input type="text" name="info" value="${area.info }">
			<input type="hidden" value="${area.plateNum }" name="plateNum">
			<input type="hidden" value="${area.id }" name="id"></li>
	</ul>
	<input type="submit" value="提交">
	</form>
</body>
</html>