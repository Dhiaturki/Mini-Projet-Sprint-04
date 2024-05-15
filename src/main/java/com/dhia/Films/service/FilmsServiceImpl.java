package com.dhia.Films.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.dhia.Films.model.Films;
import com.dhia.Films.model.Genre;
import com.dhia.Films.repos.FilmRepository;
import com.dhia.Films.repos.genreRepository;


@Service
public class FilmsServiceImpl implements FilmService {

    @Autowired
    FilmRepository filmsRepository;
    
    @Autowired 
    genreRepository genreRep;
    
    @Override
    public Films saveFilms(Films film) {
        return filmsRepository.save(film);
    }

    @Override
    public Films updateFilms(Films film) {
        return filmsRepository.save(film);
    }

    @Override
    public void deleteFilms(Films film) {
        filmsRepository.delete(film);
    }

    @Override
    public void deleteFilmsById(Long id) {
        filmsRepository.deleteById(id);
    }

    @Override
    public Films getFilms(Long id) {
        return filmsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Films> getAllFilms() {
        return filmsRepository.findAll();
    }
    @Override
    public Page<Films> getAllFilmsPerPage(int page, int size) {
        return filmsRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Films> findBynomFilm(String nom) {
        return filmsRepository.findBynomFilm(nom);
    }

    @Override
    public List<Films> findByNomFilmContains(String nom) {
        return filmsRepository.findByNomFilmContains(nom);
    }

    @Override
    public List<Films> findByNomPrix(String nom, Double prix) {
        return filmsRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Films> findBygenre(Genre genre) {
        return filmsRepository.findBygenre(genre);
    }

    @Override
    public List<Films> findByGenreidGenre(Long id) {
        return filmsRepository.findByGenreIdGenre(id);
    }

    @Override
    public List<Films> findByOrderByNomFilmAsc() {
        return filmsRepository.findByOrderByNomFilmAsc();
    }

    @Override
    public List<Films> trierFilmsNomsPrix() {
        return filmsRepository.trierFilmsNomsPrix();
    }

	@Override
	public List<Genre> getAllGenre() {
		
		return genreRep.findAll();
	}


}
