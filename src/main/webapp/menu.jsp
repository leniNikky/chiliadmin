<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>左侧导航</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="res/css/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="res/js/jquery.js"></script>
<script src="res/js/public.js"></script>
</head>
<body style="background:#313131">

<div class="menu-list">
 <a href="main.jsp" target="mainCont" class="block menu-list-title center" style="border:none;margin-bottom:8px;color:#fff;">起始页</a>
 <ul>
 
  <li class="menu-list-title">
   <span>订单管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="allOrder" title="商品列表" target="mainCont">订单列表</a></li>
   </ul>
  </li>
 
  <li class="menu-list-title">
   <span>商品管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="AllGoodsList" title="商品列表" target="mainCont">商品列表</a></li>
    <li><a href="add_goods.jsp" title="添加商品" target="mainCont">添加商品</a></li>
   </ul>
  </li>
  
  <li class="menu-list-title">
   <span>用户管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="/userList" title="会员列表" target="mainCont">用户列表</a></li>
   </ul>
  </li>
   <li class="menu-list-title">
   <span>管理员管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="/adminList" title="会员列表" target="mainCont">管理员列表</a></li>
    <li><a href="add_admin.jsp" title="添加管理员" target="mainCont">添加管理员</a></li>
    <li><a href="admin.jsp" title="个人信息" target="mainCont">个人信息</a></li>
    <li><a href="revise_psw.jsp" title="修改密码" target="mainCont">修改密码</a></li>
   </ul>
  </li>
  
    
 </ul>
</div>

</body>
</html>