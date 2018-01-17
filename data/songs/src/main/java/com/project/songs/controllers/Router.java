package com.project.songs.controllers;

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
	public String index(){
		return "index";
	}
	@RequestMapping("/songs/new")
	public String cereateSong(){
		return "new";
	}

	@PostMapping("/songs/new/new")
    public String newSong(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "new";
        }else{
			// Add the song
			songService.addSong(song);
            return "redirect:/dashboard";
        }
	}

	@RequestMapping("/dashboard")
    public String songs(Model model) {
        List<Book> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "dashboard";
	}
	@RequestMapping("/dashboard/topTen")
    public String songs(Model model) {
        model.addAttribute("songs", _ss.getTopTen());
        return "topTen";
	}
	
	@RequestMapping("/songs/{id}")
	public String findSongByid(Model model, @PathVariable("id") Long id) {
        Song song = songService.findSongByid(id);
        model.addAttribute("song", song);
        return "song";
	}


	@RequestMapping("")
	public String redirect(HttpServletRequest req){		
		String url = req.getRequestURI().toString();
		return "redirect:/";
	}		
	@RequestMapping(value="/dashboard/delete/{id}")
    public String destroySong(@PathVariable("id") Long id) {
        songService.destroySong(id);
        return "redirect:/dashboard";
	}

	@RequestMapping("/search")
	public String searchBuArtist(Model model, @RequestParam("search") String term){
		model.addAttribute("term", term);
		model.addAttribute("results", _ss.searchByArtist(term));
		return "artists";
	}
}
