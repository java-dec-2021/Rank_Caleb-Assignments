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
	
    // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    // Retrieves a list of any categories a particular product does not belong to.
    List<Category> findByProductsNotContains(Product product);
}