package com.rankcaleb.student_roster.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="contactInfo")
public class ContactInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 100)
	private String address;
	@Size(min = 2, max = 50)
	private String city;
	@Size(min = 0, max = 2)
	private String state;
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    
    // constructors
    public ContactInfo(){}
	public ContactInfo( String address, String city, String state, Student student, Date createdAt, Date updatedAt ) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.student = student;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public ContactInfo( Long id, String address, String city, String state, Student student, Date createdAt, Date updatedAt ) {
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.student = student;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
    
    // getters
    public Long getId() { return this.id; }
    public String getAddress() { return this.address; }
    public String getCity() { return this.city; }
    public String getState() { return this.state; }
    public Student getStudent() { return this.student; }
    
    public Date getCreatedAt() { return this.createdAt; }
    public Date getUpdatedAt() { return this.updatedAt; }
    
    // setters
    public void setAddress( String address ) { this.address = address; }
    public void setCity( String city ) { this.city = city; }
    public void setState( String state ) { this.state = state; }
    public void setStudent( Student student ) { this.student = student; }
    
    @PrePersist
    protected void onCreate() {	this.createdAt = new Date(); }
    @PreUpdate
    protected void onUpdate() { this.updatedAt = new Date(); }
    
}