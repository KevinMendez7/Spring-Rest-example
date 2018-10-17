package com.platzi.platziteacherspring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.platzi.platziteacherspring.model.Teacher;
import com.platzi.platziteacherspring.service.TeacherService;

@Controller
@RequestMapping(value = "/v1")
public class TeacherController {
	
	@Autowired
	private TeacherService _teacherService;
	
	@RequestMapping(value="/teacher", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<List<Teacher>> getTeacher(@RequestParam(value="name", required = false) String name){
		
		List<Teacher> lista = new ArrayList<>();
		
		if(name == null) {
			
			lista = _teacherService.getTeacherList();
			
			if(lista == null || lista.isEmpty()) {
				
				new ResponseEntity(HttpStatus.NOT_FOUND);
				
			}
			
			return new ResponseEntity<List<Teacher>>(lista, HttpStatus.OK);
			
		} else {
		
			Teacher teacher = _teacherService.getTeacherByName(name);
			if(teacher== null) {
				
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				
			}
			
			lista.add(teacher);
			
			return new ResponseEntity<List<Teacher>>(lista, HttpStatus.OK);
			
		}
		
		
//		@RequestMapping(value="/teacher", method = RequestMethod.POST , headers= "Accept=application/json")
//		public ResponseEntity<?> createTeacher(@RequestBody  Teacher teacher, UriComponentsBuilder uriComponentsBuilder){
			
//			if(teacher!=null) {
//				
//				_teacherService.createTeacher(teacher);
//				HttpHeaders headers = new HttpHeaders();
//				headers.setLocation(uriComponentsBuilder
//						.path("/v1/teacher/{id}")
//						.buildAndExpand(teacher.getIdTeacher())
//						.toUri());
				
//				return new ResponseEntity<String>(headers, HttpStatus.CREATED);
				
//			}
			
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
		
		 
//		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}

}
