package security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by Ugo on 30/05/2015.
 */
public class UserLookupInterceptor implements WebRequestInterceptor {

    private static final Logger accessLogger = LoggerFactory.getLogger("AccessLogger");
    private static final Logger logger = LoggerFactory.getLogger(UserLookupInterceptor.class);
    
    @Autowired private PlatformTransactionManager transactionManager;


    public void preHandle(final WebRequest request) throws Exception {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            public void doInTransactionWithoutResult(TransactionStatus arg0) {
                String username = request.getRemoteUser();



            }
        });
    }


    public void postHandle(final WebRequest request, ModelMap model) throws Exception {
        if(request == null || model == null){
            return;
        }

    }

    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

    }


}
