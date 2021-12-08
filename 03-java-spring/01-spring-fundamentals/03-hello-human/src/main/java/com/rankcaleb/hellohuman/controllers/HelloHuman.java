package com.rankcaleb.hellohuman.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloHuman {
	
	@RequestMapping("/")
	public String index(
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="last_name", required=false) String last_name,
			@RequestParam(value="times", required=false) Integer times
			) { 
		
		if ( times == null ) { times = (int) 1; }
		String result = "";
		String statement = new String();
		
		if ( name != null & last_name == null ) {
			statement = "Hello " + name + "\n";
			for ( int i = 0; i < times; i++ ) {
				result += statement;
			}
		}
		else if (name != null & last_name != null ) {
			statement = "Hello " + name + " " + last_name + "\n";
			for ( int i = 0; i < times; i++ ) {
				result += statement;
			}
		}
		else if ( name == null & last_name == null ) {
			for ( int i = 0; i < times; i++ ) {
				result += "Hello Human\n";
			}
		}
		return result;
	}
}