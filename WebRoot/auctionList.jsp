<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function goToPage(pageindex){
		document.forms[0].action=document.forms[0].action+"?pageindex="+pageindex;
		document.forms[0].submit();
	}
</script>
</head>

<body>
<form method="post" action="auctionList">
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
  <div class="forms">
    <label for="name">名称</label>
    <input name="auctionName" type="text" class="nwinput" id="name"/>
    <label for="names">描述</label>
    <input name="auctionDesc" type="text" id="names" class="nwinput"/>
    <label for="time">开始时间</label>
    <input name="auctionStartTime" type="text" id="time" class="nwinput"/>
    <label for="end-time">结束时间</label>
    <input name="auctionEndTime" type="text" id="end-time" class="nwinput" />
    <label for="price">起拍价</label>
    <input name="auctionStartPrice" type="text" id="price" class="nwinput" />
    <input type="submit"  value="查询" class="spbg buttombg f14  sale-buttom"/>
    <c:if test="${sessionScope.user.userisadmin==1}">
    	<input type="button" onclick="location='addAuction.jsp'"  value="发布" class="spbg buttombg f14  sale-buttom buttomb"/>
    </c:if>
    <br/>
    <c:if test="${sessionScope.user.userisadmin==0}">
      &nbsp;&nbsp;&nbsp;&nbsp;<a href="auctionResult?userid=${sessionScope.user.userid }"><b>查看竞拍结果</b></a>
      </c:if>
  </div>
  <div class="items">
      <ul class="rows even strong">
        <li>名称</li>
        <li class="list-wd">描述</li>
        <li>开始时间</li>
        <li>结束时间</li>
        <li>起拍价</li>
        <li class="borderno">操作</li>
      </ul>
      <c:forEach items="${pageList }" var="auction">
      <ul class="rows">
        <li>${auction.auctionname }</li>
        <li class="list-wd">${auction.auctiondesc }</li>
        <li>${auction.auctionstarttime }</li>
        <li>${auction.auctionendtime }</li>
        <li>${auction.auctionstartprice }</li>
        <li class="borderno red">
        	<c:if test="${sessionScope.user.userisadmin==1 }">
           		<a href="auctionget?auctionid=${auction.auctionid }">修改|</a>
          		<a href="auctiondelete?auctionid=${auction.auctionid }">删除</a>
          	</c:if>
        	<c:if test="${sessionScope.user.userisadmin==0 }">
          		<a href="auctionDetail?auctionId=${auction.auctionid }">竞拍</a>
          	</c:if>
        </li>
      </ul>
      </c:forEach>
      <div class="page">
        <a href="javascript:goToPage(1)">首页</a>
        <c:if test="${pageindex!=1}">
        	<a href="javascript:goToPage(${pageindex-1 })">上一页</a>
        </c:if>
        <c:forEach step="1" begin="1" end="${totalpage }" var="pageindex">
        <a href="javascript:goToPage(${pageindex })">${pageindex }</a>
        </c:forEach> 
        <c:if test="${pageindex!=totalpage}">
        	<a href="javascript:goToPage(${pageindex+1 })">下一页</a>
        </c:if>
        <a href="javascript:goToPage(${totalpage })" >尾页</a> 
      </div>
  </div>
<!-- main end-->
</div>
</form>
</body>
</html>
