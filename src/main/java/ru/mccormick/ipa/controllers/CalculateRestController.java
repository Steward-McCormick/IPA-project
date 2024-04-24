package ru.mccormick.ipa.controllers;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import ru.mccormick.ipa.models.Calculation;
import ru.mccormick.ipa.models.CalculationValues;
import ru.mccormick.ipa.models.CalculationValuesBuilder;
import ru.mccormick.ipa.models.CalculationValuesListBuilder;
import ru.mccormick.ipa.models.GreenhouseGasesCalculator;
import ru.mccormick.ipa.services.CalculationService;
import ru.mccormick.ipa.services.CalculationValuesService;

@RestController
public class CalculateRestController {

	private final CalculationService calculationService;
	
	private final CalculationValuesService calculationValuesService;
	
	private final GreenhouseGasesCalculator calculator;

	@Autowired
	public CalculateRestController(CalculationService calculationService,
								   CalculationValuesService calculationValuesService,
								   GreenhouseGasesCalculator calculator) {
		this.calculationService = calculationService;
		this.calculationValuesService = calculationValuesService;
		this.calculator = calculator;
	}

	@PostMapping("/calculate/{id}")
	public void calculate(@RequestBody String request, @ModelAttribute("builder") CalculationValuesListBuilder builder, 
							@PathVariable("id") int id, HttpServletResponse response) throws IOException {
		request = decode(request);
				
		
		List<CalculationValues> values = new CalculationValuesBuilder().build(request);
		
		calculator.setCalculationValues(values);
		calculator.setUserId(id);

		Calculation calculation = calculator.getCalculation();

		int calculationId = calculationService.save(calculation);
		calculationValuesService.saveCalculationValuesList(values, calculationId);

		response.sendRedirect("/?success");
	}

	private String decode(String value) throws UnsupportedEncodingException {
		return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
	}
}
