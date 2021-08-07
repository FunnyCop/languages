package com.logan.languages.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.logan.languages.mvc.models.Language;
import com.logan.languages.mvc.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	// Initialize Repository
	
	private final LanguageRepository languageRepository;
	
	public LanguageService( LanguageRepository languageRepository )
		{ this.languageRepository = languageRepository; }
	
	// Retrieve
	
	public List< Language > findAll()
		{ return languageRepository.findAll(); }

	public Language findById( Long id ) {
		Optional< Language > optionalLanguage = languageRepository.findById( id );
		
		if ( optionalLanguage.isPresent() )
			return optionalLanguage.get();
		
		return null;
	}

	public List< Language > findByName( String name )
		{ return languageRepository.findByName( name ); }

	public List< Language > findByCreator( String creator )
		{ return languageRepository.findByCreator( creator ); }

	public List< Language > findByVersion( String version )
		{ return languageRepository.findByVersion( version ); }
	
	// Create

	public Language createLanguage( Language newLanguage )
		{ return languageRepository.save( newLanguage ); }
	
	// Update
	
	public Language updateLanguageName( Long id, String name ) {
		Optional< Language > optionalLanguage = languageRepository.findById( id );
		Language language;
		
		if ( optionalLanguage.isPresent() ) {
			language = optionalLanguage.get();
			language.setId( id );
			language.setName( name );
			
			return languageRepository.save( language );
		}
		
		return null;
	}
	
	public Language updateLanguageCreator( Long id, String creator ) {
		Optional< Language > optionalLanguage = languageRepository.findById( id );
		Language language;
		
		if ( optionalLanguage.isPresent() ) {
			language = optionalLanguage.get();
			language.setId( id );
			language.setCreator( creator );
			
			return languageRepository.save( language );
		}
		
		return null;
	}
	
	public Language updateLanguageVersion( Long id, String version ) {
		Optional< Language > optionalLanguage = languageRepository.findById( id );
		Language language;
		
		if ( optionalLanguage.isPresent() ) {
			language = optionalLanguage.get();
			language.setId( id );
			language.setVersion( version );
			
			return languageRepository.save( language );
		}
		
		return null;
	}

	public Language updateLanguage( Long id, String name, String creator, String version ) {
		Optional< Language > optionalLanguage = languageRepository.findById( id );
		Language language;
		
		if ( optionalLanguage.isPresent() ) {
			language = optionalLanguage.get();
			language.setId( id );
			language.setName( name );
			language.setCreator( creator );
			language.setVersion( version );
			
			return languageRepository.save( language );
		}
		
		return null;
	}
	
	public void updateLanguage(Long id, @Valid Language language) {
		language.setId( id );
		languageRepository.save( language );
	}
	
	// Delete

	public void deleteLanguage( Long id )
		{ languageRepository.deleteById( id ); }

}
