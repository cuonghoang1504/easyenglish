package com.easyenglish.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyenglish.Models.Answer;
import com.easyenglish.Services.AnswerService;
import com.easyenglish.Services.CategoryService;
import com.easyenglish.Services.QuestionService;
import com.easyenglish.Services.UserService;
import com.easyenglish.Services.VocabularyService;



@Controller
public class AnswerController {
private AnswerService answerService;
private QuestionService questionService;
private CategoryService categoryService;	
private VocabularyService vocabularyService;
private UserService userService;

	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService us){
	this.userService = us;
	}
	@Autowired(required=true)
	@Qualifier(value="vocabularyService")
	public void setVocabularyService(VocabularyService vs){
		this.vocabularyService = vs;
	}
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
	@Autowired(required=true)
	@Qualifier(value="answerService")
	public void setAnswerService(AnswerService as){
		this.answerService = as;
	}
	
	@RequestMapping(value = "/updateAnswer", method = RequestMethod.POST)
	public void updateAnswer(HttpServletRequest request) {
		System.out.println("updating an answer");
		int question_id = Integer.parseInt(request.getParameter("question_id"));
		String answer = request.getParameter("answer");
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		Answer an = this.answerService.findAnswer(question_id, user_id);
		an.setAnswer(answer);
		this.answerService.saveAnswer(an);
		System.out.println("Answer updated!");
	}
}
