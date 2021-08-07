package com.logan.languages.mvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Language {
	
	// Columns/Fields
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id; // language.id -> Long

	@NotNull
    @Size( min = 3, max = 20 )
    private String name; // language.name -> String

	@NotNull
    @Size( min = 3, max = 20 )
    private String creator; // language.creator -> String
	
	@NotNull
    @Size( min = 1, max = 255 )
    private String version; // language.version -> String
	
	// Getters
	
	public Long getId() { return this.id; } // language.id -> Long
	
	public String getName() { return this.name; } // language.name -> String
	
	public String getCreator() { return this.creator; } // language.creator -> String
	
	public String getVersion() { return this.version; } // language.version -> String
	
	// Setters
	
	public void setId( Long newId ) { this.id = newId; } // language.id -> Long
	
	public void setName( String newName ) { this.name = newName; } // language.name -> String
	
	public void setCreator( String newCreator ) { this.creator = newCreator; } // language.creator -> String
	
	public void setVersion( String newVersion ) { this.version = newVersion; } // language.version -> String
	
	// Constructors
	
	public Language() {}
	
	public Language(
		String newName,
		String newCreator,
		String newVersion
	) {
		this.name = newName;
		this.creator = newCreator;
		this.version = newVersion;
	}
}
