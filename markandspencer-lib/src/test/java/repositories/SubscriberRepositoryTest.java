package repositories;

import model.Subscriber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import util.UserType;


import java.util.UUID;


/**
 * Created by Ugo on 30/05/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-test-context.xml")
public class SubscriberRepositoryTest {

    @Autowired private SubscriberRepository subscriberRepository;



    @Test
    public void testGetSubscriberById(){
        Subscriber subscriber = subscriberRepository.getSubscriberById(1);
    }

    @Test
    public void testCreateNewSubscriber(){
        Subscriber subscriber = subscriberRepository.save(createDummySubscriber());

        Assert.assertNotNull(subscriber);
        Assert.assertEquals("ucugo@yahoo.co.uk", subscriber.getEmailAddress());


    }


    public Subscriber createDummySubscriber(){
        Subscriber subscriber = new Subscriber();
        subscriber.setCreditCardNumber("1234567890");
        subscriber.setEmailAddress("ucugo@yahoo.co.uk");
        subscriber.setFirstName("Kevin");
        subscriber.setLastName("Brown");
        subscriber.setPassword("password");
        subscriber.setUserName("ucugo");
        subscriber.setUserType(UserType.REGISTERED_USER);
        subscriber.setUserUUId(UUID.randomUUID().toString());
        return subscriber;
    }

}