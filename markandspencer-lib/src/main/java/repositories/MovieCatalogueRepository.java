package repositories;

import model.MovieCatalogue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Ugo on 31/05/2015.
 */
public interface MovieCatalogueRepository extends JpaRepository<MovieCatalogue,Serializable> {
}
