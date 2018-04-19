<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
   + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=request.getContextPath() %>/js/admin/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=request.getContextPath() %>/js/admin/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(<%=request.getContextPath()%>/js/admin/images/topbg.gif) repeat-x;">

    <div class="topleft">
    </div>
        
   
            
    <div class="topright">    
    <ul>
    <li><a href="#">关于</a></li>
    <li><a href="" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    
    </div>    
    
    </div>
</body>
</html>
