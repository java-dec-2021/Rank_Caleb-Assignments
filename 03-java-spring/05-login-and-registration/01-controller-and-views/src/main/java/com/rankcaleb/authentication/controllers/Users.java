package com.rankcaleb.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rankcaleb.authentication.models.User;
import com.rankcaleb.authentication.services.UserService;

@Controller
public class Users {
	private final UserService userService;
	public Users(UserService userService) { this.userService = userService; }

	@RequestMapping("/")
	public String index() { return "redirect:/registration"; }
	
	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) { return "registrationPage.jsp"; }
	
	@RequestMapping("/login")
	public String login() { return "loginPage.jsp"; }
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		// if result has errors, return the registration page (don't worry about validations just now)
		if ( result.hasErrors() ) { return "registrationPage.jsp"; }
		// else, save the user in the database, save the user id in session, and redirect them to the /home route
		else {
			User newUser = userService.registerUser( user );
			session.setAttribute("userId", newUser.getId() );
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	    // if the user is authenticated, save their user id in session
		if ( userService.authenticateUser( email, password ) ) {
			User user = userService.findByEmail( email );
			session.setAttribute("userId", user.getId() );
			return "redirect:/home";
		}
	    // else, add error messages and return the login page
		else {
			return "loginPage.jsp";
		}
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
	    // get user from session, save them in the model and return the home page
		User user = userService.findUserById( (Long) session.getAttribute( "userId" ) );
		
		if ( user == null ) { return "redirect:/login"; }
		else {
			model.addAttribute( "user", user );
			return "homePage.jsp";
		}
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
	    // invalidate session
		session.invalidate();
	 	// redirect to login page
	 	return "redirect:/login";
	}
}
