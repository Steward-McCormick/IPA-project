package ru.mccormick.ipa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.mccormick.ipa.models.Calculation;
import ru.mccormick.ipa.models.CalculationValuesListBuilder;
import ru.mccormick.ipa.models.Settings;
import ru.mccormick.ipa.models.User;
import ru.mccormick.ipa.services.CalculationService;
import ru.mccormick.ipa.services.CalculationValuesService;
import ru.mccormick.ipa.services.SettingsService;
import ru.mccormick.ipa.services.UserService;
import ru.mccormick.ipa.utils.GreenhouseGasesCalculator;

@RestController
public class CalculateRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SettingsService settingsService;
	
	@Autowired
	private CalculationService calculationService;
	
	@Autowired
	private CalculationValuesService calculationValuesService;
	
	private GreenhouseGasesCalculator calculator;
	
	@PostMapping("/calculate")
	public double calculate(@ModelAttribute CalculationValuesListBuilder builder) {
		User user = userService.findByEmail("qwerty@mail.ru");
		Settings settings = settingsService.findByUserId(user.getUserId());
		Calculation calculation = new Calculation();
		calculation.setUserId(user.getUserId());
		calculation.setCalculationValues(builder.getCalculationValuesList());
		
		calculator = new GreenhouseGasesCalculator(settings, calculation.getCalculationValues());
		double calculationResult = calculator.calculate();
		calculation.setCalculationResult(calculationResult);		
		int calculation_id = calculationService.save(calculation);
		calculationValuesService.saveCalculationValuesList(builder.getCalculationValuesList(), 
														calculation_id);
		
		return calculationResult;
	}
}
