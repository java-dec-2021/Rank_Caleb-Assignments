package com.rankcaleb.student_roster.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rankcaleb.student_roster.models.Dorm;
import com.rankcaleb.student_roster.models.Student;
import com.rankcaleb.student_roster.repositories.DormRepository;

@Service
public class DormService {
	
	private final DormRepository dormRepo;
	
	public DormService( DormRepository dormRepo ) { this.dormRepo = dormRepo; }
	
	public List<Dorm> allDorms() { return dormRepo.findAll(); }
	public Dorm createDorm( Dorm d ) { return dormRepo.save( d ); }
	public Dorm findDorm( Long id ) {
		Optional<Dorm> optionalDorm = dormRepo.findById( id );
		if ( optionalDorm.isPresent() ) { return optionalDorm.get(); }
		else { return null; }
	}
	public Dorm updateDorm( Long id, String name, List<Student> students, Date createdAt, Date updatedAt ) {
		Dorm d = new Dorm( id, name, students, createdAt, updatedAt );
		return dormRepo.save( d );
	}
	public Dorm updateDorm( Dorm d ) { return dormRepo.save( d ); }
	public void deleteDorm( Long id ) { dormRepo.deleteById( id ); }
	
}
