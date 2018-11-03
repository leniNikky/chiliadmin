<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="res/css/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="res/js/jquery.js"></script>
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
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="order"></i><em>订单列表</em></span>
  </div>
  <div class="operate">
   <form action="/findOrder" method="post">
    <img src="res/images/icon_search.gif"/>
    <input type="text" class="textBox length-long" placeholder="输入订单信息" name="ordermsg"/>
    <select class="inline-select" name="msg">
     <option value="orderID">订单编号</option>
     <option value="consignName">收货人名字</option>
     <option value="orderstatus">订单状态</option>
    </select>
    <button type="submit" class="tdBtn">查询</button>
   </form>
  </div>
  <table class="list-style Interlaced">
   <tr>
    <th>订单编号</th>
    <th>下单时间</th>
    <th>收货信息</th>
    <th>订单金额</th>
    <th>付款方式</th>
    <th>订单状态</th>
    <th>操作</th>
   </tr>
   <c:forEach items="${orders}" var="order"> 
   <tr>
    <td class="center">
    <span class="block">${order.orderID }</span>
    </td>
    <td class="center">
     <span class="block">${order.orderDate }</span>
    </td>
    <td width="450">
     <span class="block">${order.consignName }[${order.consigneePhone }]</span>
     <address>${order.consigneeAddress }</address>
    </td>
    <td class="center">
     <span><i>￥</i><b>${order.totalPrice }</b></span>
    </td>
    <td class="center">
     <span>${order.payway }</span>
    </td>
    <td class="center">
     <span>${order.orderstatus }</span>
    </td>
    <td class="center">
     <a href="findOrderByOrderId?orderID=${order.orderID }" class="inline-block" title="修改订单状态"><img src="res/images/icon_view.gif"/></a>
    </td>
   </tr>
   </c:forEach>
  </table>
  <!-- BatchOperation -->
  <!-- <div style="overflow:hidden;">
      Operation
	  <div class="BatchOperation fl">
	   <input type="checkbox" id="del"/>
	   <label for="del" class="btnStyle middle">全选</label>
	   <input type="button" value="打印订单" class="btnStyle"/>
	   <input type="button" value="配货" class="btnStyle"/>
	   <input type="button" value="删除订单" class="btnStyle"/>
	  </div>
	  turn page
	  
  </div> -->
 </div>
</body>
</html>