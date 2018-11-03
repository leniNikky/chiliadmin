package com.chili.pojo;

import java.util.List;

public class Orders {
	
	private int orderID;
	private String orderNo;
	private int userID;
	private String consignName;
	private String consigneeAddress;
	private String consigneePhone;
	private String payway;
	private String orderDate;
	private String orderstatus;
	private float totalPrice;
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getconsignName() {
		return consignName;
	}
	public void setconsignName(String consignName) {
		this.consignName = consignName;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	public String getPayway() {
		return payway;
	}
	public void setPayway(String payway) {
		this.payway = payway;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", orderNo=" + orderNo + ", userID=" + userID + ", consignName="
				+ consignName + ", consigneeAddress=" + consigneeAddress + ", consigneePhone=" + consigneePhone
				+ ", payway=" + payway + ", orderDate=" + orderDate + ", orderstatus=" + orderstatus + ", totalPrice="
				+ totalPrice + "]";
	}
	public Orders(int orderID, String orderNo, int userID, String consignName, String consigneeAddress,
			String consigneePhone, String payway, String orderDate, String orderstatus, float totalPrice) {
		super();
		this.orderID = orderID;
		this.orderNo = orderNo;
		this.userID = userID;
		this.consignName = consignName;
		this.consigneeAddress = consigneeAddress;
		this.consigneePhone = consigneePhone;
		this.payway = payway;
		this.orderDate = orderDate;
		this.orderstatus = orderstatus;
		this.totalPrice = totalPrice;
		
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
}
