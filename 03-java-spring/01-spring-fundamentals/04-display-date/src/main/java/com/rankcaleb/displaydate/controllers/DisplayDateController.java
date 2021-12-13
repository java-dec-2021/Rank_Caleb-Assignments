package com.rankcaleb.displaydate.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

@Controller
public class DisplayDateController {
	
	@RequestMapping("/")
	public String index() { return "index.jsp"; }
	
	@RequestMapping("/date")
	public String date( Model model ) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, d MMMM, yyyy");
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("date", dtf.format(now) );
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time( Model model ) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm a");
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("time", dtf.format(now) );
		return "time.jsp";
	}
}
