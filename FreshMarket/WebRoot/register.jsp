<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<link href="css/style2.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript">
	 		addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); 
			function hideURLbar(){ window.scrollTo(0,1); }
			
 		</script>
 		
 		<script type="text/javascript">
			//点击切换验证码
			function _change() {
				/*
				1. 获取<img>元素
				*/
				var ele = document.getElementById("vCode");
				ele.src = "<c:url value='/VerifyCodeServlet'/>?xxx=" + new Date().getTime();
				
			}
		</script>
	
</head>
<body>
	<div class="main">
		<div class="header" >
			<h1>Login or Create a Free Account!</h1>
		</div>
		<p>Lorem iopsum dolor sit amit,consetetur sadipscing eliter,sed diam voluptua.At vero  eso et accusam et justo duo dolores et ea rebum. </p>
		
			<form action='<c:url value="/RegisterServlet"></c:url>' method="post">
				<ul class="left-form">
					<h2>注册：</h2>
					<li>
						<input type="text"  name="username" value="${registerForm.username }" placeholder="输入用户名" required/>
						<div class="clear"><h2 style="color:#F00">${errors.username } </h2> </div>
					</li> 

					<li>
						<input type="password" name="userpassword" value="${registerForm.userpassword }"  placeholder="输入密码" required/>
	
						<div class="clear"> <h2 style="color:#F00">${errors.userpassword } </h2></div>
					</li> 
					<li>
						<input type="password" name="userpassword2"  value="${registerForm.userpassword2 }" placeholder="输入确认密码" required/>
							
						<div class="clear"> <h2 style="color:#F00">${errors.userpassword2 } </h2></div>
					</li> 
                    <li>
						<input type="text"  name="verifyCode"  value="${registerForm.verifyCode }" placeholder="输入验证码" required/>
							<!-- 验证码 -->
							<img src='<c:url value="/VerifyCodeServlet"></c:url>' id="vCode" alt="验证码" bottom" style="cursor:pointer;" title="看不清可单击图片刷新" onclick="javascript:_change()" />

						<div class="clear">  <h2 style="color:#F00">${errors.verifyCode } </h2></div>
					</li> 
					<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>记住密码</label>
					<input type="submit" onClick="myFunction()" value="注册">
						<div class="clear"> </div>
				</ul>
				<div class="clear"> </div>
					
			</form>
			
		</div>
			

	
</body>
</html>