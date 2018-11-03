<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Ban辣酱后台管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="res/css/adminStyle.css" rel="stylesheet" type="text/css" />
<style>html,body{width:100%;height:100%;}</style>
<script src="res/js/jquery.js"></script>
<script src="res/js/eject.js"></script>
<script src="res/js/public.js"></script>
</head>
<body>
<%-- <input type="hidden" value="${admin.userName }" id="admin">
<script type="text/javascript">
	var admin = document.getElementById("admin");
	if(admin.value==""){
			window.location.href="http://localhost:8080/banlajiang/zadmin/checklogin.jsp";
	}
</script> --%>
<input value="${usertotal }"  id="notnull" type="hidden" >
<!-- <a href="NewGoods">a</a> -->
<script type="text/javascript">

if(document.getElementById("notnull").value==""){
	window.location.href="count";
}
</script>
<div class="wrap start-page">
 <h1><i class="home-icon"></i>欢迎来到Ban辣酱站点管理中心</h1>
 <dl>
  <dt>访问统计</dt>
  <dd>
   <ul>
    <li>
     <span>总访问数：</span>
     <span>${visitedCount }</span>
    </li>
    <li>
     <span>用户数：</span>
     <span>${usertotal }</span>
    </li>
   <li>
     <span>网站留言数：</span>
     <span>0条</span>
    </li>
   </ul>
  </dd>
 </dl>
 <dl>
  <dt>订单统计信息</dt>
  <dd>
   <ul>
    <li>
     <span>订单总数：</span>
     <span>${ordertotal }</span>
    </li>
    <li>
     <span>待处理订单：</span>
     <span>${unordertotal }</span>
    </li>
    <li>
     <span>已处理订单：</span>
     <span>${orderedtotal }</span>
    </li>
    <li>
     <span>已发货订单：</span>
     <span>${ordersendtotal}</span>
    </li>
    <li>
     <span>待收货订单：</span>
     <span>${countOrdersWait }</span>
    </li>
    <li>
     <span>已收货订单：</span>
     <span>${countOrdersRe }</span>
    </li>
   </ul>
  </dd>
 </dl>
 
 <dl>
  <dt>商品统计信息</dt>
  <dd>
   <ul>
    
    <li>
     <span>商品总数量：</span>
     <span>${countGoods }种</span>
    </li>
    <li>
     <span>交易金额总计：</span>
     <span>${totalp }元</span>
    </li>
    <li>
     <span>商品评论数：</span>
     <span>0条</span>
    </li>
    
   </ul>
  </dd>
 </dl>
 
 
 
</div>
</body>
</html>