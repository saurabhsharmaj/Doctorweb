package com.mahdidoc.doc;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mahdidoc.model.UserProfile;

@Repository
public class UserDao extends BaseDao<UserProfile> implements Dao<UserProfile> {
	
	public UserDao() {
		super(UserProfile.class);
	}

	public UserProfile getRowByName(String fieldName, String value) {
		Session session = getSession();
		DetachedCriteria criteria = DetachedCriteria
				.forClass(typeParameterClass);
		criteria.add(Restrictions.eq(fieldName, value));
		UserProfile t = (UserProfile) criteria.getExecutableCriteria(session).uniqueResult();
		return t;
	}	

}
