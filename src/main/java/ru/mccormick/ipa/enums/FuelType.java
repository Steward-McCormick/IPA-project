package ru.mccormick.ipa.enums;

public enum FuelType {
	RAW_OIL("Сырая нефть"),
	GAS_CONDENSATE("Газовый конденсат"),
	AUTOMOBILE_GASOLINE("Бензин автомобильный"),
	DIESEL_FUEL("Дизельное топливо"),
	LIGHTING_KEROSENE("Керосин осветительный"),
	FUEL_OIL("Топливо нефтяное(мазут)"),
	PROPANE_AND_BUTANE("Пропан и бутан сж."),
	COMPRESSED_HC_GASES("Углеводородные газы сж."),
	BITUMEN("Битум"),
	COKING_COAL("Коксующийся уголь"),
	COAL("Уголь каменный"),
	NATURAL_GAS("Природный газ"),
	FIREWOOD("Дрова для отопления");
	
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
