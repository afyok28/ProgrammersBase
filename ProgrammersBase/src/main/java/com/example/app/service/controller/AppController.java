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
		System.out.println("viewHomePage");

		return "index";
	}

	@GetMapping(value = { "/ProgramingLangue" })
	public String viewMenuProgramingLangue() {
		System.out.println("viewMenuProgramingLangue");
		System.out.println(1);
		programingLangueService.insert(new ProgramingLangue("Java"));
		for (ProgramingLangue o : programingLangueService.findAll()) {
			System.out.println(o);
		}
		System.out.println();
		for (ProgramingLangue o : programingLangueService.findAll2(401L)) {
			System.out.println(o);
		}
		return "plPage";
	}

	@GetMapping(value = { "/ProgramingLangueCategory" })
	public String viewMenuProgramingLangueCategory() {
		System.out.println("viewMenuProgramingLangueCategory");
		System.out.println(1);
		//programingLangueCategoryService.insert(new PrograminLangueCategory("Spring2", new ProgramingLangue(551L)));
		for (PrograminLangueCategory o : programingLangueCategoryService.findProgramingLangueCategoryByPlId(401L)) {
			System.out.println(o);
		}
		System.out.println();
		for (PrograminLangueCategory o : programingLangueCategoryService.findAll()) {
			System.out.println(o);
		}
		return "plCategoryPage";
	}

}
