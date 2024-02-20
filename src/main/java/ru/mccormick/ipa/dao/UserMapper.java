package ru.mccormick.ipa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import ru.mccormick.ipa.models.CalculationHistory;
import ru.mccormick.ipa.models.Settings;
import ru.mccormick.ipa.models.User;
import ru.mccormick.ipa.services.CalculationService;
import ru.mccormick.ipa.services.SettingsService;

public class UserMapper implements RowMapper<User> {
	
	@Autowired
	private SettingsService settingsService;
	
	@Autowired
	private CalculationService calculationService;

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
	
		user.setUserId(rs.getInt("user_id"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		
		Settings settings = settingsService.findByUserId(user.getUserId());
		
		user.setSettingsId(settings.getSettingsId());
		user.setSettings(settings);
		
		CalculationHistory calcHistory = calculationService.getUsersCalcHistory(user.getUserId());
		
		user.setCalculationHistory(calcHistory);
		
		return user;
	}
}
