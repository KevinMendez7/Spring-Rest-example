package com.platzi.platziteacherspring.dao;

import java.util.List;

import com.platzi.platziteacherspring.model.Teacher;

public interface TeacherDao {
	
	void createTeacher(Teacher teacher);
	
	void updateTeacher(Teacher teacher);
	
	void deleteTeacherById(Integer idTeacher);
	
	Teacher getTeacherById(Integer idTeacher);
	
	Teacher getTeacherByName(String name);	
	
	List<Teacher> getTeacherList();	
	
	
}
