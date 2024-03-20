package ru.mccormick.ipa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ru.mccormick.ipa.models.Calculation;
import ru.mccormick.ipa.models.CalculationValues;
import ru.mccormick.ipa.models.Settings;
import ru.mccormick.ipa.models.User;
import ru.mccormick.ipa.security.UserIpaDetails;
import ru.mccormick.ipa.services.CalculationService;
import ru.mccormick.ipa.services.CalculationValuesService;
import ru.mccormick.ipa.services.SettingsService;

@Controller
public class IndexCalculateController {
	
	private final CalculationService calculationService;
	
	private final CalculationValuesService calculationValuesService;
	
	private final SettingsService settingsService;
	
	@Autowired
	public IndexCalculateController(CalculationService calculationService, CalculationValuesService calculationValuesService, SettingsService settingsService) {
		this.calculationService = calculationService;
		this.calculationValuesService = calculationValuesService;
		this.settingsService = settingsService;
	}
	
	@GetMapping
	public String index(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserIpaDetails details = (UserIpaDetails) authentication.getPrincipal();
		User user = details.getUser();
		model.addAttribute("user", user);
		
		return "main_page";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("/history/{id}")
	public String history(@PathVariable("id") int id, Model model) {
		List<Calculation> list = calculationService.getAllUsersCalc(id);
		
		for(Calculation calc : list) {
			List<CalculationValues> values = calculationValuesService.getValuesList(calc.getCalculationId());
			calc.setCalculationValues(values);
		}
		
		model.addAttribute("calcList", list);
		
		return "history_page";
	}
	
	@GetMapping("/settings/{id}")
	public String settings(@PathVariable("id") int id, Model model) {
		Settings settings = settingsService.findByUserId(id);
		
		model.addAttribute("id", id);
		model.addAttribute("userSet", settings);
		model.addAttribute("settings", new Settings());
		
		return "settings_page";
	}
	
	@PostMapping("/settings/{id}")
	public String settings(@ModelAttribute("settings") Settings settings, @PathVariable("id") int userId) {
settings.setUserId(userId);
		
		settingsService.update(settings, settings.getSettingsId());
		
		return "redirect:/";
	}
}
