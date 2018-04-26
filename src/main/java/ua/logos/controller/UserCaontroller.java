package ua.logos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserCaontroller {

	@GetMapping("/")
	public String showUserProfile() {
		return "user/profile";
	}
	
}
