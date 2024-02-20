package ru.mccormick.ipa.enums;

public enum FuelType {
	COAL ("Уголь"),
	NATURAL_GAS ("Натуральный газ"),
	LPG ("Сжиженный нефтяной газ"),
	PATROL ("Бензин"),
	DIESEL ("Дизельное топливо");
	
	private String title;
	
	FuelType(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public static FuelType fromString(String value) {
		if(value != null) {
			for(FuelType type : FuelType.values()) {
				if(value.equalsIgnoreCase(type.title)) {
					return type;
				}
			}
		}
		
		throw new IllegalArgumentException("No such values");
	}
	
	@Override
	public String toString() {
		return title;
	}
}
