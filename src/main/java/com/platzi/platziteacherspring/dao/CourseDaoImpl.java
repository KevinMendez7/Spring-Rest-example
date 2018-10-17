package com.platzi.platziteacherspring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.platzi.platziteacherspring.model.Course;
import com.platzi.platziteacherspring.model.Teacher;

@Repository
@Transactional
public class CourseDaoImpl extends AbstractSession implements CourseDao {

	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		getSession().persist(course);
		
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		getSession().update(course);
	}

	@Override
	public void deleteCourse(Integer idCourse) {
		// TODO Auto-generated method stub
		Course course = getCourseById(idCourse);
		if(course != null) {
			getSession().delete(course);
		}		
		
	}
	
	@Override
	public Course getCourseById(Integer idCourse) {
		
		return (Course) getSession().get(Course.class, idCourse);
	}

	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Course").list();
	}

	@Override
	public Course getCourseByName(String name) {
		// TODO Auto-generated method stub
		return (Course) getSession().createQuery("from Course where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	@Override
	public List<Course> getCourseByIdTeacher(Integer idTeacher) {
		// TODO Auto-generated method stub
		return (List<Course>) getSession().createQuery(
				"from Course c join c.teacher t where t.idTeacher = :idTeacher")
				.setParameter("idTeacher", idTeacher).list();
	}

}
