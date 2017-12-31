package com.easyenglish.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.easyenglish.Models.Question;
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
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from user where username=:username");
		query.setParameter("username", username);
		query.setMaxResults(1);
		List<User> us = query.list();
		if(us.size()>0)
			return us.get(0);
		return null;
	}

	@Override
	public User getUserById(int user_id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user =  (User) session.get(User.class, user_id);
		return user;
	}

	@Override
	public void addUser(User admin) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(admin);
	}

}
