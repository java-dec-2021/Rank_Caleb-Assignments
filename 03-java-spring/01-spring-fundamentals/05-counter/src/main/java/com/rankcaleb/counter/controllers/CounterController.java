package com.rankcaleb.counter.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

@Controller
public class CounterController {

	@RequestMapping("/")
	public String index( HttpSession session ) {
		if ( session.getAttribute("count") == null ) {
			session.setAttribute("count", 0);
		}
		else {
			int newCount = (int) session.getAttribute("count");
			newCount++;
			session.setAttribute( "count", newCount );
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String index( Model model, HttpSession session ) {
		model.addAttribute("count", session.getAttribute("count") );
		return "counter.jsp";
	}
}