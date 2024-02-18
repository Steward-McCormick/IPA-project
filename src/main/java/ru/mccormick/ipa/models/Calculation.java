package ru.mccormick.ipa.models;

import java.sql.Date;

public class Calculation {
	
	private int calculationId;
	private int userId;
	private CalculationValues calculationValues;
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

	public CalculationValues getCalculationValues() {
		return calculationValues;
	}

	public void setCalculationValues(CalculationValues calculationValues) {
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
}
