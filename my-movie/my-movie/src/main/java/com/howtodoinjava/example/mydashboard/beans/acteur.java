package com.howtodoinjava.example.mydashboard.beans;

import java.util.Date;
import java.util.List;

public class acteur {

    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private List<film> filmographie;

    public acteur(String nom, String prenom, Date dateDeNaissance, List<film> filmographie) {
        super();
        this.nom=nom;
        this.prenom=prenom;
        this.dateDeNaissance=dateDeNaissance;
        this.filmographie=filmographie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public List<film> getFilmographie() {
        return filmographie;
    }

    public void setFilmographie(List<film> filmographie) {
        this.filmographie = filmographie;
    }
}
