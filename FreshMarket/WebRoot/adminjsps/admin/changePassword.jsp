<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>修改密码</h1>
    <form action="<c:url value='/AdminServlet?method=changePassword'/>" method="post">
    	<input type="hidden" name="username" value="${sessionUser.username }">
    	原密码:<input type="password" name="oldpassword" value="${form.oldpassword }"><span style="color: red">${errors.oldpassword }</span><br>
    	新密码:<input type="password" name="newpassword1" value="${form.newpassword1 }"><span style="color: red">${errors.newpassword1 }</span><br>
    	确认密码：<input type="password" name="newpassword2" value="${form.newpassword2 }"><span style="color: red">${errors.newpassword2 }</span><br>
    	<input type="submit" value="修改">
    </form>
  </body>
</html>
    