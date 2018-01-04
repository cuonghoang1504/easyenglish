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
import com.easyenglish.Models.Question;
import com.easyenglish.Services.CategoryService;
import com.easyenglish.Services.QuestionService;

@Controller
public class QuestionController {
private QuestionService questionService;
private CategoryService categoryService;	
	@Autowired(required=true)
	@Qualifier(value="questionService")
	public void setQuestionService(QuestionService qs){
		this.questionService = qs;
	}
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	public void setCategoryService(CategoryService cs){
		this.categoryService = cs;
	}
	
	@RequestMapping(value = "admin/addSpeakingQuestion", method = RequestMethod.POST)
	@ResponseBody
	public String addSpeakingQuestion(HttpServletRequest request) {
		Question q = new Question();
		String question = request.getParameter("sQuestion");
		String hint = request.getParameter("sHint");
		String cate = request.getParameter("qCate");
		String part = request.getParameter("part");
		System.out.println(cate);
		String[] cates = cate.split("#");
		List<Category> categories = new ArrayList<Category>(); 
		for(String s: cates){
			if(s.equals(""))
				continue;
			Category c = this.categoryService.findCategoryByName(s);
			c.getQuestions().add(q);
			this.questionService.addQuestion(q);
			categories.add(c);
		}
		q.setCategories(categories);
		q.setQuestion(question);
		q.setHint(hint);
		q.setType(1);
		q.setPart(Integer.parseInt(part));
		
		this.questionService.addQuestion(q);
		return "success";
	}
	
	@RequestMapping(value = "admin/addWritingQuestion", method = RequestMethod.POST)
	@ResponseBody
	public String addWritingQuestion(HttpServletRequest request) {
		Question q = new Question();
		String question = request.getParameter("sQuestion");
		String hint = request.getParameter("sHint");
		String cate = request.getParameter("qCate");
		String module = request.getParameter("module");
		String part = request.getParameter("part");
		
		System.out.println(cate);
		String[] cates = cate.split("#");
		List<Category> categories = new ArrayList<Category>(); 
		for(String s: cates){
			if(s.equals(""))
				continue;
			Category c = this.categoryService.findCategoryByName(s);
			categories.add(c);
		}
		q.setModule(Integer.parseInt(module));
		q.setCategories(categories);
		q.setQuestion(question);
		q.setHint(hint);
		q.setType(2);
		q.setPart(Integer.parseInt(part));
		
		this.questionService.addQuestion(q);
		return "success";
	}
	
	@RequestMapping(value = "speaking/getRandomSpeakingQuestion", method = RequestMethod.POST)
	@ResponseBody
	public String getRamdomSpeakingQuestion(HttpServletRequest request) {
		System.out.println("Request to get a random question!");
		/*
		Question q = this.questionService.getRandomSpeakingQuestion();
		
		SpeakingView sv = new SpeakingView();
		if(q == null){
			sv.setQuestion("Unavaialble!");
			sv.setUsefulVocab("No vocabulary found!");
			return sv;
		}
		sv.setQuestion(q.getQuestion());
		System.out.println(sv.getQuestion());
		sv.setUsefulVocab("ahihi");
		return sv;
		}
		*/
		return "ahihi";
}
}
