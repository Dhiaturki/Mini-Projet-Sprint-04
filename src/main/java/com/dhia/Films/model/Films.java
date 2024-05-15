package com.dhia.Films.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;



@Entity
public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilm;
    
    @NotNull 
    @Size (min = 4,max = 15) 
    private String nomFilm;
    
    @Min(value = 10) 
    @Max(value = 10000)
    private Double prixFilm;
    
    @Temporal(TemporalType.DATE) 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent 
    private Date datePublication;

    @JsonIgnore
    @ManyToOne
    private Genre genre;
    
    public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Films() {
        super();
    }

    public Films(String nomFilm, Double prixFilm, Date datePublication) {
        super();
        this.nomFilm = nomFilm;
        this.prixFilm = prixFilm;
        this.datePublication = datePublication;
    }

    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }

    public String getNomFilm() {
        return nomFilm;
    }

    public void setNomFilm(String nomFilm) {
        this.nomFilm = nomFilm;
    }

    public Double getPrixFilm() {
        return prixFilm;
    }

    public void setPrixFilm(Double prixFilm) {
        this.prixFilm = prixFilm;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    @Override
    public String toString() {
        return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", prixFilm=" + prixFilm
                + ", datePublication=" + datePublication + "]";
    }
}
