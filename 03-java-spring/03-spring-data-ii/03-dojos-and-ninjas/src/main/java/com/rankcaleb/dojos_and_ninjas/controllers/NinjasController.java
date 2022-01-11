package com.rankcaleb.dojos_and_ninjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rankcaleb.dojos_and_ninjas.services.DojoService;
import com.rankcaleb.dojos_and_ninjas.models.Dojo;
import com.rankcaleb.dojos_and_ninjas.services.NinjaService;
import com.rankcaleb.dojos_and_ninjas.models.Ninja;

@Controller
public class NinjasController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	public NinjasController( NinjaService ninjaService, DojoService dojoService ) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	// Routing
	@RequestMapping( value="/ninjas/new", method=RequestMethod.GET )
	public String ninjas( Model model, @ModelAttribute("dojo") Dojo dojo ) {
		List<Dojo> ds = dojoService.allDojos();
		model.addAttribute( "dojos", ds );
		
		return "ninja.jsp";
	}
	@RequestMapping( value="/ninjas/new", method=RequestMethod.POST )
	public String newNinja( Model model, @ModelAttribute("ninja") Ninja n, BindingResult result ) {
		if ( result.hasErrors() ) { return "ninja.jsp"; }
		else {
			ninjaService.createNinja( n );
			return "redirect:/ninjas/new";
		}
	}
}