package com.easyenglish.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyenglish.Models.Category;
import com.easyenglish.Models.Question;
import com.easyenglish.Services.CategoryService;
import com.easyenglish.Services.UserService;


@Controller
public class CategoryController {
private CategoryService categoryService;
	
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	public void setCategoryService(CategoryService cs){
		this.categoryService = cs;
	}
	
	@RequestMapping(value = "admin/addCategory", method = RequestMethod.POST)
	@ResponseBody
	public String addCategory(HttpServletRequest request) {
		Category c = new Category();
		String name = request.getParameter("cateName");
		if(this.categoryService.categoryExist(name)){
			System.out.println("Category existed!");
			return "failed";
		}
		c.setCategoryName(name);
		this.categoryService.addCategory(c);
		return "success";
	}
}