package ru.mccormick.ipa.models;

public class Settings {
	
	private int settingsId;
	
	private int userId;
	
	
	// Settings values
	// Array of settings values [TNV, k1, k2]
	
	private Double[] rawOil = new Double[3]; // сырая нефть
	
	private Double[] gasCondensate  = new Double[3]; // газовый конденсат
	
	private Double[] automobilesGasoline  = new Double[3]; // бензин автомобильный
	
	private Double[] dieselFuel  = new Double[3]; // дизельное топливо
	
	private Double[] lightingKerosene  = new Double[3]; // Керосин осветительный и пр.
	
	private Double[] fuelOil  = new Double[3]; // Топливо нефтяное(мазут)
	
	private Double[] propaneAndButane  = new Double[3]; // Пропан и бутан сж.
	
	private Double[] compressedHydrocarbonGases  = new Double[3]; // Углеводородные газы сж.
	
	private Double[] bitumen  = new Double[3]; // Битум нефтяной и сланцевый
	
	private Double[] cokingCoal  = new Double[3]; // Коксующийся уголь
	
	private Double[] coal  = new Double[3]; // Уголь каменный
	
	private Double[] naturalGas  = new Double[3]; // Газ природный
	
	private Double[] firewood  = new Double[3]; // Дрова для отопления
	
	public Settings() {
	};
	
	public Settings(int userId) {
		//this.settingsId = settingsId;
		this.userId = userId;
		
		// setting default values
		this.setRawOil(new Double[] {49.12, 0.995, 20.31});
		this.setGasCondensate(new Double[] {40.12, 0.995, 19.13});
		this.setAutomobilesGasoline(new Double[] {44.21, 0.995, 19.12});
		this.setDieselFuel(new Double[] {43.02, 0.995, 19.98});
		this.setLightingKerosene(new Double[] {44.75, 0.99, 19.6});
		this.setFuelOil(new Double[] {41.15, 0.99, 20.84});
		this.setPropaneAndButane(new Double[] {47.31, 0.99, 17.2});
		this.setCompressedHydrocarbonGases(new Double[] {47.31, 0.99, 17.2});
		this.setBitumen(new Double[] {40.19, 0.99, 22.0});
		this.setCokingCoal(new Double[] {24.01, 0.98, 24.89});
		this.setCoal(new Double[] {17.62, 0.98, 25.58});
		this.setNaturalGas(new Double[] {34.78, 0.995, 15.04});
		this.setFirewood(new Double[] {10.22, 0.98, 29.48});
	}
	
	public int getSettingsId() {
		return settingsId;
	}
	
	public void setSettingsId(int settingsId) {
		this.settingsId = settingsId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Double[] getRawOil() {
		return rawOil;
	}

	public void setRawOil(Double[] rawOil) {
		this.rawOil = rawOil;
	}

	public Double[] getGasCondensate() {
		return gasCondensate;
	}

	public void setGasCondensate(Double[] gasCondensate) {
		this.gasCondensate = gasCondensate;
	}

	public Double[] getAutomobilesGasoline() {
		return automobilesGasoline;
	}

	public void setAutomobilesGasoline(Double[] automobilesGasoline) {
		this.automobilesGasoline = automobilesGasoline;
	}

	public Double[] getDieselFuel() {
		return dieselFuel;
	}

	public void setDieselFuel(Double[] dieselFuel) {
		this.dieselFuel = dieselFuel;
	}

	public Double[] getLightingKerosene() {
		return lightingKerosene;
	}

	public void setLightingKerosene(Double[] lightingKerosene) {
		this.lightingKerosene = lightingKerosene;
	}

	public Double[] getFuelOil() {
		return fuelOil;
	}

	public void setFuelOil(Double[] fuelOil) {
		this.fuelOil = fuelOil;
	}

	public Double[] getPropaneAndButane() {
		return propaneAndButane;
	}

	public void setPropaneAndButane(Double[] propaneAndButane) {
		this.propaneAndButane = propaneAndButane;
	}

	public Double[] getCompressedHydrocarbonGases() {
		return compressedHydrocarbonGases;
	}

	public void setCompressedHydrocarbonGases(Double[] compressedHydrocarbonGases) {
		this.compressedHydrocarbonGases = compressedHydrocarbonGases;
	}

	public Double[] getBitumen() {
		return bitumen;
	}

	public void setBitumen(Double[] bitumen) {
		this.bitumen = bitumen;
	}

	public Double[] getCokingCoal() {
		return cokingCoal;
	}

	public void setCokingCoal(Double[] cokingCoal) {
		this.cokingCoal = cokingCoal;
	}

	public Double[] getCoal() {
		return coal;
	}

	public void setCoal(Double[] coal) {
		this.coal = coal;
	}

	public Double[] getNaturalGas() {
		return naturalGas;
	}

	public void setNaturalGas(Double[] naturalGas) {
		this.naturalGas = naturalGas;
	}

	public Double[] getFirewood() {
		return firewood;
	}

	public void setFirewood(Double[] firewood) {
		this.firewood = firewood;
	}

}
