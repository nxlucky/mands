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

        public static final int DYNAMODB_PORT = 8094;
        public static final int MYACTIVITY_PORT = 9199;

        private static final String MYACTIVITY_CONTEXT_PATH = "/markandspencer-resource";
        private static final String MYACTIVITY_RESOURCE_BASE = "src/main/webapp";
        private static final String MYACTIVITY_DESCRIPTOR_PATH = "WEB-INF/test-web.xml";

        private static JettyServer jettyServer;

        @BeforeClass
        public static void beforeIntegrationTests() throws Exception {

                // setting for Jersey http connector to allow restricted http header.
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

                startMyActivity();

                logger.info("Cucumber integration tests about to start...");
                Thread.sleep(7000); // wait a while to ensure all test services are up
        }


        private static synchronized void startMyActivity()throws Exception {
               jettyServer.start();
        }
}
