package com.rankcaleb.student_roster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rankcaleb.student_roster.models.Student;
import com.rankcaleb.student_roster.services.StudentService;

@Controller
public class StudentController {
	
	private final StudentService studentService;
	public StudentController( StudentService studentService ) { this.studentService = studentService; }
	
	// Routing
	@RequestMapping( value="/", method=RequestMethod.GET )
	public String index() { return "redirect:/students/new"; }
	
	@RequestMapping( value="/students/new", method=RequestMethod.GET )
	public String student() { return "student.jsp"; }
	
	@RequestMapping( value="/students/new", method=RequestMethod.POST )
	public String newStudent( Model model, @ModelAttribute("student") Student s, BindingResult result ) {
		if ( result.hasErrors() ) { return "student.jsp"; }
		else {
			studentService.createStudent( s );
			return "redirect:/students/new";
		}
	}

	@RequestMapping( value="/students", method=RequestMethod.GET )
	public String students( Model model ) {
		model.addAttribute("students", studentService.allStudents());
		return "students.jsp";
	}
	
}
