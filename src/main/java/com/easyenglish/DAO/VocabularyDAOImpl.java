package com.easyenglish.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.easyenglish.Models.Category;
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
		if(this.isVocabExisted(v))
			return;
		this.sessionFactory.getCurrentSession().saveOrUpdate(v);
	}

	@Override
	public void dropVocabTable() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("drop table category_vocab");
		query.executeUpdate();
		query = session.createQuery("drop table vocabulary");
		query.executeUpdate();
		System.out.println("Vocab table dropped!");
	}

	@Override
	public Vocabulary getRandomVocab() {
		Session session = this.sessionFactory.getCurrentSession();
		String query = "From vocabulary ORDER BY RAND()";
		Query q = session.createQuery(query);
		q.setMaxResults(1);
		List<Vocabulary> vs = q.list();
		if(vs.size()>0)
			return vs.get(0);
		return null;
	}

	@Override
	public List<Vocabulary> getRandomVocabsByCate(List<Category> categories) {
		// TODO Auto-generated method stub
		List<Vocabulary> vocabs = new ArrayList<Vocabulary>();
	
		for(Category c : categories){
			vocabs.addAll(c.getVocabs());
		}
		Collections.shuffle(vocabs);
		System.out.println("=====Total vocab found: " + vocabs.size());
		return vocabs.subList(0, vocabs.size() > 10 ? 10 : vocabs.size());
	}

	@Override
	public boolean isVocabExisted(Vocabulary v) {
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from vocabulary v where v.vocab=:vocab");
		query.setParameter("vocab", v.getVocab());
		if(query.list().size()>0)
			return true;
		return false;
	}

}
