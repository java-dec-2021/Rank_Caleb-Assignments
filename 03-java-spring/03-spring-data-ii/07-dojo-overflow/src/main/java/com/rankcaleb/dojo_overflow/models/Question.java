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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table( name="questions" )
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
//	@Min( 5 )
	private String question;
	
	@Column( updatable=false )
	private Date createdAt;
	private Date updatedAt;
	
	@OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answer> answers;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tags_questions",
        joinColumns = @JoinColumn(name = "question_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
	
	public Question() {}
	public Question( String question ) { this.question = question; }
	public Question( String question, List<Answer> answers, List<Tag> tags, Date createdAt, Date updatedAt ) {
		this.question = question;
		this.answers = answers;
		this.tags = tags;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Question( Long id, String question, List<Answer> answers, List<Tag> tags, Date createdAt, Date updatedAt ) {
		this.id = id;
		this.question = question;
		this.answers = answers;
		this.tags = tags;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	// getters
	public Long getId() { return this.id; }
	public String getQuestion() { return this.question; }
	public List<Tag> getTags() { return this.tags; }
	public List<Answer> getAnswers() { return this.answers; }
	public Date getCreatedAt() { return this.createdAt; }
	public Date getUpdatedAt() { return this.updatedAt; }
	
	// setters
	public void setQuestion( String question ) { this.question = question; }
	public void setTags( List<Tag> tags ) { this.tags = tags; }
	public void setAnswers( List<Answer> answers ) { this.answers = answers; }
	
	@PrePersist
    protected void onCreate() {	this.createdAt = new Date(); }
    @PreUpdate
    protected void onUpdate() { this.updatedAt = new Date(); }
}