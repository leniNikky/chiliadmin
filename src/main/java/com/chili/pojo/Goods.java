package com.chili.pojo;

public class Goods {
	private Integer goodsID;
	private Integer goodsNo;
	private String goodsName;
	private Float goodsPrice;
	private String goodsIntr;
	private String goodsimg;
	private Integer goodsCount;
	private String pictext;
	private String gclass;
	private String gimg1;
	private String gimg2;
	private String gimg3;
	private String time;
	public Integer getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(Integer goodsID) {
		this.goodsID = goodsID;
	}
	public Integer getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(Integer goodsNo) {
		this.goodsNo = goodsNo;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsIntr() {
		return goodsIntr;
	}
	public void setGoodsIntr(String goodsIntr) {
		this.goodsIntr = goodsIntr;
	}
	public String getGoodsimg() {
		return goodsimg;
	}
	public void setGoodsimg(String goodsimg) {
		this.goodsimg = goodsimg;
	}
	public Integer getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getPictext() {
		return pictext;
	}
	public void setPictext(String pictext) {
		this.pictext = pictext;
	}
	public String getGclass() {
		return gclass;
	}
	public void setGclass(String gclass) {
		this.gclass = gclass;
	}
	public String getGimg1() {
		return gimg1;
	}
	public void setGimg1(String gimg1) {
		this.gimg1 = gimg1;
	}
	public String getGimg2() {
		return gimg2;
	}
	public void setGimg2(String gimg2) {
		this.gimg2 = gimg2;
	}
	public String getGimg3() {
		return gimg3;
	}
	public void setGimg3(String gimg3) {
		this.gimg3 = gimg3;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Goods(Integer goodsID, Integer goodsNo, String goodsName, Float goodsPrice, String goodsIntr,
			String goodsimg, Integer goodsCount, String pictext, String gclass, String gimg1, String gimg2,
			String gimg3, String time) {
		super();
		this.goodsID = goodsID;
		this.goodsNo = goodsNo;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsIntr = goodsIntr;
		this.goodsimg = goodsimg;
		this.goodsCount = goodsCount;
		this.pictext = pictext;
		this.gclass = gclass;
		this.gimg1 = gimg1;
		this.gimg2 = gimg2;
		this.gimg3 = gimg3;
		this.time = time;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Goods [goodsID=" + goodsID + ", goodsNo=" + goodsNo + ", goodsName=" + goodsName + ", goodsPrice="
				+ goodsPrice + ", goodsIntr=" + goodsIntr + ", goodsimg=" + goodsimg + ", goodsCount=" + goodsCount
				+ ", pictext=" + pictext + ", gclass=" + gclass + ", gimg1=" + gimg1 + ", gimg2=" + gimg2 + ", gimg3="
				+ gimg3 + ", time=" + time + "]";
	}
	
	
	
}
