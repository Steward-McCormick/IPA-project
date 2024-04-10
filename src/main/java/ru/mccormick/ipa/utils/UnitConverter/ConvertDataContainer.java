package ru.mccormick.ipa.utils.UnitConverter;

import ru.mccormick.ipa.enums.FuelType;

import java.util.HashMap;
import java.util.Map;

public class ConvertDataContainer {

	private static final Map<FuelType, Double> dataContainer;

	static {
		dataContainer = new HashMap<>();
		dataContainer.put(FuelType.RAW_OIL, 885.0);
		dataContainer.put(FuelType.GAS_CONDENSATE, 725.0);
		dataContainer.put(FuelType.AUTOMOBILE_GASOLINE, 741.25);
		dataContainer.put(FuelType.DIESEL_FUEL, 832.5);
		dataContainer.put(FuelType.LIGHTING_KEROSENE, 797.0);
		dataContainer.put(FuelType.FUEL_OIL, 945.0);
		dataContainer.put(FuelType.PROPANE_AND_BUTANE, 500.5);
		dataContainer.put(FuelType.COMPRESSED_HC_GASES, 578.55);
		dataContainer.put(FuelType.BITUMEN, 1225.0);
		dataContainer.put(FuelType.COKING_COAL, 1875.0);
		dataContainer.put(FuelType.COAL, 1400.0);
		dataContainer.put(FuelType.NATURAL_GAS, 0.85);
		dataContainer.put(FuelType.FIREWOOD, 640.0);
	}

	public static double getDensity(FuelType type) {
		return dataContainer.get(type);
	}
}
