package ru.mccormick.ipa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.mccormick.ipa.services.SettingsService;

@SpringBootApplication
public class IpaApplication {
	
	@Autowired
	SettingsService service;
	
	public static void main(String[] args) {
		SpringApplication.run(IpaApplication.class, args);
	}
}