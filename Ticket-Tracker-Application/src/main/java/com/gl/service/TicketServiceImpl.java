package com.gl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.bean.Ticket;
import com.gl.dao.TicketRepositroy;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepositroy dao;

	public List<Ticket> findAll() {
		return dao.findAll();
	}

	public Ticket save(Ticket ticket) {
		return dao.save(ticket);
	}

	public void deleteById(int id) {
		dao.deleteById(id);
	}

	public Ticket findById(int id) {
		Optional<Ticket> ticket = dao.findById(id);
		return ticket.get();
	}

	public List<Ticket> findAllByticketTitle(String ticketTitle) {
		return (List<Ticket>) dao.findAllByticketTitle(ticketTitle);

	}

}
