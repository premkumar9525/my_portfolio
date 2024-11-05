package com.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomePageController {

	@GetMapping("/")
	public String homePage() {
		System.err.println("::: HomePageController.HomePage :::");
		return "homepage";
	}

	@GetMapping("/portfolio")
	public String portfolio(Model model) {
		model.addAttribute("na	me", "Your Name");
		model.addAttribute("jobTitle", "Your Job Title");
		model.addAttribute("aboutMe", "Brief description about you...");
		model.addAttribute("technicalExperience", "List your technical experience here...");
		model.addAttribute("workingExperience", "List your working experience here...");
		return "portfolio";
	}

}
