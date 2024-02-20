package ru.mccormick.ipa.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import ru.mccormick.ipa.models.Settings;

@Component
public class SettingsDAOImpl implements SettingsDAO {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SettingsDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Settings findSettingsById(int id) {
		String query = "SELECT * FROM Settings WHERE id=?";
		
		return jdbcTemplate.query(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
			}
		}, new SettingsMapper())
		.stream().findAny().orElse(null);
	}
	
	@Override
	public Settings findSettingsByUserId(int userId) {
		String query = "SELECT * FROM Settings WHERE user_id=?";
		
		return jdbcTemplate.query(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, userId);
			}
		}, new SettingsMapper())
		.stream().findAny().orElse(null);
	}

	@Override
	public void save(Settings settings) {
		String query = "INSERT INTO Settings(user_id) VALUES(?)"; // TODO Correct SettingsValues
		
		jdbcTemplate.update(query, settings.getUserId());
	}

	@Override
	public void update(Settings settings, int id) {
		String query = "UPDATE Settings user_id=? WHERE id=?";
		
		jdbcTemplate.update(query, settings.getUserId(), id);
	}

	@Override
	public void delete(int id) {
		String query = "DELETE FROM Settings WHERE id=?";
		
		jdbcTemplate.update(query, id);
	}

}
