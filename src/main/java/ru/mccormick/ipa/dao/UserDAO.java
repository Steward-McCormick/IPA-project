package ru.mccormick.ipa.dao;

import ru.mccormick.ipa.models.User;

public interface UserDAO {
	
	public User findUserById(int id);
	
	public void save(User user);
	
	public void update(User user, int id);
	
	public void delete(int id);
}
