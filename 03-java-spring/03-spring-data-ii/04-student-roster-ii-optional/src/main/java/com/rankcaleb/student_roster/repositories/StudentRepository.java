package com.rankcaleb.student_roster.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rankcaleb.student_roster.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

	List<Student> findAll();
    Optional<Student> findById( Long id );
    List<Student> findByDormIdIsNull();
    void deleteById( Long id );
    
}
