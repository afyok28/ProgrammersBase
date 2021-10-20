/* Created by Adam Jost on 09/13/2021 */
package com.pb.ProgrammersBase.language;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProgrammingLanguageController {

    private final ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguageController(ProgrammingLanguageService plService) {

        this.programmingLanguageService = plService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
    	
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/new")
    public String addNew(Model model) {

        model.addAttribute("programmingLanguage", new ProgrammingLanguage());

        return "create_programming_language";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("programmingLanguage") ProgrammingLanguage programmingLanguage) {

        programmingLanguageService.save(programmingLanguage);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@Min(value = 0,message = "min value 0") @PathVariable Long id, Model model) {

        model.addAttribute("programmingLanguage", programmingLanguageService.findById(id).get());

        return "edit_programming_language";
    }

    @PostMapping("/{id}")
    public String update(@Min(value = 0,message = "min value 0") @PathVariable Long id,
    		 @ModelAttribute("programmingLanguage") ProgrammingLanguage programmingLanguage) {

        programmingLanguageService.update(id, programmingLanguage.getName());

        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String deleteById(@Min(value = 0,message = "min value 0") @PathVariable Long id) {

        programmingLanguageService.deleteById(id);

        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@Min(value = 0,message = "min value 0") @PathVariable("pageNo") int pageNum,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {

        int pageSize = 6;

        Page<ProgrammingLanguage> page = programmingLanguageService.findPaginated(pageNum, pageSize, sortField, sortDir);
        List<ProgrammingLanguage> programmingLanguageList = page.getContent();

        System.out.println(page.toString());
        System.out.println(page.getNumber());
        System.out.println(page.getNumberOfElements());
        System.out.println(page.getSize());
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        model.addAttribute("programmingLanguages", programmingLanguageList);

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        return "index";
    }
}
