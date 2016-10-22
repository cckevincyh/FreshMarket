
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
<link href="<c:url value='/users/css/style.css'/>" type="text/css" rel="stylesheet" />

</head>
<body>
<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
.form label, .form input, .form select, .form textarea, .form button, .form .label{float:left;font-size:12px;}
.fl{float:left;}.fr{float:right;}.fn{float:none;}
.hide{display:none;}.invisible{visibility:hidden;}.overflow{overflow:hidden;}
.clear{display:block;clear:both;height:0;overflow:hidden;}
body{font:12px/180% Arial, Helvetica, sans-serif,"宋体";}
/* yellow_button */
.yellow_button{background:url(<c:url value='/users/images/yellow_button.png'/>);border:none;cursor:pointer;height:36px;line-height:36px; overflow:hidden; display:inline-block; text-align:center; font-size:14px; font-weight:800; color:#fff;background-position:0 0;width:139px;}
#registsubmit.disabled{background-position:0 -36px;cursor:default!important;}
.red{color:#ff0000;font-family:"宋体";font-weight:normal;}
/* formbox */
#formbox{padding:20px;border:solid 1px #D1D1D1;margin:20px auto;width:880px;}
#formbox h3{font-size:16px;height:32px;color:#3366cc;font-weight:800;border-bottom:solid 1px #D1D1D1;margin:0 0 20px 0;padding:0 10px;}
#formbox .item{padding-top:5px;height:50px;overflow:hidden;line-height:26px;}
#formbox .item a:link,#formbox .item a:visited{text-decoration:underline;}
#formbox .label{width:300px;text-align:right;font-size:14px;}
#formbox .span-150{width:150px;}
#formbox .text{width:240px;height:16px;padding:4px 3px;border:1px solid #bbb;font-size:14px;font-family:arial,"宋体";}
#formbox .text-1{width:100px;}
#formbox .blank{width:16px;height:16px;margin:2px 5px 0;}
#formbox .img img{height:26px;margin:0 5px;}
#formbox .succeed{background:url(<c:url value='/users/images/pwdstrength.gif'/>) no-repeat -105px 0;}
#formbox .yellow_button{font-size:14px;font-weight:bold;color:#fff;border:none;cursor:pointer;}
#formbox .highlight1{border:1px solid #EFA100;outline:2px solid #FFDC97;*border:2px solid #ffcc66;*padding:3px 2px;}
#formbox .highlight2{border:1px solid #f00;outline:1px solid #FFC1C1;color:#f00;}
#formbox .pwdbg{background:#FFF8EB;}
#formbox .focus{color:#999;line-height:22px;*line-height:20px;}
#formbox .null,#formbox .error{color:red;line-height:22px;*line-height:20px;}
#formbox .checkbox{margin-top:6px;*margin-top:2px;}
#formbox #referrer{color:#999;font-size:12px;}
#formbox #protocol{margin:0px 5px 0 0;display:inline;}
#pwdstrength{color:#999;line-height:22px;padding-right:10px;}
#pwdstrength b{float:left;width:104px;height:13px;overflow:hidden;margin-top:5px;*margin-top:3px;}
.strengthA b{background:url(<c:url value='/users/images/pwdstrength.gif'/>) no-repeat 0 0;}
.strengthB b{background:url(<c:url value='/users/images/pwdstrength.gif'/>) no-repeat 0 -13px;}
.strengthC b{background:url(<c:url value='/users/images/pwdstrength.gif'/>) no-repeat 0 -26px;}
</style>
<br>
<div id="formbox">
	<form id="formpersonal" method="post" action="<c:url value='/UserServlet?method=changePassword'/>"">
	<div class="form">
		<h3>修改密码</h3><!--item end-->
		
	  <div id="o-password">
    	  <div class="item">
				<span class="label"><span class="red">*</span>原密码：</span>
			  <div class="fl">
			  <input type="hidden" name="username" value="${sessionUser.username }">
					<input type="password"  name="oldpassword" class="text" value="${form.oldpassword }" tabindex="2"/>
			    <label id="pwd_succeed" class="blank"> </label>
			    <span class="clear"> </span>
			    <div  style="color: red">${errors.oldpassword }</div>
			    </div>
			</div>
      
      
			<div class="item">
				<span class="label"><span class="red">*</span>设置密码：</span>
			  <div class="fl">
					<input type="password" id="pwd2" name="newpassword1" class="text" tabindex="2" value="${form.newpassword1 }"/>
			    <label id="pwd_succeed" class="blank"></label>
			    <span class="clear"></span> 
			       <div  style="color: red">${errors.newpassword1 }</div>
			    </div>
			</div><!--item end-->
			
			<div class="item">
				<span class="label"><span class="red">*</span>确认密码：</span>
				<div class="fl">
					<input type="password" id="pwd2" name="newpassword2" class="text" tabindex="3" value="${form.newpassword2 }"/>
				  <label id="pwd2_succeed" class="blank"> </label>
				  
					<span class="clear"></span> 
			       <div  style="color: red">${errors.newpassword2 }</div>
			    </div>
					
				
				
			</div><!--item end-->
			
	  </div><!--o-password end--><!--item end--><!--item end--><!--item end--><!--item end--><!--item end--><!--item end-->
		
	<div class="item">
			<span class="label">&nbsp;</span>
			<input type="submit" class="yellow_button enabled" id="registsubmit" value="提交" tabindex="8"  />
		</div>
		
	</div>
	</form>
</div><!--formbox end-->

</body>
</html>