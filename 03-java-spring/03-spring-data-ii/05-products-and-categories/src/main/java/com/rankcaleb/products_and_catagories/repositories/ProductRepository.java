package com.rankcaleb.products_and_catagories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rankcaleb.products_and_catagories.models.Category;
import com.rankcaleb.products_and_catagories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findAll();
	Optional<Product> findById( Long id );
	void deleteById( Long id );
	
	// Retrieves a list of all products for a particular category
    List<Product> findAllByCategories( Category product );
    // Retrieves a list of any products a particular category does not belong to.
    List<Product> findByCategoriesNotContains( Category product );
}