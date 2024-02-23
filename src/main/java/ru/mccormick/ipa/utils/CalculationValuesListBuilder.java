package ru.mccormick.ipa.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ru.mccormick.ipa.enums.Consumer;
import ru.mccormick.ipa.enums.FuelType;
import ru.mccormick.ipa.enums.Unit;
import ru.mccormick.ipa.models.CalculationValues;

@Component
public class CalculationValuesListBuilder {
	
	private String consumer;
	
	private String fuelType;
	
	private String amount;
	
	private String unit;
	
	public CalculationValuesListBuilder() {	}
	
	public List<CalculationValues> getCalculationValuesList() {
		List<CalculationValues> list = new ArrayList<CalculationValues>();
		String[] consumers = consumer.split(",");
		String[] fuelTypes = fuelType.split(",");
		String[] amounts = amount.split(",");
		String[] units = unit.split(",");
		
		for(int i = 0; i < consumers.length - 1; i++) {
			list.add(new CalculationValues(Consumer.fromString(consumers[i]), FuelType.fromString(fuelTypes[i]),
					Integer.parseInt(amounts[i]), Unit.fromString(units[i])));
		}
		
		return list;
	}

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
