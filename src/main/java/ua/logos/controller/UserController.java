package ua.logos.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.logos.domain.EditRequest;
import ua.logos.entity.User;
import ua.logos.mapper.UserMapper;
import ua.logos.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired UserService userService;
	
	@GetMapping//("/")
	public String showUserProfile(Model model, Principal principal) {
//		String email = principal.getName();
//		System.out.println("Security username: " + email);
//		User user = userService.findUserByEmail(email);
		
		String id = principal.getName();
		System.out.println("Security id: " + id);
		User user = userService.findUserById(Integer.valueOf(id));
		
		model.addAttribute("userProfile", user);
		return "user/profile";
	}
	
	@GetMapping("/edit")
	public String showEdit(Model model, Principal principal) {
		
		String id = principal.getName();
		User user = userService.findUserById(Integer.valueOf(id));
		
		model.addAttribute("editModel", UserMapper.userToEditRequest(user));
		
		return "user/edit";
	}
	
	@PostMapping("/edit")
	public ModelAndView saveEditUser(@ModelAttribute("editModel") EditRequest editRequest) {
		try {
			userService.updadeUser(UserMapper.editRequestToUser(editRequest));
		} catch (Exception e) {
			// TODO: handle exception
			return new ModelAndView("user/edit", "error", "Can't edit user!");
		}
		return new ModelAndView("redirect:/user");
	}
	
	
}
