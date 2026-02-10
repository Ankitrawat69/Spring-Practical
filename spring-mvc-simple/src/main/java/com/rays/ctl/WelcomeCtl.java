package com.rays.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "WelcomeCtl")
public class WelcomeCtl {
	
	@GetMapping
	public String display() {
		
		return "Welcome";
		
		
	}

}
