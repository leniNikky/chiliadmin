package com.chili.dao;

import java.util.List;

import com.chili.pojo.Orders;
import com.chili.pojo.User;

public interface OrdersDao {
	Orders findOrderByOrderId(int orderID);
	List<Orders> findOrderByOrderID(String ordermsg);
	List<Orders> findOrderByConsignName(String ordermsg);
	List<Orders> findOrderByOrderstatus(String ordermsg);
	List<Orders> allOrder();
	String findOrderNo(int orderID);
	int countOrders();
	int countUnOrders();
	int countOrdersEd();
	int countOrdersSend();
	int countOrdersWait();
	int countOrdersRe();
	float countOrdersPrice();
	void updateOrderStatus(String orderstatus,int orderID);
	
}
