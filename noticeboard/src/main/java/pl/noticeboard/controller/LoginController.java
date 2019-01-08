package pl.noticeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		
		return "login-page";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		
		return "access-denied";
	}
}
