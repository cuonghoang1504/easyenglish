package com.easyenglish.DAO;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.easyenglish.Models.Vocabulary;
@Repository
public class VocabularyDAOImpl implements VocabularyDAO{

	private static final Logger logger = LoggerFactory.getLogger(VocabularyDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addVocablulary(Vocabulary v) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(v);
	}

}
