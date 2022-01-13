package com.rankcaleb.student_roster.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rankcaleb.student_roster.models.ContactInfo;
import com.rankcaleb.student_roster.models.Student;
import com.rankcaleb.student_roster.services.ContactInfoService;
import com.rankcaleb.student_roster.services.StudentService;

@Controller
public class ContactInfoController {
	
	private final ContactInfoService contactInfoService;
	private final StudentService studentService;
	public ContactInfoController( ContactInfoService contactInfoService, StudentService studentService ) {
		this.contactInfoService = contactInfoService;
		this.studentService = studentService;
	}
	
	// Routing
	@RequestMapping( value="/contact/new", method=RequestMethod.GET )
	public String contactInfo( Model model, @ModelAttribute("student") Student student ) {
		List<Student> ss = studentService.allStudents();
		model.addAttribute( "students", ss );
		
		return "contact.jsp";
	}
	@RequestMapping( value="/contact/new", method=RequestMethod.POST )
	public String newContactInfo( Model model, @ModelAttribute("contactInfo") ContactInfo ci, BindingResult result ) {
		if ( result.hasErrors() ) { return "contact.jsp"; }
		else {
			contactInfoService.createContactInfo( ci );
			return "redirect:/contact/new";
		}
	}
	
}
