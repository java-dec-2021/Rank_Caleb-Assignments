package com.rankcaleb.products_and_catagories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	private float price;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
	
	public Product() {}
	public Product( String name, String description, float price, List<Category> categories, Date createdAt, Date updatedAt ) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.categories = categories;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Product( Long id, String name, String description, float price, List<Category> categories, Date createdAt, Date updatedAt ) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.categories = categories;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	// getters
	public Long getId() { return this.id; }
	public String getName() { return this.name; }
	public String getDescription() { return this.description; }
	public float getPrice() { return this.price; }
	public List<Category> getCategories() { return this.categories; }
	public Date getCreatedAt() { return this.createdAt; }
	public Date getUpdatedAt() { return this.updatedAt; }
	
	// setters
	public void setName( String name ) { this.name = name; }
	public void setDescription( String description ) { this.description = description; }
	public void setPrice( float price ) { this.price = price; }
	public void setCategories( List<Category> categories ) { this.categories = categories; }
	
	@PrePersist
    protected void onCreate() {	this.createdAt = new Date(); }
    @PreUpdate
    protected void onUpdate() { this.updatedAt = new Date(); }
}