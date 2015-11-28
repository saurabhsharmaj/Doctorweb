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

		

}
