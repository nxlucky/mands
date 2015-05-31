package acceptance.helper;


import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * Created by Ugo on 31/05/2015.
 */


public class JettyServer {

    public static final String LOCALHOST = "localhost";
    public static final String CONTEXT_ROOT = "/markandspencer-resource";
    public static final int JETTY_PORT = 8080;

    private static final JettyServer instance = new JettyServer();
    private Server server;

    private JettyServer() {
    }

    public static JettyServer getJetty() {
        return instance;
    }

    public static void main(String[] args) throws Exception {
        getJetty().start();

    }

    public synchronized JettyServer start() throws Exception {
        int port = 8080;

        String wardir = "markandspencer-resource.war";

        String jetty_home = System.getProperty("user.home");

        Server server = new Server(8084);

        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar(jetty_home+"\\IdeaProjects\\UsbCopy\\marksandspencerstest\\markandspencer-resource\\target\\"+wardir);
        server.setHandler(webapp);

        server.start();
        server.join();



        return this;
    }


}