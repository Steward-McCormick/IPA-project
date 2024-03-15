package ru.mccormick.ipa.utils;

import java.util.List;


import ru.mccormick.ipa.enums.FuelType;
import ru.mccormick.ipa.models.CalculationValues;
import ru.mccormick.ipa.models.Settings;

public class GreenhouseGasesCalculator {
	
	private Settings settings;
	
	private List<CalculationValues> calculationValues;
	
	public GreenhouseGasesCalculator(Settings settings, List<CalculationValues> calculationValues) {
		this.settings = settings;
		this.calculationValues = calculationValues;
	}
	
	public double calculate() {
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
		
		return amount * k1 * TNV * k2 * (44/12);
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
}







