package com.gl.service;

import java.util.List;

import com.gl.bean.Ticket;

public interface TicketService {

	public List<Ticket> findAll();

	public Ticket save(Ticket ticket);

	public void deleteById(int id);

	public Ticket findById(int id);

	public List<Ticket> findAllByticketTitle(String ticketTitle);
}
