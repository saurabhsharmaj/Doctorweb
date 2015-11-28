package com.mahdidoc.service;

import com.mahdidoc.exception.DocException;
import com.mahdidoc.model.UserProfile;

public interface IUserService extends IService<UserProfile> {

	void saveUser(UserProfile u)  throws DocException;


}
