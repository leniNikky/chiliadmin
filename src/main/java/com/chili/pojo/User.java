package com.chili.pojo;

import java.io.Serializable;

/**
 * 实体类 数据库字段用下划线 实体类字段用驼峰法
 *
 */
public class User implements Serializable {
	/**
	 * 序列表id
	 */
	private static final long serialVersionUID = 1L;
	private Integer userID;
	private String userName;
	private String userPassword;
	private String phone;
	private String email;
	private Integer userRoot;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getUserRoot() {
		return userRoot;
	}
	public void setUserRoot(Integer userRoot) {
		this.userRoot = userRoot;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userPassword=" + userPassword + ", phone="
				+ phone + ", email=" + email + ", userRoot=" + userRoot + "]";
	}
	public User(Integer userID, String userName, String userPassword, String phone, String email, Integer userRoot) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.phone = phone;
		this.email = email;
		this.userRoot = userRoot;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
