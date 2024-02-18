package ru.mccormick.ipa.models;

public class User {
	
	private int userId;
	private Settings settings;
	private CalculationHistory calculationHistory;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	public CalculationHistory getCalculationHistory() {
		return calculationHistory;
	}

	public void setCalculationHistory(CalculationHistory calculationHistory) {
		this.calculationHistory = calculationHistory;
	}
}
