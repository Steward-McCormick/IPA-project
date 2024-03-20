package ru.mccormick.ipa.dao;

import ru.mccormick.ipa.models.Settings;

public interface SettingsDAO {

	public Settings findSettingsById(int id);
	
	public Settings findSettingsByUserId(int userId);
	
	public void save(Settings settings);
	
	public void update(Settings settings, int id);
		
	public void delete(int id);
}
