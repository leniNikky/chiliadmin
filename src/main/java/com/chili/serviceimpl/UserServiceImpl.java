package com.chili.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chili.dao.UserDao;
import com.chili.pojo.User;
import com.chili.service.UserService;




/**
 * Service实现类 注解service和transactional事务开启
 *
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void insert(User user) {
		userDao.insert(user);
	}
	public User userLogin(String userName,String userPassword) {
		 User u = userDao.userLogin(userName, userPassword);
		 System.out.println(userName+userPassword+"这是Service"+u);
		 if(u.getUserRoot() == 1) {
				return u;
			}
			else {
				return null;
			}
	}
	public User checkUserName(String userName) {
		User u = userDao.checkUserName(userName);
		if(u!= null) {
			return u;
		}
		else {
			return null;
		}
	}
	public List<User> userList(){
		List<User> users = userDao.userList();
		return users;
	}
	public List<User> adminList(){
		List<User> users = userDao.adminList();
		return users;
	}
	public User userInfo(int userID) {
		User user = userDao.userInfo(userID);
		return user;
	}
	public void Editroot(int userID) {
		userDao.Editroot(userID);
	}
	public List<User> FindUserByName(String userName) {
		List<User> users = userDao.FindUserByName(userName);
		return users;
	}
	public List<User> FindAdminByName(String userName) {
		List<User> users = userDao.FindAdminByName(userName);
		return users;
	}
	public void insertAdmin(User admin) {
		userDao.insertAdmin(admin);
	}
	public void EditMsg(int userID,String phone,String email) {
		System.out.println(phone+","+email);
		userDao.EditMsg(userID, phone, email);
	}
	public String findPs(int userID) {
		String userps = userDao.findPs(userID);
		return userps;
	}
	public void EditPs(String userPassword,int userID) {
		userDao.EditPs(userPassword, userID);
	}
	public int countUsers() {
		int a = userDao.countUsers();
		return a;
	}
}
