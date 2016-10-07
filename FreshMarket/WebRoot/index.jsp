<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
</head>
<style type="text/css">
\
		*{
			font-size:10pt;
			margin:0;padding:0;
		}
		body{
			text-align:center;
			margin: 0px;
		}
		.table{
			width:100%;
			height:100%;
			border:0px solid gray;
		    border-collapse: collapse;
		}
		.table td{
			border-bottom:3px solid red;/*固定边框,1像素*/

			
		}
		iframe {
			width: 100%;
			height: 100%;
		}
	</style>
<body>
<table class="table" align="center" style="height:auto">
	<tr style="height:190px">
		<td  align="center"  width="100%">
			<iframe frameborder="0" src="top.jsp" name="top" scrolling="no"></iframe>
		</td>
	</tr>
	<tr >
		<td style="height:800px">
			<iframe frameborder="0" src="CommodityServlet?method=findAllCommodity" scrolling="no" name="body"></iframe>
		</td>
	</tr>
</table>
</body>
</html>
