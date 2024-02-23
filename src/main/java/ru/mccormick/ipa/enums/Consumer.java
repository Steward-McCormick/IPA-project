package ru.mccormick.ipa.enums;

public enum Consumer {
	UNIT("Установки"),
	AUTOMOBILE_TRANSPORT("Автомобильный транспорт");
	
	private String title;
	
	Consumer(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public static Consumer fromString(String value) {
		if(value != null) {
			for(Consumer cons : Consumer.values()) {
				if(value.equalsIgnoreCase(cons.title)) {
					return cons;
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
