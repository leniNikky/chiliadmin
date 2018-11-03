<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>根据用户ID查询订单详情和用户名</title>
</head>
<body>
	<form action="/findOrderByUserId" method="post">
		<input type="text" name="userID">
		<button type="submit">search</button>
	</form>
	<table>
		<tr>
			<th>订单号</th>
			<th>用户ID</th>
			<th>用户ID</th>
			<th>收货人姓名</th>
			<th>收货地址</th>
			<th>联系方式</th>
			<th>付款方式</th>
			<th>下单时间</th>
			<th>订单状态</th>
		</tr>
		<c:forEach items="${orders}" var="order"> 
		<tr>
			<td>${order.orderID }</td>
			<td>${order.userID }</td>
			<td></td>
			<td>${order.consignName }</td>
			<td>${order.consigneeAddress }</td>
			<td>${order.consigneePhone }</td>
			<td>${order.payway }</td>
			<td>${order.orderDate }</td>
			<td>${order.orderstatus }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>