package com.rankcaleb.student_roster.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rankcaleb.student_roster.models.ContactInfo;
import com.rankcaleb.student_roster.models.Student;
import com.rankcaleb.student_roster.repositories.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository studentRepo;
	
	public StudentService( StudentRepository studentRepo ) { this.studentRepo = studentRepo; }
	
	public List<Student> allStudents() { return studentRepo.findAll(); }
	public List<Student> allStudentsNotInDorm() { return studentRepo.findByDormIdIsNull(); }
	public Student createStudent( Student s ) { return studentRepo.save( s ); }
	public Student findStudent( Long id ) {
		Optional<Student> optionalStudent = studentRepo.findById( id );
		if ( optionalStudent.isPresent() ) { return optionalStudent.get(); }
		else { return null; }
	}
	public Student updateStudent( Long id, String firstName, String lastName, int age, ContactInfo contactInfo, Date createdAt, Date updatedAt ) {
		Student s = new Student( id, firstName, lastName, age, contactInfo, createdAt, updatedAt );
		return studentRepo.save( s );
	}
	public Student updateStudent( Student s ) { return studentRepo.save( s ); }
	public void deleteStudent( Long id ) { studentRepo.deleteById( id ); }
	
}