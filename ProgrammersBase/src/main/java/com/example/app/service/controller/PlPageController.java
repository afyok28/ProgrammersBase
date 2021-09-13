package com.example.app.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.app.model.ProgramingLangue;
import com.example.app.service.ProgramingLangueService;

@Controller
public class PlPageController {

	private ProgramingLangueService programingLangueService;
	
	@Autowired
	public void setProgramingLangueService(ProgramingLangueService programingLangueService) {
		this.programingLangueService = programingLangueService;
	}

	@GetMapping(value = { "/ProgramingLangue/" })
	@Async("asyncExecutor")
	public String select(Model model) {
		ModelAndView modelAndView = new ModelAndView("/select");
		List<ProgramingLangue> programingLangues = programingLangueService.findAll();
		modelAndView.addObject("programingLangues", programingLangues);
		return "redirect:/ProgramingLangue";
	}
	
	@GetMapping(value = { "/ProgramingLangue/{id}" })
	@Async("asyncExecutor")
	public String delete(@PathVariable Long id) {		
		boolean isDeleted =programingLangueService.delete(id);
		return "redirect:/ProgramingLangue";
	}

	@PostMapping(value = { "/ProgramingLangue/{id}" })
	@Async("asyncExecutor")
	public String insert(@ModelAttribute("book") ProgramingLangue programingLangue) {
		programingLangue.setId(0L);
		boolean isInsert = programingLangueService.insert(programingLangue);
		return "redirect:/ProgramingLangue";
	}
	
	@PutMapping(value = { "/ProgramingLangue/" })
	@Async("asyncExecutor")
	public String update(@ModelAttribute("book") ProgramingLangue programingLangue) {		
		boolean isUpdatee =programingLangueService.update(programingLangue);
		return "redirect:/ProgramingLangue";
	}
}
