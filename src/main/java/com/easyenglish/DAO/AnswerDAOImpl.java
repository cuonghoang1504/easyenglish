package com.easyenglish.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.easyenglish.Models.Answer;
import com.easyenglish.Models.Category;

@Repository
public class AnswerDAOImpl implements AnswerDAO{
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void saveAnswer(Answer answer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(answer);
		
	}

	@Override
	public Answer findAnswer(int question_id, int user_id) {
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from answer where user_id=:user_id and question_id=:question_id");
		query.setParameter("question_id", question_id);
		query.setParameter("user_id", user_id);
		return (Answer) query.uniqueResult();
	}
}
