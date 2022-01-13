package com.rankcaleb.student_roster.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rankcaleb.student_roster.models.ContactInfo;

public interface ContactInfoRepository extends CrudRepository<ContactInfo, Long>{

	List<ContactInfo> findAll();
    Optional<ContactInfo> findById( Long id );
    void deleteById( Long id );
    
}
