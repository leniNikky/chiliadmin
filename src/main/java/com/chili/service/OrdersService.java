package com.chili.service;

import java.util.List;

import com.chili.pojo.Orders;

public interface OrdersService {
	public Orders findOrderByOrderId(int orderID);
	public List<Orders> findOrderByOrderID(String ordermsg);
	public List<Orders> findOrderByConsignName(String ordermsg);
	public List<Orders> findOrderByOrderstatus(String ordermsg);
	public List<Orders> allOrder();
	public String findOrderNo(int orderID);
	public int countOrders();
	public int countUnOrders();
	public int countOrdersEd();
	public int countOrdersSend();
	public int countOrdersWait();
	public int countOrdersRe();
	public float countOrdersPrice();
	public void updateOrderStatus(String orderstatus,int orderID);
}
