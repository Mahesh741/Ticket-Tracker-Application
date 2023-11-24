package com.gl.controller;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.bean.Ticket;
import com.gl.service.TicketService;

@Controller
@RequestMapping("/admin")
public class HomeController {

	@Autowired
	TicketService service;

	@RequestMapping("/ticket")
	public String welcome(Model m) {
		m.addAttribute("list", "List of Ticket");
		m.addAttribute("ticket", service.findAll());
		return "home";
	}

	@RequestMapping("/addTicket")
	public String addCustomer(Model m) {

		m.addAttribute("ticket", new Ticket());
		m.addAttribute("title", "Create Ticket");
		return "Ticketform";
	}

	@PostMapping("/saveTicket")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket, Model m) {

		ticket.setTicketCreated(LocalDate.now());
		service.save(ticket);
		m.addAttribute("ticket", "Ticket added Succesfully");

		return "redirect:ticket";
	}

	@PostMapping("/deleteTicket")
	public String deleteTicket(@RequestParam("id") int id, Model m) {
		service.deleteById(id);

		return "redirect:ticket";
	}

	@PostMapping("/updateTicket")
	public String updateTicket(@RequestParam("id") int id, Model m) {

		m.addAttribute("ticket", service.findById(id));
		m.addAttribute("title", "Update Ticket");
		return "Ticketform";
	}

	@PostMapping("/viewTicket")
	public String viewTicket(@RequestParam("id") int id, Model m) {

		m.addAttribute("ticket", service.findById(id));

		return "view";
	}

	@PostMapping("/searchTicket")
	public String searchTicket(@RequestParam("searchType") String searchType,
			@RequestParam("searchQuery") String searchQuery, Model m) {
		List<Ticket> ticketList = null;
		if (searchType.equals("id")) {
			try {
				int id = Integer.parseInt(searchQuery);

				m.addAttribute("ticket", service.findById(id));
				return "search";
			} catch (NumberFormatException e) {

				m.addAttribute("error", "Invalid ID format");
				return "error";
			} catch (Exception e) {

				m.addAttribute("error", "Error while processing ID search");
				return "error";
			}
		} else if (searchType.equals("name")) {
			try {
				ticketList = service.findAllByticketTitle(searchQuery);
				m.addAttribute("ticket", service.findAllByticketTitle(searchQuery));
				return "searchByName";
			} catch (Exception e) {

				m.addAttribute("error", "Error while processing name search");
				return "error";
			}
		}

		m.addAttribute("error", "Unexpected error occurred");
		return "error";
	}

}
