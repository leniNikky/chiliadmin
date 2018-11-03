package com.chili.service;

import java.util.List;

import com.chili.pojo.User;

public interface UserService {
	public User checkUserName(String userName);
	public void insert(User user);
	public User userLogin(String userName,String userPassword);
	public List<User> userList();
	public List<User> adminList();
	public User userInfo(int userID);
	public void Editroot(int userID);
	public List<User> FindUserByName(String userName);
	public List<User> FindAdminByName(String userName);
	public void insertAdmin(User admin);
	public void EditMsg(int userID,String phone,String email);
	public String findPs(int userID);
	public void EditPs(String userPassword,int userID);
	public int countUsers();
}
