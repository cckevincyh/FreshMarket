<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN" style="height: 100%; overflow: hidden;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>购物车 </title>

<meta name="Keywords" content="">
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">

<link rel="icon" type="image/x-icon" href="http://images.68dsw.com/system/config/website/favicon_0.jpg">
<link rel="shortcut icon" type="image/x-icon" href="http://images.68dsw.com/system/config/website/favicon_0.jpg">

<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/flow.css">
<script type="text/javascript" src="css/jquery.js"></script>
<script type="text/javascript" src="css/jquery.cookie.js"></script>
<link rel="stylesheet" href="css/layer.css" id="layui_layer_skinlayercss"><link rel="stylesheet" href="css/layer.ext.css" id="layui_layer_skinlayerextcss">


<script type="text/javascript">
	function deleteitem(id){
		var b = window.confirm("你确定该商品删除吗??");
		if(b){
			parent.location.href="${pageContext.request.contextPath}/CartServlet?method=delete&commodityID="+id;
		}
	}
	
	function clearcart(count){
		var b = window.confirm("你确定清空购物车吗?");
		if(b){
			parent.location.href="${pageContext.request.contextPath}/CartServlet?method=clear";
		}
	}
	
	
	function changQuantity(input,id,oldvalue){
		var quantity = input.value;//得到要修改的数量
		//检查用户输入的数量是不是一个数字
		//检查用户输入的数量是不是一个正整数
		if(quantity<=0||quantity!=parseInt(quantity)){
			alert("请输入正整数!!");
			input.value = oldvalue;
			return ;
		}
		var b = window.confirm("您确认把书的数量改为："+quantity);
		if(b){
			parent.location.href="${pageContext.request.contextPath}/CartServlet?method=changeQuantity&commodityID="+id+"&quantity="+quantity;
		}else{
			input.value = oldvalue;
		}
	}
	
	
	function addQuantity(id,cid){
		var quantity = document.getElementById(id).value//得到要修改的数量
		parent.location.href="${pageContext.request.contextPath}/CartServlet?method=changeQuantity&commodityID="+cid+"&quantity="+(parseInt(quantity)+1);
		
	}
	
	
	function removeQuantity(id,cid){
		var quantity = document.getElementById(id).value//得到要修改的数量
		if(parseInt(quantity)>0){
			parent.location.href="${pageContext.request.contextPath}/CartServlet?method=changeQuantity&commodityID="+cid+"&quantity="+(parseInt(quantity)-1);
			
		}
		if(parseInt(quantity)<=1){
			window.location.href="${pageContext.request.contextPath}/CartServlet?method=delete&commodityID="+cid;
		}
	}
	
	
	function click1(id){
		parent.location.href="${pageContext.request.contextPath}/users/cart_orderform.jsp";
	}
	
	
</script>



</head>
<body>


<div class="header">
	<div class="w1210"></div>
</div>

</script>

	<div class="w990" id="content"><div class="content">
		<div class="cart-filter-bar">
		<div class="switch-cart" id="cart_num">
			
			
			
			
<%--判断购物车是否为空 --%>
	<c:choose>
 <c:when test="${not empty sessionScope.cart.cartItems  and fn:length(sessionScope.cart.cartItems)>0}">
	
<span>
	我的购物车
	<em class="color">${sessionScope.cart.totalCount }</em>
</span>

			
		</div>
	</div>
	<div class="cart-main">
		<div class="cart-table-th">
			<div class="wp">
				<div class="th th-chk">
					<div class="select-all">
						<div class="cart-checkbox all-checkbox select">
						<!-- <input type="checkbox" name="" value="true"> --></div>
					</div>
				</div>
				<div class="th th-item">
					<div class="td-inner">商品信息</div>
				</div>
				<div class="th th-info">
					<div class="td-inner">&nbsp;商品种类</div>
				</div>
				<div class="th th-price">
					<div class="td-inner">单价（元）</div>
				</div>
				<div class="th th-amount">
					<div class="td-inner">数量</div>
				</div>
				<div class="th th-sum">
					<div class="td-inner">金额（元）</div>
				</div>
				<div class="th th-op">
					<div class="td-inner">操作</div>
				</div>
			</div>
		</div>



		<%--循环购物车 --%>
<c:forEach var="cartItems" items="${sessionScope.cart.cartItems}">

		
		<div id="cart_list" align="center">
		<div class="shop">
	<div class="shop-info"></div>
</div>
<div class="order-content">
	<div class="item-list">
		<div class="bundle bundle-last">
			<!-- 各个店铺下的信息 -->
						
			<div id="cart_shop_6" class="order-body">
			
</div>	





<div class="order-content">
	<div class="item-list">
		<div class="bundle bundle-last">
			<!-- 购物车中商品列表 -->
						<div class="item-holder" id="cartid2251">
				
				

<div class="item-body    last-item">
	<ul class="item-content clearfix goods_2251_155">
		<li class="td td-chk">
			<div class="td-inner">
								<div class="cart-checkbox goods-checkbox select" data-shop-id="6">
					
										
					
			
				</div>
							</div>
		</li>
		<li class="td td-item">
			<div class="td-inner">
				<div class="item-pic">
					<a href="#" target="_blank" class="">
					<%-- 商品图片 --%> 
						<img src="${cartItems.commodity.url }" class="itempic">
					</a>
				</div>
				<div class="item-info">
					<div class="item-basic-info">
						<a href="#" target="_blank" title="${cartItems.commodity.commodityName}" class="item-title">
							
							${cartItems.commodity.commodityName}
						</a>
					</div>
									</div>
			</div>
		</li>
		<li class="td td-info">
		  <div class="td-inner">
		    <div class="item-info">
		      <div class="item-basic-info">${cartItems.commodity.commodityType.commodityTypeName}</div>
		      </div>
		    </div>
					</li>
		<li class="td td-price">
			<div class="td-inner">
				<div class="item-price">
					<div class="price-content">
	
						<div class="price-line">
							<em class="price-now">￥${cartItems.commodity.commodityPrice }</em>
						</div>
					</div>
				</div>
			</div>
		</li>
		<li class="td td-amount">
			<div class="td-inner">
				<div class="amount-wrapper">
					<div class="item-amount">
						<!--   -->
						<span class="amount-widget amount">
							<input id="${cartItems.commodity.commodityID }" type="text"  onchange="changQuantity(this,${cartItems.commodity.commodityID},${cartItems.count})"   class="amount-input" value="${cartItems.count}" data-goods-number="${cartItems.count }" data-sku-id="155" id="number2251" data-amount-min="1" data-amount-max="2" maxlength="8" title="请输入购买量">
							<span class="amount-btn">
								<span class="amount-plus">
									<i onclick='addQuantity(${cartItems.commodity.commodityID },${cartItems.commodity.commodityID})'>+</i>
								</span>
								<span class="amount-minus">
									<i onclick='removeQuantity(${cartItems.commodity.commodityID },${cartItems.commodity.commodityID})'>-</i>
								</span>
							</span>
						</span>
						<!-- <a href="javascript:void(0)" class="minus" id="minus" data="">-</a>
						<input type="text" id="number" value="" class="text text-amount" data="" data-max="1406" data-now="1" autocomplete="off">
						<a href="javascript:void(0)" class="no-plus" id="plus" data="">+</a> -->
						
					</div>
					
										
					<div class="amount-msg" style="display:none">
						
						
					</div>
				</div>
			</div>
		</li>
		<li class="td td-sum">
			<div class="td-inner">
				<em class="number">￥${cartItems.subtotal}</em>
			</div>
		</li>
		<li class="td td-op">
			<div class="td-inner">
				<a href="javascript:void(0)" class="del"  onclick="deleteitem(${cartItems.commodity.commodityID })" data-cart-id="2251">删除</a>
			</div>
		</li>
	</ul>
</div>
<!-- 赠品 -->
</div></div></div></div></div></div></div>
	
	
</c:forEach>


	
	
	
	<!-- 购物车统计 -->
	<div class="cart-foot">
		<div class="cart-foot-wrapper">
			<div class="select-all"></div>
			<div class="operations">
				<a href="javascript:void(0)" class="del"  onclick="clearcart(${sessionScope.cart.totalCount })">清空购物车</a>
			
			</div>
			<div class="cart-bar-right" id="cart_count">
				<!-- 购物车金额 -->
				<div class="amount-sum">
	
	<em class="SZY-CART-SELECT-GOODS-NUMBER">${sessionScope.cart.totalCount }</em>
	<span class="txt">件</span>
</div>
<div class="price-sum">
	<span class="txt">合计（不含运费）:</span>
	<strong class="price SZY-CART-SELECT-GOODS-AMOUNT">￥${sessionScope.cart.total}</strong>
</div>
<div class="btn-area">
	<a href="javascript:void(0)" class="submit-btn">
		<span onclick="click1(${sessionScope.cart.total})">结 算</span>
	</a>
</div>
				
			</div>
		</div>

	</div>

	</div>
</div>



	

</c:when>
<c:otherwise>
		<ul>
				<h1 class="txt" align="center">购物车还是空空的呢，快去看看心仪的商品吧~</h1>
				<li>
					<h2>
					<a href="<c:url value='/index.jsp'/>" class="btn-link" title="去购物" target="_parent">去购物&gt;</a>
					</h2>
				</li>
			</ul>
</c:otherwise>
	</c:choose>
	
	
</body></html>