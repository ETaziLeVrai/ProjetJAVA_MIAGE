package com.howtodoinjava.example.mydashboard.model;

import java.util.Date;
import java.util.List;

public class Acteur {

    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private List<Film> filmographie;

    public Acteur(String nom, String prenom, String dateDeNaissance, List<Film> filmographie) {
        super();
        this.nom=nom;
        this.prenom=prenom;
        this.dateDeNaissance=dateDeNaissance;
        this.filmographie=filmographie;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public List<Film> getFilmographie() {
        return filmographie;
    }
}
