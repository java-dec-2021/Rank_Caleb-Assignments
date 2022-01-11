package com.rankcaleb.dojos_and_ninjas.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rankcaleb.dojos_and_ninjas.repositories.DojoRepository;
import com.rankcaleb.dojos_and_ninjas.models.Dojo;
import com.rankcaleb.dojos_and_ninjas.models.Ninja;

@Service
public class DojoService {
	
	private final DojoRepository DojoRepository;
	
	public DojoService( DojoRepository DojoRepository ) {
		this.DojoRepository = DojoRepository;
	}
	
	public List<Dojo> allDojos() { return DojoRepository.findAll(); }
	public Dojo createDojo( Dojo d ) { return DojoRepository.save( d ); }
	public Dojo findDojo( Long id ) {
		Optional<Dojo> optionalDojo = DojoRepository.findById( id );
		if ( optionalDojo.isPresent() ) { return optionalDojo.get(); }
		else { return null; }
	}
	public Dojo updateDojo( Long id, String name, List<Ninja> ninjas, Date createdAt, Date updatedAt ) {
		Dojo l = new Dojo( id, name, ninjas, createdAt, updatedAt );
		return DojoRepository.save( l );
	}
	public Dojo updateDojo( Dojo d ) { return DojoRepository.save( d ); }
	public void deleteDojo( Long id ) { DojoRepository.deleteById( id ); }
}