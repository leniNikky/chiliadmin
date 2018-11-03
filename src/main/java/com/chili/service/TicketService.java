package com.chili.service;

import java.util.List;

import com.chili.pojo.Ticket;

public interface TicketService {

	public void insert(Ticket ticket);
	public List<Ticket> listOfDAM();
	public List<Ticket> list(String tid);
}
