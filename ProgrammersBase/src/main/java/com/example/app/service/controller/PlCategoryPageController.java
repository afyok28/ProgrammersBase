package com.example.app.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.app.model.PrograminLangueCategory;
import com.example.app.service.ProgramingLangueCategoryService;
public class PlCategoryPageController {

	private ProgramingLangueCategoryService programingLangueCategoryService;

	@Autowired
	public void setProgramingLangueCategoryService(ProgramingLangueCategoryService programingLangueCategoryService) {
		this.programingLangueCategoryService = programingLangueCategoryService;
	}
	

	@PostMapping(value = { "/ProgramingLangueCategory" })
	@Async("asyncExecutor")
	public String viewProgramingLangueCategoryPagePost(@RequestParam("selectedPlId") Long selectedPlId, ModelAndView modelAndView) {	
		
		List<PrograminLangueCategory> programinLangueCategories = programingLangueCategoryService.findProgramingLangueCategoryByPlId(1L);
		
		modelAndView.addObject("programinLangueCategories", programinLangueCategories);
		return "/ProgramingLangueCategory";
	}
	
}
