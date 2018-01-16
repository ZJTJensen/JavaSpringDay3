package com.project.learing.controllers;

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
	public String main(){
		return "main";
	}

	@RequestMapping("m/{chapter}/0553/{assignmentNumber}")
	public String index(@PathVariable int chapter, @PathVariable int assignmentNumber){
		return "index";
	}

	@RequestMapping("m/{chapter}/0483/{assignmentNumber}")
	public String assignment(@PathVariable int chapter, @PathVariable int assignmentNumber){
		return "assignment";
	}
	
}
