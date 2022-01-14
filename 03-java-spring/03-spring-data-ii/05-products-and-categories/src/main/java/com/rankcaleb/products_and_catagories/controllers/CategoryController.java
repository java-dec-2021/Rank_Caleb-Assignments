package com.rankcaleb.products_and_catagories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rankcaleb.products_and_catagories.models.Category;
import com.rankcaleb.products_and_catagories.models.Product;
import com.rankcaleb.products_and_catagories.services.CategoryService;
import com.rankcaleb.products_and_catagories.services.ProductService;

@Controller
public class CategoryController {
	
	private final CategoryService categoryService;
	private final ProductService productService;
	public CategoryController( CategoryService categoryService, ProductService productService )
	{ this.categoryService = categoryService; this.productService = productService; }
	
	// Routing	
	@RequestMapping( value="/categories/new", method=RequestMethod.GET )
	public String categories( Model model ) {
		model.addAttribute( "categories", categoryService.allCategories() );
		return "new_category.jsp";
	}
	@RequestMapping( value="/categories/new", method=RequestMethod.POST )
	public String newCategory( Model model, @ModelAttribute("category") Category c, BindingResult result ) {
		if ( result.hasErrors() ) { return "new_category.jsp"; }
		else {
			categoryService.createCategory( c );
			return "redirect:/categories/new";
		}
	}
	
	@RequestMapping( value="/categories/{id}", method=RequestMethod.GET )
	public String category( @PathVariable("id") Long id, Model model ) {
		Category c = categoryService.findCategory( id );
		model.addAttribute( "category", c );
		model.addAttribute( "products", categoryService.allProducts( c ) );
		model.addAttribute( "nonProducts", categoryService.allNonProducts( c ) );
		
		return "category.jsp";
	}
	@RequestMapping( value="/categories/{c_id}", method=RequestMethod.POST )
	public String addProduct( @PathVariable("c_id") Long c_id, Model model, @RequestParam(value="product") Long p_id ) {
		Category c = categoryService.findCategory( c_id );
		Product p = productService.findProduct( p_id );
		
		c.getProducts().add( p );
		categoryService.updateCategory( c );
		
		return "redirect:/categories/" + c_id.toString();
	}
}
