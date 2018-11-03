package com.chili.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chili.dao.OrdersDao;
import com.chili.pojo.Orders;
import com.chili.service.OrdersService;
@Service("OrdersService")
public class OrdersServicImpl implements OrdersService {
	@Autowired
	private OrdersDao ordersDao;
	public Orders findOrderByOrderId(int orderID) {
		Orders order = ordersDao.findOrderByOrderId(orderID);
		return order;
	}
	public String findOrderNo(int orderID) {
		String orderNo = ordersDao.findOrderNo(orderID);
		return orderNo;
	}
	public List<Orders> findOrderByOrderID(String ordermsg){
		List<Orders> orders = ordersDao.findOrderByOrderID(ordermsg);
		return orders;
	}
	public List<Orders> findOrderByConsignName(String ordermsg){
		List<Orders> orders = ordersDao.findOrderByConsignName(ordermsg);
		return orders;
	}
	public List<Orders> findOrderByOrderstatus(String ordermsg){
		List<Orders> orders = ordersDao.findOrderByOrderstatus(ordermsg);
		return orders;
	}
	public List<Orders> allOrder(){
		List<Orders> orders = ordersDao.allOrder();
		return orders;
	}
	public int countOrders() {
		int a = ordersDao.countOrders();
		return a;
	}
	public int countUnOrders() {
		int a = ordersDao.countUnOrders();
		return a;
	}
	public int countOrdersEd() {
		int a = ordersDao.countOrdersEd();
		return a;
	}
	public int countOrdersSend() {
		int a = ordersDao.countOrdersSend();
		return a;
	}
	public int countOrdersWait() {
		int a = ordersDao.countOrdersWait();
		return a;
	}
	public int countOrdersRe() {
		int a = ordersDao.countOrdersRe();
		return a;
	}
	public float countOrdersPrice() {
		float sum = ordersDao.countOrdersPrice();
		return sum;
	}
	public void updateOrderStatus(String orderstatus,int orderID) {
		ordersDao.updateOrderStatus(orderstatus, orderID);
	}
}
