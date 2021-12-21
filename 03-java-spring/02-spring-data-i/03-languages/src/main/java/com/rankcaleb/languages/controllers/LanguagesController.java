package com.rankcaleb.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rankcaleb.languages.models.Language;
import com.rankcaleb.languages.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService languageService;
	public LanguagesController( LanguageService languageService ) {
		this.languageService = languageService;
	}
	
	// Routing.
	@RequestMapping( value="/languages", method=RequestMethod.GET )
	public String dashboard( Model model, @ModelAttribute("language") Language language ) {
		List<Language> ls = languageService.allLanguages();
		model.addAttribute( "languages", ls );
		return "index.jsp";
	}
	@RequestMapping( value="/languages", method=RequestMethod.POST )
	public String create(@Valid @ModelAttribute("language") Language l, BindingResult result ) {
		if ( result.hasErrors() ) { return "index.jsp"; }
		else {
			languageService.createLanguage( l );
			return "redirect:/languages";
		}
	}
	
	@RequestMapping( value="/languages/{id}", method=RequestMethod.GET )
	public String view( Model model, @PathVariable("id") Long id ) {
		model.addAttribute("language", languageService.findLanguage( id ));
		return "view.jsp";
	}
	
	@RequestMapping( value="/languages/{id}/edit", method=RequestMethod.GET )
	public String edit( Model model, @PathVariable("id") Long id ) {
		model.addAttribute("language", languageService.findLanguage( id ));
		return "edit.jsp";
	}
	@RequestMapping( value="/languages/{id}", method=RequestMethod.PUT )
	public String update( @Valid @ModelAttribute("language") Language l, BindingResult result ) {
		if ( result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updateLanguage( l );
            return "redirect:/languages";
        }
	}
	
	@RequestMapping( value="/languages/{id}", method=RequestMethod.DELETE )
	public String delete( @PathVariable("id") Long id ) {
        languageService.deleteLanguage( id );
        return "redirect:/languages";
    }
}