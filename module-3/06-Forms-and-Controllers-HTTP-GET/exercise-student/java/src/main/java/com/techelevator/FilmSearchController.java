package com.techelevator;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;

    @RequestMapping(value="/filmList", method = RequestMethod.GET)
    public String showFilmSearchForm() {
        return "filmList";
    }

    @RequestMapping(value="/filmList/search", method = RequestMethod.GET)
    public String searchFilms(@RequestParam(value="min_length", defaultValue = "0") int min_length, @RequestParam(value="max_length", defaultValue = "10000") int max_length, @RequestParam String genre, ModelMap modelHolder) {
        List<Film> films = filmDao.getFilmsBetween(genre, min_length, max_length);
        modelHolder.put("films", films);
        return "filmList";
    }

}