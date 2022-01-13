package com.rankcaleb.products_and_catagories.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rankcaleb.products_and_catagories.models.Category;
import com.rankcaleb.products_and_catagories.models.Product;
import com.rankcaleb.products_and_catagories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepo;
	
	public CategoryService( CategoryRepository categoryRepo ) { this.categoryRepo = categoryRepo; }
	
	public List<Category> allCategories() { return categoryRepo.findAll(); }
//	public List<Product> allProducts( Category c ) { return categoryRepo.findAllByCategories( c ); }
//	public List<Product> allNonProducts( Category c ) { return categoryRepo.findByCategoriesNotContains( c ); }
	
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