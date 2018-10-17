package com.platzi.platziteacherspring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;;




@Entity
@Table(name="teacher")
public class Teacher implements Serializable {
	
	@Id
	@Column(name="id_teacher")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTeacher;
	
	@Column(name="name")
	private String name;
	
	@Column(name="avatar")
	private String avatar;
	
	@OneToMany(mappedBy="teacher")
	@JsonIgnore
	private Set<Course> course;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="id_teacher")
	@JsonIgnore
	private Set<TeacherSocialMedia> teacherSocialMedia;	

	public Teacher() {
	}	
	
	public Teacher(String name, String avatar) {			
		this.name = name;
		this.avatar = avatar;
	}
	
	public Teacher(Integer idTeacher, String name, String avatar) {
		super();
		this.idTeacher = idTeacher;
		this.name = name;
		this.avatar = avatar;
	}

	public Integer getIdTeacher() {
		return idTeacher;
	}
	
	public void setIdTeacher(Integer idTeacher) {
		this.idTeacher = idTeacher;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	public Set<TeacherSocialMedia> getTeacherSocialMedia() {
		return teacherSocialMedia;
	}

	public void setTeacherSocialMedia(Set<TeacherSocialMedia> teacherSocialMedia) {
		this.teacherSocialMedia = teacherSocialMedia;
	}

}
