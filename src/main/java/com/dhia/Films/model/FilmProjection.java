package com.dhia.Films.model;

import org.springframework.data.rest.core.config.Projection;


@Projection(name = "nomFilm", types = { Films.class }) 
public interface FilmProjection {
	public String getNomFilm(); 
}
