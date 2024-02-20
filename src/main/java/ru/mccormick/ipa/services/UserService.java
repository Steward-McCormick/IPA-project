package ru.mccormick.ipa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.mccormick.ipa.dao.UserDAO;
import ru.mccormick.ipa.models.User;

@Service
public class UserService {
	
	private UserDAO userDAO;
	
	@Autowired
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User findById(int id) {
		return userDAO.findUserById(id);
	}
	
	public void save(User user) {
		userDAO.save(user);
	}
	
	public void update(User user, int id) {
		userDAO.update(user, id);
	}
	
	public void delete(int id) {
		userDAO.delete(id);
	}
}
