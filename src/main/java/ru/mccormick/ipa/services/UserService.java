package ru.mccormick.ipa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.mccormick.ipa.dao.UserDAO;
import ru.mccormick.ipa.models.Settings;
import ru.mccormick.ipa.models.User;

@Service
public class UserService {
	
	private UserDAO userDAO;
	
	private SettingsService settingsService;
	
	@Autowired
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User findById(int id) {
		return userDAO.findUserById(id);
	}
	
	public User findByEmail(String email) {
		return userDAO.findUserByEmail(email);
	}
	
	public void save(User user) {
		userDAO.save(user);
		settingsService.save(new Settings(userDAO.findUserByEmail(user.getEmail()).getUserId()));
	}
	
	public void update(User user, int id) {
		userDAO.update(user, id);
	}
	
	public void delete(int id) {
		userDAO.delete(id);
	}
}
