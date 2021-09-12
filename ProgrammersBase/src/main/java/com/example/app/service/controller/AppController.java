package com.example.app.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping(value = { "/index", "/", "/home" })
	public String viewHomePage() {
		System.out.println("viewHomePage");
		return "index";
	}

	@GetMapping(value = { "/ProgramingLangue" })
	public String viewMenuProgramingLangue() {
		System.out.println("viewMenuProgramingLangue");
		return "plPage";
	}

	@GetMapping(value = { "/ProgramingLangueCategory" })
	public String viewMenuProgramingLangueCategory() {
		System.out.println("viewMenuProgramingLangueCategory");
		return "plCategoryPage";
	}

}
