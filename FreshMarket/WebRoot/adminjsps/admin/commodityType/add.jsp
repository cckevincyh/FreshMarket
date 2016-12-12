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

<script type="text/javascript">
    		function _onClick(){
    			var isOK = true;
    			var cn = document.getElementById("cn").value;
    			var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");
    			if(cn.trim()==""){
    				alert("商品种类不能为空!!!");
    				isOK = false;
    			}else if(!reg.test(cn)){
    				alert("商品种类名称必须为中文!!");
    				isOK = false;
    			}
    			
    			return isOK;
    		} 
    		
    		
    		
    		
    		
    </script>


  </head>
  
  <body>
    <h1>添加分类</h1>
    <form action="<c:url value='/AdminCommodityTypeServlet?method=addCommodityType'/>" method="post">
    	分类名称:<input id="cn" type="text" name="commodityTypeName"><br>
    	<input type="submit" value="添加" onclick="javascript:return _onClick()">
    
    </form>
  </body>
</html>
