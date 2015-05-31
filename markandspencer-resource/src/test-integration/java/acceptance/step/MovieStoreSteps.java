package acceptance.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sun.security.util.PendingException;

/**
 * Created by Ugo on 31/05/2015.
 */

public class MovieStoreSteps extends AbstractStepDefinition {

    @Given("^that a registered user has a userId \"([^\"]*)\"$")
    public void that_a_registered_user_has_a_userId(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Given("^the registered user had purchased a total of (\\d+) movies$")
    public void the_registered_user_had_purchased_a_total_of_movies(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^the user lists his movie catalogues$")
    public void the_user_lists_his_movie_catalogues() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^there should be a total of (\\d+) movies in his catalogue$")
    public void there_should_be_a_total_of_movies_in_his_catalogue(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

}
