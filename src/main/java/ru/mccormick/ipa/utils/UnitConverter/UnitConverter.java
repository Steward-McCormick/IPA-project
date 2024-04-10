package ru.mccormick.ipa.utils.UnitConverter;

import ru.mccormick.ipa.enums.FuelType;
import ru.mccormick.ipa.models.CalculationValues;

public class UnitConverter {

	public static double convertUnitToTons(CalculationValues values) {
		FuelType type = values.getFuelType();
		double amount = values.getAmount();

		return (ConvertDataContainer.getDensity(type) * amount) / 1000;
	}
}
