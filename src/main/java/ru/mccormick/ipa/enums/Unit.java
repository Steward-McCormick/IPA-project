package ru.mccormick.ipa.enums;

public enum Unit {
	TONS ("Тонны"),
	CUBIC_METERS ("м3");
	
	private String title;
	
	Unit(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public static Unit fromString(String value) {
		if(value != null) {
			for(Unit unit : Unit.values()) {
				if(value.equalsIgnoreCase(unit.title)) {
					return unit;
				}
			}
		}
		
		throw new IllegalArgumentException("No such results");
	}
	
	@Override
	public String toString() {
		return title;
	}
}
	