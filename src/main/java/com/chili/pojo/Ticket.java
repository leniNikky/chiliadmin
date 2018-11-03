package com.chili.pojo;

import java.io.Serializable;

/**
 * 实体类 数据库字段用下划线 实体类字段用驼峰法
 *
 */
public class Ticket implements Serializable {
	/**
	 * 序列表id
	 */
	private static final long serialVersionUID = 1L;
	private String tid;
	private String departureAdd;
	private String destinationAdd;
	private String departureTime;
	private String arrivalTime;
	private Double price;
	private String unameCode;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(String tid, String departureAdd, String destinationAdd, String departureTime, String arrivalTime,
			Double price, String unameCode) {
		super();
		this.tid = tid;
		this.departureAdd = departureAdd;
		this.destinationAdd = destinationAdd;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
		this.unameCode = unameCode;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getDepartureAdd() {
		return departureAdd;
	}

	public void setDepartureAdd(String departureAdd) {
		this.departureAdd = departureAdd;
	}

	public String getDestinationAdd() {
		return destinationAdd;
	}

	public void setDestinationAdd(String destinationAdd) {
		this.destinationAdd = destinationAdd;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUnameCode() {
		return unameCode;
	}

	public void setUnameCode(String unameCode) {
		this.unameCode = unameCode;
	}

	@Override
	public String toString() {
		return "Ticket [tid=" + tid + ", departureAdd=" + departureAdd + ", destinationAdd=" + destinationAdd
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", price=" + price
				+ ", unameCode=" + unameCode + "]";
	}

}
