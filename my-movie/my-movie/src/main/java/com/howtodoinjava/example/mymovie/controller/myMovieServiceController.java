package com.howtodoinjava.example.mymovie.controller;

import com.howtodoinjava.example.mymovie.model.Acteur;
import com.howtodoinjava.example.mymovie.model.Film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api
@RestController
public class myMovieServiceController {
    List<Film> listFilms = new ArrayList<Film>();
    List<Acteur> listActeurs = new ArrayList<Acteur>();

    {

        Acteur a1 = new Acteur("Jaques", "Jean","12/12/1982", new ArrayList<Film>());
        Acteur a2 = new Acteur("Martin", "Benoit JR","12/12/1992", new ArrayList<Film>());


        Film f1 = new Film("Film 1", "Réalisateur 1", a1, "02/02/2022");
        Film f2 = new Film("Film 2: Le retour", "Réalisateur 1", a1, "03/03/2023");
        Film f3 = new Film("Film 3: Pour l'argent", "Réalisateur 2", a2, "04/04/2024");

        this.listFilms.add(f1);
        this.listFilms.add(f2);
        this.listFilms.add(f3);

        List<Film> filmoa1 = new ArrayList<Film>();
        filmoa1.add(f1);
        filmoa1.add(f2);

        List<Film> filmoa2 = new ArrayList<Film>();
        filmoa1.add(f3);

        a1.setFilmographie(filmoa1);
        a1.setFilmographie(filmoa2);

        listActeurs.add(a1);
        listActeurs.add(a2);
    }

    @ApiOperation(value = "List of films", response = Iterable.class, tags = "getFilms")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(value = "/getFilms")
    public List<Film> getFilms() {
        return  this.listFilms;
    }

    @ApiOperation(value = "List of acteurs", response = Iterable.class, tags = "getActeurs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
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

    @ApiOperation(value = "Update Acteur by their name (nom)", response = Iterable.class, tags = "updateActeurByName")
    @RequestMapping(value = "/updateActeurByName/{name}", method = RequestMethod.PUT)
    public void updateActeurByName(@PathVariable(value = "name") String name, Acteur act) {
        for (Acteur acteur : this.listActeurs) {
            if(acteur.getNom() == name) {
                this.listActeurs.set(listActeurs.indexOf(acteur), act);
            }
        }
    }

    @ApiOperation(value = "Delete Acteur by their name (nom)", response = Iterable.class, tags = "deleteActeurByName")
    @RequestMapping(value = "/deleteActeurByName/{name}", method = RequestMethod.DELETE)
    public void deleteActeurByName(@PathVariable(value = "name") String name) {
        for (Acteur acteur : this.listActeurs) {
            if(acteur.getNom() == name) {
                this.listActeurs.remove(acteur);
            }
        }
    }

    @ApiOperation(value = "Get Acteurs by their movies", response = Iterable.class, tags = "getActeursByMovie")
    @RequestMapping(value = "/getActeursByMovie/{movie}")
    public List<Acteur> getActeursByMovie(@PathVariable(value = "movie") Film movie) {
        List<Acteur> listA = new ArrayList<Acteur>();

        for (Acteur a : this.listActeurs) {
            for (Film m : a.getFilmographie()) {
                if(m == movie) {
                    listA.add(a);
                }
            }
        }

        return listA;
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

    @ApiOperation(value = "Update Film by their title (titre)", response = Iterable.class, tags = "updateFilmByTitle")
    @RequestMapping(value = "/updateFilmByTitle/{title}" , method = RequestMethod.PUT)
    public void updateFilmByTitle(@PathVariable(value = "title") String title, Film movie) {
        for (Film film : this.listFilms) {
            if(film.getTitre() == title) {
                this.listFilms.set(listFilms.indexOf(film), movie);
            }
        }
    }

    @ApiOperation(value = "Delete Acteur by their title (titre)", response = Iterable.class, tags = "deleteFilmByTitle")
    @RequestMapping(value = "/deleteFilmByTitle/{title}", method = RequestMethod.DELETE)
    public void deleteFilmByTitle(@PathVariable(value = "title") String title) {
        for (Film film : this.listFilms) {
            if(film.getTitre() == title) {
                this.listFilms.remove(film);
            }
        }
    }

    @ApiOperation(value = "Get Films by their date de sortie", response = Iterable.class, tags = "getFilmsByDate")
    @RequestMapping(value = "/getFilmsByDate/{date}")
    public List<Film> getFilmsByDate(@PathVariable(value = "date") String date) {
        List<Film> listF = new ArrayList<Film>();

        for (Film film : this.listFilms) {
            if(film.getDateDeSortie() == date) {
                listF.add(film);
            }
        }

        return listF;
    }

}
