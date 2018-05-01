package ua.logos.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.logos.entity.User;
import ua.logos.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired UserService userService;
	
	@GetMapping//("/")
	public String showUserProfile(Model model, Principal principal) {
		String email = principal.getName();
		System.out.println("Security username: " + email);
		User user = userService.findUserByEmail(email);
		
		model.addAttribute("userProfile", user);
		return "user/profile";
	}
	
	
	
	
}
