package com.rankcaleb.dojosurvey.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

@Controller
public class SurveyController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping( path="/submit", method=RequestMethod.POST )
	public String submit(
			HttpSession session,
			@RequestParam(value="name") String name,
			@RequestParam(value="location") String location,
			@RequestParam(value="language") String language,
			@RequestParam(value="comment") String comment
			) {
		session.setAttribute( "name", name );
		session.setAttribute( "location", location );
		session.setAttribute( "language", language );
		session.setAttribute( "comment", comment );
		System.out.println("recieved data.");
		return "redirect:/result";
	}
	
	@RequestMapping("/result")
	public String result(HttpSession session, Model model ) {
		model.addAttribute( "name", session.getAttribute("name") );
		model.addAttribute( "location", session.getAttribute("location") );
		model.addAttribute( "language", session.getAttribute("language") );
		model.addAttribute( "comment", session.getAttribute("comment") );
		System.out.println("displaying results.");
		return "results.jsp";
	}
}
