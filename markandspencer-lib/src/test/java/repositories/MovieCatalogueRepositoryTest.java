package repositories;

import model.MovieCatalogue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by uchegc01 on 02/06/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-test-context.xml")
public class MovieCatalogueRepositoryTest {

    @Autowired private MovieCatalogueRepository movieCatalogueRepository;

    @Test
    public void testGetByMovieId() throws Exception {

//        MovieCatalogue movieCatalogue = this.movieCatalogueRepository.getByMovieId(1);
//
//        Assert.assertNotNull(movieCatalogue);
    }

    @Test
    public void listMoviesByDateAndGenreTest(){

//        List<MovieCatalogue> movieCatalogues = movieCatalogueRepository.listMoviesByDateAndGenre(new Date(),new Date(), Genre.ADVENTURE);
//
//        assertTrue(movieCatalogues.size()==0);
    }



}