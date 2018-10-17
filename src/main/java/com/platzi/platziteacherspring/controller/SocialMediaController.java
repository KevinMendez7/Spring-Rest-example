package com.platzi.platziteacherspring.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.platzi.platziteacherspring.HandlerIssues;
import com.platzi.platziteacherspring.model.SocialMedia;
import com.platzi.platziteacherspring.service.SocialMediaService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/v1")
public class SocialMediaController {
	
	@Autowired
	private SocialMediaService _socialMediaService;
	
	//GET ALL AND BY NAME 
	@RequestMapping(value="/socialMedias", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<SocialMedia>> getSocialMedias(@RequestParam(value="name", required = false) String name){
		
		List<SocialMedia> socialMedia = new ArrayList<>();		
		
		if(name==null) {
			
			socialMedia = _socialMediaService.getAllSocialMedia();
			
			if(socialMedia.isEmpty()) {
				
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				
			} else {
				
				
				return new ResponseEntity<List<SocialMedia>>(socialMedia, HttpStatus.OK);
				
			}						
			
		} else{
			
			SocialMedia newSocialMedia = _socialMediaService.getSocialMediaByName(name);
			socialMedia.add(newSocialMedia);
			return new ResponseEntity<List<SocialMedia>>(socialMedia, HttpStatus.OK);
			
		}
				
	}
	
	//GET
	@RequestMapping(value="/socialMedias/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<SocialMedia> getSocialMediaById(@PathVariable("id") Integer idSocialMedia){
		if(idSocialMedia == null || idSocialMedia <= 0 ) {
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			
		}
		
		SocialMedia socialMedia = _socialMediaService.getSocialMediaById(idSocialMedia);
		if(idSocialMedia == null) {
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<SocialMedia>(socialMedia, HttpStatus.OK);
		
		
	}
	
	
	//POST
	@RequestMapping(value="/socialMedias", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createSocialMedia(@RequestBody SocialMedia socialMedia, UriComponentsBuilder uriComponentsBuilder) {
		if(socialMedia.getName().equals(null)||socialMedia.getName().isEmpty()) {
			
			return new ResponseEntity(new HandlerIssues("Name can't be null") , HttpStatus.CONFLICT);
			
		}
		
		if(_socialMediaService.getSocialMediaByName(socialMedia.getName()) != null) {
			
			return new ResponseEntity(new HandlerIssues("Social Media can't be null") , HttpStatus.CONFLICT);
		}
		
		_socialMediaService.saveSocialMedia(socialMedia);
		SocialMedia newSocialMedia = _socialMediaService.getSocialMediaByName(socialMedia.getName()); 
		HttpHeaders headers = new HttpHeaders();		
		headers.setLocation(uriComponentsBuilder
				.path("/v1/socialMedias/{id}")
				.buildAndExpand(newSocialMedia.getIdSocialMedia())
				.toUri());
		
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		
	}
	
	//PATCH
	@RequestMapping(value = "/socialMedias/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<SocialMedia> updateSocialMediaById(@PathVariable("id") Integer idSocialMedia, @RequestBody SocialMedia socialMedia){
		
		if(idSocialMedia == null || idSocialMedia <= 0) {
			
			return new ResponseEntity(new HandlerIssues("idSocialMedia can't be less or equals 0 or null") , HttpStatus.CONFLICT);
			
		}
		
		SocialMedia newSocialMedia = _socialMediaService.getSocialMediaById(idSocialMedia);
		if(newSocialMedia.equals(null)) {
			
			return new ResponseEntity(new HandlerIssues("new SocialMedia can't be null") , HttpStatus.CONFLICT);
			
		}
		
		newSocialMedia.setName(socialMedia.getName());
		newSocialMedia.setIcon(socialMedia.getIcon());
		
		_socialMediaService.updateSocialMedia(newSocialMedia);
		return new ResponseEntity<SocialMedia>(newSocialMedia, HttpStatus.OK);
	}
	
	//DELETE
	@RequestMapping(value = "/socialMedias/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteSocialMediaById(@PathVariable("id") Integer idSocialMedia){
		
		if(idSocialMedia == null || idSocialMedia <= 0) {
			
			return new ResponseEntity(new HandlerIssues("idSocialMedia can't be less or equals 0 or null") , HttpStatus.CONFLICT);
			
		}
		
		SocialMedia newSocialMedia = _socialMediaService.getSocialMediaById(idSocialMedia);
		if(newSocialMedia.equals(null)) {
			
			return new ResponseEntity(new HandlerIssues("Can't delete an inexistent SocialMedia") , HttpStatus.CONFLICT);
			
		}
		
		_socialMediaService.deleteSocialMedia(idSocialMedia);
		return new ResponseEntity(HttpStatus.OK);
	}
	

}
