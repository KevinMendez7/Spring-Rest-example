package com.platzi.platziteacherspring.dao;

import java.util.List;

import com.platzi.platziteacherspring.model.Course;

public interface CourseDao {
	
	void saveCourse(Course course);
	
	void updateCourse(Course course);
	
	void deleteCourse(Integer idCourse);
	
	List<Course> getAllCourse();
	
	Course getCourseById(Integer idCourse);
	
	Course getCourseByName(String name);
	
	List<Course> getCourseByIdTeacher(Integer idTeacher);
	

}
