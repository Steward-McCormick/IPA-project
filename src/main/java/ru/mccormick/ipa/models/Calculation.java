package ru.mccormick.ipa.models;

import java.sql.Date;
import java.util.List;

public class Calculation {
	
	private int calculationId;
	
	private int userId;
	
	private int valuesId;
	
	private List<CalculationValues> calculationValues;
	
	private int calculationResult;
	
	private Date calculationDate;
	
	public int getCalculationId() {
		return calculationId;
	}
	
	public void setCalculationId(int calculationId) {
		this.calculationId = calculationId;
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

	public int getCalculationResult() {
		return calculationResult;
	}

	public void setCalculationResult(int calculationResult) {
		this.calculationResult = calculationResult;
	}

	public Date getCalculationDate() {
		return calculationDate;
	}

	public void setCalculationDate(Date calculationDate) {
		this.calculationDate = calculationDate;
	}

	public int getValuesId() {
		return valuesId;
	}

	public void setValuesId(int valuesId) {
		this.valuesId = valuesId;
	}
}
