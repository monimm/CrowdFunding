package com.cf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back")
public class BackHomeController {
	@RequestMapping("/home")
	public String home() {	
		return "/back/home";
	}
	@RequestMapping("/main")
	public String main() {	
		return "/back/main";
	}
}
