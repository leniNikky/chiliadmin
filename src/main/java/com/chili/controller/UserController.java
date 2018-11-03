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
 * controller�� ע��controller
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	private JedisPool pool;
	private Integer exp = 30;
	//����Աע��
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registerandlogin"); // ���ص��ļ���
		return mav;

	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(User user) {
		ModelAndView mav = new ModelAndView();
		
		try {
			User u = userService.checkUserName(user.getUserName());
			System.out.println(u+"����controller");
			if(u == null) {
			userService.insert(user);
			mav.addObject("msg","ע��ɹ�����ͨ����");
			mav.setViewName("message"); // ���ص��ļ���
			return mav;
			}
			else {
				mav.addObject("msg","�û����Ѵ��ڣ�������ע�ᣡ");
				mav.setViewName("message"); // ���ص��ļ���
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg","ע��ʧ�ܣ�");
			mav.setViewName("message"); // ���ص��ļ���
			return mav;
		}

	}
	//��ӹ���Ա
		@RequestMapping(value = "/insertAdmin", method = RequestMethod.GET)
		public ModelAndView insertAdmin() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("error"); // ���ص��ļ���
			return mav;

		}

		@RequestMapping(value = "/insertAdmin", method = RequestMethod.POST)
		public ModelAndView insertAdmin(User admin) {
			ModelAndView mav = new ModelAndView();
			
			try {
				User u = userService.checkUserName(admin.getUserName());
				System.out.println(u+"����controller");
				if(u == null) {
				userService.insertAdmin(admin);
				mav.addObject("msg","��ӳɹ���");
				mav.setViewName("msg"); // ���ص��ļ���
				return mav;
				}
				else {
					mav.addObject("msg","�û����Ѵ��ڣ���������ӣ�");
					mav.setViewName("msg"); // ���ص��ļ���
					return mav;
				}
			} catch (Exception e) {
				e.printStackTrace();
				mav.addObject("msg","���ʧ�ܣ�");
				mav.setViewName("msg"); // ���ص��ļ���
				return mav;
			}

		}
	
	//����Ա��¼
	@RequestMapping(value = "/usersLogin", method = RequestMethod.GET)
	public ModelAndView userLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registerandlogin"); // ���ص��ļ���
		return mav;

	}
		
	@RequestMapping(value = "/usersLogin", method = RequestMethod.POST)
	public ModelAndView userLogin(String userName, String userPassword,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Jedis jedis = null;
		try {
			if(userName==null || userPassword==null){
				mav.setViewName("registerandlogin"); // ���ص��ļ���
				return mav;
				 }
			System.out.println(userName+userPassword+"����Controller");
			User u = userService.userLogin(userName,userPassword);
			if(u!=null) {
				
				jedis = pool.getResource(); 
				jedis.set("chili", u.toString());
				//request.getSession().setAttribute("user", u);
				mav.setViewName("adminIndex"); // ���ص��ļ���
				return mav;
			}else {
				mav.addObject("msg","�㻹���ǹ���Ա��");
				mav.setViewName("message"); // ���ص��ļ���
				return mav;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg","��¼ʧ�ܣ�");
			mav.setViewName("message"); // ���ص��ļ���
			return mav;
		}

	}
	 
	 //����Ա�˳�����session ��ת����¼ҳ
	@RequestMapping(value = "/userExit")
	public ModelAndView userExit(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		try {
			    session.invalidate();
				mav.setViewName("registerandlogin"); // ���ص��ļ���
				return mav;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg","�˳�ʧ�ܣ���������ء�ǿ���˳���");
			mav.setViewName("message"); // ���ص��ļ���
			return mav;
		}


	}
	
	//�û��б�
	@RequestMapping(value = "/userList")
	public ModelAndView userList() {
		ModelAndView mav = new ModelAndView();
		List<User> users = userService.userList();
		mav.addObject("users", users);
		mav.setViewName("user_list"); // ���ص��ļ���
		return mav;

	}
	
	//�鿴�û�������Ϣ
		@RequestMapping(value = "/userInfo")
		public ModelAndView userInfo(int userID) {
			ModelAndView mav = new ModelAndView();
			User user = userService.userInfo(userID);
			mav.addObject("user", user);
			mav.setViewName("edit_user"); // ���ص��ļ���
			return mav;

		}
		
		//�޸��û�Ȩ��
		@RequestMapping(value = "/Editroot", method = RequestMethod.GET)
		public ModelAndView Editroot() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("error"); // ���ص��ļ���
			return mav;

		}

		@RequestMapping(value = "/Editroot", method = RequestMethod.POST)
		public ModelAndView Editroot(int userID) {
			ModelAndView mav = new ModelAndView();
			
			try {
				userService.Editroot(userID);
				mav.addObject("msg","�޸ĳɹ�");
				mav.setViewName("msg"); // ���ص��ļ���
				return mav;
				
					
			} catch (Exception e) {
				e.printStackTrace();
				mav.addObject("msg","�޸�ʧ�ܣ�");
				mav.setViewName("msg"); // ���ص��ļ���
				return mav;
			}

		}
		
		//�޸ĸ�����Ϣ
		@RequestMapping(value = "/EditMsg", method = RequestMethod.GET)
		public ModelAndView EditMsg() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("error"); // ���ص��ļ���
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
				mav.addObject("msg","�޸ĳɹ�");
				mav.setViewName("msg"); // ���ص��ļ���
				return mav;
				
					
			} catch (Exception e) {
				e.printStackTrace();
				mav.addObject("msg","�޸�ʧ�ܣ�");
				mav.setViewName("msg"); // ���ص��ļ���
				return mav;
			}

		}
		
		//�޸�����
		@RequestMapping(value = "/EditPs", method = RequestMethod.GET)
		public ModelAndView EditPs() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("error"); // ���ص��ļ���
			return mav;

		}

		@RequestMapping(value = "/EditPs", method = RequestMethod.POST)
		public ModelAndView EditPs(int userID,String newps,String oldps,HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			System.out.println(userID+newps+oldps+"������");
			String ups = userService.findPs(userID);
			System.out.println(ups+"������");
			if(oldps.equals(ups)) {
			try {
				
				userService.EditPs(newps, userID);
				User u = userService.userInfo(userID);
				request.getSession().setAttribute("user", u);
				mav.addObject("msg","�޸ĳɹ�");
				mav.setViewName("msg"); // ���ص��ļ���
				return mav;
				
					
			} catch (Exception e) {
				e.printStackTrace();
				mav.addObject("msg","�޸�ʧ�ܣ�");
				mav.setViewName("msg"); // ���ص��ļ���
				return mav;
			}
			}else {
				mav.addObject("msg","ԭ�����������");
				mav.setViewName("msg"); // ���ص��ļ���
				return mav;
			}

		}
		
		//�����û��������û�
				@RequestMapping(value = "/FindUserByName", method = RequestMethod.GET)
				public ModelAndView FindUserByName() {
					ModelAndView mav = new ModelAndView();
					mav.setViewName("error"); // ���ص��ļ���
					return mav;

				}

				@RequestMapping(value = "/FindUserByName", method = RequestMethod.POST)
				public ModelAndView FindUserByName(String userName) {
					ModelAndView mav = new ModelAndView();
					
					try {
						List<User> users = userService.FindUserByName(userName);
						mav.addObject("users",users);
						mav.setViewName("user_list"); // ���ص��ļ���
						return mav;
						
							
					} catch (Exception e) {
						e.printStackTrace();
						mav.addObject("msg","����ʧ�ܣ�");
						mav.setViewName("msg"); // ���ص��ļ���
						return mav;
					}

				}
				
				//�����û������ҹ���Ա
				@RequestMapping(value = "/FindAdminByName", method = RequestMethod.GET)
				public ModelAndView FindAdminByName() {
					ModelAndView mav = new ModelAndView();
					mav.setViewName("error"); // ���ص��ļ���
					return mav;

				}

				@RequestMapping(value = "/FindAdminByName", method = RequestMethod.POST)
				public ModelAndView FindAdminByName(String userName) {
					ModelAndView mav = new ModelAndView();
					
					try {
						List<User> users = userService.FindAdminByName(userName);
						mav.addObject("users",users);
						mav.setViewName("admin_list"); // ���ص��ļ���
						return mav;
						
							
					} catch (Exception e) {
						e.printStackTrace();
						mav.addObject("msg","����ʧ�ܣ�");
						mav.setViewName("msg"); // ���ص��ļ���
						return mav;
					}

				}
	 
	//����Ա�б�
	@RequestMapping(value = "/adminList")
	public ModelAndView adminList() {
		ModelAndView mav = new ModelAndView();
		List<User> users = userService.adminList();
		mav.addObject("users", users);
		mav.setViewName("admin_list"); // ���ص��ļ���
		return mav;

	}
	

}
