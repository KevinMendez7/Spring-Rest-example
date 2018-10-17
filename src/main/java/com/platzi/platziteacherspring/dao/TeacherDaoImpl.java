package com.platzi.platziteacherspring.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.platzi.platziteacherspring.model.Teacher;
import com.platzi.platziteacherspring.model.TeacherSocialMedia;

@Repository
@Transactional
public class TeacherDaoImpl extends AbstractSession implements TeacherDao {

	@Override
	public Teacher getTeacherById(Integer idTeacher) {
		// TODO Auto-generated method stub
		return (Teacher) getSession().get(Teacher.class, idTeacher);
	}
	
	@Override
	public Teacher getTeacherByName(String name) {
	
		return (Teacher) getSession().createQuery("from Teacher where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	@Override
	public void deleteTeacherById(Integer idTeacher) {
		// TODO Auto-generated method stub
		Teacher teacher = getTeacherById(idTeacher);
		if(teacher != null) {
			
			Iterator<TeacherSocialMedia> it = teacher.getTeacherSocialMedia().iterator();
			
			while(it.hasNext()) {
				
				TeacherSocialMedia teacherSocialMedia = it.next();
				it.remove();
				getSession().delete(teacherSocialMedia);
			}
			teacher.getTeacherSocialMedia().clear();
			getSession().delete(teacher);
		}
		
	}

	@Override
	public List<Teacher> getTeacherList() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Teacher").list();
	}
	

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		getSession().update(teacher);
		
	}

	@Override
	public void createTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		getSession().persist(teacher);
		
	}

}
