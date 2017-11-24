package com.easyenglish.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyenglish.DAO.UserDAO;
import com.easyenglish.Models.User;

@Service
public class UserServiceImpl implements UserService{

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public boolean userLoginWith(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public User getUserWithUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
