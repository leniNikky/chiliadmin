package com.chili.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chili.dao.TicketDao;
import com.chili.pojo.Ticket;
import com.chili.service.TicketService;

/**
 * Service实现类 注解service和transactional事务开启
 *
 */
@Service("ticketService")
@Transactional
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao ticketDao;

	public void insert(Ticket ticket) {
		ticketDao.insert(ticket);
	}

	public List<Ticket> list(String tid) {
		List<Ticket> tickets = ticketDao.listByTid(tid);
		return tickets;
	}
	
	public List<Ticket> listOfDAM(){
		List<Ticket> tickets = ticketDao.listOfDAM();
		return tickets;
	}

}
