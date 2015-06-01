package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import response.ResponseItem;
import service.MovieStoreService;
import util.Genre;

/**
 * Created by Ugo on 31/05/2015.
 */

@RestController
@RequestMapping(value = "/browse")
public class BrowseMoviesController {

    @Autowired private MovieStoreService movieStoreService;

    @RequestMapping(method = RequestMethod.GET, value = {"/{year}/{genre}"})
    public Object listMovies(@PathVariable(value="year")final String year,@PathVariable(value = "genre")String genre){

        return movieStoreService.listMovies(year, Genre.ADVENTURE);

    }



}
