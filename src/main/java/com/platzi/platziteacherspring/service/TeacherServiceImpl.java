package com.platzi.platziteacherspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platzi.platziteacherspring.dao.TeacherDao;
import com.platzi.platziteacherspring.model.Teacher;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherDao _teacherDao;

	@Override
	public void createTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		_teacherDao.createTeacher(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		_teacherDao.updateTeacher(teacher);
	}

	@Override
	public void deleteTeacherById(Integer idTeacher) {
		// TODO Auto-generated method stub
		_teacherDao.deleteTeacherById(idTeacher);
	}

	@Override
	public Teacher getTeacherById(Integer idTeacher) {
		// TODO Auto-generated method stub
		return _teacherDao.getTeacherById(idTeacher);
	}

	@Override
	public Teacher getTeacherByName(String name) {
		// TODO Auto-generated method stub
		return _teacherDao.getTeacherByName(name);
	}

	@Override
	public List<Teacher> getTeacherList() {
		// TODO Auto-generated method stub
		return _teacherDao.getTeacherList();
	}

}
