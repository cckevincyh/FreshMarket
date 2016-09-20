<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<link href='<c:url value="/css/style.css"></c:url>' rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript">
			 addEventListener("load", function() { 
			 setTimeout(hideURLbar, 0); 
			 }, false); 
			 function hideURLbar(){
				  window.scrollTo(0,1);
			 } 
			
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
<!--webfonts-->
		<!--//webfonts-->
</head>
<body>
	<div class="main">
		<div class="header" >
			<h1>Login or Create a Free Account!</h1>
		</div>
		<p>Lorem iopsum dolor sit amit,consetetur sadipscing eliter,sed diam voluptua.At vero  eso et accusam et justo duo dolores et ea rebum. </p>
			<form action='<c:url value="/UserServlet?method=register"></c:url>' method="post">
			  <ul class="right-form">
			    <h2>注册:</h2>
					<div>
					  <li><input type="text" name="username" value="${registerForm.username }" placeholder="请输入用户名"  required"/>
					  </li>
                      
                      <span style="color:#F00">${errors.username }</span>
                      
					  <li> <input type="password" name="password" value="${registerForm.userpassword }" placeholder="请输入密码" required/>
					  </li>
                      
                      <span style="color:#F00">${errors.userpassword }</span>
                      
                      
                      <li><input type="password" name="password2"  value="${registerForm.userpassword2 }"  placeholder="请输入确认密码"  required"/>
                    	
					  </li>
                      <span style="color:#F00">${errors.userpassword2 } </span>
                      
					<li> <input type="text" style="width:198px" style="height:40px"   style="border:1px" name="verifyCode"  value="${registerForm.verifyCode }" placeholder="输入验证码" required/>
                        <!-- 验证码 -->
					
                        <img src='<c:url value="/VerifyCodeServlet"></c:url>' style="width:95px" id="vCode" alt="验证码" bottom" style="cursor:pointer;" title="看不清可单击图片刷新" onClick="javascript:_change()" /><br>
                       </li>
              
                         <span style="color:#F00">${errors.verifyCode } </span>
                        <input type="submit" onClick="check()" value="注册" >
				</div>
				<div class="clear"> </div>
			  </ul>
				<div class="clear"> </div>
					
	  </form>
			
</div>
		

	
</body>
</html>