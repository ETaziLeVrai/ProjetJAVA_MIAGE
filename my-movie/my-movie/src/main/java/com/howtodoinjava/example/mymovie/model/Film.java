package com.howtodoinjava.example.mymovie.model;

public class Film {

    private String titre;
    private String realisateur;
    private Acteur acteurPrincipal;
    private String dateDeSortie;

    public Film(String titre, String realisateur, Acteur acteurPrincipal, String dateDeSortie) {
        super();
        this.titre=titre;
        this.realisateur=realisateur;
        this.acteurPrincipal=acteurPrincipal;
        this.dateDeSortie=dateDeSortie;
    }

    public String getTitre() {
        return titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public Acteur getActeurPrincipal() {
        return acteurPrincipal;
    }

    public String getDateDeSortie() {
        return dateDeSortie;
    }


}
