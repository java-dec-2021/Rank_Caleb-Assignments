package com.rankcaleb.student_roster.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rankcaleb.student_roster.models.ContactInfo;
import com.rankcaleb.student_roster.models.Student;
import com.rankcaleb.student_roster.repositories.ContactInfoRepository;

@Service
public class ContactInfoService {

	private final ContactInfoRepository contactInfoRepo;
	
	public ContactInfoService( ContactInfoRepository contactInfoRepo ) { this.contactInfoRepo = contactInfoRepo; }
	
	public List<ContactInfo> allContactInfo() { return contactInfoRepo.findAll(); }
	public ContactInfo createContactInfo( ContactInfo ci ) { return contactInfoRepo.save( ci ); }
	public ContactInfo findContactInfo( Long id ) {
		Optional<ContactInfo> optionalContactInfo = contactInfoRepo.findById( id );
		if ( optionalContactInfo.isPresent() ) { return optionalContactInfo.get(); }
		else { return null; }
	}
	public ContactInfo updateContactInfo( Long id, String address, String city, String state, Student student, Date createdAt, Date updatedAt ) {
		ContactInfo ci = new ContactInfo( id, address, city, state, student, createdAt, updatedAt );
		return contactInfoRepo.save( ci );
	}
	public ContactInfo updateContactInfo( ContactInfo ci ) { return contactInfoRepo.save( ci ); }
	public void deleteContactInfo( Long id ) { contactInfoRepo.deleteById( id ); }
	
}