package com.gl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.bean.Ticket;

public interface TicketRepositroy extends JpaRepository<Ticket, Integer> {
	public List<Ticket> findAllByticketTitle(String ticketTitle);
}
