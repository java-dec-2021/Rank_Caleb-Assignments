package com.rankcaleb.student_roster.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rankcaleb.student_roster.models.Dorm;
import com.rankcaleb.student_roster.models.Student;
import com.rankcaleb.student_roster.services.DormService;
import com.rankcaleb.student_roster.services.StudentService;

@Controller
public class DormController {

	private final DormService dormService;
	private final StudentService studentService;
	public DormController( DormService dormService, StudentService studentService ) {
		this.dormService = dormService;
		this.studentService = studentService;
	}
	
	// Routing
	@RequestMapping( value="/dorms/new", method=RequestMethod.GET )
	public String dorms( Model model, @ModelAttribute("dorm") Dorm dorm ) {
		List<Dorm> d = dormService.allDorms();
		model.addAttribute( "dorms", d );
		
		return "dorms.jsp";
	}
	@RequestMapping( value="/dorms/new", method=RequestMethod.POST )
	public String newDorm( Model model, @ModelAttribute("dorm") Dorm d, BindingResult result ) {
		if ( result.hasErrors() ) { return "dorms.jsp"; }
		else {
			dormService.createDorm( d );
			return "redirect:/dorms/new";
		}
	}
	
	@RequestMapping( value="/dorms/{id}", method=RequestMethod.GET )
	public String dorm( @PathVariable("id") Long id, Model model, @ModelAttribute("dorm") Dorm dorm ) {
		Dorm d = dormService.findDorm( id );
		List<Student> s = studentService.allStudentsNotInDorm();
		
		model.addAttribute( "dorm", d );
		model.addAttribute( "students", s );
		
		return "dorm.jsp";
	}
	
}
