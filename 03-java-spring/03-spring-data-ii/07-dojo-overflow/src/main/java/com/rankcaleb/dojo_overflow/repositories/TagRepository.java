package com.rankcaleb.dojo_overflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rankcaleb.dojo_overflow.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

	List<Tag> findAll();
	Optional<Tag> findById( Long id );
	Optional<Tag> findBySubject( String subject );
	void deleteById( Long id );
}
