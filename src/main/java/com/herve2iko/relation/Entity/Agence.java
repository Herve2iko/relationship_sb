package com.herve2iko.relation.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agence {
    @Id
    @GeneratedValue
    private int id;
    private String nom;

    public Agence() {
    }

    public Agence(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Agence(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
}
