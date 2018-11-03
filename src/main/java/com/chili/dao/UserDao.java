package com.chili.dao;

import java.util.List;
import com.chili.pojo.User;

public interface UserDao {
	User checkUserName(String userName);
	void insert(User obj);
	User userLogin(String userName,String userPassword);
	List<User> userList();
	List<User> adminList();
	User userInfo(int userID);
	void Editroot(int userID);
	List<User> FindUserByName(String userName);
	List<User> FindAdminByName(String userName);
	void insertAdmin(User admin);
	void EditMsg(int userID,String phone,String email);
	String findPs(int userID);
	void EditPs(String userPassword,int userID);
	int countUsers();
	
}
