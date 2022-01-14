package com.rankcaleb.products_and_catagories.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rankcaleb.products_and_catagories.models.Category;
import com.rankcaleb.products_and_catagories.models.Product;
import com.rankcaleb.products_and_catagories.repositories.CategoryRepository;
import com.rankcaleb.products_and_catagories.repositories.ProductRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepo;
	private final ProductRepository productRepo;
	
	public CategoryService( CategoryRepository categoryRepo, ProductRepository productRepo )
	{ this.categoryRepo = categoryRepo; this.productRepo = productRepo; }
	
	public List<Category> allCategories() { return categoryRepo.findAll(); }
	public List<Product> allProducts( Category c ) { return productRepo.findAllByCategories( c ); }
	public List<Product> allNonProducts( Category c ) { return productRepo.findByCategoriesNotContains( c ); }
	
	public Category createCategory( Category c ) { return categoryRepo.save( c ); }
	public Category findCategory( Long id ) {
		Optional<Category> optionalCategory = categoryRepo.findById( id );
		if ( optionalCategory.isPresent() ) { return optionalCategory.get(); }
		else { return null; }
	}
	public Category updateCategory( Long id, String name, List<Product> products, Date createdAt, Date updatedAt ) {
		Category c = new Category( id, name, products, createdAt, updatedAt );
		return categoryRepo.save( c );
	}
	public Category updateCategory( Category c ) { return categoryRepo.save( c ); }
	public void deleteCategory( Long id ) { categoryRepo.deleteById( id ); }
}