package repositories;

import model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Ugo on 30/05/2015.
 */
public interface SubscriberRepository extends JpaRepository<Subscriber, Serializable> {
}
