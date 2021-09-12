package com.example.app.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.app.model.ProgramingLangue;
import com.example.app.service.ProgramingLangueService;

//@Controller(value = "/ProgramingLangue")
@Controller
public class PlPageController {

	
	private ProgramingLangueService programingLangueService;
	
	@Autowired
	public void setProgramingLangueService(ProgramingLangueService programingLangueService) {
		this.programingLangueService = programingLangueService;
	}

	@GetMapping(value = { "/findAll" })
	@Async("asyncExecutor")
	public String findAll(Model model) {
		System.out.println("table refresh");
		ModelAndView modelAndView = new ModelAndView("home/select");
		List<ProgramingLangue> programingLangues = programingLangueService.findAll();

		System.out.println("***************::::" + programingLangues.toString());
		modelAndView.addObject("programingLangues", programingLangues);
		return "redirect:/ProgramingLangue";
	}

}
