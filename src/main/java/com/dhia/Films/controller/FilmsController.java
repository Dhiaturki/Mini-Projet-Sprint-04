package com.dhia.Films.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.dhia.Films.model.Films;
import com.dhia.Films.model.Genre;
import com.dhia.Films.service.FilmService;

import jakarta.validation.Valid;

@Controller
public class FilmsController {

    @Autowired
    FilmService filmsService;

   
    
    @GetMapping(value = "/") 
    public String welcome() { 
    return "index"; 
    } 
    
    @GetMapping("/ListeFilms")
    public String listeFilms(ModelMap modelMap,
                             @RequestParam(name = "page", defaultValue = "0") int page,
                             @RequestParam(name = "size", defaultValue = "2") int size) {
        Page<Films> filmsPage = filmsService.getAllFilmsPerPage(page, size);
        modelMap.addAttribute("films", filmsPage);
        modelMap.addAttribute("pages", filmsPage.getTotalPages());
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeFilms";
    }



    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap ) {
    	
    	List<Genre> g = filmsService.getAllGenre(); 
    	modelMap.addAttribute("film",new Films()); 
    	modelMap.addAttribute("mode", "new");
    	modelMap.addAttribute("genre", g); 
        return "formFilm";
    }
    
    @RequestMapping("/saveFilm")
    public String saveFilm(@Valid Films film,BindingResult bindingResult,ModelMap modelMap,
    		@RequestParam (name="page",defaultValue = "0") int page, 
            @RequestParam (name="size", defaultValue = "2") int size) {

    	
    	int currentPage;
    	boolean isNew =false;
    	if (bindingResult.hasErrors()) 
    	{
    		modelMap.addAttribute("film", film);
    		return "formFilm"; 
    	}
    	if(film.getIdFilm()==null) {
    		isNew=true;
    	}
    	filmsService.saveFilms(film);
    	
    	if (isNew)
    	{ 
    	Page<Films> f = filmsService.getAllFilmsPerPage(page, size); 
    	currentPage = f.getTotalPages()-1; 
    	} 
    	else
    		currentPage=page;
    	
        return ("redirect:/listeFilms?page="+currentPage+"&size="+size);
    }

    @RequestMapping("/supprimerFilm")
    public String supprimerFilm(@RequestParam("id") Long id,
            ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page, 
            @RequestParam (name="size", defaultValue = "2") int size) {
        
    	filmsService.deleteFilmsById(id);
    	
    	Page<Films> filmsPage = filmsService.getAllFilmsPerPage(page, size);
        
        modelMap.addAttribute("films", filmsPage);
        modelMap.addAttribute("pages", new int[filmsPage.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "redirect:/ListeFilms?page=" + page + "&size=" + size;
    }

    @RequestMapping("/modifierFilm")
    public String editerFilm(@RequestParam("id") Long id,ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page, 
            @RequestParam (name="size", defaultValue = "2") int size) {
        Films film = filmsService.getFilms(id);
        List<Genre> g = filmsService.getAllGenre(); 
        modelMap.addAttribute("film", film);
        modelMap.addAttribute("mode", "edit"); 
        modelMap.addAttribute("genre", g);
        modelMap.addAttribute("page", page); 
        modelMap.addAttribute("size", size);
        return "formFilm";
    }

    @RequestMapping(value = "/updateFilm", method = RequestMethod.PUT)
    public String updateFilm(@ModelAttribute("film") Films film,
            @RequestParam("date") String date,
            ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date datePublication = dateFormat.parse(date);
        film.setDatePublication(datePublication);

        filmsService.updateFilms(film);
        List<Films> films = filmsService.getAllFilms();
        modelMap.addAttribute("films", films);
        return "listeFilms";
    }
}
