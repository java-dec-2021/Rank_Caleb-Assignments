package com.rankcaleb.products_and_catagories.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rankcaleb.products_and_catagories.models.Category;
import com.rankcaleb.products_and_catagories.models.Product;
import com.rankcaleb.products_and_catagories.repositories.ProductRepository;

@Service
public class ProductService {
	
private final ProductRepository productRepo;
	
	public ProductService( ProductRepository productRepo ) { this.productRepo = productRepo; }
	
	public List<Product> allProducts() { return productRepo.findAll(); }
//	public List<Category> allCategories( Product p ) { return productRepo.findAllByProducts( p ); }
//	public List<Category> allNonCategories( Product p ) { return productRepo.findByProductsNotContains( p ); }
	
	public Product createProduct( Product p ) { return productRepo.save( p ); }
	public Product findProduct( Long id ) {
		Optional<Product> optionalProduct = productRepo.findById( id );
		if ( optionalProduct.isPresent() ) { return optionalProduct.get(); }
		else { return null; }
	}
	public Product updateProduct( Long id, String name, String description, float price, List<Category> categories, Date createdAt, Date updatedAt ) {
		Product p = new Product( id, name, description, price, categories, createdAt, updatedAt );
		return productRepo.save( p );
	}
	public Product updateProduct( Product p ) { return productRepo.save( p ); }
	public void deleteProduct( Long id ) { productRepo.deleteById( id ); }
}