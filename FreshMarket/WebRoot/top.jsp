<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="css/common.css" />
<link type="text/css" rel="stylesheet" href="css/category.css" />
<link type="text/css" rel="stylesheet" href="css/iconfont.css" />
<link type="text/css" rel="stylesheet" href="css/layer.css" />
<link type="text/css" rel="stylesheet" href="css/layer.ext.css" />



<script type="text/javascript" src="<c:url value='/ajax-lib/ajaxutils.js'/>"></script>
    <script type="text/javascript">
    window.onload = new function(){
    	ajax(
    		  {
	    		url:"<c:url value='/AdminCommodityTypeServlet?method=getAllCommodityType'/>",
	    		callback:function(data) {
						var arr = data.split(",");
						// 循环遍历每个商品(种类编号:商品种类名称)，每个名称生成一个option对象，添加到<select>中
						var commoditytype = document.getElementById("commoditytype")
							for(var i = 0; i < arr.length; i++) {
								var aa = arr[i].split(":");
								var li = document.createElement("li");//创建一个指名名称元素
								var a = document.createElement("a");//创建一个指名名称元素
								a.value = aa[0];//设置op的实际值为当前的商品种类编号
								var textNode = document.createTextNode(aa[1]);//创建文本节点
								a.setAttribute("class","nav");	//添加样式
								a.setAttribute("href","<c:url value='CommodityServlet?method=queryCommodity&commodityTypeID="+aa[0]+"'/>");
								a.setAttribute("target","body");
								a.appendChild(textNode);//把文本子节点添加到a元素中，指定其显示值
								li.appendChild(a);
								if(commoditytype!=undefined)
								commoditytype.appendChild(li);
								
							}
					}
			   }
    	);
    };
    
    
    </script>


</head>

<body style="height:190px">
<div class="header-top">
	<div class="header-box">
    <div class="SZY-SUBSITE"><!--站点 start-->

<!--站点 end--></div>
    
    <ul>
			<!-- 不存在站点显示在左侧 -->
			
			<li><font id="login-info" class="login-info SZY-USER-NOT-LOGIN">
	<em>欢迎来到新鲜购! </em>
	
		<c:choose>
      		<c:when test="${not empty sessionUser }">
      			<a class="login color" >${sessionUser.username }</a>
      		</c:when>
      		<c:otherwise>
      			<a class="login color" href="<c:url value='/login.jsp'/>" target="_top">请登录</a>
    	<a class="register" href="<c:url value='/register.jsp'/>" target="_top">免费注册</a>
      		</c:otherwise>
      	</c:choose>
      	
	
</font>
<font id="login-info" class="login-info SZY-USER-ALREADY-LOGIN" style="display: none;">

</font></li>
			

			
			
      
	<c:if test="${not empty sessionUser }">
			<li class="menu-item">
						<div class="menu">
							<a class="menu-hd myinfo">我的信息</a>
							<div id="menu-2" class="menu-bd">
								<div class="menu-bd-panel">
									<a href="<c:url value='/OrderServlet?method=myOrders'/>" target="body">我的订单</a>
									<a href="<c:url value='/users/changePassword.jsp'/>" target="_parent">修改密码</a>
									<a href="<c:url value='/UserServlet?method=findUser&username=${sessionUser.username }'/>" >修改个人信息 </a>
								</div>
							</div>
		      <li>
				<a class="menu-hd" href="<c:url value='UserServlet?method=loginOut'/>" target="_parent">退出</a>
		 </li>
	</c:if>
	 
      
  </ul>
</div>
<div class="header">
	<div class="w1210">
		<div class="logo-info">
			<a href="#" class="logo">
				<img src="img/11.png">
			</a>
		</div>
		<div class="search SZY-SEARCH-BOX">
<form class="search-form" id="searchForm" method="post" action="<c:url value='/CommodityServlet?method=queryCommodity'/>" target="body">
				<div class="search-info">
					<ul class="search-type">
						<li class="search-li cur" num="0">商品</li>
						
					</ul>
					<div class="search-box">
						<div class="search-box-con">
														<input type="text" class="search-box-input" id="keyword" name="commodityName" tabindex="9" autocomplete="off" data-searchwords="" placeholder="" >
						</div>
					</div>
					<input type="hidden" id="commodityName" name="commodityTypeID" value="-1">
					<input type="submit" id="btn_search_box_submit" value="搜索" class="button bg-color">
				</div>
				
</form>


		</div>
		
		<div class="header-right">
			<!-- 购物车 -->
			
			
<c:if test="${not empty sessionUser }">
	<div class="cartbox">
		<div class="cart-icon cartbox-handle">
			<i class="cart-left"></i>
			<i class="cart-right">&gt;</i>
			<!-- 购物车商品数量 -->
			<c:if test="${not empty sessionScope.cart.totalCount and sessionScope.cart.totalCount>0 }">
				<i class="cart-count SZY-CART-COUNT">${sessionScope.cart.totalCount }</i>
			</c:if>
			<a href="<c:url value='/users/shoppingCart.jsp'/>" target="_parent">我的购物车</a>
		</div>
		
			<div class="spacer"></div>
			
	</div>
	
	</c:if>	
	
			</div>
			
		</div>
	</div>


		<div class="category-box category-box-border">
            <div class="all-category fl" id="nav">
                <ul>
                    
                    <li>
                        <a class="nav current"   title="分类">全部分类</a>
                    </li>
                    
                    <div id="commoditytype">
	                    
                  </div>
                </ul>
			</div>
		</div>
<div class="blank"></div>



</body>
</html>
