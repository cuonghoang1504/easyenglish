package com.easyenglish.DAO;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.easyenglish.Models.Category;
import com.easyenglish.Models.Question;
@Repository
public class QuestionDAOImpl implements QuestionDAO{
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	public void addCategory(Category c) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(c);
	}
	@Override
	public void addQuestion(Question q) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(q);
	}
	public List<Question> getAllSpeakingQuestion(){
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from question where type=:type");
		query.setParameter("type", 1);
		return query.list();
	}
	@Override
	public Question getRandomSpeakingQuestion() {
		// TODO Auto-generated method stub
		List<Question> qs = this.getAllSpeakingQuestion();
		if(qs.size()==0)
			return null;
		int i = new Random().nextInt(qs.size());
		return qs.get(i);
	}
}
