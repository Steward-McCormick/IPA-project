package ru.mccormick.ipa.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import ru.mccormick.ipa.models.Calculation;

@Component
public class CalculationDAOImpl implements CalculationDAO {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CalculationDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Calculation findCalculationById(int id) {
		String query = "SELECT * FROM Calculation WHERE id=?";
		
		return jdbcTemplate.query(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
			}
		}, new CalculationMapper()).stream().findAny().orElse(null);
	}
	
	@Override
	public List<Calculation> findAllUsersCalculations(int userId) {
		String query = "SELECT * FROM Calculation WHERE user_id=?";
		
		return jdbcTemplate.query(query, new CalculationMapper());
	}

	@Override
	public void save(Calculation calculation) {
		String query = "INSERT INTO Calculation(user_id, values_id, result, date) VALUES(?, ?, ?, ?)";
		
		jdbcTemplate.update(query, calculation.getUserId(), calculation.getValuesId(), 
							calculation.getCalculationResult(), calculation.getCalculationDate());
	}

	@Override
	public void update(Calculation calculation, int id) {
		String query = "UPDATE Calculation user_id=?, values_id=?, result=?, date=?";
		
		jdbcTemplate.update(query, calculation.getUserId(), calculation.getValuesId(), 
							calculation.getCalculationResult(), id);
	}

	@Override
	public void delete(int id) {
		String query = "DELETE FROM Calculation WHERE id=?";
		
		jdbcTemplate.update(query, id);
	}
}















