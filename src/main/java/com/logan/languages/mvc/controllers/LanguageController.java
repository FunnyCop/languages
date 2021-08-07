package com.logan.languages.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.logan.languages.mvc.models.Language;
import com.logan.languages.mvc.services.LanguageService;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

import javax.validation.Valid;

@Controller
public class LanguageController {
	
	// Initialize Service
	
	private final LanguageService languageService;
	
	public LanguageController( LanguageService languageService )
		{ this.languageService = languageService; }
	
	// Retrieve
	@RequestMapping( "/" )
	public String index()
		{ return "redirect:/languages"; }
	
	@RequestMapping( "/languages" )
	public String languages(
		Model model
	) {
		if ( !model.containsAttribute( "language" ) ) { model.addAttribute( "language", new Language() ); }
		
		List< Language > languages = languageService.findAll();
		model.addAttribute( "languages", languages );
		
		return "/languages/languages.jsp";
	}
	
	// Create
	
	@RequestMapping( value = "/languages/create", method = RequestMethod.POST )
	public String createLanguage(
		@Valid @ModelAttribute( "language" ) Language language,
		BindingResult result,
		RedirectAttributes redirectAttributes
	) {
		if ( !result.hasErrors() ) {
			languageService.createLanguage( language );
		} else {
			redirectAttributes.addFlashAttribute( "org.springframework.validation.BindingResult.language", result );
			redirectAttributes.addFlashAttribute( "language", language );
		}

		return "redirect:/languages";
	}
	
	// Delete
	
	@RequestMapping( "/languages/delete/{id}" )
	public String deleteLanguage( @PathVariable( "id" ) Long id ) {
		languageService.deleteLanguage( id );

		return "redirect:/languages";
	}
	
	// Update
	@RequestMapping( "/languages/update/{id}" )
	public String updateLanguage( @PathVariable( "id" ) Long id, Model model ) {
		if ( !model.containsAttribute( "language" ) ) {
			Language language = languageService.findById( id );
			model.addAttribute( "language", language );
		}
		
		return "/languages/updateLanguage.jsp";
	}
	
	@RequestMapping( value = "/languages/update/{id}/submit", method = RequestMethod.PUT )
	public String submitUpdate(
		@Valid @ModelAttribute( "language" ) Language language,
		BindingResult result,
		RedirectAttributes redirectAttributes,
		@PathVariable( "id" ) Long id
	) {
		if ( !result.hasErrors() ) {
			languageService.updateLanguage( id, language );

			return "redirect:/languages";
		}
		
		redirectAttributes.addFlashAttribute( "org.springframework.validation.BindingResult.language", result );
		redirectAttributes.addFlashAttribute( "language", language );
		
		return "redirect:/languages/update/" + String.valueOf( id );
	}
	
	// View One
	@RequestMapping( "/languages/id/{id}" )
	public String viewOne( @PathVariable( "id" ) Long id, Model model ) {
		Language language = languageService.findById( id );

		if ( language == null ) { return "redirect:/languages"; }

		model.addAttribute( "id", language.getId() );
		model.addAttribute( "name", language.getName() );
		model.addAttribute( "creator", language.getCreator() );
		model.addAttribute( "version", language.getVersion() );

		return "/languages/oneLanguage.jsp";
	}

}
