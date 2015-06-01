package model;

import util.SubscriptionType;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

/**
 * Created by Ugo on 01/06/2015.
 */
@Entity
public class Subscription extends AbstractsModel {

    @Enumerated
    private SubscriptionType subscriptionType;
    private String userName;
    private String emailAddress;

    @ManyToOne
    private MovieCatalogue movieCatalogue;

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public MovieCatalogue getMovieCatalogue() {
        return movieCatalogue;
    }

    public void setMovieCatalogue(MovieCatalogue movieCatalogue) {
        this.movieCatalogue = movieCatalogue;
    }
}
