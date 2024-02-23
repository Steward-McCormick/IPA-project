package ru.mccormick.ipa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.mccormick.ipa.utils.CalculationValuesListBuilder;

@Controller
public class SecondTest {

	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("builder", new CalculationValuesListBuilder());
		return "index";
	}
	
	
}
