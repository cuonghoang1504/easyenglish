package com.easyenglish.Services;

import java.util.List;

import com.easyenglish.Models.Category;

public interface CategoryService {
	public void addCategory(Category c);

	public List<Category> getAllCategories();

	public boolean categoryExist(String cateName);

	public Category findCategoryByName(String s);
}
