package com.platzi.platziteacherspring.service;

import java.util.List;

import com.platzi.platziteacherspring.model.Course;

public interface CourseService {
	
	void saveCourse(Course course);
	
	void updateCourse(Course course);
	
	void deleteCourse(Integer idCourse);
	
	List<Course> getAllCourse();
	
	Course getCourseById(Integer idCourse);
	
	Course getCourseByName(String name);
	
	List<Course> getCourseByIdTeacher(Integer idTeacher);

}
