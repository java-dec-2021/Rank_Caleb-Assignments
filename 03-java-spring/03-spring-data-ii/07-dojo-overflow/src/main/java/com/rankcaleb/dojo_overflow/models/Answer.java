package com.rankcaleb.dojo_overflow.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table( name="answers" )
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
//	@Min( 5 )
	private String answer;
	
	@Column( updatable=false )
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;
	
	public Answer() {}
	public Answer( String answer ) { this.answer = answer; }
	public Answer( String answer, Question question, Date createdAt, Date updatedAt ) {
		this.answer = answer;
		this.question = question;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Answer( Long id, String answer, Question question, Date createdAt, Date updatedAt ) {
		this.id = id;
		this.answer = answer;
		this.question = question;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	// getters
	public Long getId() { return this.id; }
	public String getAnswer() { return this.answer; }
	public Question getQuestion() { return this.question; }
	public Date getCreatedAt() { return this.createdAt; }
	public Date getUpdatedAt() { return this.updatedAt; }
	
	// setters
	public void setAnswer( String answer ) { this.answer = answer; }
	public void setQuestion( Question question ) { this.question = question; }
	
	@PrePersist
    protected void onCreate() {	this.createdAt = new Date(); }
    @PreUpdate
    protected void onUpdate() { this.updatedAt = new Date(); }
}