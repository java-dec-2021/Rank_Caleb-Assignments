package com.rankcaleb.dojos_and_ninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="ninjas")
public class Ninja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 50)
	private String firstName;
	@Size(min = 2, max = 50)
	private String lastName;
	private int age;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dojo_id", nullable=false)
	private Dojo dojo;
	
	public Ninja(){}
	public Ninja( String firstName, String lastName, int age, Dojo dojo, Date createdAt, Date updatedAt ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dojo = dojo;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Ninja( Long id, String firstName, String lastName, int age, Dojo dojo, Date createdAt, Date updatedAt ) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dojo = dojo;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	// getters.
    public Long getId() { return this.id; }
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public int getAge() { return this.age; }
    public Dojo getDojo() { return this.dojo; }
    public Date getCreatedAt() { return this.createdAt; }
    public Date getUpdatedAt() { return this.updatedAt; }

    // setters.
    public void setId( Long id ) { this.id = id; }
    public void setFirstName( String firstName ) { this.firstName = firstName; }
    public void setLastName( String lastName ) { this.lastName = lastName; }
    public void setAge( int age ) { this.age = age; }
    public void setDojo( Dojo dojo ) { this.dojo = dojo; }
    
    @PrePersist
    protected void onCreate() {
    	this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = new Date();
    }
}

