package com.dhia.Films.repos;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dhia.Films.model.Films;
import com.dhia.Films.model.Genre; 



@RepositoryRestResource(path = "rest") 
public interface FilmRepository extends JpaRepository<Films, Long> {

	List<Films> findBynomFilm(String nom);
	List<Films> findByNomFilmContains(String nom);  
	 
	 //@Query("select f from Films f where f.nomFilm like %?1 and f.prixFilm > ?2")
	   // List<Films> findByNomPrix(String nom, Double prix);

	 
	 @Query("select f from Films f where f.nomFilm like %:nom and f.prixFilm > :prix") 
	 List<Films> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix); 

	 @Query("select f from Films f where f.genre = ?1") 
	 List<Films> findBygenre (Genre genre);
	 
	 List<Films> findByGenreIdGenre(Long id); 

	 List<Films> findByOrderByNomFilmAsc();

	 @Query("select f from Films f order by f.nomFilm ASC, f.prixFilm DESC") 
	 List<Films> trierFilmsNomsPrix (); 
}
