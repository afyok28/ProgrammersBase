package com.example.app.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.model.PrograminLangueCategory;
import com.example.app.model.ProgramingLangue;
import com.example.app.service.ProgramingLangueCategoryService;
import com.example.app.service.ProgramingLangueService;

@Controller
public class AppController {

	private ProgramingLangueService programingLangueService;

	@Autowired
	public void setProgramingLangueService(ProgramingLangueService programingLangueService) {
		this.programingLangueService = programingLangueService;
	}

	private ProgramingLangueCategoryService programingLangueCategoryService;

	@Autowired
	public void setProgramingLangueCategoryService(ProgramingLangueCategoryService programingLangueCategoryService) {
		this.programingLangueCategoryService = programingLangueCategoryService;
	}

	
	@GetMapping(value = { "/index", "/", "/home" })
	public String viewHomePage() {

		return "index";
	}

	@GetMapping(value = { "/ProgramingLangue" })
	public String viewMenuProgramingLangue() {
		
		programingLangueService.insert(new ProgramingLangue("Java"));
		
		return "plPage";
	}

	@GetMapping(value = { "/ProgramingLangueCategory" })
	public String viewMenuProgramingLangueCategory() {
		
		return "plCategoryPage";
	}

}
