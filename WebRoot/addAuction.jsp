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
	function $(id){
		return document.getElementById(id);
	}
	function checkAuctionName(){
		if($("auctionName").value==""){
			$("nameid").style.display="block";
			return false;
		}else{
			$("nameid").style.display="none";
			return true;
		}
	}
	
	function checkStartPrice(){
		if(($("startPrice").value=="")||(isNaN($("startPrice").value)==true)){
			$("startPriceid").style.display="block";
			return false;
		}else{
			$("startPriceid").style.display="none";
			return true;
		}
	}
	
	function checkUpset(){
		if(($("upset").value=="")||(isNaN($("upset").value)==true)){
			$("upsetid").style.display="block";
			return false;
		}else{
			$("upsetid").style.display="none";
			return true;
		}		
	}
	
	function checkStartTime(){
		if($("startTime").value==""){
			$("startTimeid").style.display="block";
			return false;
		}else{
			$("startTimeid").style.display="none";
			return true;
		}		
	}
	
	function checkEndTime(){
		if($("endTime").value==""){
			$("endTimeid").style.display="block";
			return false;
		}else{
			$("endTimeid").style.display="none";
			return true;
		}		
	}
	function checkValue(){
		if((checkAuctionName()&&checkStartPrice()&&checkUpset()&&checkStartTime()&&checkEndTime())==true){				
			if($("pic").value==""){
				$("picid").style.display="block";
				return false;
			}else{
				$("picid").style.display="none";
				return true;
			}
		}
		return false;
	}
	function showPic(){
		$("imgid").src=$("pic").value;/*考虑到安全性和兼容性问题，发布拍卖品时，图片可以不显示*/
	}
</script>
</head>

<body>
        <form action="addAuction" enctype="multipart/form-data" method="post" onsubmit="return checkValue()">
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
      <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
          <dl>
            <dd >
              <label>名称：</label>
              <input type="text" onblur="checkAuctionName()" name="auctionName" class="inputh lf" value="" />
              <div id="nameid" class="lf red laba">名称不能为空</div>
            </dd>
            <dd>
              <label>起拍价：</label>
              <input type="text" onblur="checkStartPrice()" name="startPrice" class="inputh lf" value="" />
              <div id="startPriceid" class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>底价：</label>
              <input type="text" name="upset" class="inputh lf" onblur="checkUpset()" value="" />
              <div id="upsetid" class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>开始时间：</label>
              <input type="text" name="startTime" class="inputh lf" value="" onblur="checkStartTime()"/>
              <div id="startTimeid" class="lf red laba">格式：2010-05-05 12:30:00</div>
            </dd>
            <dd>
              <label>结束时间：</label>
              <input type="text" name="endTime" class="inputh lf" value="" onblur="checkEndTime()"/>
              <div id="endTimeid" class="lf red laba">格式：2010-05-06 16:30:00</div>
            </dd>
            <dd class="dds">
              <label>拍卖品图片：</label>
               <div class="lf salebd"><img id="imgid" src="images/ad20.jpg" width="100" height="100" /></div>
              <input name="pic" type="file" class="offset10 lf"  onchange="showPic()"/>
             <div id="picid" class="lf red laba">请上传图片</div>
            </dd>
             <dd class="dds">
              <label>描述：</label>
              <textarea name="desc" cols="" rows="" class="textarea"></textarea>
            </dd>
            <dd class="hegas">
                <input type="submit" value="保 存" class="spbg buttombg buttombgs buttomb f14 lf" />
                <input type="reset" value="取 消" class="spbg buttombg buttombgs buttomb f14 lf" />
            </dd>
          </dl>
    </div>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
 
    </form>
</body>
</html>
