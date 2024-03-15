package ru.mccormick.ipa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.mccormick.ipa.models.CalculationValuesListBuilder;
import ru.mccormick.ipa.models.User;
import ru.mccormick.ipa.services.UserService;

@Controller
public class IndexCalculateController {
	
	@Autowired
	private CalculationValuesListBuilder builder;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("builder", builder);
				
		return "index";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
