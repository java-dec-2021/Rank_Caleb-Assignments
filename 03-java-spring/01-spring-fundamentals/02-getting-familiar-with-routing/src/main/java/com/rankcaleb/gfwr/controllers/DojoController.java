package com.rankcaleb.gfwr.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/dojo")
public class DojoController {
	
	@RequestMapping("")
	public String index( @PathVariable("") String discard ) { return "The dojo is awesome!!!"; }
	
	@RequestMapping("/burbank")
	public String python( @PathVariable("") String discard ) { return "Burbank Dojo is located in Southern California."; }
	
	@RequestMapping("/san-jose")
	public String java( @PathVariable("") String discard ) { return "SJ dojo is the headquarters."; }
}