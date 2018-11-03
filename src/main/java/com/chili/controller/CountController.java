package com.chili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chili.pojo.User;
import com.chili.service.GoodsService;
import com.chili.service.OrdersService;
import com.chili.service.UserService;
import com.chili.service.VisitedService;

@Controller
public class CountController {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private UserService userService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private VisitedService visitedService;
	
	@RequestMapping(value = "/count")
	public ModelAndView userList() {
		ModelAndView mav = new ModelAndView();
		int ordertotal = ordersService.countOrders();
		int usertotal = userService.countUsers();
		int unordertotal = ordersService.countUnOrders();
		int orderedtotal = ordersService.countOrdersEd();
		int ordersendtotal = ordersService.countOrdersSend();
		int countOrdersWait = ordersService.countOrdersWait();
		int countOrdersRe = ordersService.countOrdersRe();
		int countGoods = goodsService.countGoods();
		float totalp = ordersService.countOrdersPrice();
		int visitedCount = visitedService.visitedCount();
		System.out.println(totalp);
		mav.addObject("ordertotal", ordertotal);
		mav.addObject("unordertotal", unordertotal);
		mav.addObject("orderedtotal", orderedtotal);
		mav.addObject("ordersendtotal", ordersendtotal);
		mav.addObject("countOrdersWait", countOrdersWait);
		mav.addObject("usertotal", usertotal);
		mav.addObject("countGoods", countGoods);
		mav.addObject("countOrdersRe", countOrdersRe);
		mav.addObject("totalp", totalp);
		mav.addObject("visitedCount", visitedCount);
		mav.setViewName("data"); // 返回的文件名
		return mav;

	}
}
