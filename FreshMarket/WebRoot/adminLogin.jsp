<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
		<link href='<c:url value="/css/style2.css"></c:url>' rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript">
			 addEventListener("load", function() { 
			 setTimeout(hideURLbar, 0); 
			 }, false); 
			 function hideURLbar(){
				  window.scrollTo(0,1);
			 } 
			 
			 
			
        </script>
        
		




</head>
<body>
	<div class="main">
		<div class="header" >
			<h1>新鲜购后台登陆界面</h1>
		</div>
	
			<form action='<c:url value="AdminServlet?method=login"></c:url>' method="post">
			  <ul class="right-form">
			    <h2>管理员登陆：</h2>
					<div>
					  <li><input type="text"  name="username"  value="${admin.username }" placeholder="请输入用户名" required/>
					  </li>
					  <li> <input type="password" name="password" value="${admin.password }"placeholder="请输入密码" required/>
					   	
					  </li>
						<span style="color:#F00">${errorMessage }</span>
							<input type="submit"  value="登陆" >
				</div>
				<div class="clear"> </div>
			  </ul>
				<div class="clear"> </div>
					
	  </form>
			
		</div>
		

	
</body>
</html>