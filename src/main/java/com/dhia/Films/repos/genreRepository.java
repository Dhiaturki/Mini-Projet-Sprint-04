package com.dhia.Films.repos;
import com.dhia.Films.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface genreRepository extends JpaRepository<Genre, Long>  {

	
	
}
