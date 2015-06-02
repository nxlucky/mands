package service;

import model.MovieCatalogue;
import model.Subscriber;
import org.apache.commons.lang.time.DateUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import payment.AbstractPaymentProcessor;
import payment.RegisteredUserPaymentProcessor;
import payment.RegularUserPaymentProcessor;
import repositories.MovieCatalogueRepository;
import repositories.SubscriberRepository;
import repositories.SubscriptionRepository;
import util.Genre;
import util.UserType;
import utils.MovieBuyerObject;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by uchegc01 on 01/06/2015.
 */

@RunWith(MockitoJUnitRunner.class)
public class MovieStoreServiceTest {

    public static final int MOVIE_ID = 1;
    public static final Genre GENRE = Genre.ADVENTURE;
    public static final double MOVIE_PRICE=1;
    Date current = new Date();
    public  final Date RELEASE_DATE= DateUtils.addYears(current,-1);
    public static final String TITLE = "title";
    public static final String URL = "url";
    public static final String SYNOPSIS="synopsis";
    public static final int SUBSCRIBER_ID=1;
    public static final String USERNAME="username";
    public static final UserType USERTYPE = UserType.REGISTERED_USER;


    @Mock private MovieCatalogueRepository movieCatalogueRepository;
    @Mock private SubscriberRepository subscriberRepository;
    @Mock private SubscriptionRepository subscriptionRepository;
    @Mock private MovieCatalogue movieCatalogue;
    @Mock private Subscriber subscriber;
    private MovieStoreService movieStoreService;
    @Mock private ObjectMapper objectMapper;
    @Mock private List<AbstractPaymentProcessor> abstractPaymentProcessors;
    @Mock private RegisteredUserPaymentProcessor registeredUserPaymentProcessor;
    @Mock private RegularUserPaymentProcessor regularUserPaymentProcessor;

    @Before
    public void setUp(){
        when(movieCatalogue.getId()).thenReturn(MOVIE_ID);
        when(movieCatalogue.getGenre()).thenReturn(GENRE);
        when(movieCatalogue.getPrice()).thenReturn(MOVIE_PRICE);
        when(movieCatalogue.getReleaseDate()).thenReturn(RELEASE_DATE);
        when(movieCatalogue.getTitle()).thenReturn(TITLE);
        when(movieCatalogue.getUrl()).thenReturn(URL);
        when(movieCatalogue.getSynopsis()).thenReturn(SYNOPSIS);

        when(movieCatalogueRepository.getByMovieId(MOVIE_ID)).thenReturn(movieCatalogue);

        when(subscriber.getId()).thenReturn(SUBSCRIBER_ID);
        when(subscriber.getUserName()).thenReturn(USERNAME);
        when(subscriber.getUserType()).thenReturn(USERTYPE);
//        movieStoreService = new MovieStoreService(objectMapper);

    }

    @Test
    public void testPayForItem()throws Exception{
         MovieBuyerObject movieBuyerObject = mock(MovieBuyerObject.class);
        AbstractPaymentProcessor abstractPaymentProcessor = mock(RegularUserPaymentProcessor.class);

        when(movieBuyerObject.getUserId()).thenReturn("barry");
        when(movieBuyerObject.getMovieId()).thenReturn("1");

//        movieStoreService.processSale("");


    }
}