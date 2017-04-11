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
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <c:if test="${not empty sessionScope.user}">
    	<div class="logout right"><a href="doLogout" title="注销">注销</a></div>
    </c:if>
    <c:if test="${empty sessionScope.user}">
    
    	<div class="logout right"><a href="login.jsp" title="登录">登录</a></div>
    </c:if>
  </div>
  
  <div class="items sg-font lf">
      <ul class="rows">
        <li>名称：</li>
        <li class="borderno">${auction.auctionname }</li>
      </ul>
      <ul class="rows">
        <li>描述：</li>
        <li class="borderno">${auction.auctiondesc }</li>
      </ul>
      <ul class="rows">
        <li>开始时间：</li>
        <li class="borderno">${auction.auctionstarttime }</li>
      </ul>
      <ul class="rows">
        <li>结束时间：</li>
        <li class="borderno">${auction.auctionendtime }</li>
      </ul>
      <ul class="rows border-no">
        <li>起拍价：</li>
        <li class="borderno">${auction.auctionstartprice }</li>
      </ul>
  </div>
  <div class="rg borders"><img src="images/${auction.priname }" width="270" alt="" /></div>
  <div class="cl"></div>
  <div class="top10 salebd">
  <form action="auctionBid?auctionId=${auction.auctionid }&auctionuserid=${user.userid}" method="post">
       <p>
       <label for="sale">出价：</label>
       <input name="auctionPrice" type="text"  class="inputwd" id="sale" value=""/>
       <input type="submit" value="竞 拍" class="spbg buttombg f14  sale-buttom" />
       </p>
</form>
<%--<p class="f14 red">不能低于最高竞拍价</p>校验已在后台完成 --%>
       
  </div>
  <div class="top10">
    <input name="" type="button" value="刷 新" class="spbg buttombg f14" />
    <input name="" type="button" value="返回列表" class="spbg buttombg f14" onclick="javascript:location='auctionList'"/>
  </div>
  <div class="offer">
    <h3>出价记录</h3>
    <div class="items sg-font">
    <c:if test="${fn:length(auction.auctionrecords)==0}">
    	此拍卖品没有人竞拍
    </c:if>
     <c:if test="${fn:length(auction.auctionrecords)!=0}">
         <ul class="rows even strong">
	        <li>竞拍时间</li>
	        <li>竞拍价格</li>
	        <li class="borderno">竞拍人</li>
     	 </ul>
	    <c:forEach items="${auction.auctionrecords}" var="record">
	      <ul class="rows">
	        <li>${record.auctiontime }</li>
	        <li>${record.auctionprice }</li>
	        <li class="borderno">${record.auctionuser.username }</li>
	      </ul>
	     </c:forEach>
	     </c:if>
  </div>
  </div>
<!-- main end-->
</div>
</body>
</html>
