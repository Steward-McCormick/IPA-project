package ru.mccormick.ipa.models;

import java.util.List;

public class CalculationHistory {

	private int historyId;
	private int userId;
	private List<Calculation> calculationHistory;
	
	public CalculationHistory(int userId, List<Calculation> calculationHistory) {
		this.userId = userId;
		this.calculationHistory = calculationHistory;
	}
	
	public int getHistoryId() {
		return historyId;
	}
	
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Calculation> getCalculationHistory() {
		return calculationHistory;
	}

	public void setCalculationHistory(List<Calculation> calculationHistory) {
		this.calculationHistory = calculationHistory;
	}
}
