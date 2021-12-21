package com.rankcaleb.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="languages")
public class Language {
	
	// attributes.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 2, max = 20)
	private String name;
	@NotNull
	@Size(min = 2, max = 20)
	private String creator;
	@NotNull
	private String currentVersion;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // constructors.
    public Language() {}
    public Language(String name, String creator, String currentVersion) {
        this.name = name;
        this.creator = creator;
        this.currentVersion = currentVersion;
    }
    public Language(Long id, String name, String creator, String currentVersion) {
    	this.id = id;
        this.name = name;
        this.creator = creator;
        this.currentVersion = currentVersion;
    }
    
    // getters.
    public Long getId() { return this.id; }
    public String getName() { return this.name; }
    public String getCreator() { return this.creator; }
    public String getCurrentVersion() { return this.currentVersion; }
    
    // setters.
    public void setId( Long id ) { this.id = id; }
    public void setName( String name ) { this.name = name; }
    public void setCreator( String creator ) { this.creator = creator; }
    public void setCurrentVersion( String currentVersion ) { this.currentVersion = currentVersion; }
    
    @PrePersist
    protected void onCreate() {
    	this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = new Date();
    }
}
