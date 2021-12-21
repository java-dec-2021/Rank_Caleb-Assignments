package com.rankcaleb.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rankcaleb.languages.repositories.LanguageRepository;
import com.rankcaleb.languages.models.Language;

@Service
public class LanguageService {
	
	private final LanguageRepository languageRepository;
	
	public LanguageService( LanguageRepository languageRepository ) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages() { return languageRepository.findAll(); }
	public Language createLanguage( Language l ) { return languageRepository.save( l ); }
	public Language findLanguage( Long id ) {
		Optional<Language> optionalLanguage = languageRepository.findById( id );
		if ( optionalLanguage.isPresent() ) { return optionalLanguage.get(); }
		else { return null; }
	}
	public Language updateLanguage( Long id, String name, String creator, String currentVersion ) {
		Language l = new Language( id, name, creator, currentVersion );
		return languageRepository.save( l );
	}
	public Language updateLanguage( Language l ) { return languageRepository.save( l ); }
	public void deleteLanguage( Long id ) { languageRepository.deleteById( id ); }
}
