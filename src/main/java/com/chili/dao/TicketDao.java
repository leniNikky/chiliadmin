package com.chili.dao;

import java.util.List;

import com.chili.pojo.Ticket;

public interface TicketDao {

	void insert(Ticket obj);
	List<Ticket> listOfDAM();
	List<Ticket> listByTid(String tid);
}
