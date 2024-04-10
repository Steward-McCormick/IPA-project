package ru.mccormick.ipa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ru.mccormick.ipa.models.User;
import ru.mccormick.ipa.services.UserService;

@Controller
public class UserHandlingController {
	
	private final UserService userService;
	
	@Autowired
	public UserHandlingController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user/create")
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		
		return "admin/create_user_page";
	}
	
	@PostMapping("/user/create")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.save(user);
		
		return "redirect:/logout";
	}
}
