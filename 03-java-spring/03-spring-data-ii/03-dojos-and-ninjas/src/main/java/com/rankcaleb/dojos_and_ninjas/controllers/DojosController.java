package com.rankcaleb.dojos_and_ninjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rankcaleb.dojos_and_ninjas.models.Dojo;
import com.rankcaleb.dojos_and_ninjas.services.DojoService;

@Controller
public class DojosController {
	private final DojoService dojoService;
	public DojosController( DojoService dojoService ) {
		this.dojoService = dojoService;
	}
	
	// Routing
	@RequestMapping( value="/", method=RequestMethod.GET )
	public String index() { return "redirect:/dojos/new"; }
	
	@RequestMapping( value="/dojos/new", method=RequestMethod.GET )
	public String dojos( Model model, @ModelAttribute("dojo") Dojo dojo ) {
		List<Dojo> ds = dojoService.allDojos();
		model.addAttribute( "dojos", ds );
		
		return "dojos.jsp";
	}
	@RequestMapping( value="/dojos/new", method=RequestMethod.POST )
	public String newDojo( Model model, @ModelAttribute("dojo") Dojo d, BindingResult result ) {
		if ( result.hasErrors() ) { return "dojos.jsp"; }
		else {
			dojoService.createDojo( d );
			return "redirect:/dojos/new";
		}
	}

	@RequestMapping( value="/dojos/{id}", method=RequestMethod.GET )
	public String dojo( Model model, @PathVariable("id") Long id ) {
		model.addAttribute("dojo", dojoService.findDojo( id ));
		return "dojo.jsp";
	}
}