package repositories;

import model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Ugo on 01/06/2015.
 */
public interface SubscriptionRepository extends JpaRepository<Subscription,Serializable> {
}
