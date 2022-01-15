package com.rankcaleb.dojo_overflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rankcaleb.dojo_overflow.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
	
	List<Answer> findAll();
	Optional<Answer> findById( Long id );
	void deleteById( Long id );
}
