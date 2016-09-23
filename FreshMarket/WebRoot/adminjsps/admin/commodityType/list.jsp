<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分类列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	table {font-family: 宋体; font-size: 11pt; border-color: rgb(78,78,78);  }
	#th {background: rgb(78,78,78);}
</style>
    <script type="text/javascript">
		function deleteitem(id){
		
			var b = window.confirm("你确认删除吗??");
			if(b){
				window.location.href="${pageContext.request.contextPath}/CommodityTypeServlet?method=deleteCommodityType&commodityTypeID="+id;
			}
		}
	</script>
  </head>
  
  <body>
    <h2 style="text-align: center;">分类列表</h2>
    <table align="center" border="1" cellpadding="0" cellspacing="0" width="60%">
    	<tr id="th" bordercolor="rgb(78,78,78)">
    		<th>分类名称</th>
    		<th > 分类图片</th>
    		<th>操作</th>
    	</tr>
      <c:forEach var="commodityTypes" items="${commodityTypes }">
    	<tr bordercolor="rgb(78,78,78)">
    		<td >${commodityTypes.commodityTypeName }</td>
    		<td align="center"><img src="${commodityTypes.typeUrl}" width="100" height="90"/></td>
    		<td >
    		  <a href="<c:url value='/CommodityTypeServlet?method=findCommodityType&commodityTypeID=${commodityTypes.commodityTypeID }'/>">修改</a> |
    		  <a href="javascript:void(0)" onclick="deleteitem(${commodityTypes.commodityTypeID})">删除</a>
    		</td>
    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
