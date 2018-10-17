package com.platzi.platziteacherspring.service;

import java.util.List;

import com.platzi.platziteacherspring.model.SocialMedia;
import com.platzi.platziteacherspring.model.TeacherSocialMedia;

public interface SocialMediaService {
	
	void saveSocialMedia(SocialMedia socialMedia);
	
	void updateSocialMedia(SocialMedia socialMedia);
	
	void deleteSocialMedia(Integer idSocialMedia);
	
	SocialMedia getSocialMediaById(Integer idSocialMedia);
	
	SocialMedia getSocialMediaByName(String name);
	
	TeacherSocialMedia findSocialMediaByIdAndName(Integer idSocialMedia, String nickname);
	
	List<SocialMedia> getAllSocialMedia();

}
