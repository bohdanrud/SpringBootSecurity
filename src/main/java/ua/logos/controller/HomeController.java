package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.logos.domain.RegisterRequest;
import ua.logos.entity.User;
import ua.logos.mail.Mail;
import ua.logos.mapper.UserMapper;
import ua.logos.service.EmailService;
import ua.logos.service.UserService;
import ua.logos.service.utils.RandomToken;

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
			User user = UserMapper.registerRequestToUser(request);
			
			String token = RandomToken.generateToken();
			System.out.println("Token: " + token);
			user.setToken(token);
			
			userService.saveUser(user);
			
			Mail mail = new Mail();
			mail.setTo(request.getEmail());
			mail.setSubject("You are registered");
			mail.setContent("Please verify your email address with link: " + "http://localhost:8080/verify?token=" + token + "&userid=" + user.getId());
			emailService.sendMessage(mail);
		} else {
			model.addAttribute("registerModel", new RegisterRequest());
			return "register";
		}
		
		
		return "redirect:";
	}
	
	
	
	
	@GetMapping("/verify")
	public String verifyEmail(
			@RequestParam("token") String token,
			@RequestParam("userid") String userId
			) {
		
		User user = userService.findUserById(Integer.valueOf(userId));
		if(user.getToken().equals(token)) {
			user.setToken(null);
			userService.updadeUser(user);
		}else {
			return "redirect:/?validate=false";
		}
		
		return "home";
	}
	
	
	
}
