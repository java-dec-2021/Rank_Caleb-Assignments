package com.rankcaleb.dojos_and_ninjas.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rankcaleb.dojos_and_ninjas.repositories.NinjaRepository;
import com.rankcaleb.dojos_and_ninjas.models.Dojo;
import com.rankcaleb.dojos_and_ninjas.models.Ninja;

@Service
public class NinjaService {
	
	private final NinjaRepository NinjaRepository;
	
	public NinjaService( NinjaRepository NinjaRepository ) {
		this.NinjaRepository = NinjaRepository;
	}
	
	public List<Ninja> allNinjas() { return NinjaRepository.findAll(); }
	public Ninja createNinja( Ninja n ) { return NinjaRepository.save( n ); }
	public Ninja findNinja( Long id ) {
		Optional<Ninja> optionalNinja = NinjaRepository.findById( id );
		if ( optionalNinja.isPresent() ) { return optionalNinja.get(); }
		else { return null; }
	}
	public Ninja updateNinja( Long id, String firstName, String lastName, int age, Dojo dojo, Date createdAt, Date updatedAt ) {
		Ninja n = new Ninja( id, firstName, lastName, age, dojo, createdAt, updatedAt );
		return NinjaRepository.save( n );
	}
	public Ninja updateNinja( Ninja n ) { return NinjaRepository.save( n ); }
	public void deleteNinja( Long id ) { NinjaRepository.deleteById( id ); }
}