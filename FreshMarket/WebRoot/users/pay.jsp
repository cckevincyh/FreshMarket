

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/users/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0118)http://www.17sucai.com/preview/72803/2015-05-09/%E8%B4%AD%E7%89%A9%E8%BD%A6/%E8%AE%A2%E5%8D%95%E6%8F%90%E4%BA%A4.html# -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>提交成功</title>
<link href="<c:url value='/users/css/public.css'/>" type="text/css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value='/users/css/base.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/users/css/buyConfirm.css'/>">
 <base href="<%=basePath%>">

</head>

<body>
 

		
		</div>
 	</div>
	<!--  导航条    end--><!--订单提交body部分开始-->  





        <div class="container payment-con">

            <div class="order-info">
                <div class="msg">
                    <h3>您的订单已提交成功！付款咯～</h3>
                    <p></p>
                    
                                                                    <p class="post-date">成功付款后，1小时之内发货</p>
                                    </div>
                <div class="info">
                    <p>
                        金额：<span class="pay-total">￥${order.total}</span>
                    </p>
                    <p>
                        订单：${order.ordersID }                   </p>
                        
                    <p>
                        成交时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.orderTime }"/>　                                <br/>
                        配送：${sessionUser.username }                                    <span class="line">/</span>
                                   ${sessionUser.phone }                                    <span class="line">/</span>
                                  ${sessionUser.address }                                                            
                                                                                                      
                                                                                
                </div>
                <div class="icon-box">
                    <i class="iconfont"><img src="css/yes_ok.png"></i>
                </div>
            </div>
            
            <div class="xm-plain-box">
                                                <!-- 选择支付方式 -->
                <div class="box-bd" id="bankList">
                    <div class="payment-bd">
                    
                    <dl class="clearfix payment-box">
                    <dt>
                                
                            </dt>
                    </dl>
                        

                        <dl class="clearfix payment-box">
                          <dt>
                                <strong>银行网银</strong>
                                <p>支持以下各银行借记卡及信用卡</p>
                                
                            </dt>
                            <dd>
                            
                            <form action="<c:url value='/OrderServlet'/>" target="_parent" method="post">
                            <input type="hidden" name="method" value="pay"/>
						<input type="hidden" name="ordersID" value="${order.ordersID }"/>
                                                                <ul class="payment-list clearfix">
                                    <li><label for="CMB"><input type="radio" name="pd_FrpId" id="CMB" value="CMB"> <img src="css/payOnline_zsyh.gif" alt=""></label></li>
                                    <li><label for="ICBCB2C"><input type="radio" name="pd_FrpId" id="ICBC-NET-B2C" value="ICBCB2C"> <img src="css/payOnline_gsyh.gif" alt=""></label></li>
                                    <li><label for="CCB"><input type="radio" name="pd_FrpId" id="CCB" value="CCB-NET-B2C"> <img src="css/payOnline_jsyh.gif" alt=""></label></li>
                                    <li><label for="ABC"><input type="radio" name="pd_FrpId" id="ABC" value="ABC-NET-B2C"> <img src="css/payOnline_nyyh.gif" alt=""></label></li>
                                    <li><label for="BOCB2C"><input type="radio" name="pd_FrpId" id="BOCB2C" value="BOC-NET-B2C"> <img src="css/payOnline_zgyh.gif" alt=""></label></li>
                                    <li><label for="COMM"><input type="radio" name="pd_FrpId" id="COMM" value="COMM"> <img src="css/payOnline_jtyh.gif" alt=""></label></li>
                                    <li><label for="PSBC-DEBIT"><input type="radio" name="pd_FrpId" id="PSBC-DEBIT" value="PSBC-DEBIT"> <img src="css/payOnline_youzheng.gif" alt=""></label></li>
                                    <li><label for="GDB"><input type="radio" name="pd_FrpId" id="GDB" value="GDB"> <img src="css/payOnline_gfyh.gif" alt=""></label></li>
                                    <li><label for="SPDB"><input type="radio" name="pd_FrpId" id="SPDB" value="SPDB"> <img src="css/payOnline_pufa.gif" alt=""></label></li>
                                    <li><label for="CEBBANK"><input type="radio" name="pd_FrpId" id="CEBBANK" value="CEBBANK"> <img src="css/payOnline_gdyh.gif" alt=""></label></li>
                                    <li><label for="SPABANK"><input type="radio" name="pd_FrpId" id="SPABANK" value="SPABANK"> <img src="css/payOnline_payh.gif" alt=""></label></li>
                                                     </ul>
                            </dd>
                        </dl>
                        

                                                
                                                
                    </div>
                            </div>
            <div class="box-ft clearfix">
                    <input type="submit" class="btn btn-primary" value="前往支付" id="payBtn">
             
                    <span class="tip"></span>
                </div>
                </form>
            </div>
            
            





 


</html>