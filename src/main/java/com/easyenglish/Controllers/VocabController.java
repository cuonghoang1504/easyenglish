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

import com.easyenglish.Models.Category;
import com.easyenglish.Models.Vocabulary;
import com.easyenglish.Services.CategoryService;
import com.easyenglish.Services.VocabularyService;

@Controller
public class VocabController {
private VocabularyService vocabularyService;
private CategoryService categoryService;
	@Autowired(required=true)
	@Qualifier(value="vocabularyService")
	public void setVocabularyService(VocabularyService vs){
		this.vocabularyService = vs;
	}
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	public void setCategoryService(CategoryService cs){
		this.categoryService = cs;
	}
	
	
	@RequestMapping(value = "admin/addVocabulary", method = RequestMethod.POST)
	@ResponseBody
	public String addVocabulary(HttpServletRequest request) {
		Vocabulary v = new Vocabulary();
		String vocab = request.getParameter("vocab");
		String vocabMean = request.getParameter("vocabMean");
		String cate = request.getParameter("qCate");
		String vocabExample = request.getParameter("vocabExample");
		
		String[] cates = cate.split("#");
		List<Category> categories = new ArrayList<Category>(); 
		for(String s: cates){
			if(s.equals(""))
				continue;
			Category c = this.categoryService.findCategoryByName(s);
			categories.add(c);
		}
		v.setCategories(categories);
		v.setExample(vocabExample);
		v.setMeaning(vocabMean);
		v.setVocab(vocab);
		System.out.println("Adding a vocab..." + vocab + vocabMean + cate + vocabExample);
		this.vocabularyService.addVocab(v);
		return "success";
	}
}