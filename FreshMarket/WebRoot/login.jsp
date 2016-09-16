<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript">
			 addEventListener("load", function() { 
			 setTimeout(hideURLbar, 0); 
			 }, false); 
			 function hideURLbar(){
				  window.scrollTo(0,1);
			 } 
			 
			 
			
        </script>
<!--webfonts-->
		<!--//webfonts-->
</head>
<body>
	<div class="main">
		<div class="header" >
			<h1>Login or Create a Free Account!</h1>
		</div>
		<p>Lorem iopsum dolor sit amit,consetetur sadipscing eliter,sed diam voluptua.At vero  eso et accusam et justo duo dolores et ea rebum. </p>
			<form action='<c:url value="/LoginServlet"></c:url>' method="post">
			  <ul class="right-form">
			    <h3>登陆：</h3>
					<div>
					  <li><input type="text"  name="username"  value="${user.username }" placeholder="用户名" required/>
					  </li>
					  <li> <input type="password" name="userpassword" value="${user.userpassword }"placeholder="密码" required/>
					   	
					  </li>
						<h3 style="color:#F00">${errorMessage }</h3>
							<input type="submit" onClick="myFunction()" value="登陆" >
				</div>
				<div class="clear"> </div>
			  </ul>
				<div class="clear"> </div>
					
	  </form>
			
		</div>
		

	
</body>
</html>