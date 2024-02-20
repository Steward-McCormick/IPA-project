package ru.mccormick.ipa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.mccormick.ipa.models.Settings;

public class SettingsMapper implements RowMapper<Settings> {

	@Override
	public Settings mapRow(ResultSet rs, int rowNum) throws SQLException {
		Settings settings = new Settings();
		
		// TODO Correct SettingsMapper
		
		return settings;
	}

}
