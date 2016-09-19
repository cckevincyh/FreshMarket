<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>新鲜购主页</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/banner.css">
<script src="script/banner.js" type="text/javascript"></script>
</head>

<body>
<!--header start-->
<div class="header fl">
	<div class="wrap">
    	<div class="logo_H fl"><img src="images/index/banner/beans.jpg" width="66" height="45">
        </div>
        
        <div class="search_H fl"></div>
        
        <div class="nav_H fr">
        	<div class="navL fl">
        	
        	
        		<c:choose>
            		<c:when test="${not empty sessionUser }">
            			<a href="#"><!--个人信息-->
            		</c:when>
            		<c:otherwise>
            			<a href="login.jsp"><!-- 登陆界面 -->
            		</c:otherwise>
            	</c:choose>
        	
            	<c:choose>
            		<c:when test="${not empty sessionUser }">
            			${sessionUser.username }
            		</c:when>
            		<c:otherwise>
            			登陆
            		</c:otherwise>
            	</c:choose>
            	
            </a>
            </div>
            
            <div class="navM fl">
            <a href="register.jsp">注册</a>
            </div>
            
            <div class="navR fl">
            <a href="LoginOutServlet">退出</a>
            </div>
        </div>
    </div>
</div>
<!--header end-->

<!--banner start-->
<div class="wrap">
<div class="Banner fl" id="slideContainer">
  <div id="frameHlicAe" class="frame cl">
    <div class="temp"></div>
      <div class="block">
        <div class="cl">
          <ul class="slideshow" id="slidesImgs">
            <li><a href="#" target="_blank">
                <img src="images/index/banner/1.jpg" width="1180" height="570" alt="" /></a>
            <li><a href="#" target="_blank">
                <img src="images/index/banner/2.jpg" width="1180" height="570" alt="" /></a>
            <li><a href="#" target="_blank">
                <img src="images/index/banner/3.jpg" width="1180" height="570" alt="" /></a>
            <li><a href="#" target="_blank">
                <img src="images/index/banner/4.jpg" width="1180" height="570" alt="" /></a>
            <li><a href="#" target="_blank">
                <img src="images/index/banner/5.jpg" width="1180" height="570" alt="" /></a>
            <li><a href="#" target="_blank">
                <img src="images/index/banner/6.jpg" width="1180" height="570" alt="" /></a>      
           </ul>
         </div>
         <div class="slidebar" id="slideBar">
           <ul>
             <li class="on">1</li>
             <li>2</li>
             <li>3</li>
             <li>4</li>
             <li>5</li>
             <li>6</li>
           </ul>
        </div>
     </div>
  </div>
</div>
</div>
<script type="text/javascript">
  SlideShow(2000);
</script>
<!--banner end-->

<!--content start-->
<div class="content fl">
	<div class="wrap">
    	<div class="CSF fl">
        	<div class="baoyou fl">
            运送范围</div>
            
            <div class="seven fl">
            7天无理由退货
            </div>
            
            <div class="free fl">
           退货免运费
            </div>
        </div>
        <!--warm start-->
        <div class="title fl">
        精品推荐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </div>
        <div class="boxM fl">
            <a href="#"><div class="boxSD" style="background:url(images/index/Food_classification/beans.jpg)">
            <div class="explanSF">
            
            </div>
            </div></a>
            <a href="#"><div class="boxSA" style="background:url(images/index/Food_classification/vegetable.jpg)">
            <div class="explanSF">
            
            </div>
            </div></a>
      </div>
            
      <div class="boxM fl">
            <a href="#"><div class="boxST" style="background:url(images/index/Food_classification/meat.jpg)">
            <div class="explanSF">
            
            </div>
            </div></a>
            <a href="#"><div class="boxSB" style="background:url(images/index/Food_classification/mix-fruit.jpg)">
            <div class="explanSF">
           
            </div>
            </div></a>
            </div>
            <div class="boxM fl">
            <a href="#"><div class="boxSD" style="background:url(images/index/Food_classification/mushroom.jpg)">
            <div class="explanSF">
           
            </div>
            </div></a>
            <a href="#"><div class="boxSA" style="background:url(images/index/Food_classification/rice-meat_dumplings.jpg)">
            <div class="explanSF">
            </div>
            </div></a>
            </div>
	</div>
        <!--warm end-->
        <!--hot start--><!--hot end-->
        <!--home start--><!--home end-->
        <!--bottom start--><!--bottom end-->
        <!--fleece start--><!--fleece end-->
        <!--knit start--><!--knit end--> 
    </div>
</div>
<!--content end-->

<!--footer start--><!--footer end-->
</body>
</html>
