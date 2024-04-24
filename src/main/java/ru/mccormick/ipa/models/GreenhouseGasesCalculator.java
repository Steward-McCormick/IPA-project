package ru.mccormick.ipa.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.mccormick.ipa.enums.FuelType;
import ru.mccormick.ipa.enums.Unit;
import ru.mccormick.ipa.services.SettingsService;
import ru.mccormick.ipa.utils.UnitConverter.UnitConverter;

@Component
public class GreenhouseGasesCalculator {
	
	private Settings settings;
	
	private int userId;
	
	private List<CalculationValues> calculationValues;
	
	private SettingsService settingsService;
	
	public GreenhouseGasesCalculator() {}

	@Autowired
	public GreenhouseGasesCalculator(SettingsService settingsService) {
		this.settingsService = settingsService;
	}

	public Calculation getCalculation() {
		setSettings();
		Calculation calculation = new Calculation();
		calculation.setUserId(userId);
		calculation.setCalculationValues(calculationValues);
		calculation.setCalculationResult(calculate());
		
		return calculation;
	}
	
	private double calculate() {
		double result = 0;
		for(CalculationValues values : calculationValues) {
			result += calculateIteration(values);
		}
		
		return result;
	}
	
	private double calculateIteration(CalculationValues values) {
		Double[] constants = getConstantsArray(values.getFuelType());
		
		double TNV = constants[0];
		double k1 = constants[1];
		double k2 = constants[2];

		double amount;

		if (values.getUnit().equals(Unit.CUBIC_METERS)) {
			amount = UnitConverter.convertUnitToTons(values);
		}
		else {
			amount = values.getAmount();
		}
		
		System.out.println(TNV + ", " + k1 + ", " + k2 + ", " + amount);
		double v = (amount * k1 * TNV * k2 * (44.0 / 12.0)) / 1000.0;

		BigDecimal bigDecimal = new BigDecimal(v).setScale(2, RoundingMode.HALF_UP);

		return bigDecimal.doubleValue();
	}
	
	private Double[] getConstantsArray(FuelType fuel) {
		return switch (fuel.getColumnName()) {
			case ("raw_oil") -> settings.getRawOil();
			case ("gas_condensate") -> settings.getGasCondensate();
			case ("automobiles_gasoline") -> settings.getAutomobilesGasoline();
			case ("diesel_fuel") -> settings.getDieselFuel();
			case ("lighting_kerosene") -> settings.getLightingKerosene();
			case ("fuel_oil") -> settings.getFuelOil();
			case ("propane_and_butane") -> settings.getPropaneAndButane();
			case ("compressed_hc_gases") -> settings.getCompressedHydrocarbonGases();
			case ("bitumen") -> settings.getBitumen();
			case ("coking_coal") -> settings.getCokingCoal();
			case ("coal") -> settings.getCoal();
			case ("natural_gas") -> settings.getNaturalGas();
			case ("firewood") -> settings.getFirewood();
			default -> throw new IllegalArgumentException("No such results");
		};
	}
	
	private void setSettings() {
		this.settings = settingsService.findByUserId(userId);
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public List<CalculationValues> getCalculationValues() {
		return calculationValues;
	}
	
	public void setCalculationValues(List<CalculationValues> calculationValues) {
		this.calculationValues = calculationValues;
	}
}







