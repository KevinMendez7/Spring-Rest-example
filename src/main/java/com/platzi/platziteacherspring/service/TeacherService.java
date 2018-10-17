package com.platzi.platziteacherspring.service;

import java.util.List;

import com.platzi.platziteacherspring.model.Teacher;

public interface TeacherService {
	
	void createTeacher(Teacher teacher);
	
	void updateTeacher(Teacher teacher);
	
	void deleteTeacherById(Integer idTeacher);
	
	Teacher getTeacherById(Integer idTeacher);
	
	Teacher getTeacherByName(String name);	
	
	List<Teacher> getTeacherList();	

}
