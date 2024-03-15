package ru.mccormick.ipa.enums;

public enum FuelType {
	RAW_OIL("Сырая нефть", "raw_oil"),
	GAS_CONDENSATE("Газовый конденсат", "gas_condensate"),
	AUTOMOBILE_GASOLINE("Бензин автомобильный", "automobiles_gasoline"),
	DIESEL_FUEL("Дизельное топливо", "diesel_fuel"),
	LIGHTING_KEROSENE("Керосин осветительный", "lighting_kerosene"),
	FUEL_OIL("Топливо нефтяное(мазут)", "fuel_oil"),
	PROPANE_AND_BUTANE("Пропан и бутан сж.", "propane_and_butane"),
	COMPRESSED_HC_GASES("Углеводородные газы сж.", "compressed_hc_gases"),
	BITUMEN("Битум", "bitumen"),
	COKING_COAL("Коксующийся уголь", "coking_coal"),
	COAL("Уголь каменный", "coal"),
	NATURAL_GAS("Природный газ", "natural_gas"),
	FIREWOOD("Дрова для отопления", "firewood");
	
	private String title;
	
	private String columnName;
	
	FuelType(String title, String columnName) {
		this.title = title;
		this.columnName = columnName;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getColumnName() {
		return columnName;
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
