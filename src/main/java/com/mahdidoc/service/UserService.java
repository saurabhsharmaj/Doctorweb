package com.mahdidoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mahdidoc.doc.UserDao;
import com.mahdidoc.exception.DocException;
import com.mahdidoc.model.UserProfile;

@Service
@Transactional
public class UserService implements IUserService {
		
	@Autowired
	UserDao userDao;
	
	public int insertRow(UserProfile t) throws DocException {
		return userDao.insertRow(t);
	}

	public List<UserProfile> getList() throws DocException {
		return userDao.getList();
	}

	public UserProfile getRowById(int id) throws DocException {
		return userDao.getRowById(id);
	}

	public int updateRow(UserProfile t) throws DocException {
		return userDao.updateRow(t);
	}

	public int deleteRow(int id) throws DocException {
		return userDao.deleteRow(id);
	}

	public void saveUser(UserProfile u) throws DocException {
		if(u.getId() == null){
			u.setEnabled(1);
			insertRow(u);
		}else{
			updateRow(u);
		}
	
		
	}

	public UserProfile getRowByName(String fieldName, String value) {
		// TODO Auto-generated method stub
		return userDao.getRowByName(fieldName,value);
	}

	
	
}
