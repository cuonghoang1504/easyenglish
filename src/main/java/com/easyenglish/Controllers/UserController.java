package com.easyenglish.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.easyenglish.Services.PersonService;
import com.easyenglish.Services.UserService;

@Controller
public class UserController {
private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService us){
		this.userService = us;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String index(Model model) {
		System.out.println("Someone is loading the admin page");
		return "admin";
		//return "admin";
	}
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView userLogin(Model model, HttpServletRequest request) {
		System.out.println("Someone is logging in the system");
		
		ModelAndView modelAndView;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String errorMessage = "";
		boolean loginSucceed = false;
		if(username.length()*password.length() == 0){
			
		}else{
			loginSucceed = true;//this.userService.userLoginWith(username, password);
		}
		if(loginSucceed){
			modelAndView = new ModelAndView("management");
			modelAndView.addObject("loggedIn", true);
			modelAndView.addObject("username", username);
			return modelAndView;
		}else{
			modelAndView = new ModelAndView("admin");
			modelAndView.addObject("username", username);
			modelAndView.addObject("errorMessage", "Either username or password entered wrong. Try again!");
			return modelAndView;
		}
	}
}
