package ru.mccormick.ipa.models;

import java.util.List;

public class Calculation {
	
	private int calculationId;
	
	private int userId;
	
	//private int valuesId;
	
	private List<CalculationValues> calculationValues; // is not a column in db
	
	private double calculationResult;
	
	//private Date calculationDate;
	
	public Calculation() {}
	
	public Calculation(int userId, int calculationResult) {
		this.userId = userId;
		this.calculationResult = calculationResult;
		//this.calculationDate = calculationDate;
	}
	
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

	public double getCalculationResult() {
		return calculationResult;
	}

	public void setCalculationResult(double calculationResult) {
		this.calculationResult = calculationResult;
	}

//	public Date getCalculationDate() {
//		return calculationDate;
//	}
//
//	public void setCalculationDate(Date calculationDate) {
//		this.calculationDate = calculationDate;
//	}

//	public int getValuesId() {
//		return valuesId;
//	}
//
//	public void setValuesId(int valuesId) {
//		this.valuesId = valuesId;
//	}
}
