package com.howtodoinjava.example.mydashboard.controller;

import com.howtodoinjava.example.mydashboard.model.Acteur;
import com.howtodoinjava.example.mydashboard.model.Film;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class myMovieServiceController {
    List<Film> listFilms = new ArrayList<Film>();
    List<Acteur> listActeurs = new ArrayList<Acteur>();

    {

        Acteur a1 = new Acteur("Jaques", "Jean","12/12/1982", new ArrayList<Film>());
        Acteur a2 = new Acteur("Martin", "Benoit JR","12/12/1992", new ArrayList<Film>());

        listActeurs.add(a1);
        listActeurs.add(a2);

        Film f1 = new Film("Film 1", "Réalisateur 1", a1, "02/02/2022");
        Film f2 = new Film("Film 2: Le retour", "Réalisateur 1", a1, "03/03/2023");
        Film f3 = new Film("Film 3: Pour l'argent", "Réalisateur 2", a2, "04/04/2024");

        this.listFilms.add(f1);
        this.listFilms.add(f2);
        this.listFilms.add(f3);
    }

    @ApiOperation(value = "List of films", response = Iterable.class, tags = "getFilms")
    @RequestMapping(value = "/getFilms")
    public List<Film> getFilms() {
        return  this.listFilms;
    }

    @ApiOperation(value = "List of acteurs", response = Iterable.class, tags = "getActeurs")
    @RequestMapping(value = "/getActeurs")
    public List<Acteur> getActeurs() {
        return  this.listActeurs;
    }

    @ApiOperation(value = "Get Acteur by their name (nom)", response = Iterable.class, tags = "getActeurByName")
    @RequestMapping(value = "/getActeurByName/{name}")
    public Acteur getActeurByName(@PathVariable(value = "name") String name) {
        Acteur a = new Acteur("Not Found", "Not Found","Not Found", new ArrayList<Film>());

        for (Acteur acteur : this.listActeurs) {
            if(acteur.getNom() == name) {
                a = acteur;
            }
        }

        return a;
    }

    @ApiOperation(value = "Get Acteurs by their movies", response = Iterable.class, tags = "getActeursByMovie")
    @RequestMapping(value = "/getActeursByMovie/{movie}")
    public List<Acteur> getActeursByMovie(@PathVariable(value = "movie") Film movie) {
        List<Acteur> listActeurs = new ArrayList<Acteur>();

        for (Acteur a : this.listActeurs) {
            for (Film m : a.getFilmographie()) {
                if(m == movie) {
                    listActeurs.add(a);
                }
            }
        }

        return listActeurs;
    }

    @ApiOperation(value = "Get Film by their title (titre)", response = Iterable.class, tags = "getFilmByTitle")
    @RequestMapping(value = "/getFilmByTitle/{title}")
    public Film getFilmByTitle(@PathVariable(value = "title") String title) {
        Acteur a = new Acteur("Not Found", "Not Found","Not Found", new ArrayList<Film>());
        Film f = new Film("Not Found", "Not Found", a, "Not Found");

        for (Film film : this.listFilms) {
            if(film.getTitre() == title) {
                f = film;
            }
        }

        return f;
    }

    @ApiOperation(value = "Get Film by their date de sortie", response = Iterable.class, tags = "getFilmByDate")
    @RequestMapping(value = "/getFilmByDate/{date}")
    public List<Film> getFilmByDate(@PathVariable(value = "date") String date) {
        List<Film> listF = new ArrayList<Film>();

        for (Film film : this.listFilms) {
            if(film.getDateDeSortie() == date) {
                listF.add(film);
            }
        }

        return listF;
    }

}
