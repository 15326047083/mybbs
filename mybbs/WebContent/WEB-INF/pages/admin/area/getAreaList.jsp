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
		&nbsp;&nbsp;&nbsp;<a href="index.jsp">主页</a> > <a>区域管理</a>
	</h2>
	${script}
	<div class="table_div">
		<div class="div_clear">

			<div class="left_top"></div>
			<div class="center_top">

				<div style="float: right; padding-right: 6px">
					<a class="sel_btn ch_cls"
						href="<%=basePath%>toAreaServlet?flag=new">新增</a>&nbsp;
				</div>
			</div>
			<div class="right_top"></div>
		</div>
		<div class="div_clear">
			<div class="left_center"></div>
			<div class="center_center">
				<div class="table_content">
					<table cellspacing="0px" cellpadding="0px">
						<thead>
							<tr>
								<th width="16%">区域名称</th>
								<th width="16%">区域简介</th>
								<th width="16%">版块数量</th>
								<th width="20%" style="border-right: none">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="area" items="${commonPages.commonList }"
								varStatus="loop">
								<tr>
									<td width="16%">${area.name }</td>
									<td width="16%">${area.info }</td>
									<td width="16%">${area.plateNum }</td>
									<td width="20%" style="border-right: none"><a
										href="<%=basePath %>getPlateListServlet?areaId=${area.id}&nowPages=1">查看板块</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="toAreaServlet?id=${area.id}&flag=update">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a
										href="deleteAreaServlet?id=${area.id}&plateNum=${area.plateNum }">删除</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<div align="right">
					<a class="sel_btn ch_cls"
						href="<%=basePath%>getAreaListServlet?nowPages=1">首页</a>
					<c:choose>
						<c:when test="${nowPages!=1 }">
							<a class="sel_btn ch_cls"
								href="<%=basePath%>getAreaListServlet?nowPages=${nowPages-1}">上一页</a>
						</c:when>
						<c:otherwise>
							<a class="sel_btn ch_cls" href="javascript:return false;"
								onclick="return false;" style="cursor: default;"><i
								class="edit" style="opacity: 0.2"></i>上一页</a>
						</c:otherwise>
					</c:choose>
					<a> ${nowPages}</a>/<a>${commonPages.totalpages} </a>
					<c:choose>
						<c:when test="${nowPages!=commonPages.totalpages }">
							<a class="sel_btn ch_cls"
								href="<%=basePath%>getAreaListServlet?nowPages=${nowPages+1}">下一页</a>
						</c:when>
						<c:otherwise>
							<a class="sel_btn ch_cls" href="javascript:return false;"
								onclick="return false;" style="cursor: default;"><i
								class="edit" style="opacity: 0.2"></i>下一页</a>
						</c:otherwise>
					</c:choose>
					<a class="sel_btn ch_cls"
						href="<%=basePath%>getAreaListServlet?nowPages=${commonPages.totalpages}">尾页</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>