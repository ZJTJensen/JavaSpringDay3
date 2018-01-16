package com.project.code.controllers;

import java.security.Principal;
import java.util.Date;

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
@RequestMapping("/*") // Wildcard all routes.
public class Router{
	public Router(){

	}

	@RequestMapping("")
		public String index(@ModelAttribute("error") String error){
		return "index";
	}

	@PostMapping("code")
	public String login(
		@RequestParam(value="code") String code,
		RedirectAttributes flash) {
		  // ... process information and save it to the session
		  
		 if( code.equals("bushido")){
			return "secret";
		 }
		 flash.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		  
	}
	@RequestMapping("secret")
	public String secret(){
		return "secret";
	}

		
}
