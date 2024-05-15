package com.dhia.Films.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.dhia.Films.model.Films;
import com.dhia.Films.model.Genre;


@Service
public interface FilmService {

    Films saveFilms(Films film);

    Films updateFilms(Films film);

    void deleteFilms(Films film);

    void deleteFilmsById(Long id);

    Films getFilms(Long id);

    List<Films> getAllFilms();
    Page<Films> getAllFilmsPerPage(int page, int size);
    
    List<Films> findBynomFilm(String nom);
	List<Films> findByNomFilmContains(String nom);  

	 List<Films> findByNomPrix (String nom, Double prix); 

	 List<Films> findBygenre (Genre genre);
	 
	 List<Films> findByGenreidGenre(Long id); 

	 List<Films> findByOrderByNomFilmAsc();

	 List<Films> trierFilmsNomsPrix (); 
	 
	 List<Genre> getAllGenre(); 

}
