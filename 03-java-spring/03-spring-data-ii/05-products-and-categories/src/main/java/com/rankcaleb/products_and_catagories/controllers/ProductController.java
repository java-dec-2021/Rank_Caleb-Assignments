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
public class ProductController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	public ProductController( ProductService productService, CategoryService categoryService )
	{ this.productService = productService; this.categoryService = categoryService; }
	
	// Routing
	@RequestMapping( value="/", method=RequestMethod.GET )
	public String index() { return "redirect:/products/new"; }
	
	@RequestMapping( value="/products/new", method=RequestMethod.GET )
	public String products( Model model ) {
		model.addAttribute( "products", productService.allProducts() );
		return "new_product.jsp";
	}
	@RequestMapping( value="/products/new", method=RequestMethod.POST )
	public String newProduct( Model model, @ModelAttribute("product") Product p, BindingResult result ) {
		if ( result.hasErrors() ) { return "new_product.jsp"; }
		else {
			productService.createProduct( p );
			return "redirect:/products/new";
		}
	}
	
	@RequestMapping( value="/products/{id}", method=RequestMethod.GET )
	public String product( @PathVariable("id") Long id, Model model ) {
		Product p = productService.findProduct( id );
		model.addAttribute( "product", p );
		model.addAttribute( "categories", productService.allCategories( p ) );
		model.addAttribute( "nonCategories", productService.allNonCategories( p ) );
		
		return "product.jsp";
	}
	@RequestMapping( value="/products/{p_id}", method=RequestMethod.POST )
	public String addCategory( @PathVariable("p_id") Long p_id, Model model, @RequestParam(value="category") Long c_id ) {
		Product p = productService.findProduct( p_id );
		Category c = categoryService.findCategory( c_id );
		
		p.getCategories().add( c );
		productService.updateProduct( p );
		
		return "redirect:/products/" + p_id.toString();
	}
}
