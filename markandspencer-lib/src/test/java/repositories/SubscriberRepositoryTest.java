package repositories;

import model.MovieCatalogue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import util.Genre;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ugo on 30/05/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-test-context.xml")
public class SubscriberRepositoryTest {

    @Autowired private MovieCatalogueRepository movieCatalogueRepository;

    @Test
    public void test(){

//        List<MovieCatalogue> movieCatalogues = movieCatalogueRepository.listMoviesByDateAndGenre(new Date(),new Date(), Genre.ADVENTURE);
//
//        assertTrue(movieCatalogues.size()==0);
    }

}