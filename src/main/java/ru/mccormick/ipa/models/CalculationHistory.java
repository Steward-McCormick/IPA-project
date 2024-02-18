package ru.mccormick.ipa.models;

public class CalculationHistory {

	private int historyId;
	private int userId;
	private Calculation[] calculationHistory;
	
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

	public Calculation[] getCalculationHistory() {
		return calculationHistory;
	}

	public void setCalculationHistory(Calculation[] calculationHistory) {
		this.calculationHistory = calculationHistory;
	}
}
