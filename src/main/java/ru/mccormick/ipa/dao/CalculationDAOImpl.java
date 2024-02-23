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
		String query = "SELECT * FROM Calculation WHERE calculation_id=?";
		
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
		
		return jdbcTemplate.query(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, userId);
			}
		}, new CalculationMapper());
	}

	@Override
	public void save(Calculation calculation) {
		String query = "INSERT INTO Calculation(user_id, calculation_result) VALUES(?, ?)";
		
		jdbcTemplate.update(query, calculation.getUserId(), calculation.getCalculationResult());
	}

	@Override
	public void update(Calculation calculation, int id) {
		String query = "UPDATE Calculation SET user_id=?, calculation_result=? WHERE calculation_id=?";
		
		jdbcTemplate.update(query, calculation.getUserId(), calculation.getCalculationResult(), id);
	}

	@Override
	public void delete(int id) {
		String query = "DELETE FROM Calculation WHERE calculation_id=?";
		
		jdbcTemplate.update(query, id);
	}
}















