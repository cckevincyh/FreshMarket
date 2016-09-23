<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">

</style>
  </head>
  
  <body>
    <h1>添加分类</h1>
    <form action="<c:url value='/CommodityTypeServlet?method=addCommodityType'/>" method="post" enctype="multipart/form-data">
    	分类名称:<input type="text" name="commodityTypeName"><br>
    	分类图片:<input type="file" name="image"/><br/>
    	<input type="submit" value="添加">
    
    </form>
  </body>
</html>
