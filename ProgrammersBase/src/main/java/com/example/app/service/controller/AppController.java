package com.example.app.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.model.ProgramingLangue;
import com.example.app.service.ProgramingLangueService;

@Controller
public class AppController {

	@Autowired
	private ProgramingLangueService programingLangueService;
	
	@GetMapping(value = {"/index","/","/home"})
	public String viewHomePage()
	{
		System.out.println("viewHomePage");
		programingLangueService.insert(new ProgramingLangue( "java"));
		List<ProgramingLangue> programingLangues=programingLangueService.findAll();
		for (ProgramingLangue programingLangue : programingLangues) {
			System.out.println(programingLangue.toString());
		}
		return "index";
	}

}
