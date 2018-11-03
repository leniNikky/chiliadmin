package com.chili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chili.pojo.Ticket;
import com.chili.service.TicketService;

/**
 * controller�� ע��controller
 *
 */
@Controller
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@RequestMapping(value = "/addTicket", method = RequestMethod.GET)
	public ModelAndView addTicket() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("add"); // ���ص��ļ���
		return mav;

	}

	@RequestMapping(value = "/addTicket", method = RequestMethod.POST)
	public ModelAndView addTicket(Ticket ticket) {
		ModelAndView mav = new ModelAndView();
		try {
			ticketService.insert(ticket);
			mav.setViewName("addSuccess"); // ���ص��ļ���
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("addFailed"); // ���ص��ļ���
			return mav;
		}

	}

	@RequestMapping(value = "/listTicket")
	public ModelAndView addTicket(String tid) {
		ModelAndView mav = new ModelAndView();

		List<Ticket> tickets = ticketService.list(tid);
		mav.addObject("tickets", tickets);
		mav.setViewName("All"); // ���ص��ļ���
		return mav;

	}
	
	@RequestMapping(value = "/listOfDAM")
	public ModelAndView listOfDAM() {
		ModelAndView mav = new ModelAndView();

		List<Ticket> tickets = ticketService.listOfDAM();
		mav.addObject("tickets", tickets);
		mav.setViewName("DAM"); // ���ص��ļ���
		return mav;

	}
	

}
