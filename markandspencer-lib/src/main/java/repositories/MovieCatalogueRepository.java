package repositories;

import model.MovieCatalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import util.Genre;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Ugo on 31/05/2015.
 */
public interface MovieCatalogueRepository extends JpaRepository<MovieCatalogue,Serializable> {



    @Query("SELECT m FROM MovieCatalogue m WHERE m.releaseDate BETWEEN :yearStart AND :yearEnd AND m.genre =:genre")
    public List<MovieCatalogue> listMoviesByDateAndGenre(@Param("yearStart")Date yearStart,@Param("yearEnd")Date yearEnd,@Param("genre")Genre genre);
}
