package model;

import util.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ugo on 31/05/2015.
 */
@Entity
public class MovieCatalogue extends AbstractsModel {

    private String title;
    private String synopsis;
    private String url;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    private double price;
    @OneToMany(mappedBy = "movieCatalogue")
    private List<MovieOrder> movieOrders = new ArrayList<MovieOrder>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<MovieOrder> getMovieOrders() {
        return movieOrders;
    }

    public void setMovieOrders(List<MovieOrder> movieOrders) {
        this.movieOrders = movieOrders;
    }
}
