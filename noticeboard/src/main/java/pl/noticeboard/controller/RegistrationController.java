package pl.noticeboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.noticeboard.service.UsersService;
import pl.noticeboard.user.NbUser;

@Controller
public class RegistrationController {
	
	@Autowired
	UsersService usersService;
	
	@GetMapping("/showRegistrationPage")
	public String showRegistrationPage(Model theModel) {
		
		NbUser nbUser = new NbUser();
		theModel.addAttribute("nbUser", nbUser);
		
		return "registration";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("nbUser") NbUser nbUser ) {
		
		usersService.save(nbUser);
		
		return "redirect:/showLoginPage";
	}
	
}
