package ru.mccormick.ipa.models;

public class User {

	private int userId;
	
	private String email;
	
	private String password;
	
	// Not db`s columns
	private int settingsId;
	
	private Settings settings;
	
	private CalculationHistory calculationHistory;
	
	public User() {}
	
	public User(int userId, int settingsId, Settings settings, CalculationHistory calculationHistory) {
		this.userId = userId;
		this.settingsId = settingsId;
		this.settings = settings;
		this.calculationHistory = calculationHistory;
	}
	
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

	public int getSettingsId() {
		return settingsId;
	}

	public void setSettingsId(int settingsId) {
		this.settingsId = settingsId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
