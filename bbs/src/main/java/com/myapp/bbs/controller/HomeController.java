package com.myapp.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value = {"/", "/home"})
	public String dashBoard() {
		return "pages/home";
	}
	
	@GetMapping("/tables")
	public String showTable() {
		return "pages/tables";
	}
	
	@GetMapping("/profile")
	public String showProfile() {
		return "pages/profile";
	}
	
	@GetMapping("/sign-in")
	public String login() {
		return "pages/sign-in";
	}
	
	@GetMapping("/sign-up")
	public String register() {
		return "pages/sign-up";
	}	

}
