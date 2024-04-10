package ru.mccormick.ipa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.mccormick.ipa.enums.Consumer;
import ru.mccormick.ipa.enums.FuelType;
import ru.mccormick.ipa.enums.Unit;
import ru.mccormick.ipa.models.CalculationValues;

public class CalculationValuesMapper implements RowMapper<CalculationValues>  {

	@Override
	public CalculationValues mapRow(ResultSet rs, int rowNum) throws SQLException {
		CalculationValues values = new CalculationValues();
		
		values.setValuesId(rs.getInt("values_id"));
		values.setCalculationId(rs.getInt("calculation_id"));
		values.setConsumer(Consumer.fromString(rs.getString("consumer")));
		values.setFuelType(FuelType.fromString(rs.getString("fuel_type")));
		values.setAmount(rs.getDouble("amount"));
		values.setUnit(Unit.fromString(rs.getString("unit")));
		
		return values;
	}

}
