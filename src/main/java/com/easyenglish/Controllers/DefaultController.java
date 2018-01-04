package com.easyenglish.Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.easyenglish.Models.*;
import com.easyenglish.Services.AnswerService;
import com.easyenglish.Services.CategoryService;
import com.easyenglish.Services.QuestionService;
import com.easyenglish.Services.UserService;
import com.easyenglish.Services.VocabularyService;

import Response.CategoryView;
import Response.QuestionView;


@Controller
public class DefaultController {
	
private QuestionService questionService;
private CategoryService categoryService;	
private VocabularyService vocabularyService;
private UserService userService;
private AnswerService answerService;

@Autowired(required=true)
@Qualifier(value="answerService")
public void setCategoryService(AnswerService as){
	this.answerService = as;
}
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
	
	@RequestMapping(value = "/resetAllData", method = RequestMethod.GET)
	@ResponseBody
	public String resetAllData() {
		System.out.println("Resetting all data!");
		//this.categoryService.dropCategoryTable();
		//this.questionService.dropQuestionTable();
		this.vocabularyService.dropVocabTable();
	    return "Done";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		if(this.userService.getUserWithUsername("admin") == null){
			User admin = new User();
			//admin.setUser_id(1);
			admin.setUsername("admin");
			admin.setPassword("admin");
			
			this.userService.addUser(admin);
		}
	    return "home";
	}
	
	@RequestMapping(value = "/mainContant", method = RequestMethod.GET)
	public ModelAndView mainContant(HttpServletRequest request) {
		//System.out.println("Default page loading!");
		String index = request.getParameter("index");
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		ModelAndView mv = new ModelAndView();
	
		if(index.equals("1")){
			Vocabulary v = this.vocabularyService.getRandomVocab();
			if(v == null)
				System.out.println("No vocab found");
			mv.setViewName("vocab_view");
			mv.addObject("vocab", v);
		}else if(index.equals("2")){
			mv.setViewName("speaking_view");
			QuestionView sv = new QuestionView();
			Question q = this.questionService.getRandomSpeakingQuestion();
			if(q == null){
				System.out.println("Controller: Can not found a random question");
				sv.setQuestion("No question found!");
				sv.setUsefulVocab("Unavailable");
				mv.addObject("question", sv);
				return mv;
			}
			System.out.println("----Category found of this question: " + q.getCategories().size());
			List<Vocabulary> vcabs = this.vocabularyService.getRandomVocabsByCate(q.getCategories());
			System.out.println("Num of vocab found: " + vcabs.size());
			String usefulVocab = "";
			for(Vocabulary v : vcabs){
				usefulVocab += v.getVocab() + "; ";
			}
			
			// Get answer and mark if marked
			User user = this.userService.getUserById(user_id);
			List<Answer> answers = user.getAnswers();
			boolean found = false;
			for(Answer a: answers){
				if(a.getQuestion().getQuestion_id() == q.getQuestion_id()){
					found = true;
					//System.out.println("Found answer, answer: " + a.getAnswer());
					sv.setAnswer(a.getAnswer());//.replace("\n", "<br />\n"));
					sv.setMark("" + a.getMark());
						}
					}
			if(!found){
				Answer answer = new Answer();
				answer.setAnswer("");
				answer.setUser(user);
				answer.setQuestion(q);
				answer.setMarked(false);
				this.answerService.saveAnswer(answer);
			}
			sv.setQuestionId(q.getQuestion_id());
		
			sv.setQuestion(q.getQuestion().replace("\n", "<br />\n"));
			System.out.println("------useful vocab: " + usefulVocab);
			sv.setUsefulVocab(usefulVocab);
			sv.setQuestionId(q.getQuestion_id());
			mv.addObject("question", sv);
			
		}else if(index.equals("3")){
			mv.setViewName("writing_view");
			Question q = this.questionService.getRandomWritingQuestion();
			QuestionView qv = new QuestionView();
			if(q == null){
				qv.setQuestion("No question found!");
				qv.setUsefulVocab("Unavailable...");
				mv.addObject("question", qv);
				return mv;
			}
			
			qv.setQuestion(q.getQuestion().replace("\n", "<br />\n"));
			List<Vocabulary> vocabs = new ArrayList<Vocabulary>();
			System.out.println("----Category found of this question: " + q.getCategories().size());
			for(Category c : q.getCategories()){
				List<Vocabulary> vs = c.getVocabs();
				if(vs.size()==0)
					continue;
				
				Collections.shuffle(c.getVocabs());  
				vocabs.addAll(vs.subList(0, vs.size() > 10? 10 : vs.size()));
			}
			
			if(vocabs.size() > 0){
				System.out.println("total vocab found: " + vocabs.size());
				Collections.shuffle(vocabs);
				vocabs = vocabs.subList(0, vocabs.size() > 10 ? 10 : vocabs.size());
				String usefulVocab = "";
				for(Vocabulary v : vocabs){
					usefulVocab += v.getVocab() + "; ";
				}
				System.out.println("------useful vocab: " + usefulVocab);
				qv.setUsefulVocab(usefulVocab);
			}else{
				qv.setUsefulVocab("No word found!");
			}
			
			// Get answer and mark if marked
			User user = this.userService.getUserById(user_id);
			List<Answer> answers = user.getAnswers();
			boolean found = false;
			for(Answer a: answers){
				if(a.getQuestion().getQuestion_id() == q.getQuestion_id()){
					found = true;
					qv.setAnswer(a.getAnswer());//.replace("\n", "<br />\n"));
					qv.setMark("" + a.getMark());
						}
					}
			if(!found){
				Answer answer = new Answer();
				answer.setAnswer("");
				answer.setUser(user);
				answer.setQuestion(q);
				answer.setMarked(false);
				this.answerService.saveAnswer(answer);
			}
			qv.setQuestionId(q.getQuestion_id());
			mv.addObject("question", qv);
		}
	    return mv;
	}
	
	@RequestMapping(value = "/vocab", method = RequestMethod.POST)
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
		System.out.println("--------");
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
