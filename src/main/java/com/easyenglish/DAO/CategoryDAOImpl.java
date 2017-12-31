package com.easyenglish.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.easyenglish.Models.Category;
@Repository
public class CategoryDAOImpl implements CategoryDAO{
	private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	public void addCategory(Category c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(c);
	}
	@Override
	public List<Category> getAllCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from category"); //You will get Weayher object
		List<Category> list = query.list();
		return list;
	}
	@Override
	public boolean categoryExist(String cateName) {
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from category where categoryName=:categoryName");
		query.setParameter("categoryName", cateName);
		Category category = (Category) query.uniqueResult();
		if(category == null)
			return false;
		return true;
	}
	@Override
	public Category findCategoryByName(String c) {
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from category where categoryName=:categoryName");
		query.setParameter("categoryName", c);
		Category category = (Category) query.uniqueResult();
		return category;
	}

}
