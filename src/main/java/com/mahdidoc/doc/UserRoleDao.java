package com.mahdidoc.doc;

import org.springframework.stereotype.Repository;

import com.mahdidoc.model.UserRole;

@Repository
public class UserRoleDao extends BaseDao<UserRole> implements Dao<UserRole> {
	
	public UserRoleDao() {
		super(UserRole.class);
	}	

}
