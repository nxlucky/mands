package repositories;

import model.MovieOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Ugo on 31/05/2015.
 */
public interface MovieOrderRepository extends JpaRepository<MovieOrder,Serializable> {
}
