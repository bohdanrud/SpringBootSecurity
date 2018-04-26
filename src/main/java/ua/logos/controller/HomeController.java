package ua.logos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public ModelAndView showHome() {
		return new ModelAndView("home");
	}
	
	@GetMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("login");
	}
}
