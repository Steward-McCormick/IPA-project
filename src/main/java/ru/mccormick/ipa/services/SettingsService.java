package ru.mccormick.ipa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.mccormick.ipa.dao.SettingsDAO;
import ru.mccormick.ipa.models.Settings;

@Service
public class SettingsService {

	private SettingsDAO settingsDAO;
	
	@Autowired
	public SettingsService(SettingsDAO settingsDAO) {
		this.settingsDAO = settingsDAO;
	}
	
	public Settings findById(int id) {
		return settingsDAO.findSettingsById(id);
	}
	
	public Settings findByUserId(int userId) {
		return settingsDAO.findSettingsByUserId(userId);
	}
	
	public void save(Settings settings) {
		settingsDAO.save(settings);
	}
	
	public void update(Settings settings, int id) {
		settingsDAO.update(settings, id);
	}
	
	public void delete(int id) {
		settingsDAO.delete(id);
	}
}
