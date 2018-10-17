package com.platzi.platziteacherspring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.platzi.platziteacherspring.model.SocialMedia;
import com.platzi.platziteacherspring.model.Teacher;
import com.platzi.platziteacherspring.model.TeacherSocialMedia;

@Repository
@Transactional
public class SocialMediaDaoImpl extends AbstractSession implements SocialMediaDao {

	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		getSession().persist(socialMedia);
		
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		getSession().update(socialMedia);
		
	}

	@Override
	public void deleteSocialMedia(Integer idSocialMedia) {
		// TODO Auto-generated method stub
		SocialMedia socialMedia = getSocialMediaById(idSocialMedia);
		if(socialMedia != null) {
			getSession().delete(socialMedia);
		}
		
	}
	
	@Override
	public SocialMedia getSocialMediaById(Integer idSocialMedia) {
		
		return (SocialMedia) getSession().get(SocialMedia.class, idSocialMedia);
	}

	@Override
	public List<SocialMedia> getAllSocialMedia() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from SocialMedia").list();
	}

	@Override
	public SocialMedia getSocialMediaByName(String name) {
		// TODO Auto-generated method stub
		return (SocialMedia) getSession().createQuery("from SocialMedia where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(Integer idSocialMedia, String nickname) {
		// TODO Auto-generated method stub
		List<Object[]> list = getSession().createQuery(
				"from TeacherSocialMedia tsm join tsm.socialMedia sm "
				+ "where sm.idSocialMedia = :idSocialMedia and tsm.nickname = :nickname")
				.setParameter("idSocialMedia", idSocialMedia)
				.setParameter("nickname", nickname).list();
		
		if(list.size() >0) {
			
			for(Object[] object: list) {
				
				for(Object obj : object) {
					if(obj instanceof TeacherSocialMedia) {
						
						return (TeacherSocialMedia) obj;
					}
					
				}
			}
		}
		
		return null;
	}

}
