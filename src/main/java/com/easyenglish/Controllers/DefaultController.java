package com.easyenglish.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.easyenglish.Models.Category;

@Controller
public class DefaultController {

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
		if(tab.equals("4")){
			ModelAndView tabContent = new ModelAndView("manageCategory");
			List<Category> categories = new ArrayList<Category>();
			for(int i = 0; i <10; i++){
				Category c = new Category();
				c.setCategoryId(1 + i);
				c.setCategoryName("Category " + i);
				c.setNumOfQuestions(i*5);
				c.setNumOfVocab(i*10);
				categories.add(c);
			}
			tabContent.addObject("categories", categories);
			return tabContent;
		}
		return null;
	}
}
