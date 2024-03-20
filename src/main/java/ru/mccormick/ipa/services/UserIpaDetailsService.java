package ru.mccormick.ipa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.mccormick.ipa.models.User;
import ru.mccormick.ipa.security.UserIpaDetails;

@Service
public class UserIpaDetailsService implements UserDetailsService {
	
	private final UserService service;
	
	@Autowired
	public UserIpaDetailsService(UserService service) {
		this.service = service;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = service.findByEmail(username);
		
		return new UserIpaDetails(user);
	}

}
