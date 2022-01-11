package com.rankcaleb.dojos_and_ninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rankcaleb.dojos_and_ninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long>{
	
    List<Dojo> findAll();
    Optional<Dojo> findById( Long id );
    void deleteById( Long id );
    
}