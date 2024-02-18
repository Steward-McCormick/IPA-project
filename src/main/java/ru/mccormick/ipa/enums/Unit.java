package ru.mccormick.ipa.enums;

public enum Unit {
	TONS ("Тонны"),
	CUBIC_METERS ("Кубические метры");
	
	private String title;
	
	Unit(String title) {
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
	