package model;

import util.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ugo on 31/05/2015.
 */

@Entity
public class MovieOrder extends AbstractsModel {

    @Enumerated
    private OrderStatus orderStatus;
    @ManyToOne
    private Subscriber subscriber;
    @ManyToOne
    private MovieCatalogue movieCatalogue;
    @OneToMany(mappedBy = "movieOrder")
    private List<Payment>payments = new ArrayList<Payment>();

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public MovieCatalogue getMovieCatalogue() {
        return movieCatalogue;
    }

    public void setMovieCatalogue(MovieCatalogue movieCatalogue) {
        this.movieCatalogue = movieCatalogue;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
