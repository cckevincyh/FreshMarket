<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	* {
		font-size: 11pt;
	}
	div {
		border: solid 2px rgb(78,78,78);
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
</style>


  </head>
  
  <body>
<h1>订单详情</h1>
<c:choose>
	<c:when test="${not empty orders and fn:length(orders)>0}">


<table border="1" width="100%" cellspacing="0" background="black">
	<c:forEach var="order" items="${orders }">
	<tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
		<td colspan="6">
			订单：${order.ordersID }　成交时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.orderTime }"/>　   　金额：<font color="red"><b>￥${order.total }</b></font>	
			         <a style="padding-left: 100px">订单状态:
			<c:choose>    
				<c:when test="${order.state eq 1 }">
					<a>未付款</a>
				</c:when>
				<c:when test="${order.state eq 2 }"><a href="<c:url value='/AdminOrderServlet?method=delivery&ordersID=${order.ordersID }'/>">发货</a></c:when>
				<c:when test="${order.state eq 3 }">
					<a>等待收货</a>
				</c:when>
				<c:when test="${order.state eq 4 }">已收货(完成)</c:when>
			</c:choose>
			</a>
		</td>
	</tr>
	  <c:forEach items="${order.orderItemList }" var="orderItem">
			<tr bordercolor="rgb(78,78,78)" align="center">
				<td width="15%">
					<div style="width: 100px; height: 100px"><img src="<c:url value='${orderItem.commodity.url }'/>"  height="75"/></div>
				</td>
				<td>商品名称：${orderItem.commodity.commodityName }</td>
				<td>商品种类：${orderItem.commodity.commodityType.commodityTypeName }</td>
				<td>单价：￥${orderItem.commodity.commodityPrice }</td>
				<td>数量：${orderItem.count }</td>
				<td>小计：￥${orderItem.subtotal}</td>
			</tr>
	</c:forEach>
  
</c:forEach>
</table>
	</c:when>
	<c:otherwise>
		<h1 align="center">暂无订单</h1>
	
	</c:otherwise>

</c:choose>
  </body>
</html>
