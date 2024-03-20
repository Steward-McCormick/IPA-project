package ru.mccormick.ipa.models;

import java.util.ArrayList;
import java.util.List;

import ru.mccormick.ipa.enums.Consumer;
import ru.mccormick.ipa.enums.FuelType;
import ru.mccormick.ipa.enums.Unit;

public class CalculationValuesBuilder {
	
	private List<String> consumers = new ArrayList<String>();
	
	private List<String> fuelTypes = new ArrayList<String>();
	
	private List<String> amounts = new ArrayList<String>();
	
	private List<String> units = new ArrayList<String>();
	
	public List<CalculationValues> build(String response) {
		List<CalculationValues> list = new ArrayList<CalculationValues>();
		
		setAllCalculationValues(response);
		
		for(int i = 0; i < consumers.size(); i++) {
			list.add(new CalculationValues(Consumer.fromString(consumers.get(i)),
											FuelType.fromString(fuelTypes.get(i)),
											Integer.parseInt(amounts.get(i)), 
											Unit.fromString(units.get(i))
											)
										);
		}
		
		return list;
	}
	
	private void setAllCalculationValues(String response) {
		setConsumers(response);
		setFuelTypes(response);
		setAmounts(response);
		setUnits(response);
	}
	
	private void setConsumers(String response) {
		for(String str : response.split("&")) {
			String[] splitStr = str.split("=");
			if(splitStr[0].equals("consumer")) {
				consumers.add(splitStr[1]);
				System.out.println(splitStr[1]);
			}
		}
	}
	
	private void setFuelTypes(String response) {
		for(String str : response.split("&")) {
			String[] splitStr = str.split("=");
			if(splitStr[0].equals("fuelType")) {
				fuelTypes.add(splitStr[1]);
				System.out.println(splitStr[1]);
			}
		}
	}
	
	private void setAmounts(String response) {
		for(String str : response.split("&")) {
			String[] splitStr = str.split("=");
			if(splitStr[0].equals("amount")) {
				amounts.add(splitStr[1]);
				System.out.println(splitStr[1]);
			}
		}
	}
	
	private void setUnits(String response) {
		for(String str : response.split("&")) {
			String[] splitStr = str.split("=");
			if(splitStr[0].equals("unit")) {
				units.add(splitStr[1]);
				System.out.println(splitStr[1]);
			}
		}
	}
}
