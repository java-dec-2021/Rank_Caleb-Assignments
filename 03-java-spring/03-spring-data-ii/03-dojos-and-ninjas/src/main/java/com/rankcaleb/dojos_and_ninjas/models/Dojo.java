package com.rankcaleb.dojos_and_ninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

//...
@Entity
@Table(name="dojos")
public class Dojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 50)
	private String name;
	@Column(updatable=false)
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    
	@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
	private List<Ninja> ninjas;
	
	// constructors
	public Dojo(){}
	public Dojo( String name, List<Ninja> ninjas, Date createdAt, Date updatedAt ) {
		this.name = name;
		this.ninjas = ninjas;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Dojo( Long id, String name, List<Ninja> ninjas, Date createdAt, Date updatedAt ) {
		this.id = id;
		this.name = name;
		this.ninjas = ninjas;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
    // getters.
    public Long getId() { return this.id; }
    public String getName() { return this.name; }
    public List<Ninja> getNinjas() { return this.ninjas; }
    public Date getCreatedAt() { return this.createdAt; }
    public Date getUpdatedAt() { return this.updatedAt; }

    // setters.
    public void setId( Long id ) { this.id = id; }
    public void setName( String name ) { this.name = name; }
    public void setNinjas( List<Ninja> ninjas ) { this.ninjas = ninjas; }
    
    @PrePersist
    protected void onCreate() {
    	this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = new Date();
    }
}