package com.herve2iko.relation.Entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
@EntityListeners(EntityListeners.class)
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Genre genre;
    @ManyToOne
    @JoinColumn(name = "depart_id")
    private Departement departement;

    

    public Employer() {
    }



    public Employer(String nom, Genre genre, Departement departement) {
        this.nom = nom;
        this.genre = genre;
        this.departement = departement;
    }



    public Employer(Long id, String nom,Genre genre, Departement departement) {
        this.id = id;
        this.nom = nom;
        this.genre = genre;
        this.departement = departement;
    }


    
}
