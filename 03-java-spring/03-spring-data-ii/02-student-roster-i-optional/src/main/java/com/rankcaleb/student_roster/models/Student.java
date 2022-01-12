package com.rankcaleb.student_roster.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 50)
	private String firstName;
	@Size(min = 2, max = 50)
	private String lastName;
	private int age;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    
    @OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private ContactInfo contactInfo;
    
    // constructors
    public Student(){}
	public Student( String firstName, String lastName, int age, ContactInfo contactInfo, Date createdAt, Date updatedAt ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactInfo = contactInfo;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Student( Long id, String firstName, String lastName, int age, ContactInfo contactInfo, Date createdAt, Date updatedAt ) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactInfo = contactInfo;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
    
    // getters.
    public Long getId() { return this.id; }
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public int getAge() { return this.age; }
    public ContactInfo getContactInfo() { return this.contactInfo; }
    public Date getCreatedAt() { return this.createdAt; }
    public Date getUpdatedAt() { return this.updatedAt; }

    // setters.
    public void setFirstName( String firstName ) { this.firstName = firstName; }
    public void setLastName( String lastName ) { this.lastName = lastName; }
    public void setAge( int age ) { this.age = age; }
    public void setContactInfo( ContactInfo contactInfo ) { this.contactInfo = contactInfo; }
    
    @PrePersist
    protected void onCreate() {	this.createdAt = new Date(); }
    @PreUpdate
    protected void onUpdate() { this.updatedAt = new Date(); }
}
