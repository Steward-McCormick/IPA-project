package ru.mccormick.ipa.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import ru.mccormick.ipa.models.CalculationValues;

@Component
public class CalculationValuesDAOImpl implements CalculationValuesDAO {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CalculationValuesDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public CalculationValues findValesById(int id) {
		String query = "SELECT * FROM Calculation_Values WHERE values_id=?";
		
		return jdbcTemplate.query(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
			}
		}, new CalculationValuesMapper()).stream().findAny().orElse(null);
	}
	
	@Override
	public List<CalculationValues> getListOfCalculationValues(int calculationId) {
		String query = "SELECT * FROM Calculation_Values WHERE calculation_id=?";
		
		return jdbcTemplate.query(query, new CalculationValuesMapper());
	}

	@Override
	public void save(CalculationValues values) {
		String query = "INSERT INTO Calculation_Values(calculation_id, consumer, fuel_type, "
						+ "amount, unit) VALUES(?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(query, values.getCalculationId(), values.getConsumer().toString(), 
							values.getFuelType().toString(), values.getAmount(), 
							values.getUnit().toString());
	}
	
	@Override
	public void saveCalculationValuesList(List<CalculationValues> list, int calculation_id) {
		for(CalculationValues values : list) {
			values.setCalculationId(calculation_id);
			save(values);
		}
	}

	@Override
	public void update(CalculationValues values, int id) {
		String query = "UPDATE Calculation_Values SET calculation_id=?, consumer=?, "
						+ "fuel_type=?, amount=?, unit=? WHERE id=?";
		
		jdbcTemplate.update(query, values.getCalculationId(), values.getConsumer().toString(), 
							values.getFuelType().toString(), values.getAmount(), 
							values.getUnit().toString(), id);
	}

	@Override
	public void delete(int id) {
		String query = "DELETE FROM Calculation_Values WHERE values_id=?";
		
		jdbcTemplate.update(query, id);
	}
}














