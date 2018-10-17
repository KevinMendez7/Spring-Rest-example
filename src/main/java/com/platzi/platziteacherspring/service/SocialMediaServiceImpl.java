package com.platzi.platziteacherspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platzi.platziteacherspring.dao.SocialMediaDao;
import com.platzi.platziteacherspring.model.SocialMedia;
import com.platzi.platziteacherspring.model.TeacherSocialMedia;

@Service("socialMediaService")
@Transactional
public class SocialMediaServiceImpl implements SocialMediaService {
	
	@Autowired
	private SocialMediaDao _socialMediaDao;

	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		_socialMediaDao.saveSocialMedia(socialMedia);
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		_socialMediaDao.updateSocialMedia(socialMedia);
	}

	@Override
	public void deleteSocialMedia(Integer idSocialMedia) {
		// TODO Auto-generated method stub
		_socialMediaDao.deleteSocialMedia(idSocialMedia);
	}

	@Override
	public SocialMedia getSocialMediaById(Integer idSocialMedia) {
		// TODO Auto-generated method stub
		return _socialMediaDao.getSocialMediaById(idSocialMedia);
	}

	@Override
	public SocialMedia getSocialMediaByName(String name) {
		// TODO Auto-generated method stub
		return _socialMediaDao.getSocialMediaByName(name);
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(Integer idSocialMedia, String nickname) {
		// TODO Auto-generated method stub
		return _socialMediaDao.findSocialMediaByIdAndName(idSocialMedia, nickname);
	}

	@Override
	public List<SocialMedia> getAllSocialMedia() {
		// TODO Auto-generated method stub
		return _socialMediaDao.getAllSocialMedia();
	}

}
