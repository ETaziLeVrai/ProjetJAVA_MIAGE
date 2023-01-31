package com.howtodoinjava.example.mydashboard.beans;

import java.util.Date;

public class film {

    private String titre;
    private String realisateur;
    private acteur acteurPrincipal;
    private Date dateDeSortie;

    public film(String titre, String realisateur, acteur acteurPrincipal, Date dateDeSortie) {
        super();
        this.titre=titre;
        this.realisateur=realisateur;
        this.acteurPrincipal=acteurPrincipal;
        this.dateDeSortie=dateDeSortie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public acteur getActeurPrincipal() {
        return acteurPrincipal;
    }

    public void setActeurPrincipal(acteur acteurPrincipal) {
        this.acteurPrincipal = acteurPrincipal;
    }

    public Date getDateDeSortie() {
        return dateDeSortie;
    }

    public void Date(Date dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }


}
