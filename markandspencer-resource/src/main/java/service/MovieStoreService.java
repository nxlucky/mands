package service;

import model.MovieCatalogue;

import model.Subscriber;
import model.Subscription;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import payment.AbstractPaymentProcessor;
import repositories.MovieCatalogueRepository;
import repositories.SubscriberRepository;
import repositories.SubscriptionRepository;
import response.ResponseItem;
import util.Genre;
import util.SubscriptionType;
import utils.MovieBuyerObject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Ugo on 10/05/2015.
 */
@Component
public class MovieStoreService {

    @Autowired private MovieCatalogueRepository movieCatalogueRepository;
    @Autowired private SubscriberRepository subscriberRepository;
    @Resource private List<AbstractPaymentProcessor> abstractPaymentProcessors;
    @Autowired private SubscriptionRepository subscriptionRepository;


    public List<ResponseItem> listMovies(String year, Genre genre){
        int yearInt = Integer.parseInt(year);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,yearInt);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        Date yearStart = calendar.getTime();
        
        calendar.add(Calendar.YEAR,1);
        Date yearEnd = calendar.getTime();

        List<MovieCatalogue> movieCatalogues = movieCatalogueRepository.listMoviesByDateAndGenre(yearStart, yearEnd, genre);

        List<ResponseItem>responseItems = new ArrayList<>();

        for(MovieCatalogue movieCatalogue : movieCatalogues){

            responseItems.add(ResponseItem.transformFromModel(movieCatalogue));
        }
        return responseItems;
    }

    @Transactional
    public Object processSale(String requestPayload)throws Exception{
        MovieBuyerObject movieBuyerObject = marshallPayload(requestPayload);
        AbstractPaymentProcessor abstractPaymentProcessor=null;

        for(AbstractPaymentProcessor paymentProcessor: abstractPaymentProcessors){
            if(paymentProcessor.canProcess(movieBuyerObject)) {
                abstractPaymentProcessor = paymentProcessor;
                break;
            }
        }

        final MovieCatalogue movie = this.movieCatalogueRepository.getOne(Integer.parseInt(movieBuyerObject.getMovieId()));

        final double cost = abstractPaymentProcessor.process(movie.getPrice());
        final Subscriber subscriber = this.subscriberRepository.getOne(Integer.parseInt(movieBuyerObject.getUserId()));

        if(!payForItem(cost,movieBuyerObject,subscriber)){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        Subscription subscription = new Subscription();
        subscription.setMovieCatalogue(movie);
        subscription.setEmailAddress(movieBuyerObject.getEmailAddress());
        subscription.setUserName(subscriber.getUserName());
        if(subscriber != null){
            subscription.setSubscriptionType(SubscriptionType.UNLIMITED);
        }else{
            subscription.setSubscriptionType(SubscriptionType.LIMITED);
        }

        return  subscriptionRepository.save(subscription);
    }

    private boolean payForItem(double cost, MovieBuyerObject movieBuyerObject,Subscriber subscriber){
        //process payment through gateway
        return true;
    }

    public MovieBuyerObject marshallPayload(String requestPayload)throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(requestPayload.getBytes(),MovieBuyerObject.class);
    }

}
