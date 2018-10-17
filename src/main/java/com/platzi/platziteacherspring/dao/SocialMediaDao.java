package com.platzi.platziteacherspring.dao;

import java.util.List;

import com.platzi.platziteacherspring.model.SocialMedia;
import com.platzi.platziteacherspring.model.TeacherSocialMedia;

public interface SocialMediaDao {	
	
	void saveSocialMedia(SocialMedia socialMedia);
	
	void updateSocialMedia(SocialMedia socialMedia);
	
	void deleteSocialMedia(Integer idSocialMedia);
	
	SocialMedia getSocialMediaById(Integer idSocialMedia);
	
	SocialMedia getSocialMediaByName(String name);
	
	TeacherSocialMedia findSocialMediaByIdAndName(Integer idSocialMedia, String nickname);
	
	List<SocialMedia> getAllSocialMedia();

}
