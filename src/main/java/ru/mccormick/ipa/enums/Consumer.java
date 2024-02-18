package ru.mccormick.ipa.enums;

public enum Consumer {
	COAL ("Уголь"),
	NATURAL_GAS ("Натуральный газ"),
	LPG ("Сжиженный нефтяной газ"),
	PATROL ("Бензин"),
	DIESEL ("Дизельное топливо");
	
	private String title;
	
	Consumer(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	@Override
	public String toString() {
		return title;
	}
}
