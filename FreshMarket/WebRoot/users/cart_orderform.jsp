
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html><head>
 <title>订单处理</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="description" content="">
 <meta name="format-detection" content="telephone=no">
 <meta name="">
 
<link rel="stylesheet" href="<c:url value='/users/css/tasp.css'/>">
<link href="<c:url value='/users/css/orderconfirm.css'/>" rel="stylesheet">



<script type="text/javascript">

<c:if test="${not empty message}">
	window.onload = function(){
		
			alert("${message}");
		
	}
</c:if>

	function click1(){
		<c:if test='${ empty sessionUser.address and empty sessionUser.phone}'>
			alert("请完善个人信息");
		 </c:if>
		 <c:if test='${not empty sessionUser.address  and not empty sessionUser.phone}'>
		parent.location.href="${pageContext.request.contextPath}/OrderServlet?method=add";
		</c:if>
	}

</script>


</head>
<body data-spm="1">
<%--判断购物车是否为空 --%>
	<c:choose>
 <c:when test="${not empty sessionScope.cart.cartItems  and fn:length(sessionScope.cart.cartItems)>0}">
	

<div id="page">

 <div id="content" class="grid-c">

  <div id="address" class="address" style="margin-top: 20px;" data-spm="2">
<form name="addrForm" id="addrForm" action="#">
<h3>确认收货地址
 <span class="manage-address">
 <c:if test='${not empty sessionUser.address }'>
 <a href="<c:url value='/users/changeAddress.jsp'/>" title="修改收货地址" class="J_MakePoint" >修改收货地址</a>
 </c:if>
 </span>
</h3>
<ul id="address-list" class="address-list">
    
 <s class="J_Marker marker"></s>
 <span class="marker-tip">寄送至:</span>
   <div class="address-info">
 <a class="user-address">
 	<c:if test='${not empty sessionUser.address  and not empty sessionUser.phone}'>
       ${sessionUser.address } <em>/${sessionUser.phone }</em>
 	</c:if>
 	<c:if test='${ empty sessionUser.address and empty sessionUser.phone}'>
      <h1><a href="<c:url value='/UserServlet?method=findUser&username=${sessionUser.username }'/>">>去完善信息</a></h1>
 	</c:if>
   </a>

 
 </div>
    



</form>
</div>


           <div>
 <h3 class="dib">确认订单信息</h3>
 <table class="order-table" id="J_OrderTable" summary="统一下单订单信息区域" cellpadding="0" cellspacing="0">
 <caption style="display: none">统一下单订单信息区域</caption>
 <thead>
 <tr>
 <th class="s-title">商品信息<hr></th>
 <th class="s-price">商品种类<hr></th>
 <th class="s-amount">单价(元)<hr></th>
 <th class="s-agio">数量<hr></th>
 <th class="s-total">小计(元)<hr></th>
 </tr>
 </thead>
     

<!-- -------------- -->

		<%--循环购物车 --%>
<c:forEach var="cartItems" items="${sessionScope.cart.cartItems}">
 <td colspan="3">
   
     
     
    
    </td>
 <td colspan="2" class="promo">
 <div>
   <ul class="scrolling-promo-hint J_ScrollingPromoHint">
       </ul>
   </div>
 </td>
</tr>
 <tr class="item" data-lineid="19614514619:31175333266:35612993875" data-pointrate="0">
 <td class="s-title">
 <!-- 商品图片 -->
     <img src="${cartItems.commodity.url }" class="itempic" style="height:100px; width:100px"/>

   <div class="props">
     <span>	${cartItems.commodity.commodityName}</span>
<br><br><br><br>
         </div>
</a>
    <div>
 <span style="color:gray;">卖家承诺1小时内发货</span>
 </div>
     </td>
 <td class="s-price">
   
  <span class="price ">
 <em class="style-normal-small-black J_ItemPrice">${cartItems.commodity.commodityType.commodityTypeName}</em>
  </span>
<input name="costprice" value="630.00" class="J_CostPrice" type="hidden">
</td>
 <td class="s-amount" data-point-url="">
         <input class="J_Quantity" value="1" name="19614514619_31175333266_35612993875_quantity" type="hidden">￥${cartItems.commodity.commodityPrice }
 
 </td>
 <td class="s-agio">
       <div class="J_Promotion promotion">${cartItems.count}</div>
   </td>
 <td class="s-total">
   
   <span class="price ">
 <em class="style-normal-bold-red J_ItemTotal ">￥${cartItems.subtotal}</em>
  </span>
    <input id="furniture_service_list_b_47285539868" name="furniture_service_list_b_47285539868" type="hidden">
 </td>
</tr>



<tr class="item-service">
 <td colspan="5" class="servicearea" style="display: none"></td>
</tr>

<tr class="blue-line" style="height: 2px;"><td colspan="5"></td></tr>
<tr class="other other-line">
 <td colspan="5">
 <ul class="dib-wrap">
 <li class="dib user-info">
 <ul class="wrap">
 <li></li>
   </ul>
 </li>
 <li class="dib extra-info">
   <div class="servicearea" style="display: none"></div>
 </li>
 </ul>
 </td>
</tr>

</c:forEach>

<!-- -------------- -->

<tr class="shop-total blue-line">
 <td colspan="5">商品合计(<span class="J_Exclude" style="display: none"></span>不含运费，服务费<span class="J_ServiceText" style="display: none"></span>)：
   <span class="price g_price ">
 <span>¥</span><em class="style-middle-bold-red J_ShopTotal">${sessionScope.cart.total}</em>
  </span>
  <input name="1704508670:2|creditcard" value="false" type="hidden">
<input id="J_IsLadderGroup" name="isLadderGroup" value="false" type="hidden">

   </td>
</tr>
</tbody>
  <tfoot>
 <tr>
 <td colspan="5">

<div class="order-go" data-spm="4">
<div class="J_AddressConfirm address-confirm">
 <div class="kd-popup pop-back" style="margin-bottom: 40px;">
 <div class="box">
 <div class="bd">
 <div class="point-in">
   
   <em class="t">实付款：</em>  <span class="price g_price ">
 <span>¥</span><em class="style-large-bold-red" id="J_ActualFee">${sessionScope.cart.total}</em>
  </span>
</div>

  <ul>
 <li><em>寄送至:</em><span id="J_AddrConfirm" style="word-break: break-all;">
    ${sessionUser.address }
   </span></li>
 <li><em>收货人:</em><span id="J_AddrNameConfirm"> ${sessionUser.username }  ${sessionUser.phone } </span></li>
 </ul>
     </div>
 </div>
 
         <a href="<c:url value='/users/shoppingCart.jsp'/>" class="back J_MakePoint" target="_parent" style="font-size: 11px" >返回购物车</a>
      
      <button id="J_Go" class="btn-go" tabindex="0" title="点击此按钮，提交订单。" style="background-color:#F60; height:33px;" onclick="click1()">提交订单</button>
 
  </div>
 </div>



 <div class="msg" style="clear: both;">

 </div>
 </div>
 </td>
 </tr>
 </tfoot>
 </table>
</div>
  

</form></div>

<div id="footer"></div>
</div>
<div style="text-align:center;">
</div>
</c:when>
<c:otherwise>
		<ul>
				<h1 class="txt" align="center">客官你还没有购买商品，暂无订单~</h1>
				<li>
					<h2 align="center">
					<a href="<c:url value='/index.jsp'/>" class="btn-link" title="去购物" target="_parent">去购物&gt;</a>
					</h2>
				</li>
			</ul>
</c:otherwise>
	</c:choose>

</body></html>