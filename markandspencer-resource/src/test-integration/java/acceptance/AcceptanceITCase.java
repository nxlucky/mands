package acceptance;
import acceptance.helper.JettyServer;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {"html:target/cucumber-report","json:target/cucumber-report.json"},
        features = "classpath:acceptance/feature",
        glue = "acceptance/step",
        tags = "~@wip")
public class AcceptanceITCase {

        private static final Logger logger = LoggerFactory.getLogger(AcceptanceITCase.class.getName());



        @BeforeClass
        public static void beforeIntegrationTests() throws Exception {


        }


        private static synchronized void startMyActivity()throws Exception {
        }
}
