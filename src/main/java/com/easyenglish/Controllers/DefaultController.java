package com.easyenglish.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.easyenglish.Models.Category;
import com.easyenglish.Services.CategoryService;

import Response.CategoryView;

@Controller
public class DefaultController {
private CategoryService categoryService;
	
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	public void setCategoryService(CategoryService cs){
		this.categoryService = cs;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		System.out.println("Default page loading!");
	    return "home";
	}
	@RequestMapping(value = "/vocab", method = RequestMethod.GET)
	public String getVocabPage() {
		System.out.println("Vocab page loading!");
	    return "vocab_view";
	}
	@RequestMapping(value = "/speaking", method = RequestMethod.GET)
	public String getSpeakingPage() {
		System.out.println("Speaking page loading!");
	    return "speaking_view";
	}
	@RequestMapping(value = "/writing", method = RequestMethod.GET)
	public String getWritingView() {
		System.out.println("Writing page loading!");
	    return "writing_view";
	}
	
	@RequestMapping(value = "admin/ajax", method = RequestMethod.POST)
	public ModelAndView ajax(HttpServletRequest request) {
		String tab = request.getParameter("tab");
		ModelAndView tabContent = null;
		List<Category> categories = new ArrayList<Category>();
		categories = this.categoryService.getAllCategories();
		if(tab.equals("4")){
			tabContent = new ModelAndView("manageCategory");
			List<CategoryView> categoryViews = new ArrayList<CategoryView>();
			
			for(Category category : categories){
				CategoryView c = new CategoryView();
				c.setCategoryId(category.getCategory_id());
				c.setCategoryName(category.getCategoryName());
				c.setNumOfQuestions(category.getQuestions().size());
				c.setNumOfVocab(category.getVocabs().size());
				categoryViews.add(c);
			}
			tabContent.addObject("categories", categoryViews);
			return tabContent;
		}
		else if(tab.equals("1")){
			tabContent = new ModelAndView("manageSpeaking");
			tabContent.addObject("categories", categories);
		}
		else if(tab.equals("2")){
			tabContent = new ModelAndView("manageWriting");
			tabContent.addObject("categories", categories);
		}
		else if(tab.equals("3")){
			tabContent = new ModelAndView("manageVocab");
			tabContent.addObject("categories", categories);
		}
		return tabContent;
	}
}
