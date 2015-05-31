package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Ugo on 31/05/2015.
 */
@Entity
public class Payment extends AbstractsModel {

    private double amount;
    @ManyToOne
    private Subscriber subscriber;
    @ManyToOne
    private MovieOrder movieOrder;


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public MovieOrder getMovieOrder() {
        return movieOrder;
    }

    public void setMovieOrder(MovieOrder movieOrder) {
        this.movieOrder = movieOrder;
    }
}
