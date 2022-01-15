package com.rankcaleb.dojo_overflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rankcaleb.dojo_overflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

	List<Question> findAll();
	Optional<Question> findById( Long id );
	void deleteById( Long id );
}
