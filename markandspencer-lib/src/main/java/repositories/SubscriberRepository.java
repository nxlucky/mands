package repositories;

import model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;

/**
 * Created by Ugo on 30/05/2015.
 */
public interface SubscriberRepository extends JpaRepository<Subscriber, Serializable> {

    @Query("SELECT m FROM Subscriber m WHERE m.id =:subscriberId")
    public Subscriber getSubscriberById(@Param("subscriberId")int subscriberId);
}
