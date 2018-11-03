package com.chili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chili.pojo.OrderDetail;
import com.chili.pojo.Orders;
import com.chili.pojo.User;
import com.chili.service.OrderDetailService;
import com.chili.service.OrdersService;

@Controller
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private OrderDetailService orderDetailService;
	
		//�鿴��������	
		@RequestMapping("/findOrderByOrderId")
		public ModelAndView findOrderByOrderId(int orderID) {
			ModelAndView mav = new ModelAndView();
				
				Orders order = ordersService.findOrderByOrderId(orderID);
				String orderNo = ordersService.findOrderNo(orderID);
				System.out.println(orderNo);
				List<OrderDetail> o = orderDetailService.findODByOrderId(orderNo);
				mav.addObject("order",order);
				mav.addObject("orderdetail",o);
				mav.setViewName("order_detail"); // ���ص��ļ���
				return mav;
			

		}
		
		//��ѯ���ж���
				
				@RequestMapping("/allOrder")
				public ModelAndView allOrder() {
					ModelAndView mav = new ModelAndView();
						List<Orders> orders = ordersService.allOrder();
						
						mav.addObject("orders",orders);
						mav.setViewName("order_list"); // ���ص��ļ���
						return mav;
					
					}
				
				//��ѯ����
				@RequestMapping(value = "/findOrder", method = RequestMethod.GET)
				public ModelAndView findOrder() {
					ModelAndView mav = new ModelAndView();
					mav.setViewName("error"); //���ص��ļ���
					return mav;
				}

				@RequestMapping(value = "/findOrder", method = RequestMethod.POST)
				public ModelAndView findOrder(String msg,String ordermsg) {
					ModelAndView mav = new ModelAndView();
					
					try {
						if(msg.equals("orderID")) {
							List<Orders> orders = ordersService.findOrderByOrderID(ordermsg);
							mav.addObject("orders",orders);
							mav.setViewName("order_list");
						}else if(msg.equals("consignName")) {
							List<Orders> orders = ordersService.findOrderByConsignName(ordermsg);
							mav.addObject("orders",orders);
							mav.setViewName("order_list");
						}else if(msg.equals("orderstatus")) {
							List<Orders> orders = ordersService.findOrderByOrderstatus(ordermsg);
							mav.addObject("orders",orders);
							mav.setViewName("order_list");
						}else {
							mav.addObject("msg","����ʧ�ܣ�");
							mav.setViewName("msg");
						}
						return mav;
							
					} catch (Exception e) {
						e.printStackTrace();
						mav.addObject("msg","����ʧ�ܣ�");
						mav.setViewName("msg"); // ���ص��ļ���
						return mav;
					}

				}
				/*@RequestMapping("/findOrder")
				public ModelAndView findOrder(String msg,String ordermsg) {
					ModelAndView mav = new ModelAndView();
						List<Orders> orders = ordersService.findOrder(msg, ordermsg);
						System.out.println(orders+"����controller");
						mav.addObject("orders",orders);
						mav.setViewName("order_list"); // ���ص��ļ���
						return mav;
					
					}*/
				
				//�޸Ķ���״̬
				@RequestMapping(value = "/updateOrderStatus", method = RequestMethod.GET)
				public ModelAndView updateOrderStatus() {
					ModelAndView mav = new ModelAndView();
					mav.setViewName("error"); //���ص��ļ���
					return mav;
				}

				@RequestMapping(value = "/updateOrderStatus", method = RequestMethod.POST)
				public ModelAndView updateOrderStatus(String orderstatus,int orderID) {
					ModelAndView mav = new ModelAndView();
					System.out.println(orderstatus+","+orderID+"����������");
					try {
						ordersService.updateOrderStatus(orderstatus, orderID);
						mav.addObject("msg","�޸ĳɹ���");
						mav.setViewName("msg"); // ���ص��ļ���
						return mav;
							
					} catch (Exception e) {
						e.printStackTrace();
						mav.addObject("msg","����ʧ�ܣ�");
						mav.setViewName("msg"); // ���ص��ļ���
						return mav;
					}

				}
				
}
