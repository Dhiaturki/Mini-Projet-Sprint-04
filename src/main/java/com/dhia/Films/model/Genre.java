package com.dhia.Films.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenre;

    private String nomGenre;
    private String descGenre;
    @JsonIgnore 
    
    @OneToMany(mappedBy = "genre")
    
    
    private List<Films> Films;

    public Genre(String nomGenre, String descGenre, List<Films> Films) {
        super();
        this.nomGenre = nomGenre;
        this.descGenre = descGenre;
        this.Films = Films;
    }

    public Long getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Long idGenre) {
        this.idGenre = idGenre;
    }

    public String getNomGenre() {
        return nomGenre;
    }

    public void setNomGenre(String nomGenre) {
        this.nomGenre = nomGenre;
    }

    public String getDescGenre() {
        return descGenre;
    }

    public void setDescGenre(String descGenre) {
        this.descGenre = descGenre;
    }

    public List<Films> getProduits() {
        return Films;
    }

    public void setProduits(List<Films> produits) {
        this.Films = produits;
    }
}
