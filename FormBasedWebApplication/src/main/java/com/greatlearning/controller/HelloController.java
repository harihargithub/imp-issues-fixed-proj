package com.greatlearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	// use of model - transfer of data to ui

	// Spring provides model, ModelMap, ModelView to define a model in its Spring
	// mvc

	// model -> adds attributes
	// ModelMap -> A holder primarily designed for model attributes
	// ModelAndView -> Holder for Model & View

	// defining a argument ModelMap named as model
	@RequestMapping("/hello")
	public String welcome(ModelMap model) {
		model.addAttribute("message", "Namas Shivaaya");
		// passing model attributee name & value
		// model accessed @ hello.jsp with $(message) command
		return "hello";
	}

}
