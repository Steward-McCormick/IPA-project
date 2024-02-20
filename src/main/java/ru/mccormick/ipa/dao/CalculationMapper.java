package ru.mccormick.ipa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import ru.mccormick.ipa.models.Calculation;
import ru.mccormick.ipa.services.CalculationValuesService;

public class CalculationMapper implements RowMapper<Calculation> {
	
	@Autowired
	private CalculationValuesService calculationValuesService;

	@Override
	public Calculation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Calculation calculation = new Calculation();
		
		calculation.setCalculationId(rs.getInt("calculation_id"));
		calculation.setUserId(rs.getInt("user_id"));
		calculation.setCalculationValues(calculationValuesService.getValuesList(rs.getInt("calculation_id")));
		calculation.setCalculationResult(rs.getInt("result"));
		calculation.setCalculationDate(rs.getDate("date"));
		
		return calculation;
	}

}
