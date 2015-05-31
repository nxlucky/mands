package model;

import util.UserType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ugo on 30/05/2015.
 */
@Entity
public class Subscriber extends AbstractsModel {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userName;
    private String password;
    private String userUUId;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @OneToMany(mappedBy = "subscriber")
    private List<MovieOrder> movieOrders = new ArrayList<MovieOrder>();
    @OneToMany(mappedBy = "subscriber")
    private List<Payment> payments = new ArrayList<Payment>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserUUId() {
        return userUUId;
    }

    public void setUserUUId(String userUUId) {
        this.userUUId = userUUId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<MovieOrder> getMovieOrders() {
        return movieOrders;
    }

    public void setMovieOrders(List<MovieOrder> movieOrders) {
        this.movieOrders = movieOrders;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
