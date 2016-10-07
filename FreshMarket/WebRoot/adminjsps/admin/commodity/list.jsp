<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		font-size: 10pt;
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 190px;
		text-align: center;
		float: left;
	}
</style>

<script type="text/javascript">
	function _change() {
		var select = document.getElementById("select");
		location = "<c:url value='/AdminCommodityServlet?${pb.url }'/>&pageCode=" + select.value;
	}
</script>


  </head>
  
  <body>
  <c:choose>
  	<c:when test="${not empty pb.beanList  and fn:length(pb.beanList)>0}">
			  <c:forEach var="commodity" items="${pb.beanList }">
			   <div class="icon">
			    <a href="<c:url value='/AdminCommodityServlet?method=findCommodity&commodityID=${commodity.commodityID }'/>"><img src="${commodity.url}"  width="160" height="170" border="0"/></a>
			      <br/>
			   	<a href="<c:url value='/AdminCommodityServlet?method=findCommodity&commodityID=${commodity.commodityID }'/>">${commodity.commodityName}</a>
			  </div>
			  </c:forEach>
			  
			
			  <%--分页工作 --%>
			    <p style="text-align: center;">
			  <div style="position:fixed;bottom: 30;text-align: center;margin-left: auto;margin-right: auto; width: 100%">
			  	第${pb.pageCode }页/共${pb.totaPage }页
			  	<a href=' <c:url value="/AdminCommodityServlet?${pb.url }&pageCode=1 "></c:url>'>首页</a>
			  <c:if test="${pb.pageCode>1 }">
			  	<a href=' <c:url value="/AdminCommodityServlet?${pb.url }&pageCode=${pb.pageCode-1 } "></c:url>'>上一页</a>
			  </c:if>
			  
			   <%-- 定义页码列表的长度，10个长 --%>
			   <c:choose>
				<%-- 第一条：如果总页数<=10，那么页码列表为1 ~ totaPage 从第一页到总页数--%>
				<%--如果总页数<=10的情况 --%>
				  <c:when test="${pb.totaPage <= 10 }">
				    <c:set var="begin" value="1"/>
				    <c:set var="end" value="${pb.totaPage }"/>
				  </c:when>
				  <%--总页数>10的情况 --%>
				  <c:otherwise>
					  	<%-- 第二条：按公式计算，让列表的头为当前页-4；列表的尾为当前页+5 --%>
					  	<c:set var="begin" value="${pb.pageCode-4 }"/>
					    <c:set var="end" value="${pb.pageCode+5 }"/>
					    
					    <%-- 第三条：第二条只适合在中间，而两端会出问题。这里处理begin出界！ --%>
					    <%-- 如果begin<1，那么让begin=1，相应end=10 --%>
					    <c:if test="${begin<1 }">
					    	<c:set var="begin" value="1"/>
					    	<c:set var="end" value="10"/>
					    </c:if>
					    <%-- 第四条：处理end出界。如果end>tp，那么让end=tp，相应begin=tp-9 --%>
					    <c:if test="${end>pb.totaPage }">
					    	<c:set var="begin" value="${pb.totaPage-9 }"/>
					    	<c:set var="end" value="${pb.totaPage }"/>
					    </c:if>
				  </c:otherwise>
			</c:choose>
			<%------------------------------------------- --%>
			<%-- 循环显示页码列表 --%>
			<c:forEach begin="${begin }" end="${end }" var="i">
			  <c:choose>
			  <%--如果是当前页则设置无法点击超链接 --%>
			  	<c:when test="${i eq pb.pageCode }">${i }</c:when>
			  	<c:otherwise>
			  		<a href="<c:url value='/AdminCommodityServlet?${pb.url }&pageCode=${i}'/>">[${i }]</a>
			  	</c:otherwise>
			  </c:choose>
			</c:forEach>
			  <%----------------------------------- --%>
			  
			  <%--如果当前页数没到总页数，即没到最后一页,则需要显示下一页 --%>
			  <c:if test="${pb.pageCode < pb.totaPage }">　
				<a href="<c:url value='/AdminCommodityServlet?${pb.url }&pageCode=${pb.pageCode+1 }'/>">下一页</a>
			</c:if>
			　<%--否则显示尾页 --%>
				<a href="<c:url value='/AdminCommodityServlet?${pb.url }&pageCode=${pb.totaPage }'/>">尾页</a>　
			
				<%--可选择的页码数 --%>
				<select name="pc" onchange="_change()" id="select">
					<%--列出所有可选页码 --%>
					 <c:forEach begin="1" end="${pb.totaPage }" var="i">
					 <%--如果是当前页码则设置为默认选中 --%>
					  <option value="${i }" <c:if test="${i eq pb.pageCode }">selected="selected"</c:if> >${i }</option>
					 </c:forEach>
				</select>
				  </div>
			</p>
		</c:when>
  	<c:otherwise>
  		<h1 align="center">暂无商品</h1>
  	</c:otherwise>
  </c:choose>
  
  </body>
 
</html>

