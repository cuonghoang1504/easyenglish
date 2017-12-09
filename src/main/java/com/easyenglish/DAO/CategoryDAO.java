package com.easyenglish.DAO;

import java.util.List;

import com.easyenglish.Models.Category;

public interface CategoryDAO {
	public void addCategory(Category c);

	public List<Category> getAllCategories();

	public boolean categoryExist(String cateName);

	public Category findCategoryByName(String c);
}
