package com.rankcaleb.dojo_overflow.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rankcaleb.dojo_overflow.models.Question;
import com.rankcaleb.dojo_overflow.models.Tag;
import com.rankcaleb.dojo_overflow.repositories.TagRepository;

@Service
public class TagService {

	private TagRepository tagRepo;
	public TagService( TagRepository tagRepo ) { this.tagRepo = tagRepo;}
	
	public List<Tag> allTags() { return tagRepo.findAll(); }
	public Tag createTag( Tag value ) { return tagRepo.save( value ); }
	public Tag findTag( Long id ) {
		Optional<Tag> optional = tagRepo.findById( id );
		if ( optional.isPresent() ) { return optional.get(); }
		else { return null; }
	}
	public Tag findTag( String subject ) {
		Optional<Tag> optional = tagRepo.findBySubject( subject );
		if ( optional.isPresent() ) { return optional.get(); }
		else { return null; }
	}
	public Tag updateTag( Long id, String subject, List<Question> questions, Date createdAt, Date updatedAt ) {
		Tag value = new Tag( id, subject, questions, createdAt, updatedAt );
		return tagRepo.save( value );
	}
	public Tag updateTag( Tag value ) { return tagRepo.save( value ); }
	public void deleteTag( Long id ) { tagRepo.deleteById( id ); }
}
