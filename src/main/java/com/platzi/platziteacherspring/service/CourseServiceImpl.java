package com.platzi.platziteacherspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platzi.platziteacherspring.dao.CourseDao;
import com.platzi.platziteacherspring.model.Course;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao _courseDao;

	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		_courseDao.saveCourse(course);
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		_courseDao.updateCourse(course);
	}

	@Override
	public void deleteCourse(Integer idCourse) {
		// TODO Auto-generated method stub
		_courseDao.deleteCourse(idCourse);
	}

	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return _courseDao.getAllCourse();
	}

	@Override
	public Course getCourseById(Integer idCourse) {
		// TODO Auto-generated method stub
		return _courseDao.getCourseById(idCourse);
	}

	@Override
	public Course getCourseByName(String name) {
		// TODO Auto-generated method stub
		return _courseDao.getCourseByName(name);
	}

	@Override
	public List<Course> getCourseByIdTeacher(Integer idTeacher) {
		// TODO Auto-generated method stub
		return _courseDao.getCourseByIdTeacher(idTeacher);
	}

}
