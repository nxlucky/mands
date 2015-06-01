package response;

import model.MovieCatalogue;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Ugo on 01/06/2015.
 */

@Component
public class ResponseItem {

    private String title;
    private String synopsis;
    private String imageUrl;
    private String videoUrl;
    private double price;
    private Date releaseDate;
    private String genre;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static ResponseItem transformFromModel(MovieCatalogue movieCatalogue){
        ResponseItem responseItem  =  new ResponseItem();
        responseItem.setTitle(movieCatalogue.getTitle());
        responseItem.setGenre(movieCatalogue.getGenre().name());
        responseItem.setReleaseDate(movieCatalogue.getReleaseDate());
        responseItem.setPrice(movieCatalogue.getPrice());
        responseItem.setSynopsis(movieCatalogue.getSynopsis());
        responseItem.setVideoUrl(movieCatalogue.getUrl());

        return responseItem;
    }
}
