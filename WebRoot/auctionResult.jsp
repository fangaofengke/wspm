<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="wrap">
  <c:if test="${fn:length(map)!=0}">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">拍卖结束的商品</h1>
    <div class="right rulse">当前用户是：<span class="blue strong">${sessionScope. user.username}</span></div>
    <div class="cl"></div>
  </div>
<div class="items">
      <ul class="rows even strong">
        <li>名称</li>
        <li>开始时间</li>
        <li>结束时间</li>
        <li>起拍价</li>
        <li class="list-wd">成交价</li>
        <li class="borderno">买家</li>
      </ul>
      <c:forEach items="${map }" var="end">
	      <ul class="rows">
	        <li>${end.auction.auctionname }</li>
	        <li>${end.auction.auctionstarttime }</li>
	        <li>${end.auction.auctionendtime}</li>
	        <li>${end.auction.auctionstartprice }</li>
	        <li class="list-wd">${end.auctionprice }</li>
	        <li class="borderno red">${end.auctionuser.username }</li>
	      </ul>
   	  </c:forEach>
  </div>
  </c:if>
  
  <c:if test="${fn:length(mapnotend)!=0}">
  <h1>拍卖中的商品</h1>
  <div class="items records">
      <ul class="rows even strong rowh"> 
        <li>名称</li>
        <li>开始时间</li>
        <li>结束时间</li>
        <li>起拍价</li>
        <li class="borderno record">出价记录</li>
        <div class="cl"></div>
      </ul>
      	<c:forEach items="${mapnotend }" var="notend">
    <ul class="rows">
        <li>${notend.auctionname }</li>
        <li>${notend.auctionstarttime }</li>
        <li>${notend.auctionendtime }</li>
        <li>${notend.auctionstartprice }</li>
        <li class="borderno blue record">
        	<c:forEach items="${notend.auctionrecords }" var="record">
          		<p>${record.auctionuser.username }&nbsp;&nbsp; ${record.auctionprice }元</p>
          	</c:forEach>
        </li>
        <div class="cl"></div>
      </ul>
   		</c:forEach>
  </div>
  </c:if> 
<!-- main end-->
</div>
</body>
</html>
