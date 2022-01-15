package com.rankcaleb.dojo_overflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table( name="tags" )
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String subject;
	
	@Column( updatable=false )
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tags_questions", 
        joinColumns = @JoinColumn(name = "tag_id"),
        inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;
	
	public Tag() {}
	public Tag( String subject ) { this.subject = subject; }
	public Tag( String subject, List<Question> questions, Date createdAt, Date updatedAt ) {
		this.subject = subject;
		this.questions = questions;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Tag( Long id, String subject, List<Question> questions, Date createdAt, Date updatedAt ) {
		this.id = id;
		this.subject = subject;
		this.questions = questions;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	// getters
	public Long getId() { return this.id; }
	public String getSubject() { return this.subject; }
	public List<Question> getQuestions() { return this.questions; }
	public Date getCreatedAt() { return this.createdAt; }
	public Date getUpdatedAt() { return this.updatedAt; }
	
	// setters
	public void setSubject( String subject ) { this.subject = subject; }
	public void setQuestions( List<Question> questions ) { this.questions = questions; }
	
	@PrePersist
    protected void onCreate() {	this.createdAt = new Date(); }
    @PreUpdate
    protected void onUpdate() { this.updatedAt = new Date(); }
}