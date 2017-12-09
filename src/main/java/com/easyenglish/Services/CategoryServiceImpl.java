package com.easyenglish.Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyenglish.DAO.CategoryDAO;
import com.easyenglish.Models.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	private CategoryDAO categoryDAO;

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Transactional
	public void addCategory(Category c) {
		this.categoryDAO.addCategory(c);
		
	}

	@Transactional
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return this.categoryDAO.getAllCategories();
	}

	@Transactional
	public boolean categoryExist(String cateName) {
		// TODO Auto-generated method stub
		return this.categoryDAO.categoryExist(cateName);
	}

	@Override
	@Transactional
	public Category findCategoryByName(String c) {
		// TODO Auto-generated method stub
		return this.categoryDAO.findCategoryByName(c);
	}

}
