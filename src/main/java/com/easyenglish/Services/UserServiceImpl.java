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
		return this.userDAO.getUserWiThUsername(username);
	}

	@Transactional
	public User getUserById(int user_id) {
		// TODO Auto-generated method stub
		return this.userDAO.getUserById(user_id);
	}

	@Transactional
	public void addUser(User admin) {
		// TODO Auto-generated method stub
		this.userDAO.addUser(admin);
	}

}
