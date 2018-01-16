package com.project.crud.controllers;
import com.project.crud.models.Language;
import com.project.crud.services.LanguageService;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Languages{
	//Member variables go here
	private final LanguageService languageService;
    public Languages(LanguageService languageService){
        this.languageService = languageService;
	}
	@PostMapping("/languages/new")
    public String newLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "index";
        }else{
			// Add the Language
			languageService.addLanguage(language);
            return "redirect:/languages";
        }
	}
	
	@RequestMapping("/languages")
    public String languages(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		System.out.println(languages);
        model.addAttribute("languages", languages);
        return "index";	
	}
	@RequestMapping("/languages/{index}")
    public String findLanguageByIndex(Model model, @PathVariable("index") Long index) {
        Language language = languageService.findLanguageByIndex(index);
        model.addAttribute("language", language);
        return "view";
	}
	@RequestMapping("/languages/edit/{id}")
    public String editLanguage(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguageByIndex(id);
        if (language != null){
            model.addAttribute("language", language);
            return "edit";
        }else{
            return "redirect:/languages";
        }
	}
	@RequestMapping("/languages/edit/{id}/edit")
    public String editLanguage(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        // Language language = languageService.findLanguageByIndex(id);
		if (result.hasErrors()){
            return "edit";
        }else{
			languageService.updateLanguage(language);
            return "redirect:/languages";
        }
	}
	@RequestMapping(value="/languages/delete/{id}")
    public String destroyLanguage(@PathVariable("id") Long id) {
        languageService.destroyLanguage(id);
        return "redirect:/languages";
	}
	@RequestMapping("")
	public String redirect(HttpServletRequest req){		
		String url = req.getRequestURI().toString();
		return "redirect:/languages";
	}	
}
