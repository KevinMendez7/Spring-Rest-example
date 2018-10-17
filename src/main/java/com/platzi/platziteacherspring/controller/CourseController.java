package com.platzi.platziteacherspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.platzi.platziteacherspring.HandlerIssues;
import com.platzi.platziteacherspring.model.Course;
import com.platzi.platziteacherspring.service.CourseService;

@Controller
@RequestMapping("/v1")
public class CourseController {
	
	@Autowired
	private CourseService _courseService;
	
	//GET
	@RequestMapping(value = "/course", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Course>> getAllCourses(){
		
		List<Course> lista = _courseService.getAllCourse();
		if(lista == null || lista.isEmpty()) {
			
			return new ResponseEntity(new HandlerIssues("No se encontro ningun curso"), HttpStatus.NOT_FOUND); 
			
		}
		
		return new ResponseEntity<List<Course>>(lista, HttpStatus.OK);
		
	}
	
	//POST
	@RequestMapping(value = "/course", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Course> createCourse(@RequestBody Course course, UriComponentsBuilder uriComponentsBuilder){
		
		if(course != null) {
			
			_courseService.saveCourse(course);
			Course newCourse = _courseService.getCourseByName(course.getName());
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setLocation(uriComponentsBuilder
					.path("v1/course/{id}")
					.buildAndExpand(newCourse.getName())
					.toUri());
			return new ResponseEntity<Course>(course, HttpStatus.OK);
			
		}
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}

}
