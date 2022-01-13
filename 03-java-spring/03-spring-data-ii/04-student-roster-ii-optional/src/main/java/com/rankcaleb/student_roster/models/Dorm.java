package com.rankcaleb.student_roster.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dorm")
public class Dorm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 100)
	private String name;
	
	@OneToMany(mappedBy="dorm", fetch = FetchType.LAZY)
	private List<Student> students;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// constructors
	public Dorm() {}
	public Dorm( String name, List<Student> students, Date createdAt, Date updatedAt ) {
		this.name = name;
		this.students = students;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Dorm( Long id, String name, List<Student> students, Date createdAt, Date updatedAt ) {
		this.id = id;
		this.name = name;
		this.students = students;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	// getters
	public Long getId() { return this.id; }
	public String getName() { return this.name; }
	public List<Student> getStudents() { return this.students; }
	public Date getCreatedAt() { return this.createdAt; }
	public Date getUpdatedAt() { return this.updatedAt; }
	
	// setters
	public void setName( String name ) { this.name = name; }
	public void setStudents( List<Student> students ) { this.students = students; }
	
	@PrePersist
    protected void onCreate() {	this.createdAt = new Date(); }
    @PreUpdate
    protected void onUpdate() { this.updatedAt = new Date(); }
}