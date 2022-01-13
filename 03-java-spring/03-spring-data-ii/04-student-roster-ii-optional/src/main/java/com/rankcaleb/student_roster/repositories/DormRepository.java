package com.rankcaleb.student_roster.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rankcaleb.student_roster.models.Dorm;

public interface DormRepository extends CrudRepository<Dorm, Long> {
	
	List<Dorm> findAll();
	Optional<Dorm> findById( Long id );
	void deleteById( Long id );
}
