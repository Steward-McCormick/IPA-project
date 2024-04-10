package ru.mccormick.ipa.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import ru.mccormick.ipa.services.UserIpaDetailsService;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

	private final UserIpaDetailsService service;
	
	@Autowired
	public AuthProviderImpl(UserIpaDetailsService service) {
		this.service = service;
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();
		
		UserDetails userDetails = service.loadUserByUsername(email);

		String password = authentication.getCredentials().toString();
		
		if(!password.equals(userDetails.getPassword())) {
			throw new BadCredentialsException("Incorrect password");
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails, password, Collections.emptyList());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
}
