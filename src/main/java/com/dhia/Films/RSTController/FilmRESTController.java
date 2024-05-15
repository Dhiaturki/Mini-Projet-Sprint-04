package com.dhia.Films.RSTController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dhia.Films.model.Films;
import com.dhia.Films.service.FilmService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FilmRESTController {

    @Autowired
    private FilmService filmService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Films> getAllFilms() {
        return filmService.getAllFilms();
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET) 
    public Films getFilmById(@PathVariable("id") Long id) {  
    	return filmService.getFilms(id); 
    } 
    @RequestMapping(method = RequestMethod.POST) 
    public Films createFilm(@RequestBody Films film) { 
    return filmService.saveFilms(film); 
    }
    @RequestMapping(method = RequestMethod.PUT) 
    public Films updateFilm(@RequestBody Films film) { 
    return filmService.updateFilms(film); 
    } 
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE) 
    public void deleteFilm(@PathVariable("id") Long id) 
    { 
    	filmService.deleteFilmsById(id); 
    } 
    @RequestMapping(value="/FilmGenre/{idGenre}",method = RequestMethod.GET) 
    public List<Films> getProduitsByCatId(@PathVariable("idGenre") Long idGenre) { 
    return filmService.findByGenreidGenre(idGenre); 
    } 
}
