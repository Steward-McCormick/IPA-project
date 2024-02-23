package ru.mccormick.ipa.models;

import ru.mccormick.ipa.enums.Consumer;
import ru.mccormick.ipa.enums.FuelType;
import ru.mccormick.ipa.enums.Unit;

public class CalculationValues {
	
	private int valuesId;
	
	private int calculationId;
	
	private Consumer consumer;
	
	private FuelType fuelType;
	
	private int amount;
	
	private Unit unit;
	
	public CalculationValues() {}
	
	public CalculationValues(Consumer consumer, FuelType fuelType, int amount, Unit unit) {
		this.consumer = consumer;
		this.fuelType = fuelType;
		this.amount = amount;
		this.unit = unit;
	}
	
	public int getCalculationId() {
		return calculationId;
	}
	
	public void setCalculationId(int calculationId) {
		this.calculationId = calculationId;
	}
	
	public Consumer getConsumer() {
		return consumer;
	}
	
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	
	public FuelType getFuelType() {
		return fuelType;
	}
	
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Unit getUnit() {
		return unit;
	}
	
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public int getValuesId() {
		return valuesId;
	}

	public void setValuesId(int valuesId) {
		this.valuesId = valuesId;
	}
	
	@Override
	public String toString() {
		return "CalculationValues{"
				+ consumer.toString() + "; " + fuelType.toString() + ";" 
				+ amount + ";" + unit.toString()
				+ "}";
	}
}
