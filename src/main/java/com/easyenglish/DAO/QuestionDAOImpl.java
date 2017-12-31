package com.easyenglish.DAO;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
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
	@Override
	public void addQuestion(Question q) {
		// TODO Auto-generated method stub
		if(this.isQuestionExisted(q))
			return;
		
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(q);
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
	@Override
	public Question getRandomWritingQuestion() {
		// TODO Auto-generated method stub
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from question where type=:type ORDER BY RAND()");
		query.setParameter("type", 2);
		query.setMaxResults(1);
		List<Question> qs = query.list();
		if(qs.size()>0)
			return qs.get(0);
		return null;
	}
	@Override
	public boolean isQuestionExisted(Question q) {
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from question q where q.question=:question");
		query.setParameter("question", q.getQuestion().trim());
		if(query.list().size()>0)
			return true;
		return false;
	}
}
