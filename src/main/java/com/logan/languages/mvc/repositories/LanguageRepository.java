package com.logan.languages.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.logan.languages.mvc.models.Language;

public interface LanguageRepository extends CrudRepository< Language, Long > {
	
	// Retrieve

	List< Language > findAll();

	Optional< Language > findById( Long id );

	List< Language > findByName( String name );

	List< Language > findByCreator( String creator );

	List< Language > findByVersion( String version );

}
