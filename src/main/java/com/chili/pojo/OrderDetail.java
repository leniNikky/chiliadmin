package com.chili.pojo;

public class OrderDetail {
	private int orderdetailID;
	private float gtotalPrice;
	private int userID;
	private String orderNo;
	private int goodsID;
	private String goodsName;
	private float goodsPrice;
	private int goodsCount;
	private String gclass;
	private String goodsImg;
	public int getOrderdetailID() {
		return orderdetailID;
	}
	public void setOrderdetailID(int orderdetailID) {
		this.orderdetailID = orderdetailID;
	}
	public float getGtotalPrice() {
		return gtotalPrice;
	}
	public void setGtotalPrice(float gtotalPrice) {
		this.gtotalPrice = gtotalPrice;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getGclass() {
		return gclass;
	}
	public void setGclass(String gclass) {
		this.gclass = gclass;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	@Override
	public String toString() {
		return "OrderDetair [orderdetailID=" + orderdetailID + ", gtotalPrice=" + gtotalPrice + ", userID=" + userID
				+ ", orderNo=" + orderNo + ", goodsID=" + goodsID + ", goodsName=" + goodsName + ", goodsPrice="
				+ goodsPrice + ", goodsCount=" + goodsCount + ", gclass=" + gclass + ", goodsImg=" + goodsImg + "]";
	}
	public OrderDetail(int orderdetailID, float gtotalPrice, int userID, String orderNo, int goodsID, String goodsName,
			float goodsPrice, int goodsCount, String gclass, String goodsImg) {
		super();
		this.orderdetailID = orderdetailID;
		this.gtotalPrice = gtotalPrice;
		this.userID = userID;
		this.orderNo = orderNo;
		this.goodsID = goodsID;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsCount = goodsCount;
		this.gclass = gclass;
		this.goodsImg = goodsImg;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
}
