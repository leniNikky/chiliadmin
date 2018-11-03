<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单详情</title>
</head>
<body>
<link href="res/css/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="order"></i><em>订单编号：${order.orderID }</em></span>
  </div>
  <dl class="orderDetail">
   <dt class="order-h">订单详情</dt>
   <dd>
    <ul>
     <li>
      <span class="h-cont h-right">收件人姓名：</span>
      <span class="h-cont h-left">${order.consignName }</span>
     </li>
     <li>
      <span class="h-cont h-right">联系电话：</span>
      <span class="h-cont h-left">${order.consigneePhone }</span>
     </li>
     <li>
      <span class="h-cont h-right">联系地址：</span>
      <span class="h-cont h-left">${order.consigneeAddress }</span>
     </li>
     <li>
      <span class="h-cont h-right">付款方式：</span>
      <span class="h-cont h-left">${order.payway }</span>
     </li>
     <li>
      <span class="h-cont h-right">下单时间：</span>
      <span class="h-cont h-left">${order.orderDate }</span>
     </li>
     <li>
      <span class="h-cont h-right">付款金额：</span>
      <span class="h-cont h-left">${order.totalPrice }</span>
     </li>
    </ul>
   </dd>
   
   <dd>
    <table class="list-style">
     <tr>
      <th>缩略图</th>
      <th>产品</th>
      <th>单价</th>
      <th>数量</th>
      <th>小计</th>
     </tr>
      <c:forEach items="${orderdetail}" var="o"> 
     <tr>
      <td class="center pic-area"><img src="res/${o.goodsImg }" class="thumbnail"/></td>
      <td>${o.goodsName }</td>
      <td>
       <span>
        <i>￥</i>
        <em>${o.goodsPrice }</em>
       </span>
      </td>
      <td>${o.goodsCount }</td>
      <td>
       <span>
        <i>￥</i>
        <em>${o.gtotalPrice }</em>
       </span>
      </td>
     </tr>
     </c:forEach>
     <tr>
      <td colspan="5">
       <div class="fr">
        <span style="font-size:15px;font-weight:bold;">
         <i>订单共计金额：￥</i>
         <b>${order.totalPrice }</b>
        </span>
       </div>
      </td>
     </tr>
    </table>
   </dd>
   <dd>
    <table class="noborder">
    <form action="updateOrderStatus" method="post">
     <tr>
      <td width="10%" style="text-align:right;"><b>管理员操作：</b></td>
      <td>
               修改订单状态
                <select name="orderstatus">
       <option>待处理</option>
       <option>已处理</option>
       <option>已发货</option>
       <option>待收货</option>
       </select>
      </td>
     
     </tr>
    </table>
   </dd>
   <input type="hidden" name="orderID" value="${order.orderID }">
   <dd>
      <!-- Operation -->
	  <div class="BatchOperation">
	   <button type="submit" class="btnStyle">提交修改</button>
	   <button type="reset" class="btnStyle">取消修改</button>
	  </div>
   </dd>
   </form>
  </dl>
 </div>
</body>
</html>