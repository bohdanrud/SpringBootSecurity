package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.logos.domain.RegisterRequest;
import ua.logos.mail.Mail;
import ua.logos.mapper.UserMapper;
import ua.logos.service.EmailService;
import ua.logos.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired 
	private EmailService emailService;
	
	@GetMapping("/")
	public ModelAndView showHome() {
		return new ModelAndView("home");
	}
	
	@GetMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("login");
	}
	
	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("registerModel", new RegisterRequest());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("registerModel") RegisterRequest request, Model model) {
		
		if(request.getPassword().equals(request.getPasswordConfirmation())) {
			userService.saveUser(UserMapper.registerRequestToUser(request));
			
			Mail mail = new Mail();
			mail.setTo(request.getEmail());
			mail.setSubject("You are registered");
			mail.setContent("TEST");
			emailService.sendMessage(mail);
		} else {
			model.addAttribute("registerModel", new RegisterRequest());
			return "register";
		}
		
		
		return "redirect:";
	}
}
