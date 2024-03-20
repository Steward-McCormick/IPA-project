package ru.mccormick.ipa.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.mccormick.ipa.enums.FuelType;
import ru.mccormick.ipa.services.SettingsService;
import ru.mccormick.ipa.services.UserService;

@Component
public class GreenhouseGasesCalculator {
	
	private Settings settings;
	
	private String userEmail;
	
	private List<CalculationValues> calculationValues;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SettingsService settingsService;
	
	
	public GreenhouseGasesCalculator() {}
	
	public Calculation getCalculation() {
		setSettings();
		Calculation calculation = new Calculation();
		calculation.setUserId(userService.findByEmail(userEmail).getUserId());
		calculation.setCalculationValues(calculationValues);
		calculation.setCalculationResult(calculate());
		
		return calculation;
	}
	
	private double calculate() {
		double result = 0;
		for(CalculationValues values : calculationValues) {
			result += calculateItaration(values);
		}
		
		return result;
	}
	
	private double calculateItaration(CalculationValues values) {
		Double[] constants = getConstantsArray(values.getFuelType());
		
		double TNV = constants[0];
		double k1 = constants[1];
		double k2 = constants[2];
		
		// Realize supporting m3
		
		double amount = values.getAmount();
		
		System.out.println(TNV + ", " + k1 + ", " + k2 + ", " + amount);
		System.out.println((amount * k1 * TNV * k2 * (44.0/12.0)) / 1000.0);
		
		return Math.round( (amount * k1 * TNV * k2 * (44.0/12.0)) / 1000.0 );
	}
	
	private Double[] getConstantsArray(FuelType fuel) {
		switch(fuel.getColumnName()) {
			case ("raw_oil"):
				return settings.getRawOil();
			case ("gas_condensate"):
				return settings.getGasCondensate();
			case ("automobiles_gasoline"):
				return settings.getAutomobilesGasoline();
			case ("diesel_fuel"):
				return settings.getDieselFuel();
			case ("lighting_kerosene"):
				return settings.getLightingKerosene();
			case ("fuel_oil"):
				return settings.getFuelOil();
			case ("propane_and_butane"):
				return settings.getPropaneAndButane();
			case ("compressed_hc_gases"):
				return settings.getCompressedHydrocarbonGases();
			case ("bitumen"):
				return settings.getBitumen();
			case ("coking_coal"):
				return settings.getCokingCoal();
			case("coal"):
				return settings.getCoal();
			case("natural_gas"):
				return settings.getNaturalGas();
			case("firewood"):
				return settings.getFirewood();
			default:
				throw new IllegalArgumentException("No such results");
		}
	}
	
	private void setSettings() {
		User user = userService.findByEmail(userEmail);
		settings = settingsService.findByUserId(user.getUserId());
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public List<CalculationValues> getCalculationValues() {
		return calculationValues;
	}
	
	public void setCalculationValues(List<CalculationValues> calculationValues) {
		this.calculationValues = calculationValues;
	}
}







