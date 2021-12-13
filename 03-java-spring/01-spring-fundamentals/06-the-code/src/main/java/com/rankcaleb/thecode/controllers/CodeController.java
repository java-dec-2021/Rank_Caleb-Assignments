package com.rankcaleb.thecode.controllers;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class CodeController {
	
	@RequestMapping("/")
	public String index( @ModelAttribute("errors") String errors, Model model ) {
		System.out.println( errors );
		model.addAttribute("error", errors );
		return "index.jsp";
	}
	
	@RequestMapping(path="/submit", method=RequestMethod.POST)
	public String submit( @RequestParam(value="code") String code, RedirectAttributes redirect ) {
		String param = new String("bushido");
		if ( code != param ) {
			redirect.addFlashAttribute( "errors", "You must train harder!" );
			return "redirect:/";
		}
		else {
			System.out.println( code );
			return "redirect:/code";
		}
	}
	
	@RequestMapping("/code")
	public String code() {
		return "code.jsp";
	}
}
