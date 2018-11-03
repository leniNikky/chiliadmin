package com.chili.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chili.pojo.Ticket;
import com.chili.pojo.User;
import com.chili.service.UserService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;



/**
 * controller类 注解controller
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	private JedisPool pool;
	private Integer exp = 30;
	//管理员注册
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registerandlogin"); // 返回的文件名
		return mav;

	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(User user) {
		ModelAndView mav = new ModelAndView();
		
		try {
			User u = userService.checkUserName(user.getUserName());
			System.out.println(u+"这是controller");
			if(u == null) {
			userService.insert(user);
			mav.addObject("msg","注册成功，待通过！");
			mav.setViewName("message"); // 返回的文件名
			return mav;
			}
			else {
				mav.addObject("msg","用户名已存在，请重新注册！");
				mav.setViewName("message"); // 返回的文件名
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg","注册失败！");
			mav.setViewName("message"); // 返回的文件名
			return mav;
		}

	}
	//添加管理员
		@RequestMapping(value = "/insertAdmin", method = RequestMethod.GET)
		public ModelAndView insertAdmin() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("error"); // 返回的文件名
			return mav;

		}

		@RequestMapping(value = "/insertAdmin", method = RequestMethod.POST)
		public ModelAndView insertAdmin(User admin) {
			ModelAndView mav = new ModelAndView();
			
			try {
				User u = userService.checkUserName(admin.getUserName());
				System.out.println(u+"这是controller");
				if(u == null) {
				userService.insertAdmin(admin);
				mav.addObject("msg","添加成功！");
				mav.setViewName("msg"); // 返回的文件名
				return mav;
				}
				else {
					mav.addObject("msg","用户名已存在，请重新添加！");
					mav.setViewName("msg"); // 返回的文件名
					return mav;
				}
			} catch (Exception e) {
				e.printStackTrace();
				mav.addObject("msg","添加失败！");
				mav.setViewName("msg"); // 返回的文件名
				return mav;
			}

		}
	
	//管理员登录
	@RequestMapping(value = "/usersLogin", method = RequestMethod.GET)
	public ModelAndView userLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registerandlogin"); // 返回的文件名
		return mav;

	}
		
	@RequestMapping(value = "/usersLogin", method = RequestMethod.POST)
	public ModelAndView userLogin(String userName, String userPassword,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Jedis jedis = null;
		try {
			if(userName==null || userPassword==null){
				mav.setViewName("registerandlogin"); // 返回的文件名
				return mav;
				 }
			System.out.println(userName+userPassword+"这是Controller");
			User u = userService.userLogin(userName,userPassword);
			if(u!=null) {
				
				jedis = pool.getResource(); 
				jedis.set("chili", u.toString());
				//request.getSession().setAttribute("user", u);
				mav.setViewName("adminIndex"); // 返回的文件名
				return mav;
			}else {
				mav.addObject("msg","你还不是管理员！");
				mav.setViewName("message"); // 返回的文件名
				return mav;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg","登录失败！");
			mav.setViewName("message"); // 返回的文件名
			return mav;
		}

	}
	 
	 //管理员退出销毁session 跳转到登录页
	@RequestMapping(value = "/userExit")
	public ModelAndView userExit(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		try {
			    session.invalidate();
				mav.setViewName("registerandlogin"); // 返回的文件名
				return mav;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg","退出失败，点击“返回”强制退出！");
			mav.setViewName("message"); // 返回的文件名
			return mav;
		}


	}
	
	//用户列表
	@RequestMapping(value = "/userList")
	public ModelAndView userList() {
		ModelAndView mav = new ModelAndView();
		List<User> users = userService.userList();
		mav.addObject("users", users);
		mav.setViewName("user_list"); // 返回的文件名
		return mav;

	}
	
	//查看用户个人信息
		@RequestMapping(value = "/userInfo")
		public ModelAndView userInfo(int userID) {
			ModelAndView mav = new ModelAndView();
			User user = userService.userInfo(userID);
			mav.addObject("user", user);
			mav.setViewName("edit_user"); // 返回的文件名
			return mav;

		}
		
		//修改用户权限
		@RequestMapping(value = "/Editroot", method = RequestMethod.GET)
		public ModelAndView Editroot() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("error"); // 返回的文件名
			return mav;

		}

		@RequestMapping(value = "/Editroot", method = RequestMethod.POST)
		public ModelAndView Editroot(int userID) {
			ModelAndView mav = new ModelAndView();
			
			try {
				userService.Editroot(userID);
				mav.addObject("msg","修改成功");
				mav.setViewName("msg"); // 返回的文件名
				return mav;
				
					
			} catch (Exception e) {
				e.printStackTrace();
				mav.addObject("msg","修改失败！");
				mav.setViewName("msg"); // 返回的文件名
				return mav;
			}

		}
		
		//修改个人信息
		@RequestMapping(value = "/EditMsg", method = RequestMethod.GET)
		public ModelAndView EditMsg() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("error"); // 返回的文件名
			return mav;

		}

		@RequestMapping(value = "/EditMsg", method = RequestMethod.POST)
		public ModelAndView EditMsg(int userID,String phone,String email,HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			System.out.println(phone+","+email);
			try {
				userService.EditMsg(userID,phone,email);
				User u = userService.userInfo(userID);
				request.getSession().setAttribute("user", u);
				mav.addObject("msg","修改成功");
				mav.setViewName("msg"); // 返回的文件名
				return mav;
				
					
			} catch (Exception e) {
				e.printStackTrace();
				mav.addObject("msg","修改失败！");
				mav.setViewName("msg"); // 返回的文件名
				return mav;
			}

		}
		
		//修改密码
		@RequestMapping(value = "/EditPs", method = RequestMethod.GET)
		public ModelAndView EditPs() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("error"); // 返回的文件名
			return mav;

		}

		@RequestMapping(value = "/EditPs", method = RequestMethod.POST)
		public ModelAndView EditPs(int userID,String newps,String oldps,HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			System.out.println(userID+newps+oldps+"改密码");
			String ups = userService.findPs(userID);
			System.out.println(ups+"改密码");
			if(oldps.equals(ups)) {
			try {
				
				userService.EditPs(newps, userID);
				User u = userService.userInfo(userID);
				request.getSession().setAttribute("user", u);
				mav.addObject("msg","修改成功");
				mav.setViewName("msg"); // 返回的文件名
				return mav;
				
					
			} catch (Exception e) {
				e.printStackTrace();
				mav.addObject("msg","修改失败！");
				mav.setViewName("msg"); // 返回的文件名
				return mav;
			}
			}else {
				mav.addObject("msg","原密码输入错误！");
				mav.setViewName("msg"); // 返回的文件名
				return mav;
			}

		}
		
		//根据用户名查找用户
				@RequestMapping(value = "/FindUserByName", method = RequestMethod.GET)
				public ModelAndView FindUserByName() {
					ModelAndView mav = new ModelAndView();
					mav.setViewName("error"); // 返回的文件名
					return mav;

				}

				@RequestMapping(value = "/FindUserByName", method = RequestMethod.POST)
				public ModelAndView FindUserByName(String userName) {
					ModelAndView mav = new ModelAndView();
					
					try {
						List<User> users = userService.FindUserByName(userName);
						mav.addObject("users",users);
						mav.setViewName("user_list"); // 返回的文件名
						return mav;
						
							
					} catch (Exception e) {
						e.printStackTrace();
						mav.addObject("msg","查找失败！");
						mav.setViewName("msg"); // 返回的文件名
						return mav;
					}

				}
				
				//根据用户名查找管理员
				@RequestMapping(value = "/FindAdminByName", method = RequestMethod.GET)
				public ModelAndView FindAdminByName() {
					ModelAndView mav = new ModelAndView();
					mav.setViewName("error"); // 返回的文件名
					return mav;

				}

				@RequestMapping(value = "/FindAdminByName", method = RequestMethod.POST)
				public ModelAndView FindAdminByName(String userName) {
					ModelAndView mav = new ModelAndView();
					
					try {
						List<User> users = userService.FindAdminByName(userName);
						mav.addObject("users",users);
						mav.setViewName("admin_list"); // 返回的文件名
						return mav;
						
							
					} catch (Exception e) {
						e.printStackTrace();
						mav.addObject("msg","查找失败！");
						mav.setViewName("msg"); // 返回的文件名
						return mav;
					}

				}
	 
	//管理员列表
	@RequestMapping(value = "/adminList")
	public ModelAndView adminList() {
		ModelAndView mav = new ModelAndView();
		List<User> users = userService.adminList();
		mav.addObject("users", users);
		mav.setViewName("admin_list"); // 返回的文件名
		return mav;

	}
	

}
