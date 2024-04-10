package ru.mccormick.ipa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.mccormick.ipa.enums.Consumer;
import ru.mccormick.ipa.enums.FuelType;
import ru.mccormick.ipa.enums.Unit;
import ru.mccormick.ipa.models.CalculationValues;
import ru.mccormick.ipa.models.User;
import ru.mccormick.ipa.services.UserService;
import ru.mccormick.ipa.utils.UnitConverter.UnitConverter;

@SpringBootApplication
public class IpaApplication implements CommandLineRunner {

	private final UserService userService;

	@Autowired
	public IpaApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(IpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (userService.findByEmail("qwerty@mail.ru") == null) {
			userService.save(new User("qwerty@mail.ru", "qwerty"));
		}
	}
}