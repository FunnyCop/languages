package com.logan.languages.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logan.languages.mvc.models.Language;
import com.logan.languages.mvc.services.LanguageService;

@RestController
@RequestMapping( "/api/languages" )
public class LanguageApi {
	
	// Initialize Service
	
	public final LanguageService languageService;
	
	public LanguageApi( LanguageService languageService ) { this.languageService = languageService; }
	
	// Retrieve
	
	@RequestMapping( value = "/all", method = RequestMethod.GET )
	public List< Language > findById() { return languageService.findAll(); }
	
	@RequestMapping( value = "/id/{id}", method = RequestMethod.GET )
	public Language findById( @PathVariable( "id" ) Long id ) { return languageService.findById( id ); }
	
	@RequestMapping( value = "/name/{name}", method = RequestMethod.GET )
	public List< Language > findByName( @PathVariable( "name" ) String name ) { return languageService.findByName( name ); }
	
	@RequestMapping( value = "/creator/{creator}", method = RequestMethod.GET )
	public List< Language > findByCreatorF( @PathVariable( "creator" ) String creator ) { return languageService.findByCreator( creator ); }
	
	@RequestMapping( value = "/version/{version}", method = RequestMethod.GET )
	public List< Language > findByVersion( @PathVariable( "version" ) String version ) { return languageService.findByVersion( version ); }
	
	// Create

	@RequestMapping( value = "/create", method = RequestMethod.POST )
	public Language createLanguage(
		@RequestParam( "name" ) String name,
		@RequestParam( "creator" ) String creator,
		@RequestParam( "version" ) String version
	) {
		Language newLanguage = new Language( name, creator, version );
		return languageService.createLanguage( newLanguage );
	}
	
	// Update
	
	@RequestMapping( value = "/update/name/{id}", method = RequestMethod.PUT )
	public Language updateLanguageName(
		@PathVariable( "id" ) Long id,
		@RequestParam( "name" ) String name
	) {
		return languageService.updateLanguageName( id, name );
	}
	
	@RequestMapping( value = "/update/creator/{id}", method = RequestMethod.PUT )
	public Language updateLanguageCreator(
		@PathVariable( "id" ) Long id,
		@RequestParam( "creator" ) String creator
	) {
		return languageService.updateLanguageCreator( id, creator );
	}
	
	@RequestMapping( value = "/update/version/{id}", method = RequestMethod.PUT )
	public Language updateLanguageVersion(
		@PathVariable( "id" ) Long id,
		@RequestParam( "version" ) String version
	) {
		return languageService.updateLanguageVersion( id, version );
	}

	@RequestMapping( value = "/update/{id}", method = RequestMethod.PUT )
	public Language updateLanguage(
		@PathVariable( "id" ) Long id,
		@RequestParam( "name" ) String name,
		@RequestParam( "creator" ) String creator,
		@RequestParam( "version" ) String version
	) {
		return languageService.updateLanguage( id, name, creator, version );
	}
	
	// Delete
	
	@RequestMapping( value = "/delete/{id}", method = RequestMethod.DELETE )
	public void deleteLanguage( @PathVariable( "id" ) Long id ) { languageService.deleteLanguage( id ); }

}
