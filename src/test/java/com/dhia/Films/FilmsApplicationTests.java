package com.dhia.Films;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.dhia.Films.model.Films;
import com.dhia.Films.model.Genre;
import com.dhia.Films.repos.FilmRepository;
import com.dhia.Films.service.FilmService;

@SpringBootTest
public class FilmsApplicationTests {

    @Autowired
    private FilmRepository filmsRepository;
    
    @Autowired
    private FilmService filmsService;
    @Test
    public void testFindFilms() {
        Films film = filmsRepository.findById(1L).orElse(null);
        System.out.println(film);
    }

    @Test
    public void testUpdateFilms() {
        Films film = filmsRepository.findById(1L).orElse(null);
        if (film != null) {
            film.setPrixFilm(1000.0);
            filmsRepository.save(film);
        }
    }

    @Test
    public void testDeleteFilms() {
        filmsRepository.deleteById(1L);
    }

    @Test
    public void testListAllFilms() {
        Iterable<Films> films = filmsRepository.findAll();
        for (Films film : films) {
            System.out.println(film);
        }
    }
    @Test
    public void testFindByNomFilmContains() {
        Page<Films> filmsPage = filmsService.getAllFilmsPerPage(0, 2);
        System.out.println(filmsPage.getSize());
        System.out.println(filmsPage.getTotalElements());
        System.out.println(filmsPage.getTotalPages());
        
        filmsPage.getContent().forEach(film -> {
            System.out.println(film.toString());
        });
    }
    @Test
    public void testFindByNomFilm() {
        List<Films> films = filmsRepository.findBynomFilm("Inception");
        for (Films f : films) {
            System.out.println(f);
        }
    }

    @Test
    public void testFindByNomfilmContains() {
        List<Films> films = filmsRepository.findByNomFilmContains("K");
        for (Films f : films) {
            System.out.println(f);
        }
    }
    @Test
    public void testfindByNomPrix() 
    { 
    List<Films>  films = filmsRepository.findByNomPrix("Inception", 15.99); 
    for (Films f : films) 
    { 
    System.out.println(f); 
    } 
    }
    @Test 
    public void testfindByGenre() 
    { 
    	Genre genre = new Genre(); 
    	genre.setIdGenre(1L);    
    List<Films>  films = filmsRepository.findBygenre(genre); 
    for (Films f : films) 
    { 
    System.out.println(f); 
    } 
    }
    @Test 
    public void testfindByGenreidgenre() 
    {    
    List<Films>  Films = filmsRepository.findByGenreIdGenre(1L); 
    for (Films f : Films) 
    { 
    System.out.println(f); 
    } 
    } 
    @Test 
    public void testfindByOrderByNomFilmsAsc() 
     { 
     List<Films>  films = filmsRepository.findByOrderByNomFilmAsc();   
      for (Films f : films) 
      { 
       System.out.println(f); 
      } 
     }
    @Test 
    public void testTrierProduitsNomsPrix() 
     { 
     List<Films>  Films = filmsRepository.trierFilmsNomsPrix();
      
      for (Films f : Films) 
      { 
       System.out.println(f); 
      } 
     } 
    
}
