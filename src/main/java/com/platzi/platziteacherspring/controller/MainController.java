package com.platzi.platziteacherspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		
		String response ="<a href='https://youtube.com'>Hola putos</a>";
		
		return response;
	}
	

}
