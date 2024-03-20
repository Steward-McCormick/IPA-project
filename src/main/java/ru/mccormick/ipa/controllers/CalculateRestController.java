package ru.mccormick.ipa.controllers;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.mccormick.ipa.models.Calculation;
import ru.mccormick.ipa.models.CalculationValues;
import ru.mccormick.ipa.models.CalculationValuesBuilder;
import ru.mccormick.ipa.models.CalculationValuesListBuilder;
import ru.mccormick.ipa.models.GreenhouseGasesCalculator;
import ru.mccormick.ipa.services.CalculationService;
import ru.mccormick.ipa.services.CalculationValuesService;

@RestController
public class CalculateRestController {

	@Autowired
	private CalculationService calculationService;
	
	@Autowired
	private CalculationValuesService calculationValuesService;
	
	@Autowired
	private GreenhouseGasesCalculator calculator;
	
		
	@PostMapping("/calculate")
	public double calculate(@RequestBody String response, @ModelAttribute("builder") CalculationValuesListBuilder builder) throws UnsupportedEncodingException {
		response = decode(response);
		
		System.out.println(response);
		
		
		List<CalculationValues> values = new CalculationValuesBuilder().build(response);
		
		calculator.setCalculationValues(values);
		calculator.setUserEmail("qwerty@mail.ru");
		
		Calculation calculation = calculator.getCalculation();
		int calculationId = calculationService.save(calculation);
		calculationValuesService.saveCalculationValuesList(values, calculationId);
		
		System.out.println(builder.getConsumer() + ", " + builder.getFuelType());
		
		return calculation.getCalculationResult();
	}

	private String decode(String value) throws UnsupportedEncodingException {
		return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
	}
}
