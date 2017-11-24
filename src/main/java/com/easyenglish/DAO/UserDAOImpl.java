package com.easyenglish.DAO;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.easyenglish.Models.User;

@Repository
public class UserDAOImpl implements UserDAO{
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public boolean userLoginWith(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserWiThUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
