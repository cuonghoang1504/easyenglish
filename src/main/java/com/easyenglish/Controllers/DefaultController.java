package com.easyenglish.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
