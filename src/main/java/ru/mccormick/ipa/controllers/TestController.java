package ru.mccormick.ipa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.mccormick.ipa.models.CalculationValues;
import ru.mccormick.ipa.models.Settings;
import ru.mccormick.ipa.services.CalculationService;
import ru.mccormick.ipa.services.SettingsService;
import ru.mccormick.ipa.utils.CalculationValuesListBuilder;

@RestController
public class TestController {
	
	@Autowired
	private SettingsService settingsService;
	
	@GetMapping("/save")
	public String save() {
		settingsService.save(new Settings(1));
		
		return "secc";
	}
	
	@PostMapping("/test")
	public String test(@ModelAttribute("builder") CalculationValuesListBuilder builder) {
		return builder.getCalculationValuesList().toString();
	}
}
